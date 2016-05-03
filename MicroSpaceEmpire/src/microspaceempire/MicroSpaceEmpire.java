
package microspaceempire;

import logicaJogo.Jogo;
import ui_text.TextUserInterface;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class MicroSpaceEmpire 
{

    public static void main(String[] args) 
    {
        TextUserInterface iuTexto = new TextUserInterface(new Jogo());
        iuTexto.corre();
    }   
}
