
package microspaceempire;

import logicaJogo.ObservableGame;
import microspaceempire.gui.MicroSpaceEmpireView;
import microspaceempire.gui.MicroSpaceEmpireFrame;



public class MicroSpaceEmpireGui {
    
    public static void main(String args[]) {
        ObservableGame ob = new ObservableGame();        
        new MicroSpaceEmpireView(ob);

    }
}
