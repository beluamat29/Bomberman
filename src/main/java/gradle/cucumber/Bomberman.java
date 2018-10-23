package gradle.cucumber;

import java.util.ArrayList;

public class Bomberman extends Personaje {

    private boolean tienePoderDeSalto;
    private boolean tienePoderDeLanzarBombasNCasilleros;
    private boolean tienePoderDeSaltarOLanzarVariasBombas;

    public Bomberman(Celda ubicacionActual) {
        super(ubicacionActual);
        tienePoderDeSalto = false;
        tienePoderDeLanzarBombasNCasilleros = false;
        tienePoderDeSaltarOLanzarVariasBombas = false;
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

    public void obtenerPoderDeLanzarBombasRecorriendoNCasilleros(){
        tienePoderDeLanzarBombasNCasilleros = true;
    }

    public void obtenerPoderDeSaltarOLanzarVariasBombas(){
        tienePoderDeSaltarOLanzarVariasBombas = true;
    }

    public void obtenerPoderDeSalto() {
        tienePoderDeSalto = true;
    }

    public void lanzarBombaRecorriendoNCasilleros(Integer nCasilleros, Tablero tablero, String direccion) {
        ArrayList<Celda> celdasTablero = tablero.getCeldas();
        if(tienePoderDeLanzarBombasNCasilleros){
            celdasTablero.forEach(celda -> {
                if (direccion.equalsIgnoreCase("derecha") &&
                        celda.estaHaciaLaDerecha(ubicacionActual.getX(), nCasilleros)) {
                    verificacionYEliminacionDeEnemigosYObstaculos(celda);
                }
                if (direccion.equalsIgnoreCase("izquierda") &&
                        celda.estaHaciaLaDerecha(ubicacionActual.getX(), nCasilleros)) {
                    verificacionYEliminacionDeEnemigosYObstaculos(celda);
                }
                if (direccion.equalsIgnoreCase("arriba") &&
                        celda.estaHaciaLaDerecha(ubicacionActual.getY(), nCasilleros)) {
                    verificacionYEliminacionDeEnemigosYObstaculos(celda);
                }
                if (direccion.equalsIgnoreCase("abajo") &&
                        celda.estaHaciaLaDerecha(ubicacionActual.getY(), nCasilleros)) {
                    verificacionYEliminacionDeEnemigosYObstaculos(celda);
                }
            });

        }

    }

    public void verificacionYEliminacionDeEnemigosYObstaculos(Celda celda){

        if (celda.tienePared() && celda.tieneParedDeMelamina()) {
            celda.destruirPared();
        }

        if (celda.tieneEnemigo()) {
            celda.destruirEnemigo(this);
        }

    }

    public void saltarOLanzarVariasBombas(){

    }


}
