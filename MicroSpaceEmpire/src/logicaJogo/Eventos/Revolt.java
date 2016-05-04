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
public class Revolt extends Evento{

    public Revolt() {
        super("Revolt");
    }
    
    @Override
    public void year1(JogoDados j){
        Carta c=j.escolheSistemaDoImperio();
        if(c!=null){
            if(j.lancaDado()+1<c.getResistencia()){
                if(j.AdequiriuT_HyperTelevision())
                    c.setResistencia(c.getResistencia()+1);
            }
            else{
                c.setTipoSistema("Distant System");
                j.retiraSistemaImperio(c);
            }
        }
    }
    
    @Override
    public void year2(JogoDados j){
        Carta c=j.escolheSistemaDoImperio();
        if(c!=null){
            if(j.lancaDado()+1<c.getResistencia()){
                if(j.AdequiriuT_HyperTelevision())
                    c.setResistencia(c.getResistencia()+3);
            }
            else{
                c.setTipoSistema("Distant System");
                j.retiraSistemaImperio(c);
            }
        }
    }
}
