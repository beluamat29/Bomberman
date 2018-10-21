package gradle.cucumber;

public class Celda {

    private final Integer x;
    private final Integer y;
    private boolean conPared;
    private boolean conEnemigo;

    public Celda(Integer unEjeX, Integer unEjeY, Boolean tienePared, Boolean tieneEnemigo) {
        x = unEjeX;
        y = unEjeY;
        conPared = tienePared;
        conEnemigo = tieneEnemigo;
    }

    public Celda(Integer unEjeX, Integer unEjeY) {
        x = unEjeX;
        y = unEjeY;
    }

    public boolean estaVacia() {
        return !conPared;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public boolean tieneEnemigo() {
        return conEnemigo;
    }

    public void destruirPared(){
        this.conPared = false;
    }

}

