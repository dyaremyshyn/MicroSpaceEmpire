
package microspaceempire.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import logicaJogo.Eventos.Evento;
import logicaJogo.ObservableGame;


public class EventPanel extends JPanel implements Constantes{
    private ObservableGame observableGame;
    //private Border tracejado = BorderFactory.createDashedBorder(Color.red, 2.0f, 3.0f,1.0f, true);
    
    public EventPanel(ObservableGame observableGame)
    {
      this.observableGame = observableGame;

      setBackground(new Color(0,0,0,0));
      setMaximumSize(new Dimension(DIM_X_CARTA, DIM_Y_CARTA));
      setPreferredSize(new Dimension(DIM_X_CARTA, DIM_Y_CARTA));
      setMinimumSize(new Dimension(DIM_X_CARTA, DIM_Y_CARTA));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int x=0,y=0;
        g.fillRect(x, y, DIM_X_CARTA, DIM_Y_CARTA);
       
        
        Evento eventoAtual = observableGame.getCurrentEvento();
        
        if(eventoAtual!= null){      
       
            String nome = eventoAtual.getNome();
        
        
        //System.out.println(" o nome da imagem é :"+eventoAtual.getNome());
        
            
            Image imagem = MicroSpaceEmpirePanel.getEventImg(nome);
            
            if (imagem != null){
                // System.out.println("vou pintar a imagem");
                g.drawImage( imagem, x , y ,DIM_X_CARTA, DIM_Y_CARTA, this );
            }else{
                System.err.println(" imagem == null");
            }
        }  else{
         g.drawImage( MicroSpaceEmpirePanel.getEventImg(EVENT), x , y ,DIM_X_CARTA, DIM_Y_CARTA, this );
        }
    
    }

}
