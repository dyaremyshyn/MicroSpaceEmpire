/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.Eventos;

import logicaJogo.Cartas.Carta;
import logicaJogo.JogoDados;


public class SmallInvasionForce extends Evento{

    public SmallInvasionForce() {
        super("Small Invasion Force");
    }
    
    @Override
    public void year1(JogoDados j){
        Carta c=j.ultimoSistemaConquistado();
        if(!c.getNome().equals("Home World")){
            if(j.lancaDado()+1<c.getResistencia()){
                if(j.AdequiriuT_PlanetaryDefenses())
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
                if(j.AdequiriuT_PlanetaryDefenses())
                    c.setResistencia(c.getResistencia()+1);
            }
            else{   
                c.setTipoSistema("Distant System");
                j.retiraSistemaImperio(c);
            }
        }
    }
    
}
