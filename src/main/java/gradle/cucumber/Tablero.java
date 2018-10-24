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

    public Celda celdaHacia(String direccion, Celda ubicacionActual) {

        if (direccion.equals("derecha")) {
            return celdaHaciaLaDerecha(ubicacionActual);
        } else if (direccion.equals("izquierda")) {
            return celdaHaciaLaIzquierda(ubicacionActual);
        } else if (direccion.equals("arriba")) {
            return celdaHaciaArriba(ubicacionActual);
        } else if (direccion.equals("abajo")) {
            return celdaHaciaAbajo(ubicacionActual);
        }
        else {
            return ubicacionActual;
        }
    }

    public Celda getCeldaHaceNCasillerosEnDireccion(String direccion, Integer nCasilleros, Celda ubicacionActual) {
        if (direccion.equals("derecha")) {
            return getCeldaEnEjes(ubicacionActual.getX() + nCasilleros, ubicacionActual.getY());
        }
        if (direccion.equalsIgnoreCase("izquierda")) {
            return getCeldaEnEjes(ubicacionActual.getX() - nCasilleros, ubicacionActual.getY());
        }
        if (direccion.equalsIgnoreCase("arriba")) {
            return getCeldaEnEjes(ubicacionActual.getX(), ubicacionActual.getY() + nCasilleros);
        }
        if (direccion.equalsIgnoreCase("abajo")) {
            return getCeldaEnEjes(ubicacionActual.getX(), ubicacionActual.getY() - nCasilleros);

        }
        else {
            return ubicacionActual;
        }
    }
}
