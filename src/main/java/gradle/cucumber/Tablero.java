package gradle.cucumber;

import java.util.ArrayList;

public class Tablero {
    private Celda celda;
    private ArrayList<Celda> celdas = new ArrayList<Celda>();

    public void agregarCelda(Celda celda){
        this.celdas.add(celda);
    }

    public ArrayList<Celda> getNombreArrayList() {
        return nombreArrayList;
    }

    public void setNombreArrayList(ArrayList<Celda> nombreArrayList) {
        this.nombreArrayList = nombreArrayList;
    }

    public Celda getCelda() {
        return celda;
    }

    public void setCelda(Celda celda) {
        this.celda = celda;
    }
}
