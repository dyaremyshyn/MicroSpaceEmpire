/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Eventos;

import logicaJogo.JogoDados;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class Asteroid  extends Evento{
     public Asteroid() {
        super("Asteroid");
    }
    
    @Override
    public void year1(JogoDados j){
        j.setRiqueza(j.getRiqueza()+1);
    }
    
    @Override
    public void year2(JogoDados j){
         j.setRiqueza(j.getRiqueza()+1);
    }
}
