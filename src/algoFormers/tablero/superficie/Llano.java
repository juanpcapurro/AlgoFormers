package algoFormers.tablero.superficie;

/**
 * Created by Charly on 5/29/16.
 */
public class Llano implements Superficie {
    private static Llano ourInstance = new Llano();

    public static Llano getInstance() {
        return ourInstance;
    }

    private Llano() {
    }

    @Override
    public void cambiarALlano(SuperficieConcretaActual superficieActual){
    }

    @Override
    public void cambiarARocoso(SuperficieConcretaActual superficieActual) {
        superficieActual.cambiarActual(Rocoso.getInstance());
    }

    @Override
    public void cambiarAPantanoso(SuperficieConcretaActual superficieActual) {
        superficieActual.cambiarActual(Pantanoso.getInstance());
    }
}
