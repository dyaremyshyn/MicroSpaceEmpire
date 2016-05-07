/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.Cartas;


public class HomeWorld extends Carta{

    public HomeWorld() {
        super("Starting System", "Home World", 1, 1, 0, 0);
    }
   
    @Override
    public String toString() {
        return " -> " + getNome() +
               " | " + getTipoSistema() +
               " | " + "+" + getMetal() + " Metal" +
               " | " + "+" + getRiqueza() + " Wealth" +
               "\n";
    }
    
}
