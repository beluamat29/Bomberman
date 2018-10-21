package gradle.cucumber;

import java.util.ArrayList;

public class Tablero {
    private Celda celda;
    private ArrayList<Celda> celdas = new ArrayList<Celda>();


    public Tablero(ArrayList<Celda> celdas){
        this.celdas = celdas;
    }

    public Tablero(){

    }

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


    public Boolean getCeldaEnEjes(Integer ejeX, Integer ejeY) {

        boolean noEncontrado = true;

        int i = 0;
        while (noEncontrado){
            if (this.getCeldas().get(i).getX() == ejeX && this.getCeldas().get(i).getY() == ejeY){
                noEncontrado = false;
                if(this.getCeldas().get(i).estaVacia()){
                    return true;
                }

            }else{
                i = i + 1;

            }

        }
    return false;
    }
}
