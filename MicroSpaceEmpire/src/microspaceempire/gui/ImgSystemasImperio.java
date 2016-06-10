
package microspaceempire.gui;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import logicaJogo.ObservableGame;



public class ImgSystemasImperio  extends JPanel implements Constantes {

    ObservableGame game;
    private final String nomeSystema;
    static private Image imagemSystem = null;
   

   public ImgSystemasImperio(ObservableGame game,String nome) {
        this.game = game;
        this.nomeSystema = nome;
       
    }
    
    
    @Override
    public void paintComponent( Graphics g)
    {
        super.paintComponent( g);
        int i=0;
                imagemSystem = MicroSpaceEmpirePanel.getSystemImg(nomeSystema);
        
        if(imagemSystem!=null){
            g.drawImage(imagemSystem,0, DIM_X_CARTA, DIM_X_CARTA, DIM_Y_CARTA, this);
         
    }else{ System.err.println(" imagem == null");}
    }
}
