
package logicaJogo;

import logicaJogo.Cartas.Carta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import logicaJogo.Cartas.*;
import logicaJogo.Eventos.Evento;
import logicaJogo.Tecnologias.CapitalShips;
import logicaJogo.Tecnologias.ForwardStarbases;
import logicaJogo.Tecnologias.HyperTelevision;
import logicaJogo.Tecnologias.InterspeciesCommerce;
import logicaJogo.Tecnologias.InterstellarBanking;
import logicaJogo.Tecnologias.InterstellarDiplomacy;
import logicaJogo.Tecnologias.PlanetaryDefenses;
import logicaJogo.Tecnologias.RobotWorkers;
import logicaJogo.Tecnologias.Tecnologia;


public class JogoDados implements Serializable {
    private List<Carta> nearSystem;
    private List<Carta> distantSystem;
    private List<Carta> imperio;
    private List<Carta> porConquistar;
    private int pontuacao;
    private int metal;
    private int riqueza;
    private int forcaMilitar;
    private int producaoMetal;
    private int producaoRiq;
    private int turno;
    private Dado dado;
    private int currentYear;
    private List<Evento> eventos;
    private Evento currentEvento;
    private int limiteForcaMilitar;
    private int limiteRecursos;
    private List<Tecnologia> tecnologias;
    private List<Tecnologia> tecnologiasAdquiridas;
    
    
    //variaveis de bloqueio;
    private int bloqueio_DTecnologia;
    private int bloqueio_AFmilitar;
    
    JogoDados(){
       imperio = new ArrayList<>();
       nearSystem = new ArrayList<>();
       distantSystem = new ArrayList<>();
       porConquistar = new ArrayList<>();
       tecnologias = new ArrayList<>();  
       tecnologiasAdquiridas = new ArrayList<>();
       eventos = new ArrayList<>();
       
       pontuacao=0;
       turno = 0;
       metal=10;
       riqueza=10;
       forcaMilitar=0;
       producaoMetal=0;
       producaoRiq=0;
       currentYear=1;
       limiteForcaMilitar = 3;
       limiteRecursos = 3;
    }

    public boolean iniciar(){
       imperio.add(new HomeWorld());
     
       iniciaNearSystem();
       iniciaDistantSystem();
       iniciaTecnologia();
       
       atualizaRecursos();
       
       zeraVariaveisDeVerificação();
       
       return true;
    }
    
    
    public boolean viraCartaNearSystem(){
        if(!nearSystem.isEmpty()){
            Dado d=new Dado();
            if(nearSystem.get(0).getResistencia() < (d.LancaDado()+forcaMilitar)){  //se a resistencia do sistema for menor que a força militar + o lançar do dado
                imperio.add(nearSystem.get(0));                                     //significa que conquistamos esse sistema e vai pertencer ao nosso imperio
                nearSystem.remove(0);
                return true;
            }
            else{
                porConquistar.add(nearSystem.get(0));                               //senão vai para o grupo de sistemas que já exploramos mas não conquistamos
                nearSystem.remove(0);                                                   //remove do baralho a carta explorada 
                return false;
            }
        }
        return false;
    }
    
     public boolean viraCartaUnalignedSystem(){
        if(!distantSystem.isEmpty()){
            Dado d=new Dado();
            if(distantSystem.get(0).getResistencia() < (d.LancaDado()+forcaMilitar)){  //se a resistencia do sistema for menor que a força militar + o lançar do dado
                imperio.add(distantSystem.get(0));                                     //significa que conquistamos esse sistema e vai pertencer ao nosso imperio
                distantSystem.remove(0);
                return true;
            }
            else{
                porConquistar.add(distantSystem.get(0));                               //senão vai para o grupo de sistemas que já exploramos mas não conquistamos
                distantSystem.remove(0);                                                   //remove do baralho a carta explorada 
                return false;
            }
        }
        return false;
    }
     
