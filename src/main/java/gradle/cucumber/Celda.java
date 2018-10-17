package gradle.cucumber;

public class Celda {

    private final Integer x;
    private final Integer y;
    private boolean conPared;

    public Celda(Integer unEjeX, Integer unEjeY, Boolean tienePared) {
        x = unEjeX;
        y = unEjeY;
        conPared = tienePared;
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
}
