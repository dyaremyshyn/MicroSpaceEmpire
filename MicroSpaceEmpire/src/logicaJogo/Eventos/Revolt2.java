/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.Eventos;

import logicaJogo.Cartas.Carta;
import logicaJogo.JogoDados;


public class Revolt2 extends Evento{

    public Revolt2() {
        super("Revolt");
    }
    
    @Override
    public void year1(JogoDados j){
        Carta c =j.escolheSistemaDoImperio();
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
                    c.setResistencia(c.getResistencia()+2);
            }
            else{
                c.setTipoSistema("Distant System");
                j.retiraSistemaImperio(c);
            }
        }
    }
}
