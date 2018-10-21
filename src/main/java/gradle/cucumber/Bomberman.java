package gradle.cucumber;

public class Bomberman {

    private Celda ubicacionActual;
    private boolean muerto;

    public Bomberman(Celda unaCelda) {
        ubicacionActual = unaCelda;
        muerto = false;
    }

    public void moverHacia(Celda unaCelda) {
        if(unaCelda.estaVacia()){
            ubicacionActual = unaCelda;
        }
        if(unaCelda.tieneEnemigo()){
            morir();
        }
    }

    private void morir() {
        muerto = true;
    }

    public Celda getUbicacion() {
        return ubicacionActual;
    }

    public boolean estaMuerto() {
        return muerto;
    }

    public void soltarBombaAUnRadioDeCasilleros(int radioDeCasilleros){

        Celda celdaActual = this.getUbicacion();
        int celdaX = celdaActual.getX();
        int celdaY = celdaActual.getY();

        for (int i = 0; i < radioDeCasilleros; i++){

            if()

        }





    }
}
