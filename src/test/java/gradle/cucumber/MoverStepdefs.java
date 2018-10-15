package gradle.cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class MoverStepdefs {
    private Bomberman bom;

    @Given("^Un Bomberman en la celda \"([^\"]*)\"")
    public void newBomberman(String unaCelda)throws Throwable {
        bom = new Bomberman(unaCelda);
    }

    @When("^Le paso la direccion \"([^\"]*)\" y la celda esta vacia")
    public void bombermanSeMueveHacia(String unaDireccion){
        bom.moverHacia(unaDireccion);
    }

    @When("^Le paso la direccion \"([^\"]*)\" y en la celda hay una pared")
    public void bombermanSeQuiereMoverACeldaConPared(String unaDireccion){
        bom.moverHacia(unaDireccion);
    }

    @Then("^Su ubicacion actual es \"([^\"]*)\"")
     public void verificacionDeUbicacion(String unaCelda){
        Object ubicacionActual = bom.getUbicacion();
        Object ubicacionEsperada = unaCelda;

        assertThat(ubicacionActual).isEqualTo(ubicacionEsperada);
    }
}
