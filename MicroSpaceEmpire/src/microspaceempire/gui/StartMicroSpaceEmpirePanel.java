
package microspaceempire.gui;

import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.JPanel;
import logicaJogo.Jogo;
import logicaJogo.JogoDados;
import logicaJogo.States.AguardaInicio;

/**
 *
 * @author Dmytro Yaremyshyn & Sergio Cruz
 */
public class StartMicroSpaceEmpirePanel extends JPanel implements Observer{ 
   
    JButton start=new JButton("Start Game");
    JogoDados jogoDados;
    Jogo game;
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
    
    
    public StartMicroSpaceEmpirePanel(Jogo jogo) {
        game=jogo;
        
        setupLayout();
        
        setVisible(game.getStates() instanceof AguardaInicio);
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
        setVisible(game.getStates() instanceof AguardaInicio);
    }
    
    
}
