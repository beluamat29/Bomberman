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

  Scenario: Bomberman lanza bomba n casilleros hacia la derecha, elimina a Bagulaa obtiene poder y elimina una pared de melamina
    Given Un Bomberman ubicado en la celda "0" "0"
    When Le agrego al tablero la celda con enemigo Bagulaa "0" "1"
    And Le agrego al tablero la celda con pared melamina "4" "0"
    And Bomberman lanza bomba
    And Bomberman obtiene poder y lanza bomba hacia la direccion "derecha" por "4" casilleros
    Then Se destruyo la pared de la celda "4" "0"

  Scenario: Bomberman lanza bomba n casilleros hacia la izquierda, elimina a Bagulaa obtiene poder y elimina una pared de melamina
    Given Un Bomberman ubicado en la celda "3" "0"
    When Le agrego al tablero la celda con enemigo Bagulaa "3" "1"
    And Le agrego al tablero la celda con pared melamina "0" "0"
    And Bomberman lanza bomba
    And Bomberman obtiene poder y lanza bomba hacia la direccion "izquierda" por "3" casilleros
    Then Se destruyo la pared de la celda "0" "0"

  Scenario: Bomberman lanza bomba n casilleros hacia arriba, elimina a Bagulaa obtiene poder y elimina una pared de melamina
    Given Un Bomberman ubicado en la celda "0" "0"
    When Le agrego al tablero la celda con enemigo Bagulaa "2" "0"
    And Le agrego al tablero la celda con pared melamina "0" "3"
    And Bomberman lanza bomba
    And Bomberman obtiene poder y lanza bomba hacia la direccion "arriba" por "3" casilleros
    Then Se destruyo la pared de la celda "0" "3"

  Scenario: Bomberman lanza bomba n casilleros hacia abajo, elimina a Bagulaa obtiene poder y elimina una pared de melamina
    Given Un Bomberman ubicado en la celda "0" "4"
    When Le agrego al tablero la celda con enemigo Bagulaa "1" "4"
    And Le agrego al tablero la celda con pared melamina "0" "0"
    And Bomberman lanza bomba
    And Bomberman obtiene poder y lanza bomba hacia la direccion "abajo" por "4" casilleros
    Then Se destruyo la pared de la celda "0" "0"


  Scenario: Bomberman salta paredes hacia la direccion derecha
    Given Un Bomberman ubicado en la celda "0" "0"
    When Le agrego al tablero la celda con enemigo Proto Max Units "0" "1"
    And Bomberman lanza bomba a un radio de "1"
    When Le agrego al tablero la celda con pared melamina "1" "0"
    When Le agrego al tablero la celda vacia "2" "0"
    Then Se mueve hacia la direccion "derecha" salta la pared y su ubicacion actual es "2" "0"

  Scenario: Bomberman salta paredes hacia la direccion izquierda
    Given Un Bomberman ubicado en la celda "3" "0"
    When Le agrego al tablero la celda con enemigo Proto Max Units "3" "1"
    And Bomberman lanza bomba a un radio de "1"
    When Le agrego al tablero la celda con pared melamina "1" "0"
    When Le agrego al tablero la celda con pared melamina "2" "0"
    When Le agrego al tablero la celda vacia "0" "0"
    Then Se mueve hacia la direccion "izquierda" salta la pared y su ubicacion actual es "0" "0"

  Scenario: Bomberman salta paredes hacia la direccion abajo
    Given Un Bomberman ubicado en la celda "0" "3"
    When Le agrego al tablero la celda con enemigo Proto Max Units "0" "4"
    And Bomberman lanza bomba a un radio de "1"
    When Le agrego al tablero la celda con pared melamina "0" "2"
    When Le agrego al tablero la celda con pared melamina "0" "1"
    When Le agrego al tablero la celda vacia "0" "0"
    Then Se mueve hacia la direccion "abajo" salta la pared y su ubicacion actual es "0" "0"

  Scenario: Bomberman salta paredes hacia la direccion arriba
    Given Un Bomberman ubicado en la celda "0" "0"
    When Le agrego al tablero la celda con enemigo Proto Max Units "1" "0"
    And Bomberman lanza bomba a un radio de "1"
    When Le agrego al tablero la celda con pared melamina "0" "1"
    When Le agrego al tablero la celda con pared melamina "0" "2"
    When Le agrego al tablero la celda vacia "0" "3"
    Then Se mueve hacia la direccion "arriba" salta la pared y su ubicacion actual es "0" "3"

