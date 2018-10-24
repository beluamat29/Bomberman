package gradle.cucumber;

public class CeldaConEnemigo extends Celda {

    public CeldaConEnemigo(Integer ejeX, Integer ejeY, Enemigo enemigo) {
        super(ejeX, ejeY);
        this.enemigo = enemigo;
    }

    @Override
    public boolean tieneEnemigo() {
        return !enemigo.estaMuerto();
    }

    @Override
    public boolean tienePared() {
        return false;
    }

    @Override
    public boolean tieneParedDeMelamina() {
        return false;
    }

    @Override
    public void destruirObstaculoPara(Bomberman bomberman, Tablero tablero) {
        destruirEnemigo(bomberman);
    }

    @Override
    public void realizarAccionPara(Bomberman bomberman, String direccion, Tablero tablero) {
        bomberman.morir();
    }

    protected void destruirEnemigo(Bomberman bomberman){
        enemigo.otorgarPoderAlMorirPara(bomberman);
    }
}
