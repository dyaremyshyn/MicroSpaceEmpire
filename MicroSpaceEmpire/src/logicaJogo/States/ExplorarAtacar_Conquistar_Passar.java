/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.States;

import logicaJogo.JogoDados;


public class ExplorarAtacar_Conquistar_Passar extends StateAdapter
{
    
    public ExplorarAtacar_Conquistar_Passar(JogoDados j) 
    {
        super(j);        
    }

    @Override
    public IStates Passar() 
    {   
        getJogo().atualizaProducaoRecursos();  
        getJogo().recolheRecursos();    
        getJogo().setBloqueio_compraDireta(0); 
        
        return new TrocaEntreRecursos(getJogo());
    }
    
    @Override
    public IStates EscolheExplorar_atacar()
    {
        return new EscolheNearOuDistantSystem(getJogo());
    }

    @Override
    public IStates EscolheConquistar() 
    {
        if(getJogo().verificaPorConquistar())
            return new EscolheUnalignedSystem(getJogo());
        else return this;
    }

    @Override
    public IStates Terminar() 
    {
        return new Fim(getJogo());
    }    
}
