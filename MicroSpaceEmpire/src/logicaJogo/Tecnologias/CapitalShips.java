/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Tecnologias;

import logicaJogo.Constantes;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class CapitalShips extends Tecnologia implements Constantes{

    public CapitalShips() {
        super("Capital Ships",1,3);
    }
    
    public int fazAcao(){
        return Constantes.LIM_C_CAPITALSHIPS;
    }
    
    @Override
    public String Descricao()
    {
     return " aumenta limite de força militar de 3 para 5";
    }
}
