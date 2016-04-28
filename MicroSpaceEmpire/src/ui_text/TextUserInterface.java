
package ui_text;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
public class TextUserInterface implements Constantes_UI
{
    
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
            System.out.println("\n0 - Comecar jogo\n1 - Recarregar jogo(nao usar ainda)\n2 - Sair");
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
                    Jogo outro = recarregar_jogo();
                    jogo = outro;
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
            System.out.println("\n0 - Explorar-Atacar(nao funcional)\n1 - Conquistar(nao funcional)\n2 - Passar\n3 - Guardar(nao usar ainda)");
            
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
            
            if (c == '3') 
            {
                System.out.println("*Guardar*");
                
                if (guardar_partida()) 
                {
                    System.out.println("\nJOGO GUARDADO");
                } else
                    {
                        System.out.println("\nJOGO NAO GUARDADO");
                    }
                
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
                System.out.println("*Near*");
                jogo.Explorar_atacar(1);
                return;
            }
         
            if ((c == '1')) 
            { 
                System.out.println("*Unaligned*");
                jogo.Explorar_atacar(2);
                return;
            }
        }
    }
    
    public void iuEscolheUnalignedSystem() 
    {
       
    }
    
    public void iuTrocaEntreRecursos() 
    {
       System.out.println("\n=== Escolher entre Near ou Unaligned  ===\n");
        
        while (true) 
        {
            System.out.println("\n0 - 1 Metal por 2 Riqueza (nao funcional)\n1 - 2 Metal por 1 Riqueza (nao funcional)");
            
            char c = ' ';
            Scanner sc = new Scanner(System.in);
            c = sc.next().charAt(0);
            
            if ((c == '0')) 
            {
                System.out.println("*1 Metal por 2 Riqueza*");
                jogo.Trocar_recursos(1);
                return;
            }
         
            if ((c == '1')) 
            { 
                System.out.println("*2 Metal por 1 Riqueza*");
                jogo.Trocar_recursos(2);
                return;
            }
        }
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
    
    Jogo recarregar_jogo() throws IOException, ClassNotFoundException 
    {      
        Jogo outro = null;
        ObjectInputStream in = null;

        try 
        {
            in = new ObjectInputStream(new FileInputStream(nomeFicheiro));
            outro = (Jogo) in.readObject();
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

        try 
        {
            out = new ObjectOutputStream(new FileOutputStream(nomeFicheiro));
            out.writeObject(jogo);

            return true;
        } catch (IOException e) 
            {
                return false;
            } finally 
                {
                    if (out != null) 
                    {
                        try 
                        {
                            out.close();
                        } catch (IOException e) {}
                    }
                }
    }
    
}
