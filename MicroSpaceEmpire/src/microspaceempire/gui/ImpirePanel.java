
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
     
  }

 
  
  public void paintComponent(Graphics g)
  {
    //super.paintComponent(g);
//    
//    imperio = observableGame.getImperio();             
//    setMaximumSize(new Dimension(DIM_X_CARTA*4, DIM_Y_CARTA));
//    setPreferredSize(new Dimension(DIM_X_CARTA*4, DIM_Y_CARTA));
//    setMinimumSize(new Dimension(DIM_X_CARTA*4, DIM_Y_CARTA));     
//    
//    setLayout(new GridLayout(1,imperio.size(),0,0));
//        
//        Image imagemSystem;
//         for(Carta p:imperio) {
//
//           imagemSystem = MicroSpaceEmpirePanel.getSystemImg(nomeSystema);
//        
//        if(imagemSystem!=null){
//            add(g.drawImage(imagemSystem,0,0, DIM_X_CARTA, DIM_Y_CARTA, this));
//         
//    }else{ System.err.println(" imagem == null");}
//    }
//      };   
//    
//    
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
