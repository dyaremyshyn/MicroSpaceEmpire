/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Cartas;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class Carta {
    private String tipoSistema;
    private String nome;
    private int metal;
    private int riqueza;
    private int resistencia;
    private int pontosVitoria;
    
    Carta(String tipo, String n, int m, int riq, int res,int p){
        tipoSistema=tipo;
        nome=n;
        metal=m;
        riqueza=riq;
        resistencia=res;
        pontosVitoria=p;
    }

    public String getTipoSistema() {
        return tipoSistema;
    }

    public String getNome() {
        return nome;
    }

    public int getMetal() {
        return metal;
    }

    public int getRiqueza() {
        return riqueza;
    }

    public int getResistencia() {
        return resistencia;
    }

    public int getPontosVitoria() {
        return pontosVitoria;
    }

    public void setTipoSistema(String tipoSistema) {
        this.tipoSistema = tipoSistema;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMetal(int metal) {
        this.metal = metal;
    }

    public void setRiqueza(int riqueza) {
        this.riqueza = riqueza;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public void setPontosVitoria(int pontosVitoria) {
        this.pontosVitoria = pontosVitoria;
    }
    
    
    
}
