/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microspaceempire.gui;

import java.awt.Dimension;
import javax.swing.JPanel;
import logicaJogo.ObservableGame;
import static microspaceempire.gui.Constantes.DIM_X_CARTA;
import static microspaceempire.gui.Constantes.DIM_Y_CARTA;

/**
 *
 * @author Sergio
 */
public class UnalignedPanel extends JPanel implements Constantes {
 
    private ObservableGame observableGame;
    
    UnalignedPanel(ObservableGame game) {
        
      this.observableGame = observableGame;

   
    setMaximumSize(new Dimension(DIM_X_CARTA*1, DIM_Y_CARTA));
    setPreferredSize(new Dimension(DIM_X_CARTA*1, DIM_Y_CARTA));
    setMinimumSize(new Dimension(DIM_X_CARTA*1, DIM_Y_CARTA));
    }
    
}
