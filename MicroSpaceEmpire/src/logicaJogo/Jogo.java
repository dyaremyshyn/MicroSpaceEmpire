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
    
    public String Painel_jogo() 
    {
    return dados.Painel_jogo();
    }
    
    public String Painel_forcaMilitar()
    {
    return dados.Painel_forcaMilitar();
    }
    
    public String Painel_tecnologiasADescobrir()
    {
    return dados.Painel_tecnologiasADescobrir();
    }
    
    public String Painel_recursos()
    {
    return dados.Painel_recursos();
    }

    public String Painel_final()
    {
    return dados.Painel_final();
    }
    
     public String Painel_recurso_riqueza()
    {
    return dados.Painel_recurso_riqueza();
    }
    
    public String Painel_Conquistar()
    {
    return dados.Painel_Conquistar();
    }
    
    //funções de verificação
    
    public boolean AdequiriuT_ForwardStarbases()
    {
    return dados.AdequiriuT_ForwardStarbases();
    }
    
    public boolean AdequiriuT_InterspeciesComerce()
    {
    return dados.AdequiriuT_InterspeciesComerce();
    }
    
    public int getBloqueio_compraDireta() {
        return dados.getBloqueio_compraDireta();
    } 
    
    public boolean VerificaSeHaSistemasPorConquistar()
    {
    return dados.VerificaSeHaSistemasPorConquistar();
    }
    
    public boolean VerificaSeHaSistemasNear()
    {
    return dados.VerificaSeHaSistemasNear();
    }
    
    public boolean VerificaSeHaSistemasDistant()
    {
    return dados.VerificaSeHaSistemasDistant();
    }
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
        setStates(estado.EscolheExplorar_atacar());
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
