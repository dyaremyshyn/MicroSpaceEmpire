/**
 *
 * @author Dmytro Yaremyshyn & Sérgio Cruz
 */
package microspaceempire.gui;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
<<<<<<< HEAD
import javax.swing.Box;
import javax.swing.JLabel;
=======
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
>>>>>>> origin/master
import javax.swing.JPanel; 
import javax.swing.border.LineBorder;
import logicaJogo.ObservableGame;
import logicaJogo.States.ExplorarAtacar_Conquistar_Passar;
import logicaJogo.States.IStates;
import logicaJogo.States.TrocaEntreRecursos;

public class MicroSpaceEmpirePanel extends JPanel implements Constantes, Observer {
   
    ObservableGame game;
    NearSystemPanel nearPanel;
    DistantSystemPanel distantPanel;
    ImpirePanel imperio;
    UnalignedPanel porConquistar;
    
    
     JPanel EscolhaDosSystem;
     JPanel VisualizacaoDosSystems;
    
     
     
    static private BufferedImage fundo = null;
    static private BufferedImage  SystemParteTras = null;
    
    
   
  
    
    static Map<String, Image> Systems;
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
       Systems = new HashMap<String, Image>();
        try {
            Systems.put(CYGNUS, ImageIO.read(Resources.getResourceFile(PATH_IMG_CYGNUS)));
            Systems.put(EPSILONERIDANI, ImageIO.read(Resources.getResourceFile(PATH_IMG_EPSILONERIDANI)));
            Systems.put(PROCYON, ImageIO.read(Resources.getResourceFile(PATH_IMG_PROCYON)));
            Systems.put(PROXIMA, ImageIO.read(Resources.getResourceFile(PATH_IMG_PROXIMA)));
            Systems.put(SIRIUS, ImageIO.read(Resources.getResourceFile(PATH_IMG_SIRIUS)));
            Systems.put(TAUCETI, ImageIO.read(Resources.getResourceFile(PATH_IMG_TAUCETI)));
            Systems.put(WOLF359, ImageIO.read(Resources.getResourceFile(PATH_IMG_WOLF359)));
            Systems.put(CANOPUS, ImageIO.read(Resources.getResourceFile(PATH_IMG_CANOPUS))); //distant
            Systems.put(GALAXYEDGE, ImageIO.read(Resources.getResourceFile(PATH_IMG_GALAXYEDGE)));//distant
            Systems.put(POLARIS, ImageIO.read(Resources.getResourceFile(PATH_IMG_POLARIS)));//distant
            Systems.put(HOMEWORLD,ImageIO.read(Resources.getResourceFile(PATH_IMG_HOMEWORLD))); //home
        } catch (IOException e) {
        }
    }
    
    
    public static Map<String, Image> getSystemsImgs() {
        return Systems;
    }

    public static Image getSystemImg(String nomeSystem) {
        return Systems.get(nomeSystem);
    }
    
     public static Map<String, Image> getEventsImgs() {
        return eventos;
    }

    public static Image getEventImg(String nomeEvent) {
        return eventos.get(nomeEvent);
    }
    
    
    public MicroSpaceEmpirePanel(ObservableGame game)
    {
        this.game=game;   
        this.game.addObserver(this);
        
        setupComponents();
        setupLayout();
       // setBorder( new LineBorder(Color.red,2));
       // setBackground(Color.red);
        update(this.game, null);
        validate();
    }

    private void setupComponents()
    {
     //panel com info e os listeners
     nearPanel = new NearSystemPanel(game);
     distantPanel = new DistantSystemPanel(game);
     imperio = new ImpirePanel(game);
     porConquistar = new UnalignedPanel(game);
     
     //jpanels para verificação de estado decorrente
    EscolhaDosSystem = new JPanel(); 
     VisualizacaoDosSystems = new JPanel();
     
          
                    
                
       
        
     
     
    }

    private void setupLayout()
    {
       // setLayout(new BorderLayout());
       //setLayout(new GridLayout(5,1));
       
       //GridBagConstraints constraints = new  GridBagConstraints();
       
//       
//       constraints.ipadx = 0;
//       constraints.ipady = 0;
      // constraints.fill = GridBagConstraints.VERTICAL;
      JLabel labSystNear= new JLabel();
      labSystNear.setText("Near Systems");
      JLabel labSystDist= new JLabel();
      labSystDist.setText("Distant Systems");
    
   
        
        
        
         //escolhe sistema near ou distant
       EscolhaDosSystem.setLayout(new FlowLayout());
       EscolhaDosSystem.setBackground(new Color(0,0,0,0));
      // EscolhaDosSystem.setSize(200, 100);
       //EscolhaDosSystem.add(Box.createRigidArea(new Dimension(15,0)));
       EscolhaDosSystem.add(nearPanel);
       EscolhaDosSystem.add(distantPanel);
      
        
      
       //add(EscolhaDosSystem, BorderLayout.NORTH);
       
        //visualizar imperio
       // VisualizacaoDosSystems.setBackground(Color.BLUE);
       // VisualizacaoDosSystems.setLayout(new FlowLayout());
        
        
        
         // VisualizacaoDosSystems.setLayout( (new BoxLayout( VisualizacaoDosSystems, BoxLayout.X_AXIS)));
        add(EscolhaDosSystem);
        add(porConquistar);
        add(imperio);  
       
       // add( VisualizacaoDoImperio, CENTER_ALIGNMENT);
      
      // add(VisualizacaoDosSystems, BorderLayout.CENTER );

       validate();
    } 
    
    public static BufferedImage getFundoInicio() {
        return fundo;
    }
     
    public static BufferedImage getSystemPartetras()
    {
      return  SystemParteTras;
    }
			
    static {
        try {
            fundo = ImageIO.read(Resources.getResourceFile("images/fundoPrincipal.gif"));
            SystemParteTras = ImageIO.read(Resources.getResourceFile("images/System.png"));
            
        } catch (IOException e) {
            System.out.println("Error loading images ");
        }
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
        
        IStates estado = game.getStates();
      
        if(estado instanceof ExplorarAtacar_Conquistar_Passar ){
            EscolhaDosSystem.setBorder( new LineBorder(Color.red,2));
            //falta o conquistar
        }else if(estado instanceof TrocaEntreRecursos)
        {    //falta repor o conquistar
             EscolhaDosSystem.setBorder( new LineBorder(new Color(0,0,0,0))); //mete o anterior a transparente
        //mesmo raciocinio
        }
        
        
 
        
        
    }
    
}
