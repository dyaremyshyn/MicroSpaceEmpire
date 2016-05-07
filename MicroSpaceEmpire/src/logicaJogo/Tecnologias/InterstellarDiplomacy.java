/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.Tecnologias;

import logicaJogo.JogoDados;


public class InterstellarDiplomacy extends Tecnologia{

    public InterstellarDiplomacy() {
        super("Interstellar Diplomacy",2,5);
    }
   
    @Override
    public void FazAccao(JogoDados jogo)
    {       
        jogo.setBloqueio_compraDireta(1);
    }
    
    @Override
    public String Descricao()
    {
     return " No próximo turno pode explorar-atacar ou reconquistar com 100% sucesso sem lançar o dado";
    }
}
