
package logicaJogo;

import java.util.List;
import java.util.Observable;
import logicaJogo.Cartas.Carta;
import logicaJogo.Eventos.Evento;
import logicaJogo.States.IStates;
import logicaJogo.Tecnologias.Tecnologia;

/**
 *
 * @author Dmytro Yaremyshyn & Sergio Cruz
 */

public class ObservableGame extends Observable {
    Jogo jogo;
    
    public ObservableGame()
    {
        jogo = new Jogo();
    }
    
    public Jogo getJogo()
    {
        return jogo;
    }
    
    public void setJogo(Jogo j){
        jogo=j;
        
        setChanged();
        notifyObservers();
    }
    
    public JogoDados getJogoDados(){
        return jogo.getJogoDados();
    }
    
    public IStates getStates(){
        return jogo.getStates();
    }
        
    
    // Methods retrieve data from the game
    // funcoes de consulta dos dados
    public int DevolveTecnologiaAlvo(String nome){
    return jogo.DevolveTecnologiaAlvo(nome);
    }
    
    
    public List<Carta> getNearSystem() {
        return jogo.getNearSystem();
    }

    public List<Carta> getDistantSystem() {
        return jogo.getDistantSystem();
    }

    public List<Carta> getImperio() {
        return jogo.getImperio();
    }

    public List<Carta> getPorConquistar() {
        return jogo.getPorConquistar();
    }

    public List<Evento> getEventos() {
        return jogo.getEventos();
    }

    public int getLimiteRecursos() {
        return jogo.getLimiteRecursos();
    }

    public List<Tecnologia> getTecnologias() {
        return jogo.getTecnologias();
    }

    public List<Tecnologia> getTecnologiasAdquiridas() {
        return jogo.getTecnologiasAdquiridas();
    }
    
     public int getTurno() {
        return  jogo.getTurno();
    }

    public int getCurrentYear() {
        return  jogo.getCurrentYear();
    }

    public Evento getCurrentEvento() {
        return  jogo.getCurrentEvento();
    }

    public int getPontuacao() {
        return  jogo.getPontuacao();
    }

    public int getMetal() {
        return  jogo.getMetal();
    }

    public int getRiqueza() {
        return  jogo.getRiqueza();
    }

    public int getForcaMilitar() {
        return  jogo.getForcaMilitar();
    }
    
    public int getProducaoMetal() {
        return  jogo.getProducaoMetal();
    }

    public int getProducaoRiq() {
        return  jogo.getProducaoRiq();
    }

    
     //funções de verificação
    
    public boolean AdequiriuT_ForwardStarbases()
    {
    return jogo.AdequiriuT_ForwardStarbases();
    }
    
    public boolean AdequiriuT_InterspeciesComerce()
    {
    return jogo.AdequiriuT_InterspeciesComerce();
    }
    
    public int getBloqueio_compraDireta() {
        return jogo.getBloqueio_compraDireta();
    } 
    
    public boolean VerificaSeHaSistemasPorConquistar()
    {
    return jogo.VerificaSeHaSistemasPorConquistar();
    }
    
    public boolean VerificaSeHaSistemasNear()
    {
    return jogo.VerificaSeHaSistemasNear();
    }
    
    public boolean VerificaSeHaSistemasDistant()
    {
    return jogo.VerificaSeHaSistemasDistant();
    }
    
    // Methods that are intended to be used by the user interfaces and that are delegated in the current state of the finite state machine 
    // funcoes delegadas no estado corrente 
    
    public void PrepararJogo()
    {
        jogo.PrepararJogo();
        
        setChanged();
        notifyObservers();
    }

    public void Explorar_atacar(int TipoSistema) 
    {
        jogo.Explorar_atacar(TipoSistema);
        
        setChanged();
        notifyObservers();
    }

    public void Conquistar(int alvo)
    {
        jogo.Conquistar(alvo);
        
        setChanged();
        notifyObservers();
    }

    public void Passar()
    {
        jogo.Passar();
        
        setChanged();
        notifyObservers();
    }    
    
    public void Trocar_recursos(int TipoDeTroca) 
    {
        jogo.Trocar_recursos(TipoDeTroca);
        
        setChanged();
        notifyObservers();
    }

    public void Aumentar_Força_Militar() 
    {
        jogo.Aumentar_Força_Militar();
        
        setChanged();
        notifyObservers();
    }

    public void Comprar_Tecnologia(int TecnologiaEscolhida)
    {
        jogo.Comprar_Tecnologia(TecnologiaEscolhida);
        
        setChanged();
        notifyObservers();
    }

    public void Terminar()
    {
        jogo.Terminar();
        
        setChanged();
        notifyObservers();
    }
    
    public void EscolheExplorar_atacar()  
    {
        jogo.EscolheExplorar_atacar();
        
        setChanged();
        notifyObservers();
    }

    public void EscolheConquistar()
    {
        jogo.EscolheConquistar();
        
        setChanged();
        notifyObservers();
    }

    public void Cancelar()
    {
        jogo.Cancelar();
        
        setChanged();
        notifyObservers();
    }
    
    public void EscolheDescobrirTecnologia()
    {
        jogo.EscolheDescobrirTecnologia();
        
        setChanged();
        notifyObservers();
    }
}
