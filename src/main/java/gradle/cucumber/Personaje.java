package gradle.cucumber;

import java.util.ArrayList;

public abstract class Personaje {

    protected Celda ubicacionActual;
    protected boolean muerto;
    protected Tablero tablero;

    public  Personaje(Celda ubicacionActual) {
        this.ubicacionActual = ubicacionActual;
        this.muerto = false;
    }

    protected void morir() {
        muerto = true;
    }

    public Celda getUbicacion() {
        return ubicacionActual;
    }

    public boolean estaMuerto() {
        return muerto;
    }



    public void verificacionDeObstaculo(Celda celda){
        if(!celda.noTienePared()){
            celda.destruirPared();
        }else if(celda.tieneEnemigo()){
            celda.destruirEnemigo();
        }
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
}
