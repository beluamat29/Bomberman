package gradle.cucumber;

import java.util.ArrayList;

public class Tablero {
    private Celda celda;
    private ArrayList<Celda> celdas = new ArrayList<Celda>();

    public Tablero(){}

    public void agregarCelda(Celda celda){
        this.celdas.add(celda);
    }

    public Celda getCelda() {
        return celda;
    }

    public void setCelda(Celda celda) {
        this.celda = celda;
    }

    public ArrayList<Celda> getCeldas(){
        return this.celdas;
    }


    public Celda getCeldaEnEjes(Integer ejeX, Integer ejeY) {
        return celdas.stream().filter(celda -> celda.getX().equals(ejeX) && celda.getY().equals(ejeY)).findFirst().get();
    }

    public Celda celdaHaciaLaDerecha(Celda unaCelda) {
        return celdas.stream()
                .filter(celda -> celda.getX().equals(unaCelda.getX() + 1) && celda.getY().equals(unaCelda.getY()))
                .findFirst().get();
    }

    public Celda celdaHaciaLaIzquierda(Celda unaCelda) {
        return celdas.stream()
                .filter(celda -> celda.getX().equals(unaCelda.getX() - 1) && celda.getY().equals(unaCelda.getY()))
                .findFirst().get();
    }

    public Celda celdaHaciaArriba(Celda unaCelda) {
        return celdas.stream()
                .filter(celda -> celda.getX().equals(unaCelda.getX()) && celda.getY().equals(unaCelda.getY() + 1))
                .findFirst().get();
    }

    public Celda celdaHaciaAbajo(Celda unaCelda) {
        return celdas.stream()
                .filter(celda -> celda.getX().equals(unaCelda.getX()) && celda.getY().equals(unaCelda.getY() - 1))
                .findFirst().get();
    }
}
