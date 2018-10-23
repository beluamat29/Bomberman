package gradle.cucumber;

public abstract class Personaje {
    protected Celda ubicacionActual;
    protected boolean muerto;

    public  Personaje(Celda ubicacionActual) {
        this.ubicacionActual = ubicacionActual;
        this.muerto = false;
    }

    protected void morir() {
        muerto = true;
    }

    public Celda getUbicacion() {
        return ubicacionActual;
    }

    public boolean estaMuerto() {
        return muerto;
    }
}
