/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.States;

import logicaJogo.JogoDados;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class TrocaEntreRecursos extends StateAdapter
{
    
    public TrocaEntreRecursos(JogoDados j) 
    {
        super(j);
    }

    @Override
    public IStates Trocar_recursos(int TipoDeTroca) {
        return super.Trocar_recursos(TipoDeTroca); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public IStates Passar() {
        return super.Passar(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
