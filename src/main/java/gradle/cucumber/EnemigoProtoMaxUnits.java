package gradle.cucumber;

public class EnemigoProtoMaxUnits extends Enemigo {

    public EnemigoProtoMaxUnits(Celda ubicacionActual) {
        super(ubicacionActual);
    }

    @Override
    public boolean esProtoMaxUnits() {
        return true;
    }

    @Override
    public void otorgarPoderAlMorirPara(Bomberman bomberman) {
        bomberman.obtenerPoderDeSaltarOLanzarVariasBombas();
    }
}
