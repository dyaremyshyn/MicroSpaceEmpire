
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
    System.out.println("\n\n\n=== AGUARDA INICIO ===\n");
              
        while (true) 
        {
            System.out.println("\n0 - Comecar jogo\n1 - Recarregar jogo\n2 - Sair");
            System.out.print("\n--> ");
            
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
    System.out.print("\n\nHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");                   
    System.out.println("\n\n\n=== Explorar-Atacar/Conquistar ===\n");
        
      
        while (true) 
        {   System.out.println(jogo.Painel_jogo());
            System.out.println(         "\n0 - Explorar-Atacar " + (jogo.getBloqueio_compraDireta() == 1? "(100% sucesso)":"") 
                               + "\n1 - Conquistar " + (jogo.getBloqueio_compraDireta() == 1? "(100% sucesso)":"") 
                               + "\n2 - Passar\n3 - Guardar\n4 - Terminar");
            
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
    System.out.print("\n\nHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");  
    System.out.println("\n\n\n=== Escolher entre Near ou Unaligned  ===\n");
        
        while (true) 
        {
            System.out.println("\n0 - Near " + (jogo.AdequiriuT_ForwardStarbases()?"\n1 - Unaligned System ":"\n? - Unaligned System (deve adquirir Forward Starbases)"));
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
         
            if ((c == '1' && jogo.AdequiriuT_ForwardStarbases())) 
            { 
                System.out.println("*Unaligned*");
                jogo.Explorar_atacar(2);
                return;
            }
        }
    }
    
    public void iuEscolheUnalignedSystem() 
    {
    System.out.print("\n\nHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");  
    System.out.println("\n\n\n=== Escolhe sistema a conquistar  ===\n");
        
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
    System.out.print("\n\nHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");  
    System.out.println("\n\n\n=== Troca entre recursos  ===");
       
       if(jogo.AdequiriuT_InterspeciesComerce())
       {
            while (true) 
            {   
                System.out.println(jogo.Painel_recursos());
                System.out.println("0 - 2 Riqueza por 1 Metal\n1 - 2 Metal por 1 Riqueza\n2 - Passar");
                System.out.print("\nEscolha: ");

                char c = ' ';
                Scanner sc = new Scanner(System.in);
                c = sc.next().charAt(0);

                if ((c == '0')) 
                {
                    System.out.println("*2 Riqueza por 1 Metal*");
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
       }else{
             System.out.println("*Passa*");
             jogo.Passar(); 
            }                      
    }
    
    public void iuConstruirFM_DescobrirTecnologia() 
    {
    System.out.print("\n\nHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");  
    System.out.println("\n\n\n=== Construir Força militar ou comprar tecnologia  ===\n");
        
        while (true) 
        {   
            System.out.println(jogo.Painel_recursos());
            System.out.println(jogo.Painel_forcaMilitar());
            System.out.println("\n0 - Aumentar força militar ( Custos: Metal: 1 e Riqueza: 1 )\n1 - Descobrir tecnologia \n2 - Passar");
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
    System.out.print("\n\nHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");  
    System.out.println("\n\n\n=== Escolhe tecnologia  ===\n");
        
       while (true) 
        {   
            System.out.println(jogo.Painel_tecnologiasADescobrir());
            System.out.println("-1 para cancelar");
            System.out.print("\nEscolha: ");
            
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
    System.out.print("\n\nHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");  
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
