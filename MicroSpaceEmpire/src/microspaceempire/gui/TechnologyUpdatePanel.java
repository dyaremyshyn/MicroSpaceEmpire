
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
    
    setMaximumSize(new Dimension(DIM_X_TecnologImg, DIM_Y_TecnologImg));
    setPreferredSize(new Dimension(DIM_X_TecnologImg, DIM_Y_TecnologImg));
    setMinimumSize(new Dimension(DIM_X_TecnologImg, DIM_Y_TecnologImg));
    
    addMouseListener( new DestaqueListener());
  }

 
  
  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
                
     
       g.drawImage(MicroSpaceEmpirePanel.getTecnologiasUpdate(),0, 0, DIM_X_TecnologImg, DIM_Y_TecnologImg, this);                     
    
  }
    
    class DestaqueListener extends MouseAdapter 
    {
        @Override
        public void mousePressed( MouseEvent e)
        {
            int x = e.getX(); //get x do mouse
            int y = e.getY(); //get y do mouse

            System.out.println("x = " + x + "y = " + y);
     
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
        
        if ( y < 0 || y > DIM_Y_TecnologImg){
            return -1;
        }
        if ( x < 0 || x > DIM_X_TecnologImg){
            return -1;
        }
        
        
        //areas das tecnologias da 1 geração
        if((x >  x_min_1ger && x < x_max_1ger) && (y > pri_fr_linha_y && y < pri_la_linha_y) )
        {   
            
            alvo = observableGame.DevolveTecnologiaAlvo(CAPIT);
            observableGame.EscolheDescobrirTecnologia();
            observableGame.Comprar_Tecnologia(alvo);
        }
        
        if((x >  x_min_1ger && x < x_max_1ger) && (y > seg__fr_linha_y && y < seg__la_linha_y) )
        {          
            alvo = observableGame.DevolveTecnologiaAlvo(ROBOT);
            observableGame.EscolheDescobrirTecnologia();
            observableGame.Comprar_Tecnologia(alvo);
        }
        
        if((x >  x_min_1ger && x < x_max_1ger) && (y > ter_fr_linha_y && y < ter_la_linha_y) )
        {          
            alvo = observableGame.DevolveTecnologiaAlvo(HYPER);
            observableGame.EscolheDescobrirTecnologia();
            observableGame.Comprar_Tecnologia(alvo);
        }
        
        if((x >  x_min_1ger && x < x_max_1ger) && (y > qua_fr_linha_y && y < qua_la_linha_y) )
        {          
            alvo = observableGame.DevolveTecnologiaAlvo(INTERSPE);
            observableGame.EscolheDescobrirTecnologia();
            observableGame.Comprar_Tecnologia(alvo);
        }
        
        //areas das tecnologias da 2 geração
        if((x >  x_min_2ger && x < x_max_2ger) && (y > pri_fr_linha_y && y < pri_la_linha_y) )
        {          
            alvo = observableGame.DevolveTecnologiaAlvo(FORWARD);
            observableGame.EscolheDescobrirTecnologia();
            observableGame.Comprar_Tecnologia(alvo);
        }
        
        if((x >  x_min_2ger && x < x_max_2ger) && (y > seg__fr_linha_y && y < seg__la_linha_y) )
        {          
            alvo = observableGame.DevolveTecnologiaAlvo(PLANETARY);
            observableGame.EscolheDescobrirTecnologia();
            observableGame.Comprar_Tecnologia(alvo);
        }
        
        if((x >  x_min_2ger && x < x_max_2ger) && (y > ter_fr_linha_y && y < ter_la_linha_y) )
        {          
            alvo = observableGame.DevolveTecnologiaAlvo(INTERDIPLO);
            observableGame.EscolheDescobrirTecnologia();
            observableGame.Comprar_Tecnologia(alvo);
        }
        
        if((x >  x_min_2ger && x < x_max_2ger) && (y > qua_fr_linha_y && y < qua_la_linha_y) )
        {          
            alvo = observableGame.DevolveTecnologiaAlvo(INTERBANK);
            observableGame.EscolheDescobrirTecnologia();
            observableGame.Comprar_Tecnologia(alvo);
        }
        
//        if(alvo == (-1)){
//        observableGame.Cancelar();
//         System.out.println("cancelei "+ alvo);   
//        }
        System.out.println("o alvo foi "+ alvo);
        
        
        
        return -1;
    }    
}
