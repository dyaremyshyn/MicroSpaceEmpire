/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import logicaJogo.Cartas.Carta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import logicaJogo.Cartas.*;

/**
 *
 * @author Sergio
 */
public class JogoDados implements Serializable {
    private List<Carta> nearSystem;
    private List<Carta> distantSystem;
    private List<Carta> imperio;
    private List<Carta> porConquistar;
    private int pontuacao;
    private int metal;
    private int riqueza;
    private int forcaMilitar;
    
    JogoDados(){
        
        iniciar();
    }
    
    public void iniciar(){
       imperio = new ArrayList<>();
       nearSystem = new ArrayList<>();
       distantSystem = new ArrayList<>();
       
       imperio.add(new HomeWorld());
       
       iniciaNearSystem();
       iniciaDistantSystem();
       
       pontuacao=0;
       metal=0;
       riqueza=0;
       forcaMilitar=0;
    }
    

    public void iniciaNearSystem() {
        nearSystem.add(new Wolf359());
        nearSystem.add(new Proxima());
        nearSystem.add(new EpsilonEridani());
        nearSystem.add(new Cygnus());
        nearSystem.add(new TauCeti());
        nearSystem.add(new Procyon());
        nearSystem.add(new Sirius());
    }

    public void iniciaDistantSystem() {
        distantSystem.add(new Canopus());
        distantSystem.add(new Polaris());
        distantSystem.add(new GalaxysEdge());
    }
    

    public void setImperio(Carta e) {
        imperio.add(e);
    }

    public void setPorConquistar(Carta e) {
        porConquistar.add(e);
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
    
    
    
}
