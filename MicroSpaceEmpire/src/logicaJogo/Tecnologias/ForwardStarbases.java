/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.Tecnologias;


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
