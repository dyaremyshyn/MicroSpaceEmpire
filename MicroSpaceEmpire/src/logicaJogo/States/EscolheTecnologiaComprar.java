
package logicaJogo.States;

import logicaJogo.JogoDados;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class EscolheTecnologiaComprar extends StateAdapter
{
    
    public EscolheTecnologiaComprar(JogoDados j) 
    {
        super(j);      
    }

    @Override
    public IStates Comprar_Tecnologia(int TecnologiaEscolhida) {
        
        /* 
            if(DescobrirTecnologia(int TecnologiaEscolhida))
            { 
            return new ConstruirFM_DescobrirTecnologia(getJogo());           
            }      
        */ 
            
        
         return this;
       
    }
    
    @Override
    public IStates Cancelar() 
    {
        return new ConstruirFM_DescobrirTecnologia(getJogo()); 
    }
    
}
