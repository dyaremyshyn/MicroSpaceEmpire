/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */
package microspaceempire.gui;


import static com.sun.javafx.fxml.expression.Expression.add;
import java.awt.CardLayout;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

import logicaJogo.ObservableGame;
import logicaJogo.States.AguardaInicio;
import logicaJogo.States.Fim;
import logicaJogo.States.IStates;


public class MicroSpacePrincipalPanel extends JPanel implements Observer, Constantes{
    ObservableGame game;
    MicroSpaceEmpirePanel gamePanel;
    StartMicroSpaceEmpirePanel startPanel;
    EndMicroSpaceEmpirePanel endPanel;
          
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
        endPanel = new EndMicroSpaceEmpirePanel(game);
        
    }

    private void setupLayout()
    {
        setLayout(cardManager);
      
        add(startPanel, "start"); 
        add(gamePanel, "game"); 
        add(endPanel, "end");
  
        
        validate();
    }

    @Override
    public void update(Observable o, Object arg) {
        IStates estado = game.getStates();
       
       
        
        if(estado instanceof AguardaInicio ){
            
            cardManager.show(this, "start");
            
        }else if(estado instanceof Fim){ 
           
            cardManager.show(this, "end");
        }else{
            
           cardManager.show(this, "game");
        }
    }

   
    
    
    
    
    
}
