Feature: Interaccion Con Enemigo

  Scenario: Bomberman se quiere mover a celda vacia
    Given Un Bomberman en la celda "1" "1"
    When Le paso la celda vacia "2" "1"
    Then Esta vivo y su ubicacion actual es "2" "1"