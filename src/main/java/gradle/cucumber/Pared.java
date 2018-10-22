package gradle.cucumber;

public class Pared {

    private String tipo;
    private Celda ubicacion;

    public Pared(String tipo, Celda ubicacion){
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        ubicacion.setConPared(true);
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Celda getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Celda ubicacion) {
        this.ubicacion = ubicacion;
    }
}
