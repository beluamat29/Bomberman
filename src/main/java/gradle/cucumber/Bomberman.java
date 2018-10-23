package gradle.cucumber;

import java.util.ArrayList;

public class Bomberman extends Personaje {

    public Bomberman(Celda ubicacionActual) {
        super(ubicacionActual);
    }

    public void moverHacia(Celda unaCelda) {
        if (!unaCelda.tienePared()) {
            ubicacionActual = unaCelda;
        }
        if (unaCelda.tieneEnemigo()) {
            morir();
        }
    }

    public void soltarBombaAUnRadioDeCasilleros(int radioDeCasilleros, Tablero tablero) {
        ArrayList<Celda> celdasTablero = tablero.getCeldas();

        celdasTablero.forEach(celda -> {
            if (celda.estaEnElRadio(ubicacionActual.getX(), ubicacionActual.getY())) {
                celda.destruirPared();
                celda.destruirEnemigo();
            }
        });
    }
}
