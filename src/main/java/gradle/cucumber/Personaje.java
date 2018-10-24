package gradle.cucumber;

public abstract class Personaje {
    protected boolean muerto;

    public  Personaje() {
        this.muerto = false;
    }

    protected void morir() {
        muerto = true;
    }

    public boolean estaMuerto() {
        return muerto;
    }


}
