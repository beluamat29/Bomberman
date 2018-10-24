package gradle.cucumber;

public abstract class Celda {

    protected final Integer x;
    protected final Integer y;
    protected boolean conPared;
    protected boolean conEnemigo;
    protected Pared pared;
    protected Enemigo enemigo;

    public Celda(Integer unEjeX, Integer unEjeY) {
        x = unEjeX;
        y = unEjeY;
    }


    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public abstract boolean tieneEnemigo();

    public void destruirPared() {
        this.conPared = false;
    }

    public boolean estaEnElRadio(Integer ejeX, Integer ejeY, Integer radioDeCasilleros) {
        return (x + radioDeCasilleros) >= ejeX && (x - radioDeCasilleros) <= ejeX
                && (y + radioDeCasilleros) >= ejeY && (y - radioDeCasilleros) <= ejeY;
    }

    public abstract boolean tienePared();

    public abstract boolean tieneParedDeMelamina();

    public abstract void destruirObstaculoPara(Bomberman bomberman, Tablero tablero);

    public abstract void realizarAccionPara(Bomberman bomberman, String direccion, Tablero tablero);
}

