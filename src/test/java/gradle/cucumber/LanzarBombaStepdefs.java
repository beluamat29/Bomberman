package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LanzarBombaStepdefs {
    private Bomberman bom;
    private Tablero tablero;

    @Given("^Un Bomberman ubicado en la celda \"([^\"]*)\" \"([^\"]*)\"")
    public void newBomberman(String unEjeX, String unEjeY)throws Throwable {
        Celda celda = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY), false, false);
        bom = new Bomberman(celda);
        tablero = new Tablero();
    }

    @When("^Le agrego al tablero la celda con pared \"([^\"]*)\" \"([^\"]*)\"")
    public void seAgregaCeldaConParedAlTablero(String  unEjeX,  String unEjeY){
        Celda celda = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY), true, false);
        tablero.agregarCelda(celda);
    }

    @When("^Le agrego al tablero la celda vacia \"([^\"]*)\" \"([^\"]*)\"")
    public void seAgregaCeldaVaciaAlTablero(String  unEjeX,  String unEjeY){
        Celda celda = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY), false, false);
        tablero.agregarCelda(celda);
    }

    @When("^Bomberman lanza bomba$")
    public void bombermanLanzaBomba() throws Throwable {
        bom.soltarBombaAUnRadioDeCasilleros(2, tablero);
    }


    @Then("^Se destruyo la pared de la celda \"([^\"]*)\" \"([^\"]*)\"")
    public void verificacionDeCeldaConParedDestruida(String unEjeX, String unEjeY){
        assertTrue(tablero.getCeldaEnEjes(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY)));
    }
}
