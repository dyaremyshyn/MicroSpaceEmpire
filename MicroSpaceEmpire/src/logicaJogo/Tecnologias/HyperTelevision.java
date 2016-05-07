/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.Tecnologias;


public class HyperTelevision extends Tecnologia{

    public HyperTelevision() {
        super("Hyper Television",1,3);
    }
    
    @Override
    public String Descricao()
    {
     return " Acrescentar uma unidade de resistência durante o evento de Revolta";
    }
}
