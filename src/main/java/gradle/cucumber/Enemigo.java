package gradle.cucumber;

public class Enemigo extends Personaje {

    public Enemigo(Celda ubicacionActual) {
        super(ubicacionActual);
        ubicacionActual.setTieneEnemigo(true);
    }
}