     public boolean conquistaSistema(int alvo){
        if(!porConquistar.isEmpty()){ 
            if(porConquistar.size()>=alvo){
                Dado d= new Dado();
                if(porConquistar.get(alvo).getResistencia() < (d.LancaDado()+forcaMilitar)){  //se a resistencia do sistema for menor que a força militar + o lançar do dado
                    imperio.add(porConquistar.get(0));                                     //significa que conquistamos esse sistema e vai pertencer ao nosso imperio
                    porConquistar.remove(0);
                    return true;
                }
            }
            else return false;
        }
        return false;
     }
    
    public void atualizaRecursos()
    {
        for(int i=0;i<imperio.size();i++)
        {  
            setProducaoRiq(getProducaoRiq() + imperio.get(i).getRiqueza());
            setProducaoMetal(getProducaoMetal() + imperio.get(i).getMetal());         
        }
        
    }
    
    public void getLimiteArmazem(){
        for(int i=0;i<tecnologiasAdquiridas.size();i++)
            if(tecnologiasAdquiridas.get(i).getNome().equals("Interstellar Banking"))
                setLimiteRecursos(Constantes.LIM_C_TEC);
        
        setLimiteRecursos(Constantes.LIM_S_TEC);
                
    }
    
    public void recolheRecursos(){
        if(limiteRecursos > getMetal())
            setMetal(getMetal()+producaoMetal);
        else if(limiteRecursos > getRiqueza()){
            setRiqueza(getRiqueza()+producaoRiq);
        }
    }
    
    public boolean verificaPorConquistar(){
        if(porConquistar.isEmpty())
            return false;
        else return true;
    }
    
    
    public void iniciaTecnologia(){
        tecnologias.add(new InterspeciesCommerce());
        tecnologias.add(new CapitalShips());
        tecnologias.add(new RobotWorkers());
        tecnologias.add(new HyperTelevision());
        tecnologias.add(new ForwardStarbases());        
        tecnologias.add(new PlanetaryDefenses());        
        tecnologias.add(new InterstellarDiplomacy());        
        tecnologias.add(new InterstellarBanking());
    }
    
    public boolean aplicaEventoAleatorio(){
        if(!eventos.isEmpty()){
            Evento e;
            int i= (int)(Math.random()*eventos.size()) + 0;
            e = eventos.get(i);
            eventos.remove(i);
            if(currentYear==1)
                e.year1();
            else e.year2();
            
            return true;
        }
        return false;
    }
    
    public void adicionaTecnologiaAdquirida(Tecnologia t){
        tecnologiasAdquiridas.add(t);
    }
    
    public void iniciaNearSystem() {
        nearSystem.add(new Wolf359());
        nearSystem.add(new Proxima());
        nearSystem.add(new EpsilonEridani());
        nearSystem.add(new Cygnus());
        nearSystem.add(new TauCeti());
        nearSystem.add(new Procyon());
        nearSystem.add(new Sirius());
        
        Collections.shuffle(nearSystem);
    }

    public void iniciaDistantSystem() {
        distantSystem.add(new Canopus());
        distantSystem.add(new Polaris());
        distantSystem.add(new GalaxysEdge());
        
        Collections.shuffle(distantSystem);
    }

