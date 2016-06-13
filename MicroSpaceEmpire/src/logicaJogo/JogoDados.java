/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo;

import logicaJogo.Cartas.Carta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import logicaJogo.Cartas.*;
import logicaJogo.Eventos.*;
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
    

    public List<Carta> getNearSystem() {
        return nearSystem;
    }

    public List<Carta> getDistantSystem() {
        return distantSystem;
    }

    public List<Carta> getImperio() {
        return imperio;
    }

    public List<Carta> getPorConquistar() {
        return porConquistar;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public int getLimiteRecursos() {
        return limiteRecursos;
    }

    public List<Tecnologia> getTecnologias() {
        return tecnologias;
    }

    public List<Tecnologia> getTecnologiasAdquiridas() {
        return tecnologiasAdquiridas;
    }
    
    private List<Carta> nearSystem;
    private List<Carta> distantSystem;
    private List<Carta> imperio;
    private List<Carta> porConquistar;
    private int pontuacao;
    private int metal;
    private final int limiteProducao;
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
    //constroir unidade / descobrir tecnologia
    private int bloqueio_DTecnologia; 
    private int bloqueio_AFmilitar;
    //para o efeito da tecnologia intersterllar diplomacy
    private int bloqueio_compraDireta;
    
    JogoDados(){
       imperio = new ArrayList<>();
       nearSystem = new ArrayList<>();
       distantSystem = new ArrayList<>();
       porConquistar = new ArrayList<>();
       tecnologias = new ArrayList<>();  
       tecnologiasAdquiridas = new ArrayList<>();
       eventos = new ArrayList<>();
       
       pontuacao=0;
       turno = 1;
       metal=0;
       riqueza=0;
       limiteProducao = 5;
       forcaMilitar=0;
       producaoMetal=0;
       producaoRiq=0;
       currentYear=1;
       limiteForcaMilitar = 3;
       limiteRecursos = 3;
       
       bloqueio_compraDireta = 0;
       bloqueio_AFmilitar = 0;
       bloqueio_DTecnologia = 0;
       
       iniciar();
       
    }

    private boolean iniciar(){
       imperio.add(new HomeWorld());   
       iniciaNearSystem();
       iniciaDistantSystem();
       iniciaTecnologia();
       iniciaEventos();
       
       //aplicaEventoAleatorio();
       eventos.remove(0);
       
       
       atualizaProducaoRecursos();
       
       zeraVariaveisDeVerificação();
       
       return true;
    }
    
    public void iniciaEventos(){
        eventos.add(new Asteroid());
        eventos.add(new DerelictShip());
        eventos.add(new LargeInvasionForce());
        eventos.add(new PeaceQuiet());
        eventos.add(new Revolt());
        eventos.add(new Revolt2());
        eventos.add(new SmallInvasionForce());
        eventos.add(new Strike());
        
        Collections.shuffle(eventos);
    }
    
    public void avancaTurno()
    {
    turno+=1;
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
    
    public void aplicaEventoAleatorio()
    {
        if(currentYear==1)
        {
            eventos.get(0).year1(this);
        }
        else {
             eventos.get(0).year2(this);
             }
        
        currentEvento = eventos.get(0);
        eventos.remove(0);
    }
    
    public int lancaDado(){
        Dado d=new Dado();
        return d.LancaDado();
    }
    
    public void retiraSistemaImperio(Carta c){
        for(int i=0;i<imperio.size();i++)
            if(imperio.get(i).getNome().equals(c.getNome())){
                porConquistar.add(imperio.get(i));
                imperio.remove(i);
            }
    }
    
    public boolean verificaRevolta(Evento e){
        if(e.getNome().equals("Revolt")){
            if(currentYear==2){
                if(imperio.size()==1)
                    return true;
            }
            return false;
        }
        return false;
    }
    
    public Carta ultimoSistemaConquistado(){
        return imperio.get(imperio.size()-1);
    }
    
    public Carta escolheSistemaDoImperio(){
        if(imperio.size()>1){
            Carta c = imperio.get(1);
            for(int i=2;i<imperio.size();i++){
                if(c.getResistencia()>=imperio.get(i).getResistencia()){
                    if(c.getResistencia()==imperio.get(i).getResistencia()){
                        if(((int)(Math.random()*99)+1)>50)
                            c=imperio.get(i);
                    }
                    else
                        c=imperio.get(i);
                }
            }
            return c;
        }
        return null;
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

    public int getBloqueio_compraDireta() {
        return bloqueio_compraDireta;
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

    public void setBloqueio_compraDireta(int bloqueio_compraDireta) {
        this.bloqueio_compraDireta = bloqueio_compraDireta;
    }
    
    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getLimiteProducao() {
        return limiteProducao;
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
    public void zeraVariaveisDeVerificação()
    {
    bloqueio_DTecnologia = 0;
    bloqueio_AFmilitar = 0;
    }

    //X2, X3, X4:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::Funções
    
    public boolean viraCartaNearSystem(){
        if(!nearSystem.isEmpty()){
            Dado d=new Dado();
            if( (nearSystem.get(0).getResistencia() < (d.LancaDado()+forcaMilitar)) || bloqueio_compraDireta == 1 ){  //se a resistencia do sistema for menor que a força militar + o lançar do dado
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
    
     public boolean viraCartaDistantSystem(){
        if(!distantSystem.isEmpty()){
            Dado d=new Dado();
            if( (distantSystem.get(0).getResistencia() < (d.LancaDado()+forcaMilitar) ) || bloqueio_compraDireta == 1 ){  //se a resistencia do sistema for menor que a força militar + o lançar do dado
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
     
    public boolean conquistaSistema(int alvo)
    {       
       if(!porConquistar.isEmpty())
       { 
           if(porConquistar.size()>=alvo)
           {
           Dado d= new Dado();
               
               if( (porConquistar.get(alvo).getResistencia() < (d.LancaDado()+forcaMilitar)) || bloqueio_compraDireta == 1 )
               {                                                                        //se a resistencia do sistema for menor que a força militar + o lançar do dado
                imperio.add(porConquistar.get(alvo));                                     //significa que conquistamos esse sistema e vai pertencer ao nosso imperio
                porConquistar.remove(alvo);
                return true;
               }
           }
           else return false;
       }       
       return false;
    }
    
    //X5:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::Funções gerenciar os recursos
    
    public void atualizaProducaoRecursos()
    {
        int r=0,m=0;
        for(int i=0;i<imperio.size();i++)
        {  
            r+=imperio.get(i).getRiqueza();
            m+=imperio.get(i).getMetal();
           
            if(r > limiteProducao )
            {
            r = limiteProducao;
            }
            
            if(m > limiteProducao)
            {
            m = limiteProducao;
            }           
        }
        setProducaoRiq(r);
        setProducaoMetal(m);        
    }
    
    public void recolheRecursos()
    {        
        try{
        
        if("Strike".equals(currentEvento.getNome())) //caso o evento corrente for Greve
        {
            if(AdequiriuT_RobotWorkers()) // caso adquiriu esta tecnologia recebe metade
            {
                if((metal + getProducaoMetal()*0.5) < limiteRecursos){
                    metal = limiteRecursos;
                }else
                {
                setMetal((int) (metal + getProducaoMetal()*0.5)); 
                }

                if((getRiqueza()+ getProducaoRiq()*0.5) < limiteRecursos){
                    setRiqueza(limiteRecursos);
                }else
                {
                setRiqueza((int) (getRiqueza()+getProducaoRiq()*0.5)); 
                }
            }
            
            //se nao adquiriu a tecnologia nao recebe recursos
            
        }else{ //recolhe os recursos completos
            
                if(limiteRecursos > (metal + producaoMetal)) 
                {
                metal += producaoMetal;                    
                }else
                {
                metal = limiteRecursos;
                }

                if(limiteRecursos > (riqueza + producaoRiq))
                {
                riqueza += producaoRiq;
                }else
                {
                riqueza = limiteRecursos;
                }
             }
        }catch (Exception e)
                            {  

                                         if(limiteRecursos > (metal + producaoMetal)) 
                                        {
                                        metal += producaoMetal;                    
                                        }else
                                        {
                                        metal = limiteRecursos;
                                        }

                                        if(limiteRecursos > (riqueza + producaoRiq))
                                        {
                                        riqueza += producaoRiq;
                                        }else
                                        {
                                        riqueza = limiteRecursos;
                                        }    
                            }
        
        //caso preencha para la do limite repoe o recurso no seu maximo pré estabelecido pelo limite de recuros corrente
//        if(getMetal() > limiteRecursos) 
//        {
//            setMetal(limiteRecursos);
//        }
//        if(getRiqueza() > limiteRecursos) 
//        {
//            setRiqueza(limiteRecursos);
//        }*/    
    } 
    
    public boolean TrocaMetalPorRiqueza()
    {     
        if(riqueza < limiteRecursos)//verifica se o jogador ja nao tem o recurso no maximo
        { 
            if(metal >= 2) //verificar se tem recursos para a troca
            {
            metal-=2;
            riqueza+=1;
            return true;
            }
        }    
    return false;         
    }

    public boolean TrocaRiquezaPorMetal()
    {      
        if(metal < limiteRecursos)//verifica se o jogador ja nao tem o recurso no maximo
        { 
            if(riqueza >= 2) //verificar se tem recursos para a troca
            {
            riqueza-=2;
            metal+=1;
            return true;
            }
        }   
    return false; 
    }

    //X6:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::Funções para aumentar força militar e descobrir tecnologia 
    
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

    public int DevolveTecnologiaAlvo(String nome)
    {   int alvo= -1;
        for(int i= 0; i< tecnologias.size();i++)
        {
            if(tecnologias.get(i).getNome().equals(nome)){
            alvo= i;}
        }

        return alvo;
    }
    
    
    
    public boolean DescobrirTecnologia(int x)
    {
        if(x <= tecnologias.size())//caso o numero indicado nao seja indicativo de uma tecnologia , nao fazer nada()
        {        
            if(riqueza >= tecnologias.get(x).getCusto())       //verifica se tem riqueza suficiente para efectuar a compra
            {
                if(null != tecnologias.get(x).getNome())
                switch (tecnologias.get(x).getNome()) 
                {
                    case "Forward Starbases":
                        if(AdequiriuT_CapitalShips())
                        {
                            compraTecnologia(x);
                            return true;
                        }
                        return false;
                    case "Planetary Defenses":
                        if(AdequiriuT_RobotWorkers())
                        {
                            compraTecnologia(x);
                            return true;
                        }
                        return false;
                    case "Interstellar Diplomacy":
                        if(AdequiriuT_HyperTelevision())
                        {
                            compraTecnologia(x);
                            return true;
                        }
                        return false;
                    case "Interstellar Banking":
                        if(AdequiriuT_InterspeciesComerce())
                        {
                            compraTecnologia(x);
                            return true;
                        }
                        return false;
                    default:
                        compraTecnologia(x);
                        break;
                }

            return true;
            }
        
        return false;
        }
    return false;
    }
    
    public void compraTecnologia(int x)
    {
            riqueza-= tecnologias.get(x).getCusto();         // subtrai o custo a riqueza   
            tecnologias.get(x).FazAccao(this);              // caso a tecnologia tenha accão direta no jogo essa acção é realizada
            tecnologiasAdquiridas.add(tecnologias.get(x)); //adiciona a tecnologia as adquiridas
            tecnologias.remove(x);     
    }
    //X7:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::Funções relacionadas a passagem de ano
    
    public void PassaDeAno()
    {
    iniciaEventos(); //volta a preencher o array e a baralhar as cartas de eventos 
    
    for(int i = 0; i < 2 ;i++) // remove 2 cartas do array
    {
    eventos.remove(i);
    }
   
    currentYear = 2; // o ano passa a ser 2    
    }
    
    //X01:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::Funções de verificação de aquisição de tecnologias e verificaçao de arrays empty
    
    public boolean AdequiriuT_RobotWorkers()
    {
        for(int i = 0;i < tecnologiasAdquiridas.size();i++)
        {
            if("Robot Workers".equals(tecnologiasAdquiridas.get(i).getNome()))
                return true;
        }
    return false;
    }   
    
    public boolean AdequiriuT_ForwardStarbases()
    {
        for(int i = 0;i < tecnologiasAdquiridas.size();i++)
        {
            if("Forward Starbases".equals(tecnologiasAdquiridas.get(i).getNome()))
                return true;
        }
    return false;
    }
    
    public boolean AdequiriuT_PlanetaryDefenses()
    {
        for(int i = 0;i < tecnologiasAdquiridas.size();i++)
        {
            if("Planetary Defenses".equals(tecnologiasAdquiridas.get(i).getNome()))
                return true;
        }
    return false;
    }
   
    public boolean AdequiriuT_InterspeciesComerce()
    {
        for(int i = 0;i < tecnologiasAdquiridas.size();i++)
        {
            if("Interspecies Commerce".equals(tecnologiasAdquiridas.get(i).getNome()))
                return true;
        }
    return false;
    }
    
    public boolean AdequiriuT_CapitalShips()
    {
        for(int i = 0;i < tecnologiasAdquiridas.size();i++)
        {
            if("Capital Ships".equals(tecnologiasAdquiridas.get(i).getNome()))
                return true;
        }
    return false;
    }
    
    public boolean AdequiriuT_HyperTelevision()
    {
        for(int i = 0;i < tecnologiasAdquiridas.size();i++)
        {
            if("Hyper Television".equals(tecnologiasAdquiridas.get(i).getNome()))
                return true;
        }
    return false;
    }
    
    public boolean AdequiriuT_InterstellarDiplomacy()
    {
        for(int i = 0;i < tecnologiasAdquiridas.size();i++)
        {
            if("Interstellar Diplomacy".equals(tecnologiasAdquiridas.get(i).getNome()))
                return true;
        }
    return false;
    }
    
    public boolean AdequiriuT_InterstellarBanking()
    {
        for(int i = 0;i < tecnologiasAdquiridas.size();i++)
        {
            if("Interstellar Banking".equals(tecnologiasAdquiridas.get(i).getNome()))
                return true;
        }
    return false;
    }
    
    
    public boolean verificaPorConquistar(){
        return !porConquistar.isEmpty();
    }
    
    public boolean VerificaSeNaoHaMaisEventos()
    {
    return eventos.isEmpty();
    }
    
    public boolean VerificaSeHaSistemasPorConquistar()
    {
    return !porConquistar.isEmpty();
    }
    
    public boolean VerificaSeHaSistemasNear()
    {
    return !nearSystem.isEmpty();
    }
    
    public boolean VerificaSeHaSistemasDistant()
    {
    return !distantSystem.isEmpty();
    }
    
    //X02:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::Funções para apresentar Pontuações no final do jogo
   
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
        pontos+=imperio.get(i).getPontosVitoria();       
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
    
    //X03:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::Cria dados para as intefaces
    
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
    
    //X04:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::INTERFACES
    //mostra informações para o utilizador
    public String Painel_tecnologiasADescobrir()
    {
    String estrutura = "";
    
    estrutura+= " Riqueza: " + riqueza 
                + "\n\n ===Primeira geração=== \n";      
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
    
    public  String Painel_forcaMilitar()
    {
    String estrutura = "";
    estrutura+=   /*"\n--------------------------------------------------------------"
                + */
                  " Força militar: " + forcaMilitar
                + "\n--------------------------------------------------------------"
                + "\n";
    
    return estrutura;
    }
    
    public String Painel_recursos()
    {
    String estrutura = "";
    estrutura+=   "\n--------------------------------------------------------------"
                + "\n Riqueza: " + riqueza               
                + "\n Metal: " + metal
                + "\n--------------------------------------------------------------"
                + "\n";
    
    return estrutura;
    }
    
    public String Painel_recurso_riqueza()
    {
    String estrutura = "";
    estrutura+=   "\n--------------------------------------------------------------"
                + "\n Riqueza: " + riqueza                             
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
    estrutura+=   "\n----------------------------------------------------------------"                
                + "\n Pontos do Imperio: " + SomaPontosImperio()
                + "\n Pontos das Tecnologias: " + SomaPontosTecnologia()
                + (ForamAdequiridasTodasAsTecnologias()? " \n (bónus científico)":"")
                + (ForamViradasTodasCartasSistema()? " \n (bónus de exploração)":"")
                + (ForamConquistadasTodasAsCartas()? " \n (bónus senhor da guerra)":"")
                + "\n----------------------------------------------------------------"
                + "\n PONTUAÇÂO TOTAL: " + SomaPontosVitoria()
                + "\n----------------------------------------------------------------"
                + "\n";
    
    return estrutura;
    }
    
     public String Painel_final_GUI()
    {
    String estrutura = "";
    estrutura+=    "<html><div style='text-align: center;'><br><br><br>              PONTUAÇÃO<br>" 
                +  "<br>-----------------------------------------------------------------"                
                + "<br>   Pontos do Imperio: " + SomaPontosImperio()
                + "<br>   Pontos das Tecnologias: " + SomaPontosTecnologia()
                + (ForamAdequiridasTodasAsTecnologias()? " <br> (bónus científico)":"")
                + (ForamViradasTodasCartasSistema()? " <br> (bónus de exploração)":"")
                + (ForamConquistadasTodasAsCartas()? " <br> (bónus senhor da guerra)":"")
                + "<br>------------------------------------------------------------------"
                + "<br>    PONTUAÇÃO TOTAL: " + SomaPontosVitoria()
                + "<br>------------------------------------------------------------------"
                + "<br><br><br><br>";
    
    return estrutura;
    }
    
     
    
    public String Painel_jogo() 
    {
        return  "\n=== SISTEMA ===\n" 
                + "Planetas por conquistar: " + ((porConquistar.isEmpty())? "nenhuns \n":"\n" + CriaDados_PlanetasPorConquistar())                  
                + "\n********************************************************************************************************************************"
                + "\n=== PAINEL DE INFORMAÇÔES ===\n" 
                + "\n Ano:" + currentYear
                + "\n Turno: " + turno
                + "\n Evento actual: " + ((currentEvento == null)? "nenhum":currentEvento)            
                + "\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"
                + "\n Imperio: \n" + CriaDados_Imperio() 
                + "\n Forca Militar: " + forcaMilitar
                + "\n--------------------------------------------------------------------------------------------------------------------------------"
                + "\n Riqueza: " + riqueza               
                + "\n Metal: " + metal
                + "\n"
                + "\n Limite de recursos: " + limiteRecursos
                + "\n Limite de força militar: " + limiteForcaMilitar                
                + "\n--------------------------------------------------------------------------------------------------------------------------------"
                + "\n Produção de metal: " + producaoMetal 
                + "\n Produção de riqueza: " + producaoRiq              
                + "\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"                               
                + "\n Tecnologias adquiridas: "  + ((tecnologiasAdquiridas.isEmpty())? "nenhumas \n":"\n" +CriaDados_TecnologiasAdquiridas()) 
                + "\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::";
    } 
    
  //mensagens GUI
    
    public String about()
    {
    return      "TP 2015/2016 - Micro Space Empire \n\n"
                + "Jogo realizado no ambito da disciplina: "                 
                + "\n- Programação Avançada\n"
                + "\n=== Criadores ===\n" 
                + "\n- Dmytro Yaremyshyn nº21220683" 
                + "\n- Sérgio Cruz nº21230463 ";
    }
    
    public String help()
    {
    return      "INFORMAÇÔES SOBRE O JOGO"
                + "\n\nFluxo do jogo\n"  
            + "***********************************************************************************************************************************************"
                + "\n\nO jogo ocorre em dois anos (terminando ao fim do segundo ano), de acordo com a seguinte sequência de etapas:"
                + "\n\nI. Preparação do jogo" 
                + "\nII. Turno" 
                    + "\n\t\t\t 1. Explorar-atacar/Conquistar/Passar" 
                    + "\n\t\t\t 2. Recolher o Metal e a Riqueza" 
                    +"\n\t\t\t 3. Construir a Força Militar (Military Strength) e Descobrir Tecnologia" 
                    +"\n\t\t\t 4. Eventos ; verificar fim de ano" 
                    +"\n\t\t\t 5. Enquanto não terminar o segundo ano, continuar na fase 1 do turno seguinte"
                +"\nIII. Fim do jogo – contagem dos pontos"
            + "\n\nRestrições"   
            + "\n*********************************************************************************************************************************************"
            + "\n* Na fase II.2:"
                    + "\n\t\t\tdepois de adquirida a tecnologia 'Interspecies' comerce é possivel apenas uma vez por turno a troca entre recursos"
            + "\n* Na fase II.3: "
                    + "\n\t\t\t Apenas é possivel comprar uma tecnologia da 2 geração se se tiver comprado a tecnologia da 1 geração correspondente"
                    + "\n\t\t\t Só se pode comprar uma tecnologia por turno "
                    + "\n\t\t\t Só se pode aumentar a força militar uma vez por turno"
            +"\n* Na fase II.4: "
                    +"\n\t\t\t Caso o seu império seja apenas constituído pelo seu Home World, o evento revolta não tem qualquer efeito no primeiro "
            + "\n\t\t\t ano e leva à perda do jogo no segundo ano pelo facto do seu Home World se revoltar.";
    }
}