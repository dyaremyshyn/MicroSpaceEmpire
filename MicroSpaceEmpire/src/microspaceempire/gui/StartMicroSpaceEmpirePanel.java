
package microspaceempire.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logicaJogo.Jogo;
import logicaJogo.JogoDados;
import logicaJogo.ObservableGame;
import logicaJogo.States.AguardaInicio;

/**
 *
 * @author Dmytro Yaremyshyn & Sergio Cruz
 */
<<<<<<< HEAD
public class StartMicroSpaceEmpirePanel extends JPanel implements Observer{ 
   
    JButton start=new JButton("Start Game");
=======
public class StartMicroSpaceEmpirePanel extends JPanel implements Observer{
    JButton start;
    JLabel title;
>>>>>>> origin/master
    JogoDados jogoDados;
    ObservableGame observableGame;
    static private BufferedImage fundo = null;
    
    public static BufferedImage getFundoInicio() {
        return fundo;
    }
			
    static {
        try {
            fundo = ImageIO.read(Resources.getResourceFile("images/fundoInicio.gif"));
        } catch (IOException e) {
            System.out.println("Error loading images ");
        }
    }
    
    
    public StartMicroSpaceEmpirePanel(ObservableGame jogo) {
        observableGame=jogo;
        
        setupLayout();
        
        setVisible(observableGame.getStates() instanceof AguardaInicio);
    }
    
    
    private void setupComponents(){        
        
        start = new JButton("Start Game");
        
        title = new JLabel("Micro Space Empire");       
        title.setFont(new Font("Arial", Font.ITALIC, 12));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);             
        
    }
    
    
     private void setupLayout()
    {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        start.setAlignmentX(Component.CENTER_ALIGNMENT); 
        
        add(start);
        
        validate();
    }
     
     @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawImage(getFundoInicio(), WIDTH, WIDTH, this);
    }

    @Override
    public void update(Observable o, Object arg)
    {
        setVisible(observableGame.getStates() instanceof AguardaInicio);
    }
    
    
}
