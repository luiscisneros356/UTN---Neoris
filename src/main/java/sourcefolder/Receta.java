package sourcefolder;

public class Receta {

    private int id;
    private String categoria;
    private String nombre;
    private String nivel;
    private int comensales;
    private int tiempo;
    private String tipo;
    private String ingredientes;

    public Receta() {
    }
    
    public Receta(int id, String categoria, String nombre, String nivel, int comensales, int tiempo, String tipo, String ingredientes) {
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.nivel = nivel;
        this.comensales = comensales;
        this.tiempo = tiempo;
        this.tipo = tipo;
        this.ingredientes = ingredientes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getComensales() {
        return comensales;
    }

    public void setComensales(int comensales) {
        this.comensales = comensales;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "Receta{" + "id=" + id + ", categoria=" + categoria + ", nombre=" + nombre + ", nivel=" + nivel + ", comensales=" + comensales + ", tiempo=" + tiempo + ", tipo=" + tipo + ", ingredientes=" + ingredientes + '}';
    }
}
