package gradle.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoverStepdefs {
    private Bomberman bom;
    private Tablero tablero;
    private Enemigo enemigo;
    private Pared pared;

    @Given("^Un Bomberman en la celda \"([^\"]*)\" \"([^\"]*)\"")
    public void newBomberman(String unEjeX, String unEjeY)throws Throwable {
        Celda celda = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY));
        bom = new Bomberman(celda);
        tablero = new Tablero();
    }

    @When("^Le paso la celda vacia \"([^\"]*)\" \"([^\"]*)\"")
    public void bombermanSeMueveHacia(String unEjeX,  String unEjeY){
        Celda celda = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY));
        bom.moverHacia(celda);
    }

    @When("^Le paso la celda con pared \"([^\"]*)\" \"([^\"]*)\"")
    public void bombermanSeQuiereMoverACeldaConPared(String  unEjeX,  String unEjeY){
        Celda celda = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY), pared = new Pared("Melamina"));
        bom.moverHacia(celda);
    }

    @When("Le paso una celda con un enemigo \"([^\"]*)\" \"([^\"]*)\"")
    public void bombermanSeQuiereMoverACeldaConEnemigo(String  unEjeX,  String unEjeY){
        Celda celda = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY));
        enemigo = new Enemigo(celda);
        bom.moverHacia(celda);
    }

    @Then("^Esta vivo y su ubicacion actual es \"([^\"]*)\" \"([^\"]*)\"")
     public void verificacionDeUbicacionYVida(String unEjeX, String unEjeY){
        verificarUbicacion(unEjeX, unEjeY);
        assertFalse(bom.estaMuerto());
    }

    @Then("^Esta muerto pero su ubicacion actual es \"([^\"]*)\" \"([^\"]*)\"")
    public void verificacionDeUbicacionYMuerte(String unEjeX, String unEjeY){
        verificarUbicacion(unEjeX, unEjeY);
        assertTrue(bom.estaMuerto());
    }

    private void verificarUbicacion(String unEjeX, String unEjeY) {
        Celda ubicacionActual = bom.getUbicacion();
        Celda ubicacionEsperada = new Celda(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY));

        assertThat(ubicacionActual.getX()).isEqualTo(ubicacionEsperada.getX());
        assertThat(ubicacionActual.getY()).isEqualTo(ubicacionEsperada.getY());
    }
}
