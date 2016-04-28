
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
        return super.Comprar_Tecnologia(TecnologiaEscolhida); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public IStates Cancelar() {
        return super.Cancelar(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
