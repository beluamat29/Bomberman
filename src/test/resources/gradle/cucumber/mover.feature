Feature: Mover Bomberman

  Scenario: Bomberman se quiere mover a celda vacia
    Given Un Bomberman en la celda "1" "1"
    When Le agrego al tablero una celda vacia "2" "1"
    And Bomberman se mueve hacia la "derecha"
    Then Esta vivo y su ubicacion actual es "2" "1"

  Scenario: Bomberman se quiere mover a celda con pared
    Given Un Bomberman en la celda "1" "1"
    When Le agrego al tablero una celda con pared melamina "1" "2"
    And Bomberman se mueve hacia la "arriba"
    Then Esta vivo y su ubicacion actual es "1" "1"

  Scenario: Bomberman se quiere mover a celda con enemigo
    Given Un Bomberman en la celda "1" "1"
    When Le agrego al tablero una celda con enemigo "0" "1"
    And Bomberman se mueve hacia la "izquierda"
    Then Bomberman muere

