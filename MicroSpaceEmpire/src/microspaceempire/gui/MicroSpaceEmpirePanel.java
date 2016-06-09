
package microspaceempire.gui;


import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel; 
import logicaJogo.ObservableGame;
/**
 *
 * @author Dmytro Yaremyshyn & Sérgio Cruz
 */
public class MicroSpaceEmpirePanel extends JPanel {
    
    ObservableGame game;
    StartMicroSpaceEmpirePanel optionPainel;
    //GameGrid theGrid;
   // PlayerData pd1,pd2;

    public MicroSpaceEmpirePanel(ObservableGame game)
    {
        this.game=game;               
        setupComponents();
        setupLayout();
    }

    private void setupComponents()
    {
      // optionPanel=new StartOptionPanel(game);
     //   theGrid=new GameGrid(game);
     //   pd1=new PlayerData(game,1);
     //   pd2=new PlayerData(game,2);
   
    }

    private void setupLayout()
    {
        JPanel pCenter, pSouth;

        setLayout(new BorderLayout());

        pCenter=new JPanel();
        pCenter.setLayout(new BorderLayout());
      //  pCenter.add(theGrid,BorderLayout.NORTH);
        
        pSouth=new JPanel();
     //   pSouth.add(pd1);
     //   pSouth.add(pd2);
        pCenter.add(pSouth,BorderLayout.SOUTH);
 
                       
        add(pCenter,BorderLayout.CENTER);
        
        add(optionPainel,BorderLayout.EAST);        
        
        validate();
    }
    
    
    
}
