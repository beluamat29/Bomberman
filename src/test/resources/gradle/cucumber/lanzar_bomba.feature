Feature: Lanzar Bomba

  Scenario: Bomberman lanza bomba a un determinado radio
    Given Un Bomberman ubicado en la celda "0" "0"
    When Le agrego al tablero la celda con pared "1" "0"
    When Le agrego al tablero la celda vacia "1" "2"
    When Bomberman lanza bomba
    Then Se destruyo la pared de la celda "1" "0"