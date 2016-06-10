/**
 *
 * @author Dmytro Yaremyshyn & Sérgio Cruz
 */
package microspaceempire.gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel; 
import javax.swing.border.LineBorder;
import logicaJogo.ObservableGame;
import logicaJogo.States.ConstruirFM_DescobrirTecnologia;
import logicaJogo.States.ExplorarAtacar_Conquistar_Passar;
import logicaJogo.States.IStates;
import logicaJogo.States.TrocaEntreRecursos;

public class MicroSpaceEmpirePanel extends JPanel implements Constantes, Observer {
   
    ObservableGame game;
    
    NearSystemPanel nearPanel;
    DistantSystemPanel distantPanel;
    ImpirePanel imperio;
    UnalignedPanel porConquistar;
    MetalPanel recursoMetalPanel;
    WeathPanel recursoRiquezaPanel;
    MilitaryStrenghPanel forcaMilitarPanel;
    TechnologyUpdatePanel tecnologiasPanel;
     
    
    JPanel EscolhaDosSystem;
    JPanel VisualizacaoDosSystems;
    JPanel ParteDosRecursosEeventos;
     
    JButton trocaRiquezaPorMetal;
    JButton trocaMetalPorRiqueza;
    JButton Passar;
    
     
    static private BufferedImage fundo = null;
    static private BufferedImage  SystemParteTras = null;
    static private BufferedImage  riqueza = null;
    static private BufferedImage  metal = null;
    static private BufferedImage  tecnologiasUpdate = null;
    static private BufferedImage  forcaMilitar = null;
    static private BufferedImage  marcador1 = null;
    
   
  
    
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
        repaint();
    }

    private void setupComponents()
    {
     //panel com info e os listeners
     nearPanel = new NearSystemPanel(game);
     distantPanel = new DistantSystemPanel(game);
     imperio = new ImpirePanel(game);
     porConquistar = new UnalignedPanel(game);
     recursoMetalPanel = new MetalPanel(game);
     recursoRiquezaPanel = new  WeathPanel(game);
     forcaMilitarPanel = new MilitaryStrenghPanel(game);
     tecnologiasPanel = new TechnologyUpdatePanel(game);
     
     //butoes
     trocaRiquezaPorMetal = new JButton() ;
     trocaMetalPorRiqueza = new JButton();
     Passar = new JButton("Passar");
     Passar.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev){         
              game.Passar();
            }
        });
     
     //labels
     
     
     //jpanels para verificação de estado decorrente
    EscolhaDosSystem = new JPanel(); 
    VisualizacaoDosSystems = new JPanel();
    ParteDosRecursosEeventos = new JPanel(); 
          
                   
    }

    private void setupLayout()
    {
    

//   
//
//        int nSist = game.getImperio().size();
//
//       
//         imperio.setMaximumSize(new Dimension(DIM_X_CARTA * nSist, DIM_Y_CARTA));
//         imperio.setPreferredSize(new Dimension(DIM_X_CARTA * nSist, DIM_Y_CARTA));
//         imperio.setMinimumSize(new Dimension(DIM_X_CARTA * nSist, DIM_Y_CARTA));
//        
//        
//        
//         //escolhe sistema near ou distant

       //escolhe sistema near ou distant

       EscolhaDosSystem.setLayout(new FlowLayout()); //tipo float
       EscolhaDosSystem.setBackground(Color.MAGENTA);
      
       EscolhaDosSystem.add(nearPanel);
       EscolhaDosSystem.add(distantPanel);
      
        //visualizar imperio e planetas pro conquistar
        VisualizacaoDosSystems.setLayout(new GridLayout(2,1)); //tipo grid 
        VisualizacaoDosSystems.setBackground(Color.BLUE);
        
        
        VisualizacaoDosSystems.add(porConquistar);
        VisualizacaoDosSystems.add(imperio);
        //VisualizacaoDosSystems.setLayout(new FlowLayout());
      
        //parte de baixo
        JPanel pSouth=new JPanel();
        
        
        ParteDosRecursosEeventos.setLayout(new FlowLayout());
        ParteDosRecursosEeventos.setBackground(Color.BLACK);
        ParteDosRecursosEeventos.add(recursoMetalPanel);
        ParteDosRecursosEeventos.add(recursoRiquezaPanel);
        ParteDosRecursosEeventos.add(forcaMilitarPanel);
        ParteDosRecursosEeventos.add(tecnologiasPanel);
        pSouth.setBackground(Color.yellow);
        pSouth.setSize(200, 400);
        add(pSouth,BorderLayout.SOUTH);
        
       add(EscolhaDosSystem);
       add(VisualizacaoDosSystems);
       add(ParteDosRecursosEeventos);
       add(Passar);
       add(tecnologiasPanel);


       validate();
    } 
    
    
    public static BufferedImage getFundoInicio() {
        return fundo;
    }
     
    public static BufferedImage getSystemPartetras()
    {
      return  SystemParteTras;
    }

    public static BufferedImage getRiqueza() {
        return riqueza;
    }

    public static BufferedImage getMetal() {
        return metal;
    }

    public static BufferedImage getTecnologiasUpdate() {
        return tecnologiasUpdate;
    }

    public static BufferedImage getForcaMilitar() {
        return forcaMilitar;
    }

    public static BufferedImage getMarcador1() {
        return marcador1;
    }
	
    
    static {
        try {
            fundo = ImageIO.read(Resources.getResourceFile("images/fundoPrincipal.gif"));
            SystemParteTras = ImageIO.read(Resources.getResourceFile("images/System.png"));
            riqueza = ImageIO.read(Resources.getResourceFile("images/Wealth.png"));
            metal = ImageIO.read(Resources.getResourceFile("images/Metal.png"));
            tecnologiasUpdate = ImageIO.read(Resources.getResourceFile("images/Technology.png"));
            forcaMilitar = ImageIO.read(Resources.getResourceFile("images/Military.png"));
            marcador1 =  ImageIO.read(Resources.getResourceFile("images/marcador2.png"));
            
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
      
     nearPanel = new NearSystemPanel(game);
     distantPanel = new DistantSystemPanel(game);
     imperio = new ImpirePanel(game);
     porConquistar = new UnalignedPanel(game);
     recursoMetalPanel = new MetalPanel(game);
     recursoRiquezaPanel = new  WeathPanel(game);
     forcaMilitarPanel = new MilitaryStrenghPanel(game);
     tecnologiasPanel = new TechnologyUpdatePanel(game);
     
     //butoes
     trocaRiquezaPorMetal = new JButton() ;
     trocaMetalPorRiqueza = new JButton();
     
    }
    
    public void tiraContornos()
    {
        nearPanel.setBorder( new LineBorder(new Color(0,0,0,0))); //mete o anterior a transparente
        distantPanel.setBorder( new LineBorder(new Color(0,0,0,0))); //mete o anterior a transparente
        porConquistar.setBorder( new LineBorder(new Color(0,0,0,0))); //mete o anterior a transparente
        recursoMetalPanel.setBorder( new LineBorder(new Color(0,0,0,0)));
        recursoRiquezaPanel.setBorder( new LineBorder(new Color(0,0,0,0)));
        trocaRiquezaPorMetal.setBorder( new LineBorder(new Color(0,0,0,0)));
        trocaMetalPorRiqueza.setBorder( new LineBorder(new Color(0,0,0,0)));
    
    }
    
    
}
