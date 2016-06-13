/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import logicaJogo.ObservableGame;


public class EndMicroSpaceEmpirePanel extends JPanel implements Observer, Constantes{
    
   
    JButton restart;
    JButton close;
    JLabel title; 
    JLabel conteudo;
    ImageIcon icon;
    JPanel fundo_label;
    
    ObservableGame observableGame;
    
    
    static private BufferedImage fundo = null;
    static private BufferedImage placa = null;
    
    public static BufferedImage getFundoInicio() {
        return fundo;
    }
	public static BufferedImage getPLaca() {
        return placa;
    }
    
    static {
        try {
            placa = ImageIO.read(Resources.getResourceFile("images/placa3.png"));
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
        
       // icon = new ImageIcon("/images/placa3.png");

         conteudo= new JLabel(observableGame.Painel_final_GUI(), SwingConstants.CENTER) {
        @Override
        public void paintComponent(Graphics g) {
         
          g.drawImage(placa, 0, 0, conteudo.getWidth(), conteudo.getHeight(), null);
         super.paintComponent(g);
      }
    };

    conteudo.setOpaque(false);
 
        JPanel parteDeBaixo = new JPanel();
        JPanel parteDeCima = new JPanel();
        JPanel parteDoMeio = new JPanel();
        
        setLayout(new BorderLayout());

        title.setFont(new Font("Arial", Font.ITALIC, 47));
        title.setForeground(Color.WHITE);
        
        conteudo.setFont(new Font("Arial", Font.ITALIC, 25));
        conteudo.setForeground(Color.BLACK);
       
       
        restart.setSize(400,200); 
        close.setSize(400,200);
        
        add(parteDeCima, BorderLayout.NORTH);
        add(parteDeBaixo, BorderLayout.SOUTH);
        add(parteDoMeio, BorderLayout.CENTER);
        
    
        parteDeBaixo.add(Box.createRigidArea(new Dimension(0,100)));
        
        parteDeBaixo.setBackground(new Color(0,0,0,0)); //torna o fundo transparente
        parteDeCima.setBackground(new Color(0,0,0,0));
        parteDoMeio.setBackground(new Color(0,0,0,0));
      
        
        
        parteDeBaixo.add(restart);
        parteDeBaixo.add(close);
        parteDeCima.add(title);
        parteDoMeio.add(conteudo);

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
