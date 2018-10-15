Feature: Mover Bomberman

  Scenario: lalala
    Given Un Bomberman en la celda "a1"
    When Le paso la direccion "derecha" y la celda esta vacia
    Then Su ubicacion actual es "a2"

  Scenario: bomberman se quiere mover a celda con pared
    Given Un Bomberman en la celda "a2"
    When Le paso la direccion "norte" y en la celda hay una pared
    Then Su ubicacion actual es "a2"