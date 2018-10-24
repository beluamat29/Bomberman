package gradle.cucumber;

import java.util.ArrayList;

public class Bomberman extends Personaje {

    private boolean tienePoderDeSalto;
    private boolean tienePoderDeLanzarBombasNCasilleros;
    private boolean tienePoderDeSaltarOLanzarVariasBombas;
    private boolean tienePoderDeSaltoNVeces;
    private boolean bombaDisponible;
    private Bomba bomba;

    public Bomberman(Celda ubicacionActual, Bomba bomba) {
        super(ubicacionActual);
        tienePoderDeSalto = false;
        tienePoderDeLanzarBombasNCasilleros = false;
        tienePoderDeSaltarOLanzarVariasBombas = false;
        tienePoderDeSaltoNVeces = false;
        bombaDisponible = true;
        this.bomba = bomba;
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
        setBombaDisponible(true);
        this.getBomba().setExploto(false);
        celdasTablero.forEach(celda -> {
            if (celda.estaEnElRadio(ubicacionActual.getX(), ubicacionActual.getY(), radioDeCasilleros) && bombaDisponible && !(getBomba().getExploto()) ) {
                verificacionYEliminacionDeEnemigosYObstaculos(celda);
            }
        });

    }

    public void obtenerPoderDeLanzarBombasRecorriendoNCasilleros(){
        tienePoderDeLanzarBombasNCasilleros = true;
    }

    public void obtenerPoderDeSaltarOLanzarVariasBombas(){
        tienePoderDeSaltoNVeces = true;
        tienePoderDeLanzarBombasNCasilleros = true;
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
                        celda.estaHaciaLaIzquierda(ubicacionActual.getX(), nCasilleros)) {
                    verificacionYEliminacionDeEnemigosYObstaculos(celda);
                }
                if (direccion.equalsIgnoreCase("arriba") &&
                        celda.estaHaciaArriba(ubicacionActual.getY(), nCasilleros)) {
                    verificacionYEliminacionDeEnemigosYObstaculos(celda);
                }
                if (direccion.equalsIgnoreCase("abajo") &&
                        celda.estaHaciaAbajo(ubicacionActual.getY(), nCasilleros)) {
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


        //Una vez que la bomba explota se vuelve a actualizar
        //this.getBomba().setExploto(false);

    }

    public void saltarParedesHaciaUnaDireccion(String direccion, Tablero tablero){
        ArrayList<Celda> celdasTablero = tablero.getCeldas();
        if(tienePoderDeSaltoNVeces){
            int radio = 1;
            for (Celda celda : celdasTablero){
                if (direccion.equalsIgnoreCase("derecha") &&
                        celda.estaHaciaLaDerecha(ubicacionActual.getX(), radio) && !celda.tienePared() ) {
                    moverHacia(celda);
                }
                if (direccion.equalsIgnoreCase("izquierda") &&
                        celda.estaHaciaLaIzquierda(ubicacionActual.getX(), radio) && !celda.tienePared() ) {
                    moverHacia(celda);
                }
                if (direccion.equalsIgnoreCase("arriba") &&
                        celda.estaHaciaArriba(ubicacionActual.getY(), radio) && !celda.tienePared() ) {
                    moverHacia(celda);
                }
                if (direccion.equalsIgnoreCase("abajo") &&
                        celda.estaHaciaAbajo(ubicacionActual.getY(), radio) && !celda.tienePared() ) {
                    moverHacia(celda);
                }
                radio = radio + 1;
            }
        }

    }


    public Bomba getBomba() {
        return bomba;
    }

    public void setBomba(Bomba bomba) {
        this.bomba = bomba;
    }

    public boolean isBombaDisponible() {
        return bombaDisponible;
    }

    public void setBombaDisponible(boolean bombaDisponible) {
        this.bombaDisponible = bombaDisponible;
    }
}
