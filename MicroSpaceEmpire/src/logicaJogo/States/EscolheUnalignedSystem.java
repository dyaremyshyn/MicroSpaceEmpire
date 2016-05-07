/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.States;

import logicaJogo.JogoDados;


public class EscolheUnalignedSystem extends StateAdapter
{
    
    public EscolheUnalignedSystem(JogoDados j) 
    {
        super(j);
    }

    @Override
    public IStates Conquistar(int alvo) {
        
        getJogo().conquistaSistema(alvo);
        return new TrocaEntreRecursos(getJogo());
    }
    
    
}
