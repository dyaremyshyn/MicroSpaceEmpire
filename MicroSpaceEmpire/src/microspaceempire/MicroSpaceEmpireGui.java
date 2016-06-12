
package microspaceempire;

import logicaJogo.ObservableGame;
import microspaceempire.gui.MicroSpaceEmpireFrame;



public class MicroSpaceEmpireGui {
    
    public static void main(String args[]) {
        MicroSpaceEmpireFrame GUI = new MicroSpaceEmpireFrame(new ObservableGame());
    }
}
