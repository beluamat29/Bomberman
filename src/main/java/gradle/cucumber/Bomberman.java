package gradle.cucumber;

import java.util.ArrayList;

public class Bomberman extends Personaje {

    public Bomberman(Celda ubicacionActual) {
        super(ubicacionActual);
    }

    public void moverHacia(Celda unaCelda) {
        if(unaCelda.noTienePared()){
            ubicacionActual = unaCelda;
        }
        if(unaCelda.tieneEnemigo()){
            morir();
        }
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

                verificacionDeObstaculo(celdasTablero.get(indiceCelda));
            }

            //Verifico el radio de celdas hacia la izquierda
            if(celdasTablero.get(indiceCelda).getX() == (celdaActualX - i) && celdasTablero.get(indiceCelda).getY() == (celdaActualY)){

                verificacionDeObstaculo(celdasTablero.get(indiceCelda));
            }

            //Verifico el radio de celdas hacia arriba
            if(celdasTablero.get(indiceCelda).getX() == (celdaActualX ) && celdasTablero.get(indiceCelda).getY() == (celdaActualY + 1)){

                verificacionDeObstaculo(celdasTablero.get(indiceCelda));
            }

            //Verifico el radio de celdas hacia abajo
            if(celdasTablero.get(indiceCelda).getX() == (celdaActualX ) && celdasTablero.get(indiceCelda).getY() == (celdaActualY - 1)){

                verificacionDeObstaculo(celdasTablero.get(indiceCelda));
            }

            indiceCelda = indiceCelda + 1;
        }

    }
}
