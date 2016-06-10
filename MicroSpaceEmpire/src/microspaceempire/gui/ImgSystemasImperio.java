
package microspaceempire.gui;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;



public class ImgSystemasImperio  extends JPanel implements Constantes {

  
    private final String nomeSystema;
    static private Image imagemSystem = null;
   

   public ImgSystemasImperio(String nome) {
        
        this.nomeSystema = nome;
       
    }
    
    
    @Override
    public void paintComponent( Graphics g)
    {
        super.paintComponent( g);
        
                imagemSystem = MicroSpaceEmpirePanel.getSystemImg(nomeSystema);
        
        if(imagemSystem!=null){
            g.drawImage(imagemSystem,0, 0, DIM_X_CARTA, DIM_Y_CARTA, this);
    }
    }
}
