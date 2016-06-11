
package microspaceempire.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import logicaJogo.ObservableGame;


public class WeathPanel extends JPanel implements Constantes{
  
  private ObservableGame observableGame;

  public WeathPanel(ObservableGame observableGame)
  {
      
    this.observableGame = observableGame;
    
    setMaximumSize(new Dimension(DIM_X_RecursoImg, DIM_Y_RecursoImg));
    setPreferredSize(new Dimension(DIM_X_RecursoImg, DIM_Y_RecursoImg));
    setMinimumSize(new Dimension(DIM_X_RecursoImg, DIM_Y_RecursoImg));
  }
    
   
  @Override
  public void paintComponent(Graphics g)
  {
    
    super.paintComponent(g);
            
     
       g.drawImage(MicroSpaceEmpirePanel.getRiqueza(),0, 0, DIM_X_RecursoImg, DIM_Y_RecursoImg, this);   
      
       colocaMarcador_stockRiq(g);
       colocaMarcador_ProduRiq(g);  
       
  }
    
    public void colocaMarcador_stockRiq(Graphics g)
    {
        int x = 0 ,y = 0;
        int flag=0;
        
       switch(observableGame.getRiqueza()) //metal que se tem 
       { 
           case 0:
               x = 73 ;
               y = 75;
               break;
           case 1:
                 x = 126 ;
                 y = 75;
               break;
           case 2:
                 x = 179 ;
                 y = 75;
               break;
           case 3:
                 x = 233 ;
                 y = 75;
               break;
           case 4:
                 x = 179 ;
                 y = 161;
               break;
           case 5 :
                 x = 233;
                 y = 161;
               break;
               
           default:
               flag = 1;
       }
       
     
       if(flag == 0){
       g.drawImage(MicroSpaceEmpirePanel.getMarcador1(),x, y, DIM_X_Marcador, DIM_Y_Marcador, this); //mercador de quantidade em stok
       System.out.println("Wealth mostro :q: "+observableGame.getRiqueza()+"  x = "+x+"  y = "+ y);
       }
    }
    
    public void colocaMarcador_ProduRiq(Graphics g)          
    { 
        int x = 0 ,y = 0;
        int flag = 0;

       
       switch(observableGame.getProducaoRiq()) //metal que se tem 
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
       g.drawImage(MicroSpaceEmpirePanel.getMarcador1(),x, y, DIM_X_MarcadorProd, DIM_Y_MarcadorProd, this); //mercador de quantidade em stok
    }      
}
