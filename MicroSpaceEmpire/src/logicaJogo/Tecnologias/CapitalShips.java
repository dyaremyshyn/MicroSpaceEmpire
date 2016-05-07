/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.Tecnologias;

import logicaJogo.JogoDados;


public class CapitalShips extends Tecnologia{

    public CapitalShips() {
        super("Capital Ships",1,3);
    }
    
    @Override
    public void FazAccao(JogoDados jogo){
        jogo.setLimiteForcaMilitar(LIM_C_TEC);      
    }
    
    @Override
    public String Descricao()
    {
     return " Aumenta o limite de força militar de 3 para 5";
    }
}
