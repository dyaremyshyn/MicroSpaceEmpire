/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microspaceempire;

import logicaJogo.Jogo;
import ui_text.TextUserInterface;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class MicroSpaceEmpire {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TextUserInterface iuTexto = new TextUserInterface(new Jogo());
        iuTexto.corre();
    }
    
}
