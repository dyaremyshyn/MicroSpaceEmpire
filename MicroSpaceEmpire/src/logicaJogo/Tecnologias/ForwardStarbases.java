/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Tecnologias;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class ForwardStarbases extends Tecnologia{

    public ForwardStarbases() {
        super("Forward Starbases",2,4);
    }
    
    @Override
    public String Descricao()
    {
     return " Necessaria para explorar ou conquistar sistemas distantes";
    }
}
