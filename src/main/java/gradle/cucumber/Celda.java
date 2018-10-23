package gradle.cucumber;

public class Celda {

    private final Integer x;
    private final Integer y;
    private boolean conPared;
    private boolean conEnemigo;

    public Celda(Integer unEjeX, Integer unEjeY) {
        x = unEjeX;
        y = unEjeY;
        conPared = false;
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

    public boolean estaEnElRadio(Integer ejeX, Integer ejeY) {
        return (x + 3) >= ejeX && (x - 3) <= ejeX && (y + 3) >= ejeY && (y - 3) <= ejeY;
    }

    public boolean tienePared() {
        return conPared;
    }
}

