
package microspaceempire.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import logicaJogo.ObservableGame;
import logicaJogo.States.AguardaInicio;
import logicaJogo.States.IStates;


public class MicroSpacePrincipalPanel extends JPanel implements Observer, Constantes{
     ObservableGame game;
     MicroSpaceEmpirePanel gamePanel;
     StartMicroSpaceEmpirePanel startPanel;
     
     
     CardLayout cardManager = new CardLayout();
   
    

    public MicroSpacePrincipalPanel(ObservableGame game)
    {
        this.game=game;
        this.game.addObserver(this);
              
        setupComponents();
        setupLayout();

        
        update(this.game, null);
    }

    private void setupComponents()
    {
        startPanel = new StartMicroSpaceEmpirePanel(game);
        gamePanel = new  MicroSpaceEmpirePanel(game);
   
    }

    private void setupLayout()
    {
        setLayout(cardManager);
        add(startPanel, "start"); 
        add(gamePanel, "game");  
        
//        add(startPanel); 
//        add(gamePanel);  
        
        validate();
    }

    @Override
    public void update(Observable o, Object arg) {
        IStates estado = game.getStates();
        if(estado instanceof AguardaInicio ){
            cardManager.show(this, "start");
        }else{
            
            cardManager.show(this, "game");
        }
    }
    
}
