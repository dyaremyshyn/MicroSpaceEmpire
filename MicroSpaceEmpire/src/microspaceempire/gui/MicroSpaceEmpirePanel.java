
package microspaceempire.gui;


import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel; 
import logicaJogo.ObservableGame;
/**
 *
 * @author Dmytro Yaremyshyn & Sérgio Cruz
 */
public class MicroSpaceEmpirePanel extends JPanel implements Constantes {
    ObservableGame game;
    StartMicroSpaceEmpirePanel startPainel;
    NearSystemPanel nearPanel;
    static Map<String, Image> nearSystem;
    static Map<String, Image> distantSystem;
    static Map<String, Image> eventos;    

    static {
        eventos = new HashMap<String, Image>();
        try {
            eventos.put(ASTEROID, ImageIO.read(Resources.getResourceFile(PATH_IMG_ASTEROID)));
            eventos.put(DERELICTSHIP, ImageIO.read(Resources.getResourceFile(PATH_IMG_DERELICTSHIP)));
            eventos.put(LARGEINVASIONFORCE, ImageIO.read(Resources.getResourceFile(PATH_IMG_LARGEINVASIONFORCE)));
            eventos.put(PEACEQUIET, ImageIO.read(Resources.getResourceFile(PATH_IMG_PEACEQUIET)));
            eventos.put(REVOLT, ImageIO.read(Resources.getResourceFile(PATH_IMG_REVOLT)));
            eventos.put(REVOLT2, ImageIO.read(Resources.getResourceFile(PATH_IMG_REVOLT2)));
            eventos.put(SMALLINVASIONFORCE, ImageIO.read(Resources.getResourceFile(PATH_IMG_SMALLINVASIONFORCE)));
            eventos.put(STRIKE, ImageIO.read(Resources.getResourceFile(PATH_IMG_STRIKE)));
        } catch (IOException e) {
        }
    }
    
    static {
        distantSystem = new HashMap<String, Image>();
        try {
            distantSystem.put(CANOPUS, ImageIO.read(Resources.getResourceFile(PATH_IMG_CANOPUS)));
            distantSystem.put(GALAXYEDGE, ImageIO.read(Resources.getResourceFile(PATH_IMG_GALAXYEDGE)));
            distantSystem.put(POLARIS, ImageIO.read(Resources.getResourceFile(PATH_IMG_POLARIS)));
        } catch (IOException e) {
        }
    }
    
    static {
        nearSystem = new HashMap<String, Image>();
        try {
            nearSystem.put(CYGNUS, ImageIO.read(Resources.getResourceFile(PATH_IMG_CYGNUS)));
            nearSystem.put(EPSILONERIDANI, ImageIO.read(Resources.getResourceFile(PATH_IMG_EPSILONERIDANI)));
            nearSystem.put(PROCYON, ImageIO.read(Resources.getResourceFile(PATH_IMG_PROCYON)));
            nearSystem.put(PROXIMA, ImageIO.read(Resources.getResourceFile(PATH_IMG_PROXIMA)));
            nearSystem.put(SIRIUS, ImageIO.read(Resources.getResourceFile(PATH_IMG_SIRIUS)));
            nearSystem.put(TAUCETI, ImageIO.read(Resources.getResourceFile(PATH_IMG_TAUCETI)));
            nearSystem.put(WOLF359, ImageIO.read(Resources.getResourceFile(PATH_IMG_WOLF359)));
        } catch (IOException e) {
        }
    }
    
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
