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
        System.out.println("\n=== AGUARDA INICIO ===\n");
              
        while (true) 
        {
            System.out.println("\n0 - Comecar jogo\n1 - Recarregar jogo(nao funcional)\n2 - Sair");
            char c = ' ';
            Scanner sc = new Scanner(System.in);
            c = sc.next().charAt(0);
            
            if ((c == '0')) 
            {               
                System.out.println("Comecar jogo");
                jogo.PrepararJogo();
                return;
            }
         
            if ((c == '1')) 
            {
               System.out.println("Recarregar partida");
                try 
                {
                    //JogoMaqEstados outro = recarregar_jogo();
                   // jogo = outro;
                } catch (Exception e) 
                    {
                        System.out.println("ERRO ao ler ficheiro" + e);
                    }
                
                return;
            }
            if ((c == '2'))
            {
                sair = true;
                return;
            }
        }
    }

    public void iuExplorarAtacar_Conquistar_Passar() 
    {
        System.out.println("\n=== Explorar-Atacar/Conquistar ===\n");
        
        while (true) 
        {
            System.out.println("\n0 - Explorar-Atacar(nao funcional)\n1 - Conquistar(nao funcional)\n2 - Passar");
            
            char c = ' ';
            Scanner sc = new Scanner(System.in);
            c = sc.next().charAt(0);
            
            if ((c == '0')) 
            {
                System.out.println("*Explorar-Atacar*");
                jogo.EscolheExplorar_atacar();
                return;
            }
         
            if ((c == '1')) 
            { 
                System.out.println("*Conquistar*");
                jogo.EscolheConquistar();
                return;
            }
            
            if ((c == '2'))
            {
                System.out.println("*Passar*");
                jogo.Passar();
                return;
            }
        }
    }

    public void iuEscolheNearOuUnalignedSystem() 
    {
       System.out.println("\n=== Escolher entre Near ou Unaligned  ===\n");
        
        while (true) 
        {
            System.out.println("\n0 - Near (nao funcional)\n1 - Unaligned System (nao funcional)");
            
            char c = ' ';
            Scanner sc = new Scanner(System.in);
            c = sc.next().charAt(0);
            
            if ((c == '0')) 
            {
                System.out.println("*Explorar-Atacar*");
                jogo.EscolheExplorar_atacar();
                return;
            }
         
            if ((c == '1')) 
            { 
                System.out.println("*Conquistar*");
                jogo.EscolheConquistar();
                return;
            }
            
            if ((c == '2'))
            {
                System.out.println("*Passar*");
                jogo.Passar();
                return;
            }
        }
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
    System.out.println("*Fim*");
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
