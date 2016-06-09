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
<<<<<<< HEAD
    private MicroSpacePrincipalPanel painelPrincipal;
=======
    private MicroSpaceEmpirePanel gamePanel;
>>>>>>> origin/master
    
    public MicroSpaceEmpireFrame( ObservableGame j) {
        this( j, 200, 100, DIM_X_FRAME, DIM_Y_FRAME);
    }
    
    public MicroSpaceEmpireFrame( ObservableGame j, int x, int y ) { 
        this( j, x,y, DIM_X_FRAME, DIM_Y_FRAME);
    }
    
    public MicroSpaceEmpireFrame( ObservableGame j, int x, int y, int width, int height) {
        
        super("Micro Space Empire"); 

        observableGame = j;
        observableGame.addObserver(this);
             
<<<<<<< HEAD
        painelPrincipal = new MicroSpacePrincipalPanel(observableGame);
        
         addComponents();
=======
        gamePanel = new MicroSpaceEmpirePanel(observableGame);
        addComponents();
>>>>>>> origin/master
        
               
        setLocation(x, y); 
        setSize(width,height); 
        setMinimumSize(new Dimension(width,height));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    
    }
    

     private void addComponents()
    {      
<<<<<<< HEAD
         Container cp = getContentPane(); 
        //cp.setLayout(new BorderLayout());//
        cp.add(painelPrincipal);
=======
        Container cp = getContentPane(); 
        cp.add(gamePanel);
>>>>>>> origin/master
    }
    
    @Override
    public void update(Observable o, Object o1) {
        repaint();
    }
    
    
}
