
package microspaceempire.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JPanel;
import logicaJogo.Cartas.Carta;
import logicaJogo.ObservableGame;
import static microspaceempire.gui.Constantes.DIM_X_CARTA;
import static microspaceempire.gui.Constantes.DIM_Y_CARTA;



public class UnalignedPanel extends JPanel implements Constantes {
 
    private ObservableGame observableGame;
     private   List<Carta> porConquistar;
     
    UnalignedPanel(ObservableGame game) {
        
      this.observableGame = game;
      porConquistar = observableGame.getPorConquistar();
   
    setMaximumSize(new Dimension(DIM_X_CARTA* porConquistar.size(), DIM_Y_CARTA));
    setPreferredSize(new Dimension(DIM_X_CARTA*porConquistar.size(), DIM_Y_CARTA));
    setMinimumSize(new Dimension(DIM_X_CARTA*porConquistar.size(), DIM_Y_CARTA));
    

    setLayout(new GridLayout(1,porConquistar.size(),0,0));
        
        
         for(Carta p:porConquistar) {
           add(new ImgSystemasImperio(observableGame,p.getNome()));
      }; 
    }
    
}
