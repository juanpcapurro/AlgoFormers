
B√°sicamente ya est√° desarrollado lo que ser√≠a el Tablero y los Casilleros.

## To do list
* ~~Implementar m√©todos b√°sicos del Tablero/Casillero.~~ EDIT AILU 30/5: Para mi casillero ya est·; queda completar tablero.

* Hacer pruebas que verifiquen los turnos.

* Desarrollar las clase Turno, y decidir como se va a manejar.Nota: propongo que haya una instancia de una clase Juego o algo as√≠(posiblemente un singleton) que sepa de quien es el turno, y haga las interacciones entre la UI y el Tablero, desacoplando al tablero del resto del programa.

* ~~Hacer Test de las superficies.~~ EDIT AILU 30/5: Est·n testeados todos los cambios de las superficies (cada una con las otras dos, y que cambie a sÌ misma). Entiendo que est· testeado todo el cÛdigo existente de superficies.

* ~~Desarrollar el state Superficie, y el 'switch' del state.~~

* ~~Desarrollar el state para los estados normal y alterno de los algoformers.~~

* Hacer pruebas sobre todos los Algoformers (sus ataques, habilidades especiales, modo Alterno)
* ~~Desarrollar los Algoformers (Cada uno con sus propias caracteristicas).~~ EDIT: Faltan desarrollar los modos y las caracterÌsticas seg˙n esos modos.

* Armar test con las armas, los disparos en determinadas casillas. (Todos los objetos son atacables, pero los Espacios Vacio y los bonus si los atacan, no hacen nada, Si atacan un casillero, y el casillero es una superficie Rocosa, debe cambiar de Estado y ser una superficie LLana)EDIT AILU 30/5: Hay que implementar el recibirAtaque de cada superficie; puse comentada una idea de cÛdigo en Rocoso pero no estoy segura si est· bien entendido.

* Desarrollar la interacci√≥n y los m√©todos que van a relacionar las armas con los Atacables, Algoformers y las superficies.

* Idear una forma de obtener/validar los movimientos legales de los AlgoFormers, sin que el tablero sepa como se mueve cada uno ni que el algoFormer tenga que saber en que posicion est√°. Que les parece que el tablero le pregunte al algoFormer su velocidad o capacidad de movimiento, y que con este dato el tablero, sabiendo donde esta el algoFormer, calcule los movimientos legales?
