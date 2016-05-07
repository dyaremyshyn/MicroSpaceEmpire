/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package microspaceempire;

import logicaJogo.Jogo;
import ui_text.TextUserInterface;


public class MicroSpaceEmpire 
{

    public static void main(String[] args) 
    {
        TextUserInterface iuTexto = new TextUserInterface(new Jogo());
        iuTexto.corre();
    }   
}
