/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */
package microspaceempire.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import logicaJogo.ObservableGame;
import static microspaceempire.gui.Constantes.DIM_X_RECURSO_IMG;
import static microspaceempire.gui.Constantes.DIM_Y_RECURSO_IMG;


public class MilitaryStrenghPanel extends JPanel implements Constantes{
    private ObservableGame observableGame;

  public MilitaryStrenghPanel(ObservableGame observableGame)
  {
      
    this.observableGame = observableGame;
    
    setMaximumSize(new Dimension(DIM_X_RECURSO_IMG, DIM_Y_RECURSO_IMG));
    setPreferredSize(new Dimension(DIM_X_RECURSO_IMG, DIM_Y_RECURSO_IMG));
    setMinimumSize(new Dimension(DIM_X_RECURSO_IMG, DIM_Y_RECURSO_IMG));
    
    addMouseListener( new DestaqueListener());
  }

 
  
  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
                
     int x = 0 ,y = 0;
    int flag=0;
     
      g.drawImage(MicroSpaceEmpirePanel.getForcaMilitar(),0, 0, DIM_X_RECURSO_IMG, DIM_Y_RECURSO_IMG, this);     
      
       
       switch(observableGame.getForcaMilitar()) //metal que se tem 
       { 
           case 0:
               x = 67 ;
               y = 28;
               break;
           case 1:
                 x = 120 ;
                 y = 28;
               break;
           case 2:
                 x = 174 ;
                 y = 28;
               break;
           case 3:
                 x = 226 ;
                 y = 28;
               break;
           case 4:
                 x = 174 ;
                 y = 77;
               break;
           case 5 :
                 x = 226;
                 y = 77;
               break;
               
           default:
               flag = 1;
       }
       
     
       if(flag == 0)
       g.drawImage(MicroSpaceEmpirePanel.getMarcador1(),x, y, DIM_X_MARCADOR, DIM_Y_MARCADOR, this); //mercador de quantidade em stok
       
                          
    
  }
    
    class DestaqueListener extends MouseAdapter 
    {
        @Override
        public void mousePressed( MouseEvent e)
        {
            int x = e.getX(); //get x do mouse
            int y = e.getY(); //get y do mouse
            
           // System.out.println("x = " + x + "y = " + y);
     
            trataclique( x, y);
            
        }
    }
    
    int trataclique(int x, int y)
    {
       
        
        if ( y < 0 || y > DIM_Y_RECURSO_IMG){
            return -1;
        }
        if ( x < 0 || x > DIM_X_RECURSO_IMG){
            return -1;
        }
        
        if((x > 68 && x < 273 && y > 29 && y < 70) || (x >173 && x < 273 && y > 77 && y < 119 ))
        {          
            observableGame.Aumentar_Força_Militar();
        }
        
        // aqui os varios if's 
        
        
        return -1;
    }    
}
