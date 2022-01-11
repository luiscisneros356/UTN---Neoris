
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.*;
import sourcefolder.Cocinero;
import sourcefolder.Evento;
import sourcefolder.Receta;

public class NewMain {
    //Primer Argumento del args ruta a cocineros, 2 ruta a eventos, 3 ruta a Recetas, 4 Orden
    public static void main(String[] args) throws Exception {

        org.slf4j.Logger logger = LoggerFactory.getLogger(NewMain.class);
        
        File outputFile = new File("output.txt");
        PrintWriter pw = new PrintWriter(outputFile);

        //Listas donde se guardarán los objetos
        ArrayList<Cocinero> cocineros = new ArrayList();
        ArrayList<Evento> eventos = new ArrayList();
        ArrayList<Receta> recetas = new ArrayList();

        //Ruta de los archivos (¡Cambiar según cada uno!)
//        String rutaCocineros = "C:/Users/xavie/Desktop/Curso_NEORIS_UTN_Java/proyecto_UTN/cocineros.csv";
//        String rutaEventos = "C:/Users/xavie/Desktop/Curso_NEORIS_UTN_Java/proyecto_UTN/eventos.csv";
//        String rutaRecetas = "C:/Users/xavie/Desktop/Curso_NEORIS_UTN_Java/proyecto_UTN/recetascomida.csv";

        if(args.length == 0 || args[0].isEmpty() || args[1].isEmpty() || args[2].isEmpty()){
            throw new Exception("Las rutas de los archivos no pueden estar vacías");
        }
        String rutaCocineros = args[0];
        String rutaEventos = args[1];
        String rutaRecetas = args[2];
        String orden = args[3];
//        FileReaders para cada csv
        FileReader leerCocineros = new FileReader(rutaCocineros);
        FileReader leerEventos = new FileReader(rutaEventos);
        FileReader leerRecetas = new FileReader(rutaRecetas);

        //BufferedReaders
        BufferedReader readerCocineros = new BufferedReader(leerCocineros);
        BufferedReader readerEventos = new BufferedReader(leerEventos);
        BufferedReader readerRecetas = new BufferedReader(leerRecetas);

        String line = "";
        Integer numero = null;
        logger.debug("Se lee el archivo " + leerCocineros);
        try {
            //While para leer todo el archivo hasta que la fila sea nula
            while ((line = readerCocineros.readLine()) != null) {
                String[] row = line.split(",");

                //Creo objeto y seteo atributos
                Cocinero cocinero = new Cocinero();

                cocinero.setNombre(row[0]);
                cocinero.setTiempo(numero.valueOf(row[1]));
                cocinero.setNivel(row[2]);
                //Lo agrego a la lista de cocineros
                cocineros.add(cocinero);
            }
            
            logger.debug("Se lee el archivo " + leerEventos);
            while ((line = readerEventos.readLine()) != null) {
                String[] row = line.split(",");

                Evento evento = new Evento();

                evento.setTipoEvento(row[0]);
                evento.setCantidadPersonnas(numero.valueOf(row[2]));

                eventos.add(evento);
            }
            
            logger.debug("Se lee el archivo " + leerRecetas);
            while ((line = readerRecetas.readLine()) != null) {
                String[] row = line.split(",");

                Receta receta = new Receta();

                receta.setId(numero.valueOf(row[0]));
                receta.setCategoria(row[1]);
                receta.setNombre(row[2]);
                receta.setNivel(row[3]);
                receta.setComensales(numero.valueOf(row[4]));
                receta.setTiempo(numero.valueOf(row[5]));
                receta.setTipo(row[6]);
                receta.setIngredientes(row[6]);

                recetas.add(receta);
            }
            logger.info("Se procesaron los datos y se crearon objetos de tipo Cocinero, Evento, Receta");
        } catch (Exception e) {
            logger.error("Error critico:" + e);
            e.printStackTrace();
        } finally {

            try {
                //Cierrro el reader
                readerCocineros.close();
                readerEventos.close();
                readerRecetas.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            logger.debug("Se asigna recetas a cocineros segun su habilidad y tiempo");
            for (int i = 0; i < cocineros.size(); i++) {
                Cocinero chef = cocineros.get(i);
                asignarRecetas(chef, recetas);
            }
            logger.info("Se asignaron las recetas a los cocineros correctamente");
            try {
                for(Evento even : eventos) {
                    //Cada cocinero realizara dos de sus recetas
                    ArrayList<Cocinero> coc = new ArrayList<Cocinero>();
                    if(orden.equals("azar")) {
                        even.getCantidadPersonas();
                        int numComen = even.getCantidadPersonas();
                        while (numComen > 0 && cocineros.size() != 0) {
                            int numeroRandom = (int) (Math.random() * cocineros.size() - 1);
                            Cocinero randomChef = cocineros.get(numeroRandom);
                            cocineros.remove(numeroRandom);
                            if (randomChef.getUtilizada() == null) {
                                Receta receta = randomChef.getRecetas().get((int) (Math.random() * randomChef.getRecetas().size() - 1));
                                numComen -= receta.getComensales();
                                coc.add(randomChef);
                                randomChef.setUtilizada(receta);
                            }
                        }
                        even.setCocineros(coc);
                        
                    }
                    else if(orden.equals("orden")){
                        int numComen = even.getCantidadPersonas();
                            while(numComen > 0 && cocineros.size() != 0){
                                Cocinero cocinero = cocineros.get(0);
                                cocineros.remove(0);
                                if(cocinero.getUtilizada() == null){
                                    Receta receta = cocinero.getRecetas().get((int) (Math.random() * cocinero.getRecetas().size() - 1));
                                    numComen -= receta.getComensales();
                                    coc.add(cocinero);
                                    cocinero.setUtilizada(receta);
                                }
                            }
                            even.setCocineros(coc);
                    }
                }
                logger.info("Se establecieron correctamente los cocineros a los eventos");
                //ESCRIBO JSON EN CSV
                for (int i = 0; i < eventos.size(); i++) {
                    ObjectMapper objectmapper = new ObjectMapper();
                    String json = objectmapper.writeValueAsString(eventos.get(i));
                    pw.println(json);
                    pw.println("\n");
                }
                logger.info("Mapeo y transcripcion realizado correctamente");
            } finally {
                try {
                    //Cierro el reader
                    pw.close();
                } catch (Exception e) {
                    logger.error("Error critico:" + e);
                    e.printStackTrace();
                }
            }
        }
    }
    public static void asignarRecetas(Cocinero chef, ArrayList<Receta> recetas) {
        ArrayList<Receta> auxiliar = new ArrayList<Receta>();
        for (int j = 0; j < recetas.size(); j++) {
            if (chef.getNivel().equals(recetas.get(j).getNivel()) &&
                    chef.getTiempo() <= recetas.get(j).getTiempo()) {
                auxiliar.add(recetas.get(j));
            }
        }
        if (auxiliar.size() > 0) {
            chef.setRecetas(auxiliar);
        }
    }
}