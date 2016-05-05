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
public class RobotWorkers extends Tecnologia{

    public RobotWorkers() {
        super("Robot Workers",1,2);
    }
        
    @Override
    public String Descricao()
    {
     return " Durante o evento Greve permite recolher 1/2 dos recursos";
    }
}
