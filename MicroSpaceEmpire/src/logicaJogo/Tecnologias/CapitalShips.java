/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Tecnologias;

import logicaJogo.Constantes;
import logicaJogo.JogoDados;

/**
 *
 * @author Dmytro Yaremyshyn
 */
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
     return " aumenta limite de força militar de 3 para 5";
    }
}
