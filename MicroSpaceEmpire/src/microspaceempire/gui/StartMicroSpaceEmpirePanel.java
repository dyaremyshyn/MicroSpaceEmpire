
package microspaceempire.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import logicaJogo.JogoDados;
import logicaJogo.ObservableGame;


/**
 *
 * @author Dmytro Yaremyshyn & Sergio Cruz
 */

public class StartMicroSpaceEmpirePanel extends JPanel implements Observer, Constantes{
   
    JButton start;
    JLabel title; 
    
    //JogoDados jogoDados;
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
      //  setBorder( new LineBorder(Color.blue,2));
     //   setBackground(Color.blue);
       // setVisible(observableGame.getStates() instanceof AguardaInicio);
       // update(observableGame, null);
    }
    
    
    private void setupComponents()
    {  
        start = new JButton("Start Game");
        title = new JLabel("Micro Space Empire"); 
        
//        setMaximumSize(new Dimension(600, 600));
//        setMinimumSize(new Dimension(600, 600));
//        setPreferredSize(new Dimension(600, 600));
        
        
        start.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev){
          
                observableGame.PrepararJogo();

            }
        });
   
    }
    
    
     private void setupLayout()
    {
        
        JPanel parteDeBaixo = new JPanel();
        JPanel parteDeCima = new JPanel();
       
        
        setLayout(new BorderLayout());

        title.setFont(new Font("Arial", Font.ITALIC, 47));
        title.setForeground(Color.WHITE);
        
        start.setSize(100,100);                
        
        add(parteDeCima, BorderLayout.NORTH);
        add(parteDeBaixo, BorderLayout.SOUTH);
        
    
        parteDeBaixo.add(Box.createRigidArea(new Dimension(0,100)));
        
        parteDeBaixo.setBackground(new Color(0,0,0,0)); //torna o fundo transparente
        parteDeCima.setBackground(new Color(0,0,0,0));
      
        
        parteDeBaixo.add(start);
        parteDeCima.add(title);
        

        
        
        validate();
    }
     
     @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawImage(getFundoInicio(), 0, 0, getWidth(), getHeight(), this);
        
    }

    @Override
    public void update(Observable o, Object arg)
    {

    }
    
    
}
