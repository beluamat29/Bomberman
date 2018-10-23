package gradle.cucumber;

public class Pared {

    private String tipo;
    private Celda ubicacion;

    public Pared(String tipo){
        this.tipo = tipo;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean esDeMelamina() {
        return tipo.equals("Melamina");
    }
}
