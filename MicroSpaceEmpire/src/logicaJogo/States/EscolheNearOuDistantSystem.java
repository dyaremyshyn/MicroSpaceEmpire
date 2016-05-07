/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.States;

import logicaJogo.JogoDados;


public class EscolheNearOuDistantSystem extends StateAdapter
{
    
    public EscolheNearOuDistantSystem(JogoDados j) 
    {
        super(j);
    }

    @Override
    public IStates Explorar_atacar(int TipoSistema) 
    {
       if(TipoSistema == 1)
       {
           getJogo().viraCartaNearSystem();
           
       }else if (TipoSistema == 2)
            {
                getJogo().viraCartaDistantSystem();
            }
       
       return new TrocaEntreRecursos(getJogo()); 
    }
    
    
}
