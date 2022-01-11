package sourcefolder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opencsv.bean.CsvBindByPosition;
import java.util.ArrayList;


public class Cocinero {

    private String nombre;
    private Integer tiempoDisponible;
    private String nivel;
    private Integer comensales;
    @JsonIgnore
    private ArrayList<Receta> recetas;
//    @JsonIgnore
    private Receta utilizada;

    public Cocinero() {
        recetas = new ArrayList<>();
    }

    public Cocinero(String nombre, Integer tiempoDisponible, String nivel, ArrayList<Receta> recetas) {
        this.nombre = nombre;
        this.tiempoDisponible = tiempoDisponible;
        this.nivel = nivel;
        this.recetas = recetas;
    }

    public Receta getUtilizada() {
        return utilizada;
    }

    public void setUtilizada(Receta utilizada) {
        this.utilizada = utilizada;
    }
    public String getNombre() {
        return nombre;
    }

    public int getTiempo() {
        return tiempoDisponible;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTiempo(int tiempo) {
        this.tiempoDisponible = tiempo;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public ArrayList<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(ArrayList<Receta> recetas) {
        this.recetas = recetas;
    }

    @Override
    public String toString() {
        return "Cocinero{" + "nombre=" + nombre + ", tiempoDisponible=" + tiempoDisponible + ", nivel=" + nivel + ", comensales=" + comensales + ", recetas=" + recetas + ", utilizada=" + utilizada + '}';
    }
}
