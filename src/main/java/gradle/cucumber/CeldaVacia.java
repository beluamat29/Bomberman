package gradle.cucumber;

public class CeldaVacia extends Celda {
    public CeldaVacia(Integer ejeX, Integer ejeY) {
        super(ejeX, ejeY);
    }

    @Override
    public boolean tieneEnemigo() {
        return false;
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

    }

    @Override
    public void realizarAccionPara(Bomberman bomberman, String direccion, Tablero tablero) {
        bomberman.setUbicacion(this);
    }
}
