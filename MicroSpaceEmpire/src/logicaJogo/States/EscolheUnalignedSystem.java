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
public class EscolheUnalignedSystem extends StateAdapter
{
    
    public EscolheUnalignedSystem(JogoDados j) 
    {
        super(j);
    }

    @Override
    public IStates Conquistar(int alvo) {
        return super.Conquistar(alvo); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
