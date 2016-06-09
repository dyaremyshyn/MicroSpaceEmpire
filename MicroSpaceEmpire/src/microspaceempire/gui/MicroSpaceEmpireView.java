
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
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import logicaJogo.ObservableGame;


public class MicroSpaceEmpireView extends JFrame implements Observer {
    
    ObservableGame jogo;
    MicroSpaceEmpirePanel painel;
    //JMenuBar menuBar;
  
    
    public MicroSpaceEmpireView(ObservableGame j)
    {
        super("Three in a row");

        jogo = j;            
        jogo.addObserver(this);
        painel = new MicroSpaceEmpirePanel(jogo);

        /*
        addComponents();
        menus();*/
        
        setVisible(true);
        this.setSize(700, 500);
        this.setMinimumSize(new Dimension(650, 450));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
        
        update(jogo,null);
    }

     private void addComponents()
    {
        Container cp=getContentPane();
        
        cp.setLayout(new BorderLayout());
        cp.add(painel,BorderLayout.CENTER);
    }
    
    @Override
    public void update(Observable o, Object arg) {                   
       // menuBar.setVisible(!(jogo.getState() instanceof AwaitBeginning));
        repaint();
    }
    
    
    /*
    private void menus()
    {
    menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    //opções de menu
    JMenu Menu_file = new JMenu("File");
    Menu_file.setMnemonic(KeyEvent.VK_G);
    
    JMenu Menu_help = new JMenu("Help");
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
    JMenuItem helpContentObjJMI = new JMenuItem("Help Contents");
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
           jogo.();
        }
    }
    
    class loadObjMenuBarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
         JFileChooser fc  = new JFileChooser("./data");
         int returnval = fc.showOpenDialog(ThreeInRowView.this);         
            if(returnval == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                try
                {
                GameModel gameModel = (GameModel)FileUtility.retrieveGameFromFile(file);
                if(gameModel != null){
                game.setGameModel(gameModel);
                }
                }catch(IOException | ClassNotFoundException ex){
                     JOptionPane.showMessageDialog(ThreeInRowView.this,"operaçao falhou\r\n\r\n" + ex,"ERRO",JOptionPane.PLAIN_MESSAGE);              
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

            int returnval = fc.showSaveDialog(ThreeInRowView.this);
            if(returnval == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                try
                {
                FileUtility.saveGameToFile(file,game.getGameModel());
                }catch(IOException ex){
                JOptionPane.showMessageDialog(ThreeInRowView.this,"operaçao falhou\r\n\r\n" + ex,"ERRO",JOptionPane.PLAIN_MESSAGE);
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
          JOptionPane.showMessageDialog(ThreeInRowView.this,"ola","Help content",JOptionPane.PLAIN_MESSAGE);
        }
    }

    class aboutObjMenuBarListener implements ActionListener 
    {

        @Override
        public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(ThreeInRowView.this,"ola","Help content",JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
}
