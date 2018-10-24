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
    private Bomba bomba;

    @Given("^Un Bomberman en la celda \"([^\"]*)\" \"([^\"]*)\"")
    public void newBomberman(String unEjeX, String unEjeY)throws Throwable {
        Celda celda = new CeldaVacia(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY));
        bomba = new Bomba(5);
        bom = new Bomberman(celda,bomba);
        tablero = new Tablero();
        tablero.agregarCelda(celda);
    }

    @When("^Bomberman se mueve hacia la \"([^\"]*)\"")
    public void bombermanSeMueveHacia(String direccion){
        bom.moverHacia(direccion, tablero);
    }

    @When("^Le agrego al tablero una celda vacia \"([^\"]*)\" \"([^\"]*)\"")
    public void seAgregaCeldaVaciaAlTablero(String  unEjeX,  String unEjeY){
        Celda celda = new CeldaVacia(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY));
        tablero.agregarCelda(celda);
    }

    @When("^Le agrego al tablero una celda con enemigo \"([^\"]*)\" \"([^\"]*)\"")
    public void seAgregaCeldaConEnemigoAlTablero(String  unEjeX,  String unEjeY){
        Celda celda = new CeldaConEnemigo(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY), new EnemigoBagulaa());
        tablero.agregarCelda(celda);
    }

    @When("^Le agrego al tablero una celda con pared melamina \"([^\"]*)\" \"([^\"]*)\"")
    public void seAgregaCeldaConParedMelaminaAlTablero(String  unEjeX,  String unEjeY){
        Celda celda = new CeldaConPared(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY), new Pared("Melamina"));
        tablero.agregarCelda(celda);
    }

    @Then("^Esta vivo y su ubicacion actual es \"([^\"]*)\" \"([^\"]*)\"")
     public void verificacionDeUbicacionYVida(String unEjeX, String unEjeY){
        verificarUbicacion(unEjeX, unEjeY);
        assertFalse(bom.estaMuerto());
    }

    @Then("^Bomberman muere")
    public void verificacionDeMuerte(){
        assertTrue(bom.estaMuerto());
    }

    private void verificarUbicacion(String unEjeX, String unEjeY) {
        Celda ubicacionActual = bom.getUbicacion();
        Celda ubicacionEsperada = new CeldaVacia(Integer.valueOf(unEjeX), Integer.valueOf(unEjeY));

        assertThat(ubicacionActual.getX()).isEqualTo(ubicacionEsperada.getX());
        assertThat(ubicacionActual.getY()).isEqualTo(ubicacionEsperada.getY());
    }

}
