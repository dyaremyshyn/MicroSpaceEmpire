
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

  
  
  public ImpirePanel(ObservableGame observableGame)
  {
    this.observableGame = observableGame;
     
    setMaximumSize(new Dimension(DIM_X_CARTA*11, DIM_Y_CARTA));
    setPreferredSize(new Dimension(DIM_X_CARTA*11, DIM_Y_CARTA));
    setMinimumSize(new Dimension(DIM_X_CARTA*11, DIM_Y_CARTA));
    setBackground(new Color(0,0,0,0));
    
  }

 
  
  public void paintComponent(Graphics g)
  {
    
       int x,y;
        
        super.paintComponent( g);

        List<Carta> Imperio_actual = observableGame.getImperio();
       

        x = 0; y = 0;
        
        for (int i = 0 ; i < Imperio_actual.size() ; i++){
                      
            String nome = Imperio_actual.get(i).getNome();

            g.fillRect(x, y, DIM_X_CARTA, DIM_Y_CARTA);
            Image imagem = MicroSpaceEmpirePanel.getSystemImg(nome);
            
            if (imagem != null){
                g.drawImage( imagem, x , y ,DIM_X_CARTA, DIM_Y_CARTA, this );
            }else{
                System.err.println(" imagem == null");
            }
            
            x += DIM_X_CARTA;
        }



 }

    
    
}
