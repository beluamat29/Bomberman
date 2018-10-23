package gradle.cucumber;

public class Enemigo extends Personaje {

    public Enemigo(Celda ubicacionActual) {
        super(ubicacionActual);
        ubicacionActual.setTieneEnemigo(true);
        ubicacionActual.setEnemigo(this);
    }

    public boolean esProtoMaxJr() {
        return false;
    }

    public boolean esBagulaa() {
        return false;
    }

    public boolean esProtoMaxUnits() {
        return false;
    }

}
