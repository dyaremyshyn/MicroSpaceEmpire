/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo;

import java.io.Serializable;
import java.util.List;
import logicaJogo.Cartas.Carta;
import logicaJogo.Eventos.Evento;
import logicaJogo.States.AguardaInicio;
import logicaJogo.States.IStates;
import logicaJogo.Tecnologias.Tecnologia;


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
    
    public JogoDados getJogoDados(){
        return dados;
    }
    public void setJogoDados(JogoDados jd){
        dados=jd;
    }

    private void setStates(IStates estado) {
        this.estado = estado;
    }
    
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    // funçoes get dados para gui
    public int DevolveTecnologiaAlvo(String nome)
    {
    return dados.DevolveTecnologiaAlvo(nome);
    }
    
    public List<Carta> getNearSystem() {
        return dados.getNearSystem();
    }

    public List<Carta> getDistantSystem() {
        return dados.getDistantSystem();
    }

    public List<Carta> getImperio() {
        return dados.getImperio();
    }

    public List<Carta> getPorConquistar() {
        return dados.getPorConquistar();
    }

    public List<Evento> getEventos() {
        return dados.getEventos();
    }

    public int getLimiteRecursos() {
        return dados.getLimiteRecursos();
    }

    public List<Tecnologia> getTecnologias() {
        return dados.getTecnologias();
    }

    public List<Tecnologia> getTecnologiasAdquiridas() {
        return dados.getTecnologiasAdquiridas();
    }
    
    public int getTurno() {
        return  dados.getTurno();
    }

    public int getCurrentYear() {
        return  dados.getCurrentYear();
    }

    public Evento getCurrentEvento() {
        return  dados.getCurrentEvento();
    }
    
    public int getPontuacao() {
        return  dados.getPontuacao();
    }

    public int getMetal() {
        return  dados.getMetal();
    }

    public int getRiqueza() {
        return  dados.getRiqueza();
    }

    public int getForcaMilitar() {
        return  dados.getForcaMilitar();
    }
    
    public int getProducaoMetal() {
        return  dados.getProducaoMetal();
    }

    public int getProducaoRiq() {
        return  dados.getProducaoRiq();
    }   
    
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
    
    public String Painel_final_GUI()
    {
    return dados.Painel_final_GUI();
    }
    
     public String Painel_recurso_riqueza()
    {
    return dados.Painel_recurso_riqueza();
    }
    
    public String Painel_Conquistar()
    {
    return dados.Painel_Conquistar();
    }
    
    //infos GUI
    public String help()
    {
    return dados.help();
    }
    
    public String about()
    {
    return dados.about();
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
