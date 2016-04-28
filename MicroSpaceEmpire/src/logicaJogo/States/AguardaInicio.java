
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
