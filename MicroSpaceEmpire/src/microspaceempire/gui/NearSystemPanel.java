/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */
package microspaceempire.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import logicaJogo.ObservableGame;
import logicaJogo.States.ExplorarAtacar_Conquistar_Passar;


public class NearSystemPanel extends JPanel implements Constantes
{
    private ObservableGame observableGame;
    private final Border tracejado = BorderFactory.createDashedBorder(Color.red, 2.0f, 3.0f,1.0f, true);
    
    public NearSystemPanel(ObservableGame observableGame)
    {
      this.observableGame = observableGame;
      
      setTamanho();
      addMouseListener( new DestaqueListener());
    }

    public final void setTamanho(){
    setMaximumSize(new Dimension(DIM_X_CARTA, DIM_Y_CARTA));
    setPreferredSize(new Dimension(DIM_X_CARTA, DIM_Y_CARTA));
    setMinimumSize(new Dimension(DIM_X_CARTA, DIM_Y_CARTA)); 
    setBackground(new Color(0,0,0,0));
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(observableGame.VerificaSeHaSistemasNear())
        {
        g.drawImage(MicroSpaceEmpirePanel.getSystemParteTrasNear(), 0, 0, DIM_X_CARTA, DIM_Y_CARTA, this);  
        }else{
            setBorder(tracejado);
             setBackground(new Color(0,0,0,0));
        }
    }

    class DestaqueListener extends MouseAdapter 
    {
        @Override
        public void mousePressed( MouseEvent e)
        {
            if(observableGame.getStates() instanceof ExplorarAtacar_Conquistar_Passar && observableGame.VerificaSeHaSistemasNear())
            {
             //System.out.println("carreguei para explorar sistema near!");
             NearSystemPanel.this.observableGame.EscolheExplorar_atacar(); //escolhe atacar           
             NearSystemPanel.this.observableGame.Explorar_atacar(1); // tipo 1 é near
            }
        }
    }

}
