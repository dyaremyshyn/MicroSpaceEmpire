/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Tecnologias;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class InterstellarDiplomacy extends Tecnologia{

    public InterstellarDiplomacy() {
        super("Interstellar Diplomacy",2,5);
    }
    
    
    public void fazAcao(){
        
    }
    
    @Override
    public String Descricao()
    {
     return " no proximo turno pode explorar-atacar ou reconquistar com 100% sucesso sem lançar o dado";
    }
}
