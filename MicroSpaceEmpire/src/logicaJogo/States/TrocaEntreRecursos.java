/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.States;

import logicaJogo.JogoDados;


public class TrocaEntreRecursos extends StateAdapter
{
    
    public TrocaEntreRecursos(JogoDados j) 
    {
        super(j);       
    }
    

    @Override
    public IStates Trocar_recursos(int TipoDeTroca) 
    {
        if(TipoDeTroca == 1)//2 de riqueza por 1 de metal
       {
            if(getJogo().TrocaRiquezaPorMetal())
            {
              return new ConstruirFM_DescobrirTecnologia(getJogo()); //retorna se a troca se verificar pois so é permitido a troca 1 vez por turno
            }           
                
       }else if (TipoDeTroca == 2)//2 de metal por 1 de riqueza
            {
                if(getJogo().TrocaMetalPorRiqueza())
                {
                return new ConstruirFM_DescobrirTecnologia(getJogo());
                }
            }
   
        return  this ; 
    }
    
    @Override
    public IStates Passar() {
        return new ConstruirFM_DescobrirTecnologia(getJogo());
    }
    
    
}
