
package logicaJogo.States;
import logicaJogo.JogoDados;
import java.io.Serializable;
/**
 *
 * @author Dmytro Yaremyshyn
 */
public abstract class StateAdapter implements IStates , Serializable 
{
    
    private JogoDados jogo;

    public StateAdapter(JogoDados j) 
    {
        this.jogo = j;
    }

    public JogoDados getJogo() 
    {
        return jogo;
    }

    public void setJogo(JogoDados jogo) 
    {
        this.jogo = jogo;
    }
    
    

//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    
    @Override
    public IStates PrepararJogo(){return this;}
    
    @Override
    public IStates Explorar_atacar(int TipoSistema){return this;}
    
    @Override
    public IStates Conquistar(int alvo){return this;}
    
    @Override
    public IStates Passar(){return this;}
    
    @Override
    public IStates Trocar_recursos(int TipoDeTroca){return this;}
    
    @Override
    public IStates Aumentar_Força_Militar(){return this;}
    
    @Override
    public IStates Comprar_Tecnologia(int TecnologiaEscolhida){return this;}
    
    @Override
    public IStates Terminar(){return this;}

    @Override
    public IStates EscolheDescobrirTecnologia(){return this;}

    @Override
    public IStates Cancelar(){return this;}

    @Override
    public IStates EscolheConquistar(){return this;}

    @Override
    public IStates EscolheExplorar_atacar(){return this;}
    
    
}
