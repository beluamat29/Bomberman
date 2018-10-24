package gradle.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LanzarBombaStepdefs {
    private Bomberman bom;
    private Tablero tablero;
    private Bomba bomba;

    @Given("^Un Bomberman ubicado en la celda \"([^\"]*)\" \"([^\"]*)\"")
    public void newBomberman(String unEjeX, String unEjeY)throws Throwable {
        Celda celda = new CeldaVacia(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY));
        bomba = new Bomba(3);
        bom = new Bomberman(celda, bomba);
        tablero = new Tablero();
    }

    @When("^Le agrego al tablero la celda con pared melamina \"([^\"]*)\" \"([^\"]*)\"")
    public void seAgregaCeldaConParedMelaminaAlTablero(String  unEjeX,  String unEjeY){
        Celda celda = new CeldaConPared(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY), new Pared("Melamina"));
        tablero.agregarCelda(celda);
    }

    @When("^Le agrego al tablero la celda con pared acero \"([^\"]*)\" \"([^\"]*)\"")
    public void seAgregaCeldaConParedAceroAlTablero(String  unEjeX,  String unEjeY){
        Celda celda = new CeldaConPared(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY), new Pared("Acero"));
        tablero.agregarCelda(celda);
    }

    @When("^Le agrego al tablero la celda con enemigo \"([^\"]*)\" \"([^\"]*)\"")
    public void seAgregaCeldaConEnemigoAlTablero(String  unEjeX,  String unEjeY){
        Celda celda = new CeldaConEnemigo(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY), new EnemigoBagulaa());
        tablero.agregarCelda(celda);
    }

    @When("^Le agrego al tablero la celda con enemigo Proto Max Jr \"([^\"]*)\" \"([^\"]*)\"")
    public void seAgregaCeldaConEnemigoProtoMaxJrAlTablero(String  unEjeX,  String unEjeY){
        Celda celda = new CeldaConEnemigo(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY), new EnemigoProtoMaxJr());
        tablero.agregarCelda(celda);
    }

    @When("^Le agrego al tablero la celda vacia \"([^\"]*)\" \"([^\"]*)\"")
    public void seAgregaCeldaVaciaAlTablero(String  unEjeX,  String unEjeY){
        Celda celda = new CeldaVacia(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY));
        tablero.agregarCelda(celda);
    }

    @When("^Bomberman lanza bomba$")
    public void bombermanLanzaBomba() throws Throwable {
        bom.soltarBombaAUnRadioDeCasilleros(3, tablero);
    }

    @When("^Bomberman se mueve hacia la direccion \"([^\"]*)\"")
    public void bombermanSeMueveHacia(String direccion){
        bom.moverHacia(direccion, tablero);
    }

    @Then("^Se destruyo la pared de la celda \"([^\"]*)\" \"([^\"]*)\"")
    public void verificacionDeCeldaConParedDestruida(String unEjeX, String unEjeY){
        assertFalse(tablero.getCeldaEnEjes(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY)).tienePared());
    }

    @Then("^No se destruye la pared en la celda \"([^\"]*)\" \"([^\"]*)\"")
    public void verificacionDeParedesSinDestuir(String unEjeX, String unEjeY){
        assertTrue(tablero.getCeldaEnEjes(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY)).tienePared());
    }

    @Then("^No se destruye ninguna pared")
    public void verificacionDeParedesSinDestuir(){
        assertTrue(todasLasCeldasConPared());
    }

    @Then("^Se elimina al enemigo de la celda \"([^\"]*)\" \"([^\"]*)\"")
    public void verificacionDeCeldaEnemigoDestruido(String unEjeX, String unEjeY){
        assertFalse(tablero.getCeldaEnEjes(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY)).tieneEnemigo());
    }

    @Then("^No se elimina al enemigo de la celda \"([^\"]*)\" \"([^\"]*)\"")
    public void verificacionDeCeldaEnemigoNoDestruido(String unEjeX, String unEjeY){
        assertTrue(tablero.getCeldaEnEjes(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY)).tieneEnemigo());
    }

    @Then("^Salta paredes moviendose a celda \"([^\"]*)\" \"([^\"]*)\"")
    public void verificacionDeObtencionDePoderDeSaltarParedes(String unEjeXFinal, String unEjeYFinal){
        verificarUbicacion(unEjeXFinal, unEjeYFinal);
    }

    private boolean todasLasCeldasConPared() {
        return tablero.getCeldas().stream().allMatch(celda -> celda.tienePared());
    }

    private void verificarUbicacion(String unEjeX, String unEjeY) {
        Celda ubicacionActual = bom.getUbicacion();
        Celda ubicacionEsperada = new CeldaVacia(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY));

        assertThat(ubicacionActual.getX()).isEqualTo(ubicacionEsperada.getX());
        assertThat(ubicacionActual.getY()).isEqualTo(ubicacionEsperada.getY());
    }

    @And("^Bomberman obtiene poder y lanza bomba hacia la direccion \"([^\"]*)\" por \"([^\"]*)\" casilleros$")
    public void bombermanObtienePoderYLanzaBombaHaciaLaPorCasilleros(String direccion, String nCasilleros) throws Throwable {
        bom.lanzarBombaRecorriendoNCasilleros(Integer.valueOf(nCasilleros), tablero, direccion);
    }

    @When("^Le agrego al tablero la celda con enemigo Bagulaa \"([^\"]*)\" \"([^\"]*)\"$")
    public void leAgregoAlTableroLaCeldaConEnemigoBagulaa(String unEjeX, String unEjeY) throws Throwable {
        Celda celda = new CeldaConEnemigo(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY), new EnemigoBagulaa());
        tablero.agregarCelda(celda);
    }


    @When("^Le agrego al tablero la celda con enemigo Proto Max Units \"([^\"]*)\" \"([^\"]*)\"$")
    public void leAgregoAlTableroLaCeldaConEnemigoProtoMaxUnits(String x, String y) throws Throwable {
        Celda celda = new CeldaConEnemigo(Integer.valueOf(x), Integer.valueOf(y), new EnemigoProtoMaxUnits());
        tablero.agregarCelda(celda);
    }

    @And("^Bomberman lanza bomba a un radio de \"([^\"]*)\"$")
    public void bombermanLanzaBombaAUnRadioDe(String radio) throws Throwable {
        bom.soltarBombaAUnRadioDeCasilleros(Integer.valueOf(radio), tablero);

    }

    @Given("^Bomberman ubicado en la celda \"([^\"]*)\" \"([^\"]*)\" lanza bomba de \"([^\"]*)\" tick$")
    public void bombermanUbicadoEnLaCeldaLanzaBombaDeTick(String x, String y, String tick) throws Throwable {
        Celda celda = new CeldaVacia(Integer.valueOf(x), Integer.valueOf(y));
        bomba = new Bomba(Integer.valueOf(tick));
        bom = new Bomberman(celda,bomba);
    }

    @When("^pasa un tick$")
    public void pasaUnTick() throws Throwable {
        bom.getBomba().disminuirTick();
    }

    @Then("^La bomba exploto$")
    public void laBombaExploto() throws Throwable {
        assertTrue(bom.getBomba().getExploto());
    }
}
