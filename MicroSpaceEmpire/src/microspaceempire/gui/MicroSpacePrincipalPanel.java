/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microspaceempire.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import logicaJogo.ObservableGame;
import logicaJogo.States.AguardaInicio;

/**
 *
 * @author Sergio
 */
public class MicroSpacePrincipalPanel extends JPanel implements Observer, Constantes{
     ObservableGame game;
     MicroSpaceEmpirePanel gamePanel;
     StartMicroSpaceEmpirePanel startPanel;
   
    

    public MicroSpacePrincipalPanel(ObservableGame game)
    {
        this.game=game;
              
        setupComponents();
        setupLayout();
    }

    private void setupComponents()
    {
        startPanel=new StartMicroSpaceEmpirePanel(game);
    //    gamePanel = new  MicroSpaceEmpirePanel(game);
   
    }

    private void setupLayout()
    {
        JPanel pCenter;

        setLayout(new FlowLayout());

        pCenter=new JPanel();
       
        pCenter.setLayout(new FlowLayout());
        
      
 
                       
        add(pCenter,FlowLayout.CENTER);
        
        add(startPanel);        
        
        validate();
    }
    
    public void update(Observable o, Object arg)
    {
        setVisible(!(game.getStates() instanceof AguardaInicio));
    }
}
