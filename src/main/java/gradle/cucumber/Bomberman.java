package gradle.cucumber;

public class Bomberman {

    private Celda ubicacionActual;

    public Bomberman(Celda unaCelda) {
        ubicacionActual = unaCelda;
    }

    public void moverHacia(Celda unaCelda) {
        if(unaCelda.estaVacia()){
            ubicacionActual = unaCelda;
        }
    }

    public Celda getUbicacion() {
        return ubicacionActual;
    }
}
