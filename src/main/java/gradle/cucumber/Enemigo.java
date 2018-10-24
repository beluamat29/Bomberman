package gradle.cucumber;

public abstract class Enemigo extends Personaje {

    public Enemigo() { }

    public boolean esProtoMaxJr() {
        return false;
    }

    public boolean esBagulaa() {
        return false;
    }

    public boolean esProtoMaxUnits() {
        return false;
    }

    public abstract void otorgarPoderAlMorirPara(Bomberman bomberman);
}
