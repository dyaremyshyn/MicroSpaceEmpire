/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microspaceempire.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import logicaJogo.ObservableGame;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class MicroSpaceEmpireFrame extends JFrame implements Observer, Constantes{
   
    private ObservableGame observableGame;
    private MicroSpaceEmpirePanel gamePanel;
    
    public MicroSpaceEmpireFrame( ObservableGame j) {
        this( j, 200, 100, DIM_X_FRAME, DIM_Y_FRAME);
    }
    
    public MicroSpaceEmpireFrame( ObservableGame j, int x, int y ) { //?
        this( j, x,y, DIM_X_FRAME, DIM_Y_FRAME);
    }
    
    public MicroSpaceEmpireFrame( ObservableGame j, int x, int y, int width, int height) {
        
        super("Micro Space Empire"); 

        observableGame = j;
        observableGame.addObserver(this);
             
        gamePanel = new MicroSpaceEmpirePanel(observableGame);
        gamePanel.setSize(DIM_X_FRAME, DIM_Y_FRAME);
        addComponents();
        
               
        setLocation(x, y); 
        setSize(width,height); 
        setMinimumSize(new Dimension(width,height));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    
    }
    

     private void addComponents()
    {      
        Container cp = getContentPane(); 
        cp.add(gamePanel);
    }
    
    @Override
    public void update(Observable o, Object o1) {
        repaint();
    }
    
    
}
