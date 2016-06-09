
package microspaceempire.gui;

import java.awt.Color;
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

public class StartMicroSpaceEmpirePanel extends JPanel implements Observer, Constantes{
    JButton start ;
    JLabel title; 
    
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
        observableGame.addObserver(this);
        setupComponents();
        setupLayout();
        
        
        
        
        setVisible(observableGame.getStates() instanceof AguardaInicio);
    }
    
    
    private void setupComponents()
    {  
        start = new JButton("Start Game");
        title = new JLabel("Micro Space Empire"); 
        
        start.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev){
          
                observableGame.PrepararJogo();

            }
        });
   
    }
    
    
     private void setupLayout()
    {
        title.setFont(new Font("Arial", Font.ITALIC, 47));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.TOP_ALIGNMENT); 

        start.setAlignmentX(Component.CENTER_ALIGNMENT);      
        add(start);
        add(title);
        
        validate();
    }
     
     @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawImage(getFundoInicio(), WIDTH, HEIGHT, this);
        
    }

    @Override
    public void update(Observable o, Object arg)
    {
        setVisible(observableGame.getStates() instanceof AguardaInicio);
    }
    
    
}
