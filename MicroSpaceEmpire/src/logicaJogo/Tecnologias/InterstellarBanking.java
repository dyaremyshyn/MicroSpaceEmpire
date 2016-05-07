/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.Tecnologias;
import logicaJogo.*;


public class InterstellarBanking extends Tecnologia{

    public InterstellarBanking() {
        super("Interstellar Banking",2,3);
    }
    
    @Override
    public void FazAccao(JogoDados jogo){
        jogo.setLimiteRecursos(LIM_C_TEC);
    }
    
    @Override
    public String Descricao()
    {
     return " Limite de armazenamento de metal e de riqueza passam de 3 para 5";
    }
}
