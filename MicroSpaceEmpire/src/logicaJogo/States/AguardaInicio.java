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

public class AguardaInicio extends StateAdapter
{ 
  
    public AguardaInicio(JogoDados j) 
    {
        super(j);
    }

    @Override
    public IStates PrepararJogo() 
    {
        if(getJogo().iniciar())
        {
            return new ExplorarAtacar_Conquistar_Passar(getJogo());
        }
        
        return this;
    }

   

   
}
