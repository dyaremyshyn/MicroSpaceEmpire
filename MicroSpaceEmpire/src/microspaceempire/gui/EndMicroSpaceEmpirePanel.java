
package microspaceempire.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import logicaJogo.ObservableGame;


public class EndMicroSpaceEmpirePanel extends JPanel implements Observer, Constantes{
    
   
    JButton restart;
    JButton close;
    JLabel title; 
    
    ObservableGame observableGame;
    
    
    static private BufferedImage fundo = null;
    
    public static BufferedImage getFundoInicio() {
        return fundo;
    }
			
    static {
        try {
            fundo = ImageIO.read(Resources.getResourceFile("images/fundoPrincipal.gif"));
        } catch (IOException e) {
            System.out.println("Error loading images ");
        }
    }
    
    
    public EndMicroSpaceEmpirePanel(ObservableGame jogo) {
       
        observableGame=jogo;
        observableGame.addObserver(this);
        setupComponents();
        setupLayout();
      
    }
    
    
    private void setupComponents()
    {  
        restart = new JButton("Restart");
        close = new JButton("Close");
        title = new JLabel("END"); 

        
        
        restart.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev){          
                MicroSpaceEmpireFrame GUI = new MicroSpaceEmpireFrame(new ObservableGame());
            }
        });
        
        close.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev){         
                 System.exit(0);
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
        
        restart.setSize(100,100); 
        close.setSize(100,100);
        
        add(parteDeCima, BorderLayout.NORTH);
        add(parteDeBaixo, BorderLayout.SOUTH);
        
    
        parteDeBaixo.add(Box.createRigidArea(new Dimension(0,100)));
        
        parteDeBaixo.setBackground(new Color(0,0,0,0)); //torna o fundo transparente
        parteDeCima.setBackground(new Color(0,0,0,0));
      
        
        parteDeBaixo.add(restart);
        parteDeBaixo.add(close);
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
