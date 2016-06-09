/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microspaceempire;

import logicaJogo.ObservableGame;
import microspaceempire.gui.MicroSpaceEmpireView;

/**
 *
 * @author Sergio
 */
public class MicroSpaceEmpireGui {
    
    public static void main(String[] args)
    {                
        MicroSpaceEmpireView GUI = new MicroSpaceEmpireView(new ObservableGame());
    }
}
