
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
            System.out.print("\nEscolha: ");
            
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
        {   System.out.println(jogo.Painel_jogo());
            System.out.println("\n0 - Explorar-Atacar(nao funcional)\n1 - Conquistar(nao funcional)\n2 - Passar\n3 - Guardar(nao usar ainda)\n4 - Terminar");
            System.out.print("\nEscolha: ");
            
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
            
            if ((c == '4'))
            {
                System.out.println("*Terminar*");
                jogo.Terminar();
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
            System.out.print("\nEscolha: ");
            
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
      
               System.out.println("\n=== Escolhe sistema a conquistar  ===\n");
        
       while (true) 
        {   
            System.out.println(jogo.Painel_Conquistar());
            
            System.out.print("\nEscolha: ");
            
            int c ;
            Scanner sc = new Scanner(System.in);
            c = sc.nextInt();
            
            jogo.Conquistar(c);  
            
                          
        return;     
        }
    }
    
    public void iuTrocaEntreRecursos() 
    {
       System.out.println("\n=== Troca entre recursos  ===");
       
       
        while (true) 
        {   System.out.println(jogo.Painel_recursos());
            System.out.println("0 - 1 Metal por 2 Riqueza (nao funcional)\n1 - 2 Metal por 1 Riqueza (nao funcional)\n2 - Passar");
            System.out.print("\nEscolha: ");
            
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
            
            if ((c == '2')) 
            { 
                System.out.println("*Passa*");
                jogo.Passar();
                return;
            }
        }
    }
    
    public void iuConstruirFM_DescobrirTecnologia() 
    {
    System.out.println("\n=== Construir Força militar ou comprar tecnologia  ===\n");
        
        while (true) 
        {
            System.out.println("\n0 - Aumentar força militar ( 1 de metal e 1 de riqueza )\n1 - Descobrir tecnologia \n2 - Passar");
            System.out.print("\nEscolha: ");
            
            char c = ' ';
            Scanner sc = new Scanner(System.in);
            c = sc.next().charAt(0);
            
            if ((c == '0')) 
            {
                System.out.println("*Aumentar força militar*");
                jogo.Aumentar_Força_Militar();
                return;
            }
         
            if ((c == '1')) 
            { 
                System.out.println("*Descobrir tecnologia*");
                jogo.EscolheDescobrirTecnologia();
                return;
            }
            
            if ((c == '2')) 
            { 
                System.out.println("*Passa*");
                jogo.Passar();
                return;
            }
        }
    }
    
    public void iuEscolheTecnologiaComprar() 
    {
        System.out.println("\n=== Escolhe tecnologia  ===\n");
        
       while (true) 
        {   
            System.out.println(jogo.Painel_tecnologiasADescobrir());
            System.out.println("\nEscolha uma tecnologia ou -1 para cancelar: ");
            
            int c ;
            Scanner sc = new Scanner(System.in);
            c = sc.nextInt();
            
            if(c == -1)
            {
            jogo.Cancelar();
            }else{jogo.Comprar_Tecnologia(c);}
            
                          
        return;     
        }
    }

    public void iuFim()
    {
    System.out.println("*Fim*");
     while (true) 
        {
            System.out.println(jogo.Painel_final());
            System.out.println("0 - Recomeçar \n1 - Sair do jogo");
            System.out.print("\nEscolha: ");
            
            char c = ' ';
            Scanner sc = new Scanner(System.in);
            c = sc.next().charAt(0);
            
            if ((c == '0')) 
            {                              
                TextUserInterface iuTexto = new TextUserInterface(new Jogo());
                iuTexto.corre();
            }
         
            if ((c == '1')) 
            { 
               sair = true;
               return;
            }                     
        }    
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