    public int getTurno() {
        return turno;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public Evento getCurrentEvento() {
        return currentEvento;
    }

    public Dado getDado() {
        return dado;
    }
    
    public int getPontuacao() {
        return pontuacao;
    }

    public int getMetal() {
        return metal;
    }

    public int getRiqueza() {
        return riqueza;
    }

    public int getForcaMilitar() {
        return forcaMilitar;
    }
    
    public int getProducaoMetal() {
        return producaoMetal;
    }

    public int getProducaoRiq() {
        return producaoRiq;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public void setCurrentEvento(Evento currentEvento) {
        this.currentEvento = currentEvento;
    }
 
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public void setMetal(int metal) {
        this.metal = metal;
    }

    public void setRiqueza(int riqueza) {
        this.riqueza = riqueza;
    }

    public void setForcaMilitar(int forcaMilitar) {
        this.forcaMilitar = forcaMilitar;
    }
    
    public void setImperio(Carta e) {
        imperio.add(e);
    }

    public void setPorConquistar(Carta e) {
        porConquistar.add(e);
    }
    
    public void setProducaoMetal(int producaoMetal) {
        this.producaoMetal = producaoMetal;
    }

    public void setProducaoRiq(int producaoRiq) {
        this.producaoRiq = producaoRiq;
    }

    public void setDado(Dado dado) {
        this.dado = dado;
    }

    public int getBloqueio_DTecnologia() {
        return bloqueio_DTecnologia;
    }

    public int getBloqueio_AFmilitar() {
        return bloqueio_AFmilitar;
    }

    public void setBloqueio_DTecnologia(int bloqueio_DTecnologia) {
        this.bloqueio_DTecnologia = bloqueio_DTecnologia;
    }

    public void setBloqueio_AFmilitar(int bloqueio_AFmilitar) {
        this.bloqueio_AFmilitar = bloqueio_AFmilitar;
    }

    public int getLimiteForcaMilitar() {
        return limiteForcaMilitar;
    }

    public void setLimiteForcaMilitar(int limiteForcaMilitar) {
        this.limiteForcaMilitar = limiteForcaMilitar;
    }

    public void setLimiteRecursos(int limiteRecursos) {
        this.limiteRecursos = limiteRecursos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.tecnologiasAdquiridas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if(!(obj instanceof Tecnologia))
            return false;
        return true;
    }
   
    
    
    
    
    //funções 
    
    public boolean TrocaMetalPorRiqueza()
    {
     return true;
    }

    public boolean TrocaRiquezaPorMetal()
    {
     return true;
    }

    public boolean aumenta_FMilitar()
    {
        if(!(forcaMilitar == limiteForcaMilitar)) //caso ja tenha a força militar ao maximo (nao faz nada)
        {       
           if(metal >= 1 &&  riqueza >= 1)//caso se verifique é possivel a compra
           {
           //remove recursos    
           metal-=1;
           riqueza-=1;
           //aumenta força militar
           forcaMilitar+=1;
           
           return true;    
           } 
        }  
        
    return false;
    }

    public boolean DescobrirTecnologia(int x)
    {
        if(x <= tecnologias.size())//caso o numero indicado nao seja indicativo de uma tecnologia , nao fazer nada
        { 
        
            if(riqueza >= tecnologias.get(x).getCusto())
            {
            riqueza-= tecnologias.get(x).getCusto();            
            tecnologiasAdquiridas.add(tecnologias.get(x));
            tecnologias.remove(x);
            return true;
            }
        
        return false;
        }
    return false;
    }

    public void zeraVariaveisDeVerificação()
    {
    bloqueio_DTecnologia = 0;
    bloqueio_AFmilitar = 0;
    }
    
    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::Parte Do FIM
    public int SomaPontosVitoria()
    {
    int pontos = 0;
    
    pontos+=SomaPontosImperio();
    pontos+=SomaPontosTecnologia();
    
    if( ForamViradasTodasCartasSistema()) //saber se foram viradas todas as cartas dos sistemas
        pontos+=1;
    
    if(ForamAdequiridasTodasAsTecnologias()) //saber se tem todas as tecnologias
        pontos+=1;    
    
    if(ForamConquistadasTodasAsCartas()) //11 cartas totais para conquistar
       pontos+=3;
    
    
    return pontos;
    }
    
    public int SomaPontosImperio()
    {
    int pontos = 0;
    
    for(int i=0;i<imperio.size();i++)
    {
        if("Near System".equals(imperio.get(i).getTipoSistema()))
        {
        pontos+=imperio.get(i).getPontosVitoria();
        }
    }
  
    return pontos;
    }
    
    public int SomaPontosTecnologia()
    {
    return tecnologiasAdquiridas.size();
    }
    
    public boolean ForamViradasTodasCartasSistema()
    {
    return nearSystem.isEmpty() && distantSystem.isEmpty();
    }
    
    public boolean ForamAdequiridasTodasAsTecnologias()
    {
    return tecnologias.isEmpty();
    }
    
    public boolean ForamConquistadasTodasAsCartas()
    {
    return (imperio.size() == 11);
    }
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    
    public String CriaDados_Imperio()
    {
    String estrutura = "";
    
        for(int i= 0;i< imperio.size();i++)
        {
        estrutura+= imperio.get(i);
        }
        
    return estrutura;
    }
    
    public String CriaDados_TecnologiasAdquiridas()
    {
     String estrutura = "";
    
        for(int i= 0;i< tecnologiasAdquiridas.size();i++)
        {
        estrutura+= tecnologiasAdquiridas.get(i);
        }
        
    return estrutura;    
    }
    
    public String CriaDados_PlanetasPorConquistar()
    {
    String estrutura = "";
    
        for(int i= 0;i < porConquistar.size();i++)
        {
        estrutura+= porConquistar.get(i);
        }
        
    return estrutura;   
    }
    
    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::INTERFACES
    //mostra informações para o utilizador
    public String Painel_tecnologiasADescobrir()
    {
    String estrutura = "";
   
    estrutura+= "\n ===Primeira geração=== \n";        
       for(int i= 0;i< tecnologias.size();i++)
       {             
           if(tecnologias.get(i).getGeracao() == 1)
           estrutura+= i + " " + tecnologias.get(i);
       }
       
    estrutura+= "\n ===Segunda geração=== \n";
       for(int i= 0;i< tecnologias.size();i++)
       {           
           if(tecnologias.get(i).getGeracao() == 2)
           estrutura+= i + " " + tecnologias.get(i);
       }

    return estrutura;
    }
    
    public String Painel_recursos()
    {
    String estrutura = "";
    estrutura+=   "\n--------------------------------------------------------------"
                + "\n riqueza: " + riqueza               
                + "\n metal: " + metal
                + "\n--------------------------------------------------------------"
                + "\n";
    
    return estrutura;
    }
    
    public String Painel_recurso_riqueza()
    {
    String estrutura = "";
    estrutura+=   "\n--------------------------------------------------------------"
                + "\n riqueza: " + riqueza                             
                + "\n--------------------------------------------------------------"
                + "\n";
    
    return estrutura;
    }
    
    public String Painel_Conquistar()
    {
    String estrutura = "";
    
        for(int i= 0;i < porConquistar.size();i++)
        {
        estrutura+= i + " " +porConquistar.get(i);
        }
        
    return estrutura;  
    }
    
    public String Painel_final()
    {
    String estrutura = "";
    estrutura+=   "\n--------------------------------------------------------------"                
                + "\n Imperio: " + SomaPontosImperio()
                + "\n Tecnologias: " + SomaPontosTecnologia()
                + (ForamAdequiridasTodasAsTecnologias()? " \n (bónus científico)":"")
                + (ForamViradasTodasCartasSistema()? " \n (bónus de exploração)":"")
                + (ForamConquistadasTodasAsCartas()? " \n (bónus de exploração)":"")
                + "\n--------------------------------------------------------------"
                + "\n PONTUAÇÂO TOTAL: " + SomaPontosVitoria()
                + "\n--------------------------------------------------------------"
                + "\n";
    
    return estrutura;
    }
    
    public String Painel_jogo() 
    {
        return  "=== SISTEMA ===\n" 
                + "Planetas por conquistar: \n"
                + CriaDados_PlanetasPorConquistar()
                + "\n******************************************************************"
                + "\n=== PAINEL DE INFORMAÇÔES ===\n" 
                + "\n Ano:" + currentYear
                + "\n Turno: " + turno
                + "\n Evento actual: " + currentEvento               
                + "\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"
                + "\n imperio: \n" + CriaDados_Imperio() 
                + "\n forcaMilitar=" + forcaMilitar
                + "\n--------------------------------------------------------------"
                + "\n riqueza: " + riqueza               
                + "\n metal: " + metal
                + "\n--------------------------------------------------------------"
                + "\n producao de metal: " + producaoMetal 
                + "\n producao de riquesa: " + producaoRiq              
                + "\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"                               
                + "\n Tecnologias adquiridas: "  + CriaDados_TecnologiasAdquiridas()
                + "\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::";
    } 
}