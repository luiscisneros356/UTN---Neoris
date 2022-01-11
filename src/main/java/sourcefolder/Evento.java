package sourcefolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class Evento {

    private String tipoEvento;
    private ArrayList<Cocinero> cocineros;
    private int cantidadPersonas;
    private int personasSinPlato;

    public int getPersonasSinPlato() {
        return personasSinPlato;
    }

    public void setPersonasSinPlato(int personasSinPlato) {
        this.personasSinPlato = personasSinPlato;
    }

    public Evento() {
        cocineros = new ArrayList<>();
    }

    public Evento(String tipoEvento, ArrayList<Cocinero> cocinero, int cantidadPersonas) {
        this.tipoEvento = tipoEvento;
        this.cocineros = cocinero;
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public ArrayList<Cocinero> getCocineros() {
        return cocineros;
    }

    public void setCocineros(ArrayList<Cocinero> cocinero) {
        this.cocineros = cocinero;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
        this.personasSinPlato = cantidadPersonas;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    @Override
    public String toString() {
        return "Evento{" + "tipoEvento=" + tipoEvento + ", cocinero=" + cocineros + ", cantidadPersonas=" + cantidadPersonas + '}';
    }

    public void setCantidadPersonnas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }
}
