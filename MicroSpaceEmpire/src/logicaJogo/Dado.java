/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo;

import java.io.Serializable;


public class Dado implements Serializable{
    
    private final int minimo;
    private final int maximo;
    
    Dado(){minimo = 1; maximo = 6;}
    
    public int LancaDado(){
        return (int)(Math.random()*maximo) + minimo;
    }
}
