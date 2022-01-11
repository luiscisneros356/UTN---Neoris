import org.junit.Before;
import org.junit.Test;
import sourcefolder.Cocinero;
import sourcefolder.Receta;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ClaseTest {
    
    private Cocinero chef;
    private ArrayList<Receta> recetas = new ArrayList<Receta>();

    @Before
    public void SetUp(){
        this.chef = new Cocinero("Federico", 30, "baja", new ArrayList<Receta>());
        Receta receta1 = new Receta(60745,"Recetas de Aperitivos y tapas","Receta de Ceviche de surimi " +
                "con mango", "baja",29,40,"Entrante","6 barras de surimi");
        Receta receta2 = new Receta(60792,"Recetas de Aperitivos y tapas","Receta de Soufflé de 4 quesos",
                "media",45,130,"Entrante","½ litro de Leche");
        recetas.add(receta1);
        recetas.add(receta2);
    }

    @Test()
    public void testAsignarRecetasOK() throws Exception{
        NewMain.asignarRecetas(chef, recetas);
        assertEquals(1, chef.getRecetas().size());
    }

}
