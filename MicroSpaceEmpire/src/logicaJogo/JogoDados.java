/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import logicaJogo.Cartas.Carta;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Sergio
 */
public class JogoDados implements Serializable {
    List<Carta> nearSystem;
    List<Carta> unalignedSystem;
    List<Carta> imperio;
    List<Carta> porConquistar;
    
    JogoDados(){
        
    }

    

    public void setNearSystem(List<Carta> nearSystem) {
        this.nearSystem = nearSystem;
    }

    public void setUnalignedSystem(List<Carta> unalignedSystem) {
        this.unalignedSystem = unalignedSystem;
    }

    public void setImperio(List<Carta> imperio) {
        this.imperio = imperio;
    }

    public void setPorConquistar(List<Carta> porConquistar) {
        this.porConquistar = porConquistar;
    }
    
    
}
