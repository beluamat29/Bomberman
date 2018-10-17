package gradle.cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class MoverStepdefs {
    private Bomberman bom;

    @Given("^Un Bomberman en la celda \"([^\"]*)\" \"([^\"]*)\"")
    public void newBomberman(String unEjeX, String unEjeY)throws Throwable {
        Celda celda = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY), false);
        bom = new Bomberman(celda);
    }

    @When("^Le paso la celda vacia \"([^\"]*)\" \"([^\"]*)\"")
    public void bombermanSeMueveHacia(String unEjeX,  String unEjeY){
        Celda celda = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY), false);
        bom.moverHacia(celda);
    }

    @When("^Le paso la celda con pared \"([^\"]*)\" \"([^\"]*)\"")
    public void bombermanSeQuiereMoverACeldaConPared(String  unEjeX,  String unEjeY){
        Celda celda = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY), true);
        bom.moverHacia(celda);
    }

    @Then("^Su ubicacion actual es \"([^\"]*)\" \"([^\"]*)\"")
     public void verificacionDeUbicacion(String unEjeX, String unEjeY){
        Celda ubicacionActual = bom.getUbicacion();
        Celda ubicacionEsperada = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY), false);

        assertThat(ubicacionActual.getX()).isEqualTo(ubicacionEsperada.getX());
        assertThat(ubicacionActual.getY()).isEqualTo(ubicacionEsperada.getY());
    }
}
