Feature: Mover Bomberman

  Scenario: Bomberman se quiere mover a celda vacia
    Given Un Bomberman en la celda "1" "1"
    When Le paso la celda vacia "2" "1"
    Then Su ubicacion actual es "2" "1"

  Scenario: Bomberman se quiere mover a celda con pared
    Given Un Bomberman en la celda "1" "1"
    When Le paso la celda con pared "2" "1"
    Then Su ubicacion actual es "1" "1"