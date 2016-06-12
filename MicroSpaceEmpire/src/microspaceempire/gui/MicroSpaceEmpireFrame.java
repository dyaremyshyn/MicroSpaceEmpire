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
 * @author Dmytro Yaremyshyn & Sérgio Cruz
 */
public class MicroSpaceEmpireFrame extends JFrame implements Observer, Constantes{
   
    private ObservableGame observableGame;
    private MicroSpacePrincipalPanel painelPrincipal;

    
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
        
        painelPrincipal = new MicroSpacePrincipalPanel(observableGame);
        addComponents();
        
        setLocation(0, 0); 
        setSize(width,height); 
        setMinimumSize(new Dimension(width,height));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    
        update(observableGame,null);
    }
    

     private void addComponents()
    {      
        Container cp = getContentPane(); 
        cp.setLayout(new BorderLayout());//
        cp.add(painelPrincipal,BorderLayout.CENTER);
    }
    
    @Override
    public void update(Observable o, Object o1) {
        repaint();
    }
    
    
}
