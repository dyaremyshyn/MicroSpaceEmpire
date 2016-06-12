/**
 *
 * @author Dmytro Yaremyshyn & Sérgio Cruz
 */
package microspaceempire.gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel; 
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
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
    EventPanel EventosPanel;
     
    JPanel sul, este;
    
    
    JPanel EscolhaDosSystem;
    JPanel VisualizacaoDosSystems;
    JPanel ParteDosRecursosEeventos;
    JPanel CurrentEvent;
     
    JButton trocaRiquezaPorMetal;
    JButton trocaMetalPorRiqueza;
    JButton Passar;
    
    
    JLabel nearSystemLabel;
    JLabel distantSystemLabel;
    JLabel imperioLabel;
    JLabel porConquistarLabel;
    JLabel currentState;
    
    
     
    static private BufferedImage fundo = null;
    static private BufferedImage  SystemParteTras = null;
    static private BufferedImage  riqueza = null;
    static private BufferedImage  metal = null;
    static private BufferedImage  tecnologiasUpdate = null;
    static private BufferedImage  forcaMilitar = null;
    static private BufferedImage  marcador1 = null;
    static private BufferedImage evento = null;
   
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
    
        update(this.game, null);
        
        validate();
        repaint();
    }

    private void setupComponents()
    {
        //panel com info e os listeners
        EventosPanel=new EventPanel(game);
        
        nearPanel = new NearSystemPanel(game);
        distantPanel = new DistantSystemPanel(game);
        
        imperio = new ImpirePanel(game);
        porConquistar = new UnalignedPanel(game);
        recursoMetalPanel = new MetalPanel(game);
        recursoRiquezaPanel = new  WeathPanel(game);
        forcaMilitarPanel = new MilitaryStrenghPanel(game);
        tecnologiasPanel = new TechnologyUpdatePanel(game);
     
        //butoes
        trocaRiquezaPorMetal = new JButton("Metal -> Riq") ;
        trocaRiquezaPorMetal.setEnabled(false);
        trocaMetalPorRiqueza = new JButton("Riq -> Metal");
        trocaMetalPorRiqueza.setEnabled(false);
        Passar = new JButton("Passar");
        Passar.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev){         
              game.Passar();
            }
        });
     
        //labels
        nearSystemLabel= new JLabel("NEAR");
        nearSystemLabel.setFont(new Font("Arial", Font.BOLD, 12));
        nearSystemLabel.setAlignmentX(Component.TOP_ALIGNMENT);
        nearSystemLabel.setForeground(Color.ORANGE);
     
        distantSystemLabel= new JLabel("DISTANT");
        distantSystemLabel.setFont(new Font("Arial", Font.BOLD, 12));
        distantSystemLabel.setAlignmentX(Component.TOP_ALIGNMENT);
        distantSystemLabel.setForeground(Color.ORANGE);
        
        
        imperioLabel= new JLabel("Imperio");
        imperioLabel.setFont(new Font("Arial", Font.BOLD, 12));
        imperioLabel.setAlignmentX(Component.TOP_ALIGNMENT);
        imperioLabel.setForeground(Color.ORANGE);
        
        porConquistarLabel= new JLabel("Unaligned");
        porConquistarLabel.setFont(new Font("Arial", Font.BOLD, 12));
        porConquistarLabel.setAlignmentX(Component.TOP_ALIGNMENT);
        porConquistarLabel.setForeground(Color.ORANGE);
        
        
        
        //jpanels para verificação de estado decorrente
        EscolhaDosSystem = new JPanel(); 
        VisualizacaoDosSystems = new JPanel();
        ParteDosRecursosEeventos = new JPanel(); 
    
                   
    }

    private void setupLayout()
    {
        //setLayout(new BorderLayout());

//   
// importante manter esta implementaçao
       /* int nSist = game.getImperio().size();

         imperio.setMaximumSize(new Dimension(DIM_X_CARTA * nSist, DIM_Y_CARTA));
         imperio.setPreferredSize(new Dimension(DIM_X_CARTA * nSist, DIM_Y_CARTA));
         imperio.setMinimumSize(new Dimension(DIM_X_CARTA * nSist, DIM_Y_CARTA));
        
         int nPorConq = game.getPorConquistar().size();

          porConquistar.setMaximumSize(new Dimension(DIM_X_CARTA * nPorConq , DIM_Y_CARTA));
          porConquistar.setPreferredSize(new Dimension(DIM_X_CARTA * nPorConq , DIM_Y_CARTA));
          porConquistar.setMinimumSize(new Dimension(DIM_X_CARTA * nPorConq , DIM_Y_CARTA));*/
        
//        
//         //escolhe sistema near ou distant

      

        EscolhaDosSystem.setLayout(new BoxLayout(EscolhaDosSystem, BoxLayout.Y_AXIS)); //tipo float
        //EscolhaDosSystem.setBackground(Color.MAGENTA);
        nearPanel.add(nearSystemLabel,BOTTOM_ALIGNMENT);
        distantPanel.add(distantSystemLabel,BOTTOM_ALIGNMENT);
        
        EscolhaDosSystem.add(nearPanel);
        EscolhaDosSystem.add(distantPanel);
      
        //visualizar imperio e planetas pro conquistar
        VisualizacaoDosSystems.setLayout(new GridLayout(2,1)); //tipo grid 
        VisualizacaoDosSystems.setBackground(new Color(0,0,0,0));
        
        imperio.setToolTipText("O nosso império!");
        porConquistar.setToolTipText("Sistemas que foram explorados mas NÃO conquistados!");
        imperio.add(imperioLabel,BOTTOM_ALIGNMENT);
        porConquistar.add(porConquistarLabel,BOTTOM_ALIGNMENT);
        
        VisualizacaoDosSystems.add(porConquistar);
        VisualizacaoDosSystems.add(imperio);
        //VisualizacaoDosSystems.setLayout(new FlowLayout());
      
        //parte de baixo
       
        //ParteDosRecursosEeventos.setLayout(new BoxLayout(ParteDosRecursosEeventos, WIDTH));
        ParteDosRecursosEeventos.setLayout(new FlowLayout());
        //ParteDosRecursosEeventos.setBackground(Color.BLACK);
        ParteDosRecursosEeventos.add(recursoMetalPanel);
        ParteDosRecursosEeventos.add(recursoRiquezaPanel);
        ParteDosRecursosEeventos.add(forcaMilitarPanel);
        ParteDosRecursosEeventos.add(tecnologiasPanel);
        ParteDosRecursosEeventos.setBackground(new Color(0,0,0,0));
        
        //CurrentEvent.setLayout(new BoxLayout(CurrentEvent,BoxLayout.Y_AXIS));
        //CurrentEvent.add(EventosPanel);
        
        Box principal = Box.createHorizontalBox();
        Box vertical = Box.createVerticalBox();
        Box horizontal = Box.createHorizontalBox();
        
        principal.setBorder(new LineBorder(Color.blue));
        vertical.setBorder(new LineBorder(Color.GREEN));
        
        
        principal.add(ParteDosRecursosEeventos);
        principal.add(Box.createHorizontalGlue());
        
        horizontal.add(Box.createHorizontalGlue());
        horizontal.add(Passar);
        horizontal.add(trocaRiquezaPorMetal);
        horizontal.add(trocaMetalPorRiqueza);
        horizontal.setBorder(new LineBorder(Color.pink));
        //vertical.add(horizontal,Component.LEFT_ALIGNMENT);
        vertical.add(Box.createVerticalGlue());
        vertical.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        
        //vertical.add(CurrentEvent);
        
        principal.add(vertical);
        principal.add(Box.createVerticalGlue());
        principal.setAlignmentY(Component.LEFT_ALIGNMENT);
        principal.add(Box.createHorizontalGlue());
        principal.add(Box.createHorizontalGlue());
        principal.add(Box.createHorizontalGlue());
        principal.add(Box.createHorizontalGlue());
        
        principal.add(horizontal);
        
       add(EscolhaDosSystem);
       add(VisualizacaoDosSystems);
       //add(ParteDosRecursosEeventos);
       //add(Passar);
       //add(tecnologiasPanel);
       //add(pSouth,BorderLayout.SOUTH);
       
       add(principal);
       add(Box.createHorizontalGlue());

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
         
//        IStates estado = game.getStates();
//      
//     nearPanel = new NearSystemPanel(game);
//     distantPanel = new DistantSystemPanel(game);
//     imperio = new ImpirePanel(game);
//     porConquistar = new UnalignedPanel(game);
//     recursoMetalPanel = new MetalPanel(game);
//     recursoRiquezaPanel = new  WeathPanel(game);
//     forcaMilitarPanel = new MilitaryStrenghPanel(game);
//     tecnologiasPanel = new TechnologyUpdatePanel(game);
//     
//     //butoes
//     trocaRiquezaPorMetal = new JButton() ;
//     trocaMetalPorRiqueza = new JButton();
     
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
