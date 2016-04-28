
package logicaJogo.States;

import logicaJogo.JogoDados;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class TrocaEntreRecursos extends StateAdapter
{
    
    public TrocaEntreRecursos(JogoDados j) 
    {
        super(j);
    }

    @Override
    public IStates Trocar_recursos(int TipoDeTroca) {
        return super.Trocar_recursos(TipoDeTroca); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public IStates Passar() {
        return super.Passar(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
