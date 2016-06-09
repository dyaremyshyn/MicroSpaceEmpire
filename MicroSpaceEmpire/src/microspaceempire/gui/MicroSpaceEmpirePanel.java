
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
    StartMicroSpaceEmpirePanel startPainel;

    public MicroSpaceEmpirePanel(ObservableGame game)
    {
        this.game=game;               
        setupComponents();
        setupLayout();
    }

    private void setupComponents()
    {
       startPainel = new  StartMicroSpaceEmpirePanel (game);  
    }

    private void setupLayout()
    {
        add(startPainel);        
        
        validate();
    } 
}
