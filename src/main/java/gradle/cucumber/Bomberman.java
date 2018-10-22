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
        for (int i = 1; i <= radioDeCasilleros; ++i){

            //Verifico el radio de celdas hacia la derecha
            if(celdasTablero.get(indiceCelda).getX() == (celdaActualX + i) && celdasTablero.get(indiceCelda).getY() == (celdaActualY)){

                if(!celdasTablero.get(indiceCelda).estaVacia()){
                    celdasTablero.get(indiceCelda).destruirPared();
                }
            }

            //Verifico el radio de celdas hacia la izquierda
            if(celdasTablero.get(indiceCelda).getX() == (celdaActualX - i) && celdasTablero.get(indiceCelda).getY() == (celdaActualY)){

                if(!celdasTablero.get(indiceCelda).estaVacia()){
                    celdasTablero.get(indiceCelda).destruirPared();
                }
            }

            //Verifico el radio de celdas hacia arriba
            if(celdasTablero.get(indiceCelda).getX() == (celdaActualX ) && celdasTablero.get(indiceCelda).getY() == (celdaActualY + 1)){

                if(!celdasTablero.get(indiceCelda).estaVacia()){
                    celdasTablero.get(indiceCelda).destruirPared();
                }
            }

            //Verifico el radio de celdas hacia abajo
            if(celdasTablero.get(indiceCelda).getX() == (celdaActualX ) && celdasTablero.get(indiceCelda).getY() == (celdaActualY - 1)){

                if(!celdasTablero.get(indiceCelda).estaVacia()){
                    celdasTablero.get(indiceCelda).destruirPared();
                }

            }
            indiceCelda = indiceCelda + 1;
        }

    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
}
