
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
    public IStates EscolheDescobrirTecnologia() {
        
       /* if(getJogo().getbloqueio_DTecnologia() == 0)
        {
           return new EscolheTecnologiaComprar(getJogo());
        }*/
       return new EscolheTecnologiaComprar(getJogo()); //tirar depois
    }

    @Override
    public IStates Aumentar_Força_Militar() {
       
       /* if(getJogo().getbloqueio_AFmilitar() == 0)
        {
            if(getJogo().aumenta_FMilitar())
            {
            bloqueio_AFmilitar = 1; //bloqueia
            }       
        }*/ 
        return this;  
    }

    @Override
    public IStates Passar() {//duvida::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        return new ExplorarAtacar_Conquistar_Passar(getJogo());
    } 
}
