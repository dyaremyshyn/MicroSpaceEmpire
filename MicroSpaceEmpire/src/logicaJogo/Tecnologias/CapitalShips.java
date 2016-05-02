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
public class CapitalShips extends Tecnologia{

    public CapitalShips() {
        super("Capital Ships");
    }
    
    public int fazAcao(){
        return Constantes.LIM_C_CAPITALSHIPS;
    }
}
