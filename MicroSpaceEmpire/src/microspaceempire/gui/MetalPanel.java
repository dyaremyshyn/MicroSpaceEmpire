/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microspaceempire.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JPanel;
import logicaJogo.Cartas.Carta;
import logicaJogo.ObservableGame;


/**
 *
 * @author Sergio
 */
public class MetalPanel extends JPanel implements Constantes{
    
private ObservableGame observableGame;

  public MetalPanel(ObservableGame observableGame)
  {
      
    this.observableGame = observableGame;
    
    setMaximumSize(new Dimension(DIM_X_RecursoImg, DIM_Y_RecursoImg));
    setPreferredSize(new Dimension(DIM_X_RecursoImg, DIM_Y_RecursoImg));
    setMinimumSize(new Dimension(DIM_X_RecursoImg, DIM_Y_RecursoImg));
    
    //addMouseListener( new DestaqueListener());
  }

 
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
            int x = 0 ,y = 0;
            int flag=0;
     
       g.drawImage(MicroSpaceEmpirePanel.getMetal(),0, 0, DIM_X_RecursoImg, DIM_Y_RecursoImg, this);   
      
       
       switch(observableGame.getMetal()) //metal que se tem 
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
       
     
       if(flag == 0)
       g.drawImage(MicroSpaceEmpirePanel.getMarcador1(),x, y, DIM_X_Marcador, DIM_Y_Marcador, this); //mercador de quantidade em stok
       
    
       //produção deste recurso
       flag = 0;
       
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
       g.drawImage(MicroSpaceEmpirePanel.getMarcador1(),x, y, DIM_X_MarcadorProd, DIM_Y_MarcadorProd, this); //mercador de quantidade em stok
             
  }
    
//    class DestaqueListener extends MouseAdapter 
//    {
//        @Override
//        public void mousePressed( MouseEvent e)
//        {
//            int x = e.getX(); //get x do mouse
//            int y = e.getY(); //get y do mouse
//            
//            System.out.println("x = " + x + "y = " + y);
//     
//            trataclique( x, y);
//            
////            if(qual != -1){
////                modelo.setDestaque(qual);
////            } 
//        }
//    }
    
//    int trataclique(int x, int y)
//    {
//        int qual;
//        
//        if ( y < 0 || y > DIM_Y_RecursoImg){
//            return -1;
//        }
//        if ( x < 0 || x > DIM_X_RecursoImg){
//            return -1;
//        }
//        
//        // aqui os varios if's 
//        
//        
//        return -1;
//    }    
}
