package gradle.cucumber;

public class EnemigoBagulaa extends Enemigo {

    public EnemigoBagulaa(Celda ubicacionActual) {
        super(ubicacionActual);
    }

    @Override
    public boolean esBagulaa() {
        return true;
    }

    @Override
    public void otorgarPoderAlMorirPara(Bomberman bomberman) {
        bomberman.obtenerPoderDeLanzarBombasRecorriendoNCasilleros();
    }
}
