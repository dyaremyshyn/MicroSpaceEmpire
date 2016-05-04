
package logicaJogo.States;

import logicaJogo.JogoDados;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class ConstruirFM_DescobrirTecnologia extends StateAdapter
{
    
    
    public ConstruirFM_DescobrirTecnologia(JogoDados j) 
    {     
        super(j);        
    }    
    
    @Override
    public IStates EscolheDescobrirTecnologia() 
    {       
        if(getJogo().getBloqueio_DTecnologia() == 0) // se 0 é porque ainda pode efectuar compra
        {
           return new EscolheTecnologiaComprar(getJogo());
        }
        
    return this;
    }

    @Override
    public IStates Aumentar_Força_Militar() 
    {      
        if(getJogo().getBloqueio_AFmilitar() == 0)
        {
        getJogo().aumenta_FMilitar();                   
        getJogo().setBloqueio_AFmilitar(1); //bloqueia
        }
        
    return this;  
    }

    @Override
    public IStates Passar() {//duvida::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::              
        //funções autonomas 
        getJogo().avancaTurno();
        
        
        
        getJogo().zeraVariaveisDeVerificação(); //volta a por as variaveis de bloqueio a 0
        return new ExplorarAtacar_Conquistar_Passar(getJogo());
    } 
}
