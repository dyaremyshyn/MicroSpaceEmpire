/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import java.io.Serializable;
import logicaJogo.States.AguardaInicio;
import logicaJogo.States.IStates;

/**
 *
 * @author Sergio
 */
public class Jogo implements Serializable 
{
    
    private JogoDados dados = new JogoDados();
    private IStates estado;

    public Jogo() {
        setStates(new AguardaInicio(dados));
    }

    public IStates getStates() {
        return estado;
    }

    private void setStates(IStates estado) {
        this.estado = estado;
    }
    
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
     // funcoes de consulta dos dados
    
    
    
    
    
    
    
    
    
    
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    // funcoes delegadas no estado corrente 

    public void PrepararJogo()
    {
        setStates(estado.PrepararJogo());
    }

    public void Explorar_atacar(int TipoSistema) 
    {
        setStates(estado.Explorar_atacar(TipoSistema));
    }

    public void Conquistar(int alvo) 
    {
        setStates(estado.Conquistar(alvo));
    }

    public void Passar() 
    {
        setStates(estado.Passar());
    }

    public void Trocar_recursos(int TipoDeTroca) 
    {
        setStates(estado.Trocar_recursos(TipoDeTroca));
    }

    public void Aumentar_Força_Militar() 
    {
        setStates(estado.Aumentar_Força_Militar() );
    }

    public void Comprar_Tecnologia(int TecnologiaEscolhida) 
    {
        setStates(estado.Comprar_Tecnologia(TecnologiaEscolhida));
    }

    public void Terminar() 
    {
        setStates(estado.Terminar());
    }

    public void EscolheExplorar_atacar() 
    {
        setStates(estado.Terminar());
    }

    public void EscolheConquistar() 
    {
        setStates(estado.EscolheConquistar());
    }

    public void Cancelar() 
    {
        setStates(estado.Cancelar());
    }

    public void EscolheDescobrirTecnologia() 
    {
        setStates(estado.EscolheDescobrirTecnologia());
    }
    
    
}
