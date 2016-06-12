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


public class MetalPanel extends JPanel implements Constantes{
    
private ObservableGame observableGame;

  public MetalPanel(ObservableGame observableGame)
  {
      
    this.observableGame = observableGame;
    settamanho();
    
  }

 public final void settamanho(){
    setMaximumSize(new Dimension(DIM_X_RECURSO_IMG, DIM_Y_RECURSO_IMG));
    setPreferredSize(new Dimension(DIM_X_RECURSO_IMG, DIM_Y_RECURSO_IMG));
    setMinimumSize(new Dimension(DIM_X_RECURSO_IMG, DIM_Y_RECURSO_IMG)); 
    // addMouseListener( new MetalPanel.DestaqueListener());
 }
  
@Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g); 
     
    g.drawImage(MicroSpaceEmpirePanel.getMetal(),0, 0, DIM_X_RECURSO_IMG, DIM_Y_RECURSO_IMG, this);   
    
    colocaMarcador_stockMetal(g);
    colocaMarcador_ProduMetal(g);
  }
    
//  class DestaqueListener extends MouseAdapter 
//    {
//        @Override
//        public void mousePressed( MouseEvent e)
//        {
//            int x = e.getX(); //get x do mouse
//            int y = e.getY(); //get y do mouse
//            
//           System.out.println("x = " + x + "y = " + y);
//     
//         
//            
//        }
//    }
  
public void colocaMarcador_stockMetal(Graphics g)
    {
        int x = 0 ,y = 0;
        int flag=0;
        
       switch(observableGame.getMetal()) //metal que se tem 
       { 
           case 0:
               x = 73;
               y = 75;
               break;
           case 1:
                 x = 126;
                 y = 75;
               break;
           case 2:
                 x = 179;
                 y = 75;
               break;
           case 3:
                 x = 233;
                 y = 75;
               break;
           case 4:
                 x = 180;
                 y = 125;
               break;
           case 5 :
                 x = 233;
                 y = 125;
               break;
               
           default:
               flag = 1;
       }
       
     
       if(flag == 0){
       g.drawImage(MicroSpaceEmpirePanel.getMarcador1(),x, y, DIM_X_MARCADOR, DIM_Y_MARCADOR, this); //mercador de quantidade em stok     
       }
    }
    
    public void colocaMarcador_ProduMetal(Graphics g)          
    { 
        int x = 0 ,y = 0;
        int flag = 0;

       
       switch(observableGame.getProducaoMetal()) //metal que se tem 
       { 
           
           case 1:
                 x = 73 ;
                 y = 29;
               break;
           case 2:
                 x = 116 ;
                 y = 29;
               break;
           case 3:
                 x = 160 ;
                 y = 29;
               break;
           case 4:
                 x = 202 ;
                 y = 29;
               break;
           case 5 :
                 x = 245;
                 y = 29;
               break;
               
           default:
               flag = 1;
       }
       
     
       if(flag == 0)
       g.drawImage(MicroSpaceEmpirePanel.getMarcador1(),x, y, DIM_X_MARCADORPRO, DIM_Y_MARCADORPRO, this); //mercador de quantidade em stok
    }           
}
