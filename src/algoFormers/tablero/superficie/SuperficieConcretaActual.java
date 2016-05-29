package algoFormers.tablero.superficie;

/**
 * Created by Charly on 5/29/16.
 */
public class SuperficieConcretaActual {
    Superficie actual;

    public SuperficieConcretaActual(){actual=Llano.getInstance();}

    public void cambiarARocoso(){
        actual.cambiarARocoso(this);
    }

    public void cambiarAPantanoso(){
        actual.cambiarAPantanoso(this);
    }
    public void cambiarALlano(){
        actual.cambiarALlano(this);
    }
    public Superficie verActual(){
        return actual;
    }
    public void cambiarActual(Superficie aCambiar){
        actual=aCambiar;
    }
}
