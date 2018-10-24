package gradle.cucumber;

import java.util.ArrayList;

public class Bomberman extends Personaje {

    private boolean tienePoderDeSalto;
    private boolean tienePoderDeLanzarBombasNCasilleros;
    private boolean bombaDisponible;
    private Bomba bomba;
    private Celda ubicacionActual;

    public Bomberman(Celda ubicacionActual, Bomba bomba) {
        super();
        this.ubicacionActual = ubicacionActual;
        tienePoderDeSalto = false;
        tienePoderDeLanzarBombasNCasilleros = false;
        bombaDisponible = true;
        this.bomba = bomba;
    }

    public Celda getUbicacion() {
        return ubicacionActual;
    }

    public void moverHacia(String direccion, Tablero tablero) {
        Celda nuevaUbicacion = null;

        nuevaUbicacion = tablero.celdaHacia(direccion, ubicacionActual);

        nuevaUbicacion.realizarAccionPara(this, direccion, tablero);
    }

    public void soltarBombaAUnRadioDeCasilleros(Integer radioDeCasilleros, Tablero tablero) {
        ArrayList<Celda> celdasTablero = tablero.getCeldas();
        setBombaDisponible(true);
        celdasTablero.forEach(celda -> {
            if (celda.estaEnElRadio(ubicacionActual.getX(), ubicacionActual.getY(), radioDeCasilleros) && bombaDisponible) {
                verificacionYEliminacionDeEnemigosYObstaculos(celda, tablero);
            }
        });
    }

    public void obtenerPoderDeLanzarBombasRecorriendoNCasilleros() {
        tienePoderDeLanzarBombasNCasilleros = true;
    }

    public void obtenerPoderDeSaltarOLanzarVariasBombas() {
        tienePoderDeSalto = true;
        tienePoderDeLanzarBombasNCasilleros = true;
    }

    public void obtenerPoderDeSalto() {
        tienePoderDeSalto = true;
    }

    public void lanzarBombaRecorriendoNCasilleros(Integer nCasilleros, Tablero tablero, String direccion) {
        Celda celda;

        if (tienePoderDeLanzarBombasNCasilleros) {
            celda = tablero.getCeldaHaceNCasillerosEnDireccion(direccion, nCasilleros, ubicacionActual);
            verificacionYEliminacionDeEnemigosYObstaculos(celda, tablero);
        }
    }

    public void verificacionYEliminacionDeEnemigosYObstaculos(Celda celda, Tablero tablero) {
        celda.destruirObstaculoPara(this, tablero);

        //Una vez que la bomba explota se vuelve a actualizar
        this.getBomba().setExploto(false);
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

    public void setUbicacion(Celda celda) {
        ubicacionActual = celda;
    }

    public boolean tienePoderDeSalto() {
        return tienePoderDeSalto;
    }
}
