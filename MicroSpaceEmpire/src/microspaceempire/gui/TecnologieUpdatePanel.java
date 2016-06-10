/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microspaceempire.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import logicaJogo.ObservableGame;
import static microspaceempire.gui.Constantes.DIM_X_RecursoImg;
import static microspaceempire.gui.Constantes.DIM_Y_RecursoImg;


/**
 *
 * @author Sergio
 */
public class TecnologieUpdatePanel extends JPanel implements Constantes{
     private ObservableGame observableGame;

  public TecnologieUpdatePanel(ObservableGame observableGame)
  {
      
    this.observableGame = observableGame;
    
    setMaximumSize(new Dimension(DIM_X_TecnologImg, DIM_Y_TecnologImg));
    setPreferredSize(new Dimension(DIM_X_TecnologImg, DIM_Y_TecnologImg));
    setMinimumSize(new Dimension(DIM_X_TecnologImg, DIM_Y_TecnologImg));
    
    addMouseListener( new DestaqueListener());
  }

 
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
                
     
       g.drawImage(MicroSpaceEmpirePanel.getTecnologiasUpdate(),0, 0, DIM_X_TecnologImg, DIM_Y_TecnologImg, this);                     
    
  }
    
    class DestaqueListener extends MouseAdapter 
    {
        @Override
        public void mousePressed( MouseEvent e)
        {
            int x = e.getX(); //get x do mouse
            int y = e.getY(); //get y do mouse
            
            System.out.println("x = " + x + "y = " + y);
     
            trataclique( x, y);
            
//            if(qual != -1){
//                modelo.setDestaque(qual);
//            } 
        }
    }
    
    int trataclique(int x, int y)
    {
        int qual;
        
        if ( y < 0 || y > DIM_Y_TecnologImg){
            return -1;
        }
        if ( x < 0 || x > DIM_X_TecnologImg){
            return -1;
        }
        
        // aqui os varios if's 
        
        
        return -1;
    }    
}
