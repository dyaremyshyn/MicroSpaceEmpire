/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.Tecnologias;


public class PlanetaryDefenses extends Tecnologia {

    public PlanetaryDefenses() {
        super("Planetary Defenses",2,4);
    }
    
    @Override
    public String Descricao()
    {
     return " Acrescenta uma unidade de resistência durante um evento de invasão";
    }
}
