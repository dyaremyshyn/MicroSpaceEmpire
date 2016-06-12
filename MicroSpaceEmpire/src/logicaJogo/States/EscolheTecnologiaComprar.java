/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.States;

import logicaJogo.JogoDados;


public class EscolheTecnologiaComprar extends StateAdapter
{
    
    public EscolheTecnologiaComprar(JogoDados j) 
    {
        super(j);      
    }

    @Override
    public IStates Comprar_Tecnologia(int TecnologiaEscolhida) 
    {       
            if(getJogo().DescobrirTecnologia(TecnologiaEscolhida)) //caso deia para comprar a tecnologia passa(true)
            { 
            getJogo().setBloqueio_DTecnologia(1);//bloqueia
            return new ConstruirFM_DescobrirTecnologia(getJogo());           
            }      
               
    return this;      
    }
    
    @Override
    public IStates Cancelar() 
    {
        return new ConstruirFM_DescobrirTecnologia(getJogo()); 
    }
    
     @Override
    public IStates Passar() 
    {
        if(getJogo().VerificaSeNaoHaMaisEventos()) //verifica se os eventos ja acabaram
        {
            if(getJogo().getCurrentYear() == 2) // caso ja esteja no 2 ano ele sai do jogo
            {
             return new Fim(getJogo());
            }
            
        getJogo().PassaDeAno(); //passa de ano
        }
        
        getJogo().aplicaEventoAleatorio();
        
        if(getJogo().verificaRevolta(getJogo().getCurrentEvento()))
            return new Fim(getJogo());
        
        getJogo().avancaTurno();       
        getJogo().zeraVariaveisDeVerificação(); //volta a por as variaveis de bloqueio a 0
        
    return new ExplorarAtacar_Conquistar_Passar(getJogo());
    }
    
}
