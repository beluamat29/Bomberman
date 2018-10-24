package gradle.cucumber;

public class EnemigoProtoMaxUnits extends Enemigo {

    public EnemigoProtoMaxUnits() {
        super();
    }

    @Override
    public boolean esProtoMaxUnits() {
        return true;
    }

    @Override
    public void otorgarPoderAlMorirPara(Bomberman bomberman) {
        bomberman.obtenerPoderDeSaltarOLanzarVariasBombas();
        morir();
    }
}
