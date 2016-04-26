/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class Dado {
    
    private int minimo;
    private int maximo;
    
    
    Dado(){setMinimo(1);setMaximo(6);};
    
    public int LancaDado(){
        return (int)(Math.random()*maximo) + minimo;
    }

    
    //set's e get's //////////////////////////////////////////
   
    public int getMinimo() {
        return minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }
    
    
    
}
