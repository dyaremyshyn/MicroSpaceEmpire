/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.States;

import logicaJogo.JogoDados;


public class AguardaInicio extends StateAdapter
{ 
  
    public AguardaInicio(JogoDados j) 
    {
        super(j);
    }

    @Override
    public IStates PrepararJogo() 
    {
        if(1 == 1)
        {
            return new ExplorarAtacar_Conquistar_Passar(getJogo());
        }
        
    return this;
    }

}
