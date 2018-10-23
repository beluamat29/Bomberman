package gradle.cucumber;

import java.util.ArrayList;

public class Bomberman extends Personaje {

    private boolean tienePoderDeSalto;

    public Bomberman(Celda ubicacionActual) {
        super(ubicacionActual);
        tienePoderDeSalto = false;
    }

    public void moverHacia(Celda unaCelda) {
        if (!unaCelda.tienePared()) {
            ubicacionActual = unaCelda;
        }
        if (tienePoderDeSalto) {
            ubicacionActual = new Celda(unaCelda.getX() + 1, unaCelda.getY());
        }
        if (unaCelda.tieneEnemigo()) {
            morir();
        }
    }

    public void soltarBombaAUnRadioDeCasilleros(Integer radioDeCasilleros, Tablero tablero) {
        ArrayList<Celda> celdasTablero = tablero.getCeldas();

        celdasTablero.forEach(celda -> {
            if (celda.estaEnElRadio(ubicacionActual.getX(), ubicacionActual.getY(), radioDeCasilleros)) {
                if (celda.tienePared() && celda.tieneParedDeMelamina()) {
                    celda.destruirPared();
                }

                if (celda.tieneEnemigo()) {
                    celda.destruirEnemigo(this);
                }
            }
        });
    }

    public void obtenerPoderDeSalto() {
        tienePoderDeSalto = true;
    }
}
