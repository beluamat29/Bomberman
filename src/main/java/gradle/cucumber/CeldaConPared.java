package gradle.cucumber;

public class CeldaConPared extends Celda {

    public CeldaConPared(Integer ejeX, Integer ejeY, Pared pared) {
        super(ejeX, ejeY);
        this.pared = pared;
    }

    @Override
    public boolean tieneEnemigo() {
        return false;
    }

    @Override
    public boolean tienePared() {
        return pared != null;
    }

    @Override
    public boolean tieneParedDeMelamina() {
        return tienePared() && pared.esDeMelamina();
    }

    @Override
    public void destruirObstaculoPara(Bomberman bomberman, Tablero tablero) {
        if (tieneParedDeMelamina()) {
            pared = null;
        }
    }

    @Override
    public void realizarAccionPara(Bomberman bomberman, String direccion, Tablero tablero) {
        if (bomberman.tienePoderDeSalto()) {
            bomberman.setUbicacion(this);
            bomberman.moverHacia(direccion, tablero);
        }
    }
}
