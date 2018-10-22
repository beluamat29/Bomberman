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

    public boolean noTienePared() {
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

}

