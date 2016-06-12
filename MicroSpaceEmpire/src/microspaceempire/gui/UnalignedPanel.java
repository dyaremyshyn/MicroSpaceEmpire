/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */
package microspaceempire.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JPanel;
import logicaJogo.Cartas.Carta;
import logicaJogo.ObservableGame;
import logicaJogo.States.ExplorarAtacar_Conquistar_Passar;




public class UnalignedPanel extends JPanel implements Constantes {
 
    private ObservableGame observableGame;
    List<Carta> porConquistar;
    
    UnalignedPanel(ObservableGame game) 
    {        
        this.observableGame = game;

        setMaximumSize(new Dimension(DIM_X_CARTA*11, DIM_Y_CARTA));
        setPreferredSize(new Dimension(DIM_X_CARTA*11, DIM_Y_CARTA));
        setMinimumSize(new Dimension(DIM_X_CARTA*11, DIM_Y_CARTA));
        setBackground(new Color(0,0,0,0));

        addMouseListener( new UnalignedPanel.DestaqueListener());
    }
    
    @Override
    public void paintComponent( Graphics g)
    {
     super.paintComponent( g); 

     int x,y;
        
        super.paintComponent( g);

         porConquistar = this.observableGame.getPorConquistar();
         setLayout(new GridLayout(1,porConquistar.size(),0,0));
         
         x = 0; y = 0;
        
         for (int i = 0 ; i < porConquistar.size() ; i++)
         {
                      
            String nome = porConquistar.get(i).getNome();

            g.fillRect(x, y, DIM_X_CARTA, DIM_Y_CARTA);
            Image imagem = MicroSpaceEmpirePanel.getSystemImg(nome);
            
            if (imagem != null)
            {
                g.drawImage( imagem, x , y ,DIM_X_CARTA, DIM_Y_CARTA, this );
            }else{
                System.err.println(" imagem == null");
            }
                         
            x += DIM_X_CARTA;
         }    
       
    }    
    
    
    
    class DestaqueListener extends MouseAdapter 
    {
        @Override
        public void mousePressed( MouseEvent e)
        {
             int i= 0;
       
             int x = e.getX(); //get x do mouse
             int y = e.getY();

             if(!(x > porConquistar.size()*DIM_X_CARTA) && x != 0)
             {
             i = qualFigura(x, y);
             
                if(i != -1)
                {
                       if(observableGame.getStates() instanceof ExplorarAtacar_Conquistar_Passar && observableGame.VerificaSeHaSistemasPorConquistar())
                       {
                       System.out.println("carreguei para conquistar! e foi a " + i + " carta");
                       UnalignedPanel.this.observableGame.EscolheConquistar();
                       UnalignedPanel.this.observableGame.Conquistar(i);
                       }
                }
             }
            
        }
    }
    
    
    int qualFigura(int x, int y)
    {
        int qual;
        
        if ( y < 0 || y > DIM_Y_CARTA){
            return -1;
        }
        
        qual = x/DIM_X_CARTA;
        
        if (qual >= 0 
                && qual < observableGame.getPorConquistar().size() 
                && qual < getWidth()/DIM_X_CARTA){
            return qual;
        }
        return -1;
    }    
}
