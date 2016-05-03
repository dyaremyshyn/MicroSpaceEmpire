
package logicaJogo.States;

import logicaJogo.JogoDados;

/**
 *
 * @author Sergio
 */
public class EscolheNearOuUnalignedSystem extends StateAdapter
{
    
    public EscolheNearOuUnalignedSystem(JogoDados j) 
    {
        super(j);
    }

    @Override
    public IStates Explorar_atacar(int TipoSistema) 
    {
       if(TipoSistema == 1)
       {
           //getJogo().viraCartaNearSystem();
           
       }else if (TipoSistema == 2)
            {
                    
            }
       
       return new TrocaEntreRecursos(getJogo()); 
    }
    
    
}
