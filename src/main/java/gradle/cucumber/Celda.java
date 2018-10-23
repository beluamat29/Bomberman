package gradle.cucumber;

public class Celda {

    private final Integer x;
    private final Integer y;
    private boolean conPared;
    private boolean conEnemigo;
    private Pared pared;

    public Celda(Integer unEjeX, Integer unEjeY) {
        x = unEjeX;
        y = unEjeY;
        conPared = false;
        conEnemigo = false;
    }

    public Celda(Integer unEjeX, Integer unEjeY, Pared unaPared) {
        x = unEjeX;
        y = unEjeY;
        pared = unaPared;
        conPared = true;
        conEnemigo = false;
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

    public void setTieneEnemigo(Boolean tieneEnemigo){
        this.conEnemigo = tieneEnemigo;
    }

    public void setConPared(Boolean conPared){
        this.conPared = conPared;
    }

    public void destruirEnemigo(){
        this.conEnemigo = false;
    }

    public void destruirPared() {
        this.conPared = false;
    }

    public boolean estaEnElRadio(Integer ejeX, Integer ejeY, Integer radioDeCasilleros) {
        return (x + radioDeCasilleros) >= ejeX && (x - radioDeCasilleros) <= ejeX
                && (y + radioDeCasilleros) >= ejeY && (y - radioDeCasilleros) <= ejeY;
    }

    public boolean tienePared() {
        return conPared;
    }

    public boolean tieneParedDeMelamina() {
        return pared.esDeMelamina();
    }
}

