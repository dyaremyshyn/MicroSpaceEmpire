/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui_text;


import logicaJogo.Jogo;
import logicaJogo.States.AguardaInicio;
import logicaJogo.States.ConstruirFM_DescobrirTecnologia;
import logicaJogo.States.EscolheNearOuUnalignedSystem;
import logicaJogo.States.EscolheTecnologiaComprar;
import logicaJogo.States.EscolheUnalignedSystem;
import logicaJogo.States.ExplorarAtacar_Conquistar_Passar;
import logicaJogo.States.Fim;
import logicaJogo.States.IStates;
import logicaJogo.States.TrocaEntreRecursos;


import java.util.Scanner;
/**
 *
 * @author Dmytro Yaremyshyn
 */
public class TextUserInterface {
    
    private Jogo jogo;
    private boolean sair = false;

    public TextUserInterface(Jogo jogo) 
    {
        this.jogo = jogo;
    }

    public void iuAguardaInicio() 
    {
        
    }

    public void iuExplorarAtacar_Conquistar_Passar() 
    {
        
    }

    public void iuEscolheNearOuUnalignedSystem() 
    {
       
    }
    
    public void iuEscolheUnalignedSystem() 
    {
       
    }
    
    public void iuTrocaEntreRecursos() 
    {
       
    }
    
    public void iuConstruirFM_DescobrirTecnologia() 
    {
       
    }
    
    public void iuEscolheTecnologiaComprar() 
    {
       
    }

    public void iuFim()
    {
    
    }
    
    public void corre() 
    {
        while (!sair) 
        {
            IStates estado = jogo.getStates();
            
            if (estado instanceof AguardaInicio) 
            {
                iuAguardaInicio();
            } else if (estado instanceof ExplorarAtacar_Conquistar_Passar) 
                {
                    iuExplorarAtacar_Conquistar_Passar();
                } else if (estado instanceof EscolheNearOuUnalignedSystem) 
                    {
                        iuEscolheNearOuUnalignedSystem();
                    }else if (estado instanceof EscolheUnalignedSystem) 
                        {
                            iuEscolheUnalignedSystem();
                        }else if (estado instanceof TrocaEntreRecursos) 
                            {
                                iuTrocaEntreRecursos();
                            }else if (estado instanceof ConstruirFM_DescobrirTecnologia) 
                                {
                                    iuConstruirFM_DescobrirTecnologia();
                                }else if (estado instanceof EscolheTecnologiaComprar) 
                                    {
                                        iuEscolheTecnologiaComprar();
                                    }else if (estado instanceof Fim) 
                                        {
                                            iuFim();
                                        }
        }
    }

    
    
    
    /*
    
        JogoMaqEstados recarregar_jogo() throws IOException, ClassNotFoundException {
        JogoMaqEstados outro = null;
        ObjectInputStream in = null;
        String nomeFicheiro = "jogo_guardado";
        try {
            in = new ObjectInputStream(new FileInputStream(nomeFicheiro));
            outro = (JogoMaqEstados) in.readObject();
            return outro;
        } finally {
            if (in != null) {
                in.close();
            }
        }

    }

    public boolean guardar_partida() 
    {

        ObjectOutputStream out = null;
        String nomeFicheiro = "jogo_guardado";

        try {
            out = new ObjectOutputStream(new FileOutputStream(nomeFicheiro));

            out.writeObject(jogo);

            return true;
        } catch (IOException e) {
            return false;
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
    }
    
    */
    
    
    
    
    
    
}
