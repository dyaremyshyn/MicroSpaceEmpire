/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Eventos;

import logicaJogo.Cartas.Carta;
import logicaJogo.JogoDados;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class Revolt2 extends Evento{

    public Revolt2() {
        super("Revolt2");
    }
    
    @Override
    public void year1(JogoDados j){
        Carta c=j.escolheSistemaDoImperio();
        if(j.lancaDado()+1<c.getResistencia()){
            if(j.temHyperTelevision())
                c.setResistencia(c.getResistencia()+1);
        }
        else{
            c.setTipoSistema("Distant System");
            j.retiraSistemaImperio(c);
        }
    }
    
    @Override
    public void year2(JogoDados j){
        Carta c=j.escolheSistemaDoImperio();
        if(j.lancaDado()+1<c.getResistencia()){
            if(j.temHyperTelevision())
                c.setResistencia(c.getResistencia()+2);
        }
        else{
            c.setTipoSistema("Distant System");
            j.retiraSistemaImperio(c);
        }
    }
}
