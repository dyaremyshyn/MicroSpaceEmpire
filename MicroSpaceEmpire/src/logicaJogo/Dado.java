/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import java.io.Serializable;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class Dado implements Serializable{
    
    private final int minimo;
    private final int maximo;
    
    Dado(){minimo = 1; maximo = 6;}
    
    public int LancaDado(){
        return (int)(Math.random()*maximo) + minimo;
    }
}
