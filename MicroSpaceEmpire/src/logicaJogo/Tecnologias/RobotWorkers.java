/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.Tecnologias;


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
