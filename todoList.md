
Básicamente ya está desarrollado lo que sería el Tablero y los Casilleros.

## To do list
* ~~Implementar métodos básicos del Tablero/Casillero.~~

* ~~Hacer pruebas que verifiquen los turnos.~~

* ~~Desarrollar las clase Turno, y decidir como se va a manejar.~~

* ~~Hacer Test de las superficies.~~

* ~~Desarrollar el state Superficie, y el 'switch' del state.~~

* ~~Desarrollar el state para los estados normal y alterno de los algoformers.~~

* ~~Hacer pruebas sobre todos los Algoformers (sus ataques, habilidades especiales, modo Alterno)~~

* ~~Desarrollar los Algoformers (Cada uno con sus propias caracteristicas)~~

* Armar test con las armas, los disparos en determinadas casillas. (Todos los objetos son atacables, pero los Espacios Vacio y los bonus si los atacan, no hacen nada, Si atacan un casillero, y el casillero es una superficie Rocosa, debe cambiar de Estado y ser una superficie LLana)EDIT AILU 30/5: Hay que implementar el recibirAtaque de cada superficie; puse comentada una idea de código en Rocoso pero no estoy segura si está bien entendido.

* Desarrollar la interacción y los métodos que van a relacionar las armas con los Atacables, Algoformers y las superficies.

* Idear una forma de obtener/validar los movimientos legales de los AlgoFormers, sin que el tablero sepa como se mueve cada uno ni que el algoFormer tenga que saber en que posicion está. Que les parece que el tablero le pregunte al algoFormer su velocidad o capacidad de movimiento, y que con este dato el tablero, sabiendo donde esta el algoFormer, calcule los movimientos legales?

* implementar bonus, modificadores de ataques velocidad, verificar que si ya tiene un bonus, no pueda agarrar otro.

* realizar los test relacionados a los bonus.
