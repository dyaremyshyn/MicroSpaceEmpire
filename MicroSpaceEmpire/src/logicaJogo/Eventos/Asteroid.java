/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.Eventos;

import logicaJogo.JogoDados;


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
