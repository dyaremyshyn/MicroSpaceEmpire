/**
 *
 * @author Dmytro Yaremyshyn & Sérgio Cruz
 */
package microspaceempire.gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.JPanel; 
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import logicaJogo.Jogo;
import logicaJogo.ObservableGame;
import logicaJogo.States.ConstruirFM_DescobrirTecnologia;
import logicaJogo.States.ExplorarAtacar_Conquistar_Passar;
import logicaJogo.States.IStates;
import logicaJogo.States.TrocaEntreRecursos;
import logicaJogo.files.FileUtility;


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
    JButton AumentarForcaMilitar;
    
    
    JLabel nearSystemLabel;
    JLabel distantSystemLabel;
    JLabel imperioLabel;
    JLabel porConquistarLabel;
    JLabel currentState;
    
    JLabel anoLabel;
    JLabel turnoLabel;
    
    JMenuBar menuBar;
     
    static private BufferedImage fundo = null;
    static private BufferedImage  SystemParteTrasNear = null;
    static private BufferedImage  SystemParteTrasDistant = null;
    static private BufferedImage  riqueza = null;
    static private BufferedImage  metal = null;
    static private BufferedImage  tecnologiasUpdate = null;
    static private BufferedImage  forcaMilitar = null;
    static private BufferedImage  marcador1 = null;
    static private BufferedImage marcador_tecnologias = null;
   
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
            eventos.put(EVENT, ImageIO.read(Resources.getResourceFile(PATH_IMG_EVENT)));            
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
        AumentarForcaMilitar = new JButton("+ Força Militar");
        AumentarForcaMilitar.setEnabled(false);
        AumentarForcaMilitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.Aumentar_Força_Militar();
            }
        });
                
        trocaRiquezaPorMetal = new JButton("(2)Metal -> (1)Riq") ;
        trocaRiquezaPorMetal.setEnabled(false);
        trocaRiquezaPorMetal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                game.Trocar_recursos(2);
            }
        });
        trocaMetalPorRiqueza = new JButton("(2)Riq -> (1)Metal");
        trocaMetalPorRiqueza.setEnabled(false);
        trocaMetalPorRiqueza.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                game.Trocar_recursos(1);
            }
        });
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
        
        currentState = new JLabel("Estado Atual: ");
        currentState.setFont(new Font("Arial", Font.BOLD, 14));
        currentState.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentState.setForeground(Color.ORANGE);
        
        anoLabel = new JLabel("Ano: ");
        anoLabel.setFont(new Font("Arial", Font.BOLD,18));
        anoLabel.setAlignmentX(TOP_ALIGNMENT);
        anoLabel.setForeground(Color.orange);
        
        turnoLabel = new JLabel("Turno: ");
        turnoLabel.setFont(new Font("Arial",Font.BOLD,18));
        turnoLabel.setAlignmentX(TOP_ALIGNMENT);
        turnoLabel.setForeground(Color.orange);
        
        //jpanels para verificação de estado decorrente
        EscolhaDosSystem = new JPanel(); 
        VisualizacaoDosSystems = new JPanel();
        ParteDosRecursosEeventos = new JPanel(); 
        CurrentEvent = new JPanel();
        
        
    }

    private void setupLayout()
    {
        
        EscolhaDosSystem.setLayout(new BoxLayout(EscolhaDosSystem, BoxLayout.Y_AXIS)); //tipo float
        
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
        
        //parte de baixo
        ParteDosRecursosEeventos.setLayout(new FlowLayout());
        
        ParteDosRecursosEeventos.add(CurrentEvent);
        ParteDosRecursosEeventos.add(recursoMetalPanel);
        ParteDosRecursosEeventos.add(recursoRiquezaPanel);
        ParteDosRecursosEeventos.add(forcaMilitarPanel);
        ParteDosRecursosEeventos.add(tecnologiasPanel);
        ParteDosRecursosEeventos.setBackground(new Color(0,0,0,0));
        
        CurrentEvent.setLayout(new BoxLayout(CurrentEvent,BoxLayout.Y_AXIS));
        CurrentEvent.add(EventosPanel);
        
        Box principal = Box.createVerticalBox();
        Box h = Box.createHorizontalBox();
        Box horizontal = Box.createHorizontalBox();
        
        principal.setBorder(new LineBorder(Color.blue));
        h.setBorder(new LineBorder(Color.GREEN));
        
        principal.add(ParteDosRecursosEeventos);
        principal.add(Box.createHorizontalGlue());
        
        horizontal.add(Box.createHorizontalGlue());
        horizontal.add(Passar);
        horizontal.add(Box.createHorizontalGlue());
        horizontal.add(AumentarForcaMilitar);
        horizontal.add(Box.createHorizontalGlue());
        horizontal.add(trocaRiquezaPorMetal);
        horizontal.add(trocaMetalPorRiqueza);
        
        horizontal.setAlignmentX(Component.CENTER_ALIGNMENT);
        horizontal.setBorder(new LineBorder(Color.pink));
        
        h.add(anoLabel);
        h.add(Box.createHorizontalGlue());
        h.add(turnoLabel);
        h.add(Box.createHorizontalGlue());
        h.add(currentState);
        
        
        principal.add(Box.createVerticalGlue());
        principal.setAlignmentY(Component.LEFT_ALIGNMENT);
        principal.add(Box.createHorizontalGlue());
              
        principal.add(horizontal);
        principal.add(h);
        add(EscolhaDosSystem);
        add(VisualizacaoDosSystems);
        
        add(principal,BorderLayout.SOUTH);
        add(Box.createHorizontalGlue());
        
        validate();
    } 
    
    public static BufferedImage getFundoInicio() {
        return fundo;
    }

    public static BufferedImage getSystemParteTrasNear() {
        return SystemParteTrasNear;
    }

    public static BufferedImage getSystemParteTrasDistant() {
        return SystemParteTrasDistant;
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
	
    public static BufferedImage getMarcador_Tecnologias() {
        return marcador_tecnologias;
    }
    
    static {
        try {
            fundo = ImageIO.read(Resources.getResourceFile("images/fundoPrincipal.gif"));            
            SystemParteTrasNear   = ImageIO.read(Resources.getResourceFile("images/Carta_sistema_parte_de_traz_near.png"));;
            SystemParteTrasDistant   = ImageIO.read(Resources.getResourceFile("images/Carta_sistema_parte_de_traz_distant.png"));;
            riqueza = ImageIO.read(Resources.getResourceFile("images/Wealth.png"));
            metal = ImageIO.read(Resources.getResourceFile("images/Metal.png"));
            tecnologiasUpdate = ImageIO.read(Resources.getResourceFile("images/Technology.png"));
            forcaMilitar = ImageIO.read(Resources.getResourceFile("images/Military.png"));
            marcador1 =  ImageIO.read(Resources.getResourceFile("images/marcador2.png"));
            marcador_tecnologias = ImageIO.read(Resources.getResourceFile("images/check.png"));
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
        repaint();   
        
        IStates estado = game.getStates();
        
        anoLabel.setText("Ano: " + game.getCurrentYear());
        turnoLabel.setText("Turno: " + game.getTurno());
        //currentState.setText();
        if(estado instanceof ExplorarAtacar_Conquistar_Passar)
            currentState.setText("Estado Atual: Explorar/Atacar - Conquistar/Passar");
        
        if(estado instanceof ConstruirFM_DescobrirTecnologia){
            currentState.setText("Estado Atual: Aumentar FM e Descobre Tecno");
            AumentarForcaMilitar.setEnabled(true);
        }else{ 
            AumentarForcaMilitar.setEnabled(false);
        }
        if(estado instanceof TrocaEntreRecursos){
            currentState.setText("Estado Atual: Troca de Recursos");
            if(game.getTecnologiasAdquiridas().equals("Interspecies Commerce")){
                trocaRiquezaPorMetal.setEnabled(true);
                trocaMetalPorRiqueza.setEnabled(true);
            }
        }else{
            trocaRiquezaPorMetal.setEnabled(false);
            trocaMetalPorRiqueza.setEnabled(false);
        }
        
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
