/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microspaceempire.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import logicaJogo.Cartas.Carta;
import logicaJogo.Eventos.Evento;
import logicaJogo.ObservableGame;
import logicaJogo.States.ExplorarAtacar_Conquistar_Passar;
import static microspaceempire.gui.Constantes.DIM_X_CARTA;
import static microspaceempire.gui.Constantes.DIM_Y_CARTA;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class EventPanel extends JPanel implements Constantes{
    private ObservableGame observableGame;
    private Border tracejado = BorderFactory.createDashedBorder(Color.red, 2.0f, 3.0f,1.0f, true);
    
    public EventPanel(ObservableGame observableGame)
    {
      this.observableGame = observableGame;

      setBackground(new Color(0,0,0,0));
      setMaximumSize(new Dimension(DIM_X_CARTA, DIM_Y_CARTA));
      setPreferredSize(new Dimension(DIM_X_CARTA, DIM_Y_CARTA));
      setMinimumSize(new Dimension(DIM_X_CARTA, DIM_Y_CARTA));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        int x=0,y=0;
        super.paintComponent(g);

        Evento eventoAtual = observableGame.getCurrentEvento();
       
        String nome = eventoAtual.getNome();

            g.fillRect(x, y, DIM_X_CARTA, DIM_Y_CARTA);
            Image imagem = MicroSpaceEmpirePanel.getEventImg(nome);
            
            if (imagem != null){
                g.drawImage( imagem, x , y ,DIM_X_CARTA, DIM_Y_CARTA, this );
            }else{
                System.err.println(" imagem == null");
            }
            
    
    }

}
