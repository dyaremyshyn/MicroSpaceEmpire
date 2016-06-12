/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */

package microspaceempire.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import logicaJogo.ObservableGame;

public class TechnologyUpdatePanel extends JPanel implements Constantes{
     private ObservableGame observableGame;

  public TechnologyUpdatePanel(ObservableGame observableGame)
  {
      
    this.observableGame = observableGame;
    
    setMaximumSize(new Dimension(DIM_X_TECNOLOG_IMG, DIM_Y_TECNOLOG_IMG));
    setPreferredSize(new Dimension(DIM_X_TECNOLOG_IMG, DIM_Y_TECNOLOG_IMG));
    setMinimumSize(new Dimension(DIM_X_TECNOLOG_IMG, DIM_Y_TECNOLOG_IMG));
    
    addMouseListener( new DestaqueListener());
  }

 
  
  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
                   
       g.drawImage(MicroSpaceEmpirePanel.getTecnologiasUpdate(),0, 0, DIM_X_TECNOLOG_IMG, DIM_Y_TECNOLOG_IMG, this);                     
       pinta_marcadores(g);    
  }
    
    public void pinta_marcadores(Graphics g)
    {
      
     
    int x_1= 35;
    int x_2= 285;
    int y_1= 105;
    int y_2= 165;
    int y_3= 225;
    int y_4= 275;
      
           
           
          //pinta mercadores de aquisiçao
        //1 geraçao
        if(observableGame.AdequiriuT_RobotWorkers())
        {         
        
        g.drawImage(MicroSpaceEmpirePanel.getMarcador_Tecnologias(),x_1, y_2, DIM_X_MARCADORTEC, DIM_Y_MARCADORTEC, this);
        }
        if(observableGame.AdequiriuT_InterspeciesComerce())
        {
        g.drawImage(MicroSpaceEmpirePanel.getMarcador_Tecnologias(),x_1, y_4, DIM_X_MARCADORTEC, DIM_Y_MARCADORTEC, this);
        }
        if(observableGame.AdequiriuT_CapitalShips())
        {
        g.drawImage(MicroSpaceEmpirePanel.getMarcador_Tecnologias(),x_1, y_1, DIM_X_MARCADORTEC, DIM_Y_MARCADORTEC, this);
        }
        if(observableGame.AdequiriuT_HyperTelevision())
        {
        g.drawImage(MicroSpaceEmpirePanel.getMarcador_Tecnologias(),x_1, y_3, DIM_X_MARCADORTEC, DIM_Y_MARCADORTEC, this);
        }
        
        //2 geraçao
        if(observableGame.AdequiriuT_ForwardStarbases())
        {
        g.drawImage(MicroSpaceEmpirePanel.getMarcador_Tecnologias(),x_2, y_1, DIM_X_MARCADORTEC, DIM_Y_MARCADORTEC, this);
        } 
        if(observableGame.AdequiriuT_InterstellarBanking())
        {
        g.drawImage(MicroSpaceEmpirePanel.getMarcador_Tecnologias(),x_2, y_4, DIM_X_MARCADORTEC, DIM_Y_MARCADORTEC, this);
        }
        if(observableGame.AdequiriuT_InterstellarDiplomacy())
        {
        g.drawImage(MicroSpaceEmpirePanel.getMarcador_Tecnologias(),x_2, y_3, DIM_X_MARCADORTEC, DIM_Y_MARCADORTEC, this);
        }
        if(observableGame.AdequiriuT_PlanetaryDefenses())
        {
        g.drawImage(MicroSpaceEmpirePanel.getMarcador_Tecnologias(),x_2, y_2, DIM_X_MARCADORTEC, DIM_Y_MARCADORTEC, this);
        }  
    
    }
  
  
    class DestaqueListener extends MouseAdapter 
    {
        @Override
        public void mousePressed( MouseEvent e)
        {
            int x = e.getX(); //get x do mouse
            int y = e.getY(); //get y do mouse
           // System.out.println("x = " + x + "y = " + y);    
            trataclique( x, y);
        }
    }
    
    int trataclique(int x, int y)
    {
        int x_min_1ger=20;
        int x_max_1ger=260;
        
        int x_min_2ger=262;
        int x_max_2ger=482;
        
        int pri_fr_linha_y=98;
        int  pri_la_linha_y= 145;
       
        int seg__fr_linha_y=145;
        int seg__la_linha_y= 211;
        
        int ter_fr_linha_y=212;
        int ter_la_linha_y= 262;
        
        int qua_fr_linha_y=263;
        int qua_la_linha_y= 329;
        
        int alvo = -1;
        
        if ( y < 0 || y > DIM_Y_TECNOLOG_IMG){
            return -1;
        }
        if ( x < 0 || x > DIM_X_TECNOLOG_IMG){
            return -1;
        }
        
        
        //areas das tecnologias da 1 geração
        if((x >  x_min_1ger && x < x_max_1ger) && (y > pri_fr_linha_y && y < pri_la_linha_y) )
        {   
            
            alvo = observableGame.DevolveTecnologiaAlvo(CAPIT);
            observableGame.EscolheDescobrirTecnologia();
            observableGame.Comprar_Tecnologia(alvo);
            observableGame.Cancelar();
        }
        
        if((x >  x_min_1ger && x < x_max_1ger) && (y > seg__fr_linha_y && y < seg__la_linha_y) )
        {          
            alvo = observableGame.DevolveTecnologiaAlvo(ROBOT);
            observableGame.EscolheDescobrirTecnologia();
            observableGame.Comprar_Tecnologia(alvo);
            observableGame.Cancelar();
        }
        
        if((x >  x_min_1ger && x < x_max_1ger) && (y > ter_fr_linha_y && y < ter_la_linha_y) )
        {          
            alvo = observableGame.DevolveTecnologiaAlvo(HYPER);
            observableGame.EscolheDescobrirTecnologia();
            observableGame.Comprar_Tecnologia(alvo);
            observableGame.Cancelar();
        }
        
        if((x >  x_min_1ger && x < x_max_1ger) && (y > qua_fr_linha_y && y < qua_la_linha_y) )
        {          
            alvo = observableGame.DevolveTecnologiaAlvo(INTERSPE);
            observableGame.EscolheDescobrirTecnologia();
            observableGame.Comprar_Tecnologia(alvo);
            observableGame.Cancelar();
        }
        
        //areas das tecnologias da 2 geração
        if((x >  x_min_2ger && x < x_max_2ger) && (y > pri_fr_linha_y && y < pri_la_linha_y) )
        {          
            alvo = observableGame.DevolveTecnologiaAlvo(FORWARD);
            observableGame.EscolheDescobrirTecnologia();
            observableGame.Comprar_Tecnologia(alvo);
            observableGame.Cancelar();
        }
        
        if((x >  x_min_2ger && x < x_max_2ger) && (y > seg__fr_linha_y && y < seg__la_linha_y) )
        {          
            alvo = observableGame.DevolveTecnologiaAlvo(PLANETARY);
            observableGame.EscolheDescobrirTecnologia();
            observableGame.Comprar_Tecnologia(alvo);
            observableGame.Cancelar();
        }
        
        if((x >  x_min_2ger && x < x_max_2ger) && (y > ter_fr_linha_y && y < ter_la_linha_y) )
        {          
            alvo = observableGame.DevolveTecnologiaAlvo(INTERDIPLO);
            observableGame.EscolheDescobrirTecnologia();
            observableGame.Comprar_Tecnologia(alvo);
            observableGame.Cancelar();
        }
        
        if((x >  x_min_2ger && x < x_max_2ger) && (y > qua_fr_linha_y && y < qua_la_linha_y) )
        {          
            alvo = observableGame.DevolveTecnologiaAlvo(INTERBANK);
            observableGame.EscolheDescobrirTecnologia();
            observableGame.Comprar_Tecnologia(alvo);
            observableGame.Cancelar();
        }
        

        //System.out.println("o alvo foi "+ alvo);

        return -1;
    }    
}
