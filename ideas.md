# Ideas para arrancar con el modelo del TP
> ### si a alguno se le ocurren algunas ideas más, o algo que le gustaria cambiar, añadirlas más abajo.

* Tablero
  1. Usar un Hash o una matriz.
  2. Vamos a hacerlo de tamaño variable, obviamente. ¿Pero que tan variable?¿ Vamos a dar la posibilidad de que el usuario ingrese exactamente el tamaño del tablero?¿ O vamos a darle una serie de tamaños predefinidos?( Ej.: chico,mediano,grande, muy grande).
  3. Debe contener una clase "Casillero", la cuál debe tener un estado que se llame "Tipo de terreno". ¿Por qué un estado? Me parecería genial que el terreno pueda ir cambiando mientras se está desarrollando el juego, Por ejemplo si tenemos un casillero con una zona "rocosa", y un transformer tira un misil en esa posición, el casillero pase a tener una zona "llana". O que tambien existan determinados bonus, que pudan hacer que obteniendo determinado item, poder elegir un casillero para inundarlo. En fin, eso lo vemos más adelante.
  4. Para los tipos de terrenos debemos usar interfaces, y debe existir una única instancia de cada tipo de terreno, y los distintos casilleros apuntan los mismos tipos de terreno. Como el ejemplo de las piezas del tablero de ajedrez (no se si todos estaban presentes), pero aplicado al terreno.
  5. Se me ocurre que los casilleros van a tener un atributo del tipo "colocado", donde van a tener un objeto del tipo "Colocable", de esta manera se resuelve el problema de poder tener un solo elemento en el casillero al mismo tiempo. Colocable puede ser un Transformer, un item, etc.



* Turnos
  1. ¿Los turnos van a ser Random? ¿Se puede elegir al principio de la jugada que jugador va a iniciar jugando? ¿Siempre va a arrancar el mismo jugador?
  Desde mi punto de vista, siempre tendrían que arrancar los Decepticons. Ya que los que siempre arrancan con la movida son los malos, y los buenos buscan detener a los malos. Pero generalmente no arrancan antes de que los malos empiecen a romper todo. Pero en definitiva es bastante debatible.
  2. Me parece interesante que dada determinada condición, los jugadores pierdan turnos.
  3. Va a haber una clase Turno. ¿Cómo va a ser? Todavia no se me ocurre, pero una posibilidad es que contenga una clase "Jugador", y que esta contenga todas las caracteristicas del jugador, con todos los bonus, desventajas, etc. Además de las caracteristicas y del bando que es cada jugador.
  4. ¿Va a existir un limite de turnos?
  5. ¿Se van a poder saltear turnos? Si es asi. ¿Va a poder ser indefinidamente o va a haber un limite de turnos que se van a poder saltear consecutivamente?


* Jugadores
  1. Básicamente se derrallo en el item anterior. Debería existir una clase "Jugador", que contenga todas las referencias a sus Transformer, el bando al que pertenece, bonus, desventajas, vida, y otras caracteristicas.
  2. Debería hacerse también con una interfaz. Por ahora solo hay dos tipos de jugadores, pero me parece genial dejar abierta la posibilidad de que haya un 3er jugador. Del tipo... ¿Humanos?¿Gatos voladores parlantes con rayos láser amantes de Netflix y Starbucks? No creo que lleguemos a hacerlo, pero sería genial dejar la posibilidad de agregar más tipos de jugadores.


* Unidades
  1. En principio, las "Unidades" van a heredar de la clase "Colocable". ¿Hace falta diferenciar los chicos buenos de los malos? Pienso que no hace falta diferenciarlos. Se podrían todas las unidades iguales en un principio,pero con caracteristicas diferentes (ataque,vida,velocidad, modo alterno, etc.). Una ventaja de esto, es que permite que las unidades cambien de bando sin ningún problema, lo único que hay que hacer es cambiar la referencia de los Jugadores. Lo cual me parece una caracteristica genial para agregar al juego, que dada determinada condicion, una unidad mala se pueda pasar al bando de los buenos, y viceversa,
  2. En cada unidad,Debe existir un objeto del tipo "Modo". El cual lo único que indica es si se encuentre en modo terrestre o volador, ya que las caracteristicas de ataque,velocidad, etc. No cambian de acuerdo al modo. No lo dice el enunciado, pero desde mi punto de vista si deberían cambiar, por ejemplo la velocidad en modo aéreo debe ser mayor que en modo terrestre, dando la posibilidad (quizás) a moverse dos casilleros por turno.
  3. De acuerdo al modo Superion y Menasor (la combinación de los transformer). En el enunciado dice que tenemos que definir nosotros la distancia a la que deben estar las unidades para poder formar el super robot. Y aca es donde tenemos que diferenciar si vamos a optar por lo más realista, o lo más interesante de acuerdo al juego. Lo más realista serían que todos las unidades esten a una distancia de 1/2/3 casilleros entre sí. Pero me resulta interesante que el super robot se pueda formar, solo si las unidades están alineadas en linea recta en el tablero, sin importar la distancia. Pero bueno no se, hay que pensarlo.
