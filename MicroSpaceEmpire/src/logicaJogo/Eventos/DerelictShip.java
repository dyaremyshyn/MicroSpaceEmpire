/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.Eventos;

import logicaJogo.JogoDados;


public class DerelictShip extends Evento{

    public DerelictShip() {
        super("Derelict Ship");
    }
    
    @Override
    public void year1(JogoDados j){
       if((j.getMetal()+1)< j.getLimiteRecursos()){
        j.setMetal(j.getMetal()+1);
       }
    }
    
    @Override
    public void year2(JogoDados j){
        if((j.getMetal()+1)< j.getLimiteRecursos()){
        j.setMetal(j.getMetal()+1);
        }
    }
    
}
