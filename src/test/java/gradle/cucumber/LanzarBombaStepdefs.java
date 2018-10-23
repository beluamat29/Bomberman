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

    @Given("^Un Bomberman ubicado en la celda \"([^\"]*)\" \"([^\"]*)\"")
    public void newBomberman(String unEjeX, String unEjeY)throws Throwable {
        Celda celda = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY));
        bom = new Bomberman(celda);
        tablero = new Tablero();
    }

    @When("^Le agrego al tablero la celda con pared melamina \"([^\"]*)\" \"([^\"]*)\"")
    public void seAgregaCeldaConParedMelaminaAlTablero(String  unEjeX,  String unEjeY){
        Celda celda = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY), new Pared("Melamina"));
        tablero.agregarCelda(celda);
    }

    @When("^Le agrego al tablero la celda con pared acero \"([^\"]*)\" \"([^\"]*)\"")
    public void seAgregaCeldaConParedAceroAlTablero(String  unEjeX,  String unEjeY){
        Celda celda = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY), new Pared("Acero"));
        tablero.agregarCelda(celda);
    }

    @When("^Le agrego al tablero la celda con enemigo \"([^\"]*)\" \"([^\"]*)\"")
    public void seAgregaCeldaConEnemigoAlTablero(String  unEjeX,  String unEjeY){
        Celda celda = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY));
        new Enemigo(celda);
        tablero.agregarCelda(celda);
    }

    @When("^Le agrego al tablero la celda con enemigo Proto Max Jr \"([^\"]*)\" \"([^\"]*)\"")
    public void seAgregaCeldaConEnemigoProtoMaxJrAlTablero(String  unEjeX,  String unEjeY){
        Celda celda = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY));
        new EnemigoProtoMaxJr(celda);
        tablero.agregarCelda(celda);
    }

    @When("^Le agrego al tablero la celda vacia \"([^\"]*)\" \"([^\"]*)\"")
    public void seAgregaCeldaVaciaAlTablero(String  unEjeX,  String unEjeY){
        Celda celda = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY));
        tablero.agregarCelda(celda);
    }

    @When("^Bomberman lanza bomba$")
    public void bombermanLanzaBomba() throws Throwable {
        bom.soltarBombaAUnRadioDeCasilleros(2, tablero);
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

    @Then("^Bomberman obtiene poder, se quiere mover a \"([^\"]*)\" \"([^\"]*)\" pero salta paredes moviendose a celda \"([^\"]*)\" \"([^\"]*)\"")
    public void verificacionDeObtencionDePoderDeSaltarParedes(String unEjeX, String unEjeY, String unEjeXFinal, String unEjeYFinal){
        Celda celda = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY));
        bom.moverHacia(celda);

        verificarUbicacion(unEjeXFinal, unEjeYFinal);
    }

    private boolean todasLasCeldasConPared() {
        return tablero.getCeldas().stream().allMatch(celda -> celda.tienePared());
    }

    private void verificarUbicacion(String unEjeX, String unEjeY) {
        Celda ubicacionActual = bom.getUbicacion();
        Celda ubicacionEsperada = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY));

        assertThat(ubicacionActual.getX()).isEqualTo(ubicacionEsperada.getX());
        assertThat(ubicacionActual.getY()).isEqualTo(ubicacionEsperada.getY());
    }

    @And("^Bomberman obtiene poder y lanza bomba hacia la direccion \"([^\"]*)\" por \"([^\"]*)\" casilleros$")
    public void bombermanObtienePoderYLanzaBombaHaciaLaPorCasilleros(String direccion, String nCasilleros) throws Throwable {
        bom.lanzarBombaRecorriendoNCasilleros(Integer.valueOf(nCasilleros), tablero, direccion);
    }

    @When("^Le agrego al tablero la celda con enemigo Bagulaa \"([^\"]*)\" \"([^\"]*)\"$")
    public void leAgregoAlTableroLaCeldaConEnemigoBagulaa(String unEjeX, String unEjeY) throws Throwable {
        Celda celda = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY));
        new EnemigoBagulaa(celda);
        tablero.agregarCelda(celda);
    }

    @Then("^Se mueve hacia la direccion \"([^\"]*)\" salta la pared y su ubicacion actual es \"([^\"]*)\" \"([^\"]*)\"$")
    public void seMueveHaciaLaDireccionSaltaLaParedYSuUbicacionActualEs(String direccion, String x, String y) throws Throwable {
        bom.saltarParedesHaciaUnaDireccion(direccion, tablero);
        verificarUbicacion(x, y);

    }

    @When("^Le agrego al tablero la celda con enemigo Proto Max Units \"([^\"]*)\" \"([^\"]*)\"$")
    public void leAgregoAlTableroLaCeldaConEnemigoProtoMaxUnits(String x, String y) throws Throwable {
        Celda celda = new Celda(Integer.valueOf(x), Integer.valueOf(y));
        new EnemigoProtoMaxUnits(celda);
        tablero.agregarCelda(celda);
    }

    @And("^Bomberman lanza bomba a un radio de \"([^\"]*)\"$")
    public void bombermanLanzaBombaAUnRadioDe(String radio) throws Throwable {
        bom.soltarBombaAUnRadioDeCasilleros(Integer.valueOf(radio), tablero);

    }
}
