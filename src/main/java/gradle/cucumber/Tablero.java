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
}
