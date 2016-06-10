
package microspaceempire.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import logicaJogo.Cartas.Carta;
import logicaJogo.ObservableGame;



public class ImpirePanel extends JPanel implements Constantes  {
    
        
  private ObservableGame observableGame;

  private   List<Carta> imperio;
  
  public ImpirePanel(ObservableGame observableGame)
  {
    this.observableGame = observableGame;
    imperio = observableGame.getImperio();
    
   // setBackground(Color.red);
    setMaximumSize(new Dimension(DIM_X_CARTA*imperio.size(), DIM_Y_CARTA));
    setPreferredSize(new Dimension(DIM_X_CARTA*imperio.size(), DIM_Y_CARTA));
    setMinimumSize(new Dimension(DIM_X_CARTA*imperio.size(), DIM_Y_CARTA));
    
    
  }

 
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
                
        setLayout(new GridLayout(1,imperio.size(),0,0));
       
        imperio.stream().forEach((p) -> {

           add(new ImgSystemasImperio(p.getNome()));
      });               
    
    
    
  }

    
    
}
