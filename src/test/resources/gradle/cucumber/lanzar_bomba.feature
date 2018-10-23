Feature: Lanzar Bomba

  Scenario: Bomberman lanza bomba a un determinado radio y rompe paredes de melamina
    Given Un Bomberman ubicado en la celda "0" "0"
    When Le agrego al tablero la celda con pared "1" "0"
    When Le agrego al tablero la celda vacia "1" "2"
    When Bomberman lanza bomba
    Then Se destruyo la pared de la celda "1" "0"

  Scenario: Bomberman lanza bomba a un determinado radio y no rompe paredes de melamina por lejania
    Given Un Bomberman ubicado en la celda "0" "0"
    When Le agrego al tablero la celda con pared "5" "0"
    When Bomberman lanza bomba
    Then No se destruye ninguna pared en la celda "5" "0"

  Scenario: Bomberman lanza bomba a un determinado radio y elimina enemigo
    Given Un Bomberman ubicado en la celda "0" "0"
    When Le agrego al tablero la celda con enemigo "1" "2"
    When Bomberman lanza bomba
    Then Se elimina al enemigo de la celda "1" "2"

  Scenario: Bomberman lanza bomba a un determinado radio y no elimina enemigo por lejania
    Given Un Bomberman ubicado en la celda "0" "0"
    When Le agrego al tablero la celda con enemigo "5" "2"
    When Bomberman lanza bomba
    Then No se elimina al enemigo de la celda "5" "2"