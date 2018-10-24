package gradle.cucumber;

public class EnemigoProtoMaxJr extends Enemigo {

    public EnemigoProtoMaxJr(Celda celda) {
        super(celda);
    }

    @Override
    public boolean esProtoMaxJr() {
        return true;
    }

    @Override
    public void otorgarPoderAlMorirPara(Bomberman bomberman) {
        bomberman.obtenerPoderDeSalto();
    }
}
