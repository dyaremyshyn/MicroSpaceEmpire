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
   
    public Boolean fazAcao(){
        return true;
    }
}