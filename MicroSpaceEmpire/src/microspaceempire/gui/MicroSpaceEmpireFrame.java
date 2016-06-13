/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */
package microspaceempire.gui;

import java.awt.BorderLayout;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import java.io.IOException;

import java.util.Observable;
import java.util.Observer;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import logicaJogo.Jogo;
import logicaJogo.ObservableGame;
import logicaJogo.States.AguardaInicio;
import logicaJogo.States.Fim;
import logicaJogo.files.FileUtility;

/**
 *
 * @author Dmytro Yaremyshyn & Sérgio Cruz
 */
public class MicroSpaceEmpireFrame extends JFrame implements Observer, Constantes{
   
    private ObservableGame game;
    private MicroSpacePrincipalPanel painelPrincipal;

    JMenuBar menuBar;
    
    public MicroSpaceEmpireFrame( ObservableGame j) {
        this( j, 200, 100, DIM_X_FRAME, DIM_Y_FRAME);
    }
    
    public MicroSpaceEmpireFrame( ObservableGame j, int x, int y ) { 
        this( j, x,y, DIM_X_FRAME, DIM_Y_FRAME);
    }
    
    public MicroSpaceEmpireFrame( ObservableGame j, int x, int y, int width, int height) {
        
        super("Micro Space Empire"); 

        game = j;
        game.addObserver(this);
        
        painelPrincipal = new MicroSpacePrincipalPanel(game);
        addComponents();
        menus();
        setLocation(0, 0); 
        setSize(width,height); 
        setMinimumSize(new Dimension(width,height));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         File fl = new File("musicGame.wav");
         playWav(fl);
         validate();
    
        update(game,null);
    }
    

     private void addComponents()
    {      
        Container cp = getContentPane(); 
        cp.setLayout(new BorderLayout());//
        cp.add(painelPrincipal,BorderLayout.CENTER);
    }
    
    @Override
    public void update(Observable o, Object o1) {
        
        menuBar.setVisible( !( (game.getStates() instanceof AguardaInicio) || (game.getStates() instanceof Fim))  );
        repaint();
    }
    
    public void playWav(File sound)
    {
        try{
   Clip clip = AudioSystem.getClip();
   clip.open(AudioSystem.getAudioInputStream(sound));
   clip.start();
  // Thread.sleep(clip.getMicrosecondLength()\1000);
        }catch(Exception e){}    
    }
    
    
    
    private void menus()
    {
    menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    //opções de menu
    JMenu Menu_file = new JMenu("File");
    Menu_file.setMnemonic(KeyEvent.VK_G);
    
    JMenu Menu_help = new JMenu("More");
    Menu_help.setMnemonic(KeyEvent.VK_H);
    
    
    //submenu de file
    JMenuItem newObjJMI = new JMenuItem("Stop");
    newObjJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); //atalho
    
    JMenuItem readObjJMI = new JMenuItem("Load");
    readObjJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK)); //atalho
    
    JMenuItem saveObjJMI = new JMenuItem("Save");
    saveObjJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));//atalho
    
    JMenuItem ExitJMI = new JMenuItem("Exit");
    ExitJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));//atalho
    
    //montar o JMenu - file
    Menu_file.add(newObjJMI);
    Menu_file.add(readObjJMI);
    Menu_file.add(saveObjJMI);
    Menu_file.addSeparator(); //separador
    Menu_file.add(ExitJMI);
    menuBar.add(Menu_file);

    //add listeners
    newObjJMI.addActionListener(new newObjMenuBarListener());
    readObjJMI.addActionListener(new loadObjMenuBarListener());
    saveObjJMI.addActionListener(new saveObjtMenuBarListener());
    ExitJMI.addActionListener(new exitObjtMenuBarListener());


    //submenu de help
    JMenuItem helpContentObjJMI = new JMenuItem("Help");
    helpContentObjJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)); //atalho
    
    JMenuItem aboutObjJMI = new JMenuItem("About");
    aboutObjJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK)); //atalho
    
    //montar o Jmenu - help   
    Menu_help.add(helpContentObjJMI);
    Menu_help.add(aboutObjJMI);
    menuBar.add(Menu_help);
    
    //add listeners para sub help opções
    helpContentObjJMI.addActionListener(new helpContentObjMenuBarListener());
    aboutObjJMI.addActionListener(new aboutObjMenuBarListener());
    }

   
    

    class newObjMenuBarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           game.Terminar();
        }
    }
    
    class loadObjMenuBarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
         JFileChooser fc  = new JFileChooser("./data");
         int returnval = fc.showOpenDialog(MicroSpaceEmpireFrame.this);         
            if(returnval == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                try
                {
                Jogo jogo = (Jogo)FileUtility.retrieveGameFromFile(file);
                if(jogo != null){
                game.setJogo(jogo);
                }
                }catch(IOException | ClassNotFoundException ex){
                     JOptionPane.showMessageDialog(MicroSpaceEmpireFrame.this,"operaçao falhou\r\n\r\n" + ex,"ERRO",JOptionPane.PLAIN_MESSAGE);              
                }
            }else{System.out.println("operaçao cancelada");}
        }
    }

    class saveObjtMenuBarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JFileChooser fc  = new JFileChooser("./data");

            int returnval = fc.showSaveDialog(MicroSpaceEmpireFrame.this);
            if(returnval == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                try
                {
                FileUtility.saveGameToFile(file,game.getJogo());
                }catch(IOException ex){
                JOptionPane.showMessageDialog(MicroSpaceEmpireFrame.this,"operaçao falhou\r\n\r\n" + ex,"ERRO",JOptionPane.PLAIN_MESSAGE);
                }

            }else{System.out.println("operaçao cancelada");}
        }
    }

    class exitObjtMenuBarListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
        System.exit(0);
        }
    }

    class helpContentObjMenuBarListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
          JOptionPane.showMessageDialog(MicroSpaceEmpireFrame.this,game.help(),"Help",JOptionPane.PLAIN_MESSAGE);
        }
    }

    class aboutObjMenuBarListener implements ActionListener 
    {

        @Override
        public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(MicroSpaceEmpireFrame.this,game.about(),"About",JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    
    
    
    
}
