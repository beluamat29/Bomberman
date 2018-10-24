package gradle.cucumber;

public class EnemigoProtoMaxJr extends Enemigo {

    public EnemigoProtoMaxJr() {
        super();
    }

    @Override
    public boolean esProtoMaxJr() {
        return true;
    }

    @Override
    public void otorgarPoderAlMorirPara(Bomberman bomberman) {
        bomberman.obtenerPoderDeSalto();
        morir();
    }
}
