package gradle.cucumber;

public class Celda {

    private final Integer x;
    private final Integer y;
    private boolean conPared;
    private boolean conEnemigo;
    private Pared pared;
    private Enemigo enemigo;

    public Celda(Integer unEjeX, Integer unEjeY) {
        x = unEjeX;
        y = unEjeY;
        conPared = false;
        conEnemigo = false;
    }

    public Celda(Integer unEjeX, Integer unEjeY, Pared unaPared) {
        x = unEjeX;
        y = unEjeY;
        pared = unaPared;
        conPared = true;
        conEnemigo = false;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public boolean tieneEnemigo() {
        return conEnemigo;
    }

    public void setTieneEnemigo(Boolean tieneEnemigo){
        this.conEnemigo = tieneEnemigo;
    }

    public void setConPared(Boolean conPared){
        this.conPared = conPared;
    }

    public void destruirEnemigo(Bomberman bomberman){
        if (enemigo.esProtoMaxJr()) {
            bomberman.obtenerPoderDeSalto();
        }
        if(enemigo.esBagulaa()){
            bomberman.obtenerPoderDeLanzarBombasRecorriendoNCasilleros();
        }
        if(enemigo.esProtoMaxUnits()){
            bomberman.obtenerPoderDeSaltarOLanzarVariasBombas();
        }


        this.conEnemigo = false;
    }

    public void destruirPared() {
        this.conPared = false;
    }

    public boolean estaEnElRadio(Integer ejeX, Integer ejeY, Integer radioDeCasilleros) {
        return (x + radioDeCasilleros) >= ejeX && (x - radioDeCasilleros) <= ejeX
                && (y + radioDeCasilleros) >= ejeY && (y - radioDeCasilleros) <= ejeY;
    }

    public boolean tienePared() {
        return conPared;
    }

    public boolean tieneParedDeMelamina() {
        return pared.esDeMelamina();
    }

    public void setEnemigo(Enemigo unEnemigo) {
        enemigo = unEnemigo;
    }

    public boolean estaHaciaLaDerecha(Integer ejeX, Integer nCasilleros) {
        return (x + nCasilleros) >= ejeX  ;
    }

    public boolean estaHaciaLaIzquierda(Integer ejeX, Integer nCasilleros) {
        return (x - nCasilleros) <= ejeX  ;
    }

    public boolean estaHaciaArriba(Integer ejeY, Integer nCasilleros) {
        return  (y + nCasilleros) >= ejeY  ;
    }

    public boolean estaHaciaAbajo(Integer ejeY, Integer nCasilleros) {
        return (y - nCasilleros) <= ejeY  ;
    }
}

