package gradle.cucumber;

import java.util.ArrayList;

public class Bomberman {

    private Celda ubicacionActual;
    private boolean muerto;
    private Tablero tablero;

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

    public void soltarBombaAUnRadioDeCasilleros(int radioDeCasilleros, Tablero tablero){

        Celda celdaActual = this.getUbicacion();

        int celdaActualX = celdaActual.getX();
        int celdaActualY = celdaActual.getY();

        ArrayList<Celda> celdasTablero = tablero.getCeldas();

        int indiceCelda = 0;
        for (int i = 1; i <= 3; ++i){
            if(celdasTablero.get(indiceCelda).getX() == (celdaActualX + 1) && celdasTablero.get(indiceCelda).getY() == (celdaActualY)){

                indiceCelda = indiceCelda + 1;

                if(!celdasTablero.get(indiceCelda).estaVacia()){
                    celdasTablero.get(indiceCelda).destruirPared();
                }
            }
        }

    }

    public Celda obtenerCeldaDeEjeXDeLaPosicion(Celda celda, int i){
        int celdaX = celda.getX() + i;
        int celdaY = celda.getY();

        return (new Celda(celdaX, celdaY,true,false));
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
}
