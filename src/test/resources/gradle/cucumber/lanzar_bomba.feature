Feature: Lanzar Bomba

  Scenario: Bomberman lanza bomba a un determinado radio y rompe paredes de melamina
    Given Un Bomberman ubicado en la celda "0" "0"
    When Le agrego al tablero la celda con pared melamina "1" "0"
    And Le agrego al tablero la celda vacia "1" "2"
    And Bomberman lanza bomba
    Then Se destruyo la pared de la celda "1" "0"

  Scenario: Bomberman lanza bomba a un determinado radio y no rompe paredes de melamina por lejania
    Given Un Bomberman ubicado en la celda "0" "0"
    When Le agrego al tablero la celda con pared melamina "5" "0"
    And Bomberman lanza bomba
    Then No se destruye la pared en la celda "5" "0"

  Scenario: Bomberman lanza bomba a un determinado radio y elimina enemigo
    Given Un Bomberman ubicado en la celda "0" "0"
    When Le agrego al tablero la celda con enemigo "1" "2"
    And Bomberman lanza bomba
    Then Se elimina al enemigo de la celda "1" "2"

  Scenario: Bomberman lanza bomba a un determinado radio y no elimina enemigo por lejania
    Given Un Bomberman ubicado en la celda "0" "0"
    When Le agrego al tablero la celda con enemigo "5" "2"
    And Bomberman lanza bomba
    Then No se elimina al enemigo de la celda "5" "2"

  Scenario: Bomberman lanza bomba a un determinado radio y no rompe paredes de acero
    Given Un Bomberman ubicado en la celda "0" "0"
    When Le agrego al tablero la celda con pared acero "5" "0"
    And Le agrego al tablero la celda con pared acero "1" "0"
    And Bomberman lanza bomba
    Then No se destruye ninguna pared

  Scenario: Bomberman lanza bomba a un determinado radio y elimina Proto Max Jr
    Given Un Bomberman ubicado en la celda "0" "0"
    When Le agrego al tablero la celda con enemigo Proto Max Jr "1" "2"
    And Le agrego al tablero la celda con pared acero "1" "0"
    And Bomberman lanza bomba
    Then Bomberman obtiene poder, se quiere mover a "1" "0" pero salta paredes moviendose a celda "2" "0"