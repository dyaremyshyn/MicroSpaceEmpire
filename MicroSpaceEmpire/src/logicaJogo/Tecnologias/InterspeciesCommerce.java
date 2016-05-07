/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.Tecnologias;


public class InterspeciesCommerce extends Tecnologia{

    public InterspeciesCommerce() {
        super("Interspecies Commerce",1,2);
    }    
    
    @Override
    public String Descricao()
    {
     return " Torna possível as trocas entre metal e riqueza";
    }
}
