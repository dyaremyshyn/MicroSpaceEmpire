/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microspaceempire.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JPanel;
import logicaJogo.ObservableGame;


public class NearSystemPanel extends JPanel implements Constantes{
    
    
  private ObservableGame observableGame;
  
  public NearSystemPanel(ObservableGame observableGame)
  {
    this.observableGame = observableGame;
    
    setMaximumSize(new Dimension(DIM_X_CARTA, DIM_Y_CARTA));
    setPreferredSize(new Dimension(DIM_X_CARTA, DIM_Y_CARTA));
    setMinimumSize(new Dimension(DIM_X_CARTA, DIM_Y_CARTA));
    
     addMouseListener( new DestaqueListener());
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
        g.drawImage(MicroSpaceEmpirePanel.getSystemPartetras(), 0, 0, DIM_X_CARTA, DIM_Y_CARTA, this);     
  }

class DestaqueListener extends MouseAdapter 
    {
        @Override
        public void mousePressed( MouseEvent e)
        {
            System.out.print("carreguei para explorar near!");
             NearSystemPanel.this.observableGame.EscolheExplorar_atacar(); //escolhe atacar           
             NearSystemPanel.this.observableGame.Explorar_atacar(1); // tipo 1 é near
        }
    }

}
