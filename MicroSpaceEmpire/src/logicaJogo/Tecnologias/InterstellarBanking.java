/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Tecnologias;
import logicaJogo.*;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class InterstellarBanking extends Tecnologia{

    public InterstellarBanking() {
        super("Interstellar Banking",2,3);
    }
    
    public void fazAcao(){
        //getJogo().setLimArmazem(5);
    }
    
    @Override
    public String Descricao()
    {
     return " passa limite de armazenamento de metal e de riqueza passam de 3 para 5";
    }
}
