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
public class SmallInvasionForce extends Evento{

    public SmallInvasionForce() {
        super("Small Invasion Force");
    }
    
    @Override
    public void year1(JogoDados j){
        Carta c=j.ultimoSistemaConquistado();
        if(!c.getNome().equals("Home World")){
            if(j.lancaDado()+1<c.getResistencia()){
                if(j.temPlanetaryDefenses())
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
        Carta c=j.ultimoSistemaConquistado();
        if(!c.getNome().equals("Home World")){
            if(j.lancaDado()+2<c.getResistencia()){
                if(j.temPlanetaryDefenses())
                    c.setResistencia(c.getResistencia()+1);
            }
            else{   
                c.setTipoSistema("Distant System");
                j.retiraSistemaImperio(c);
            }
        }
    }
    
}
