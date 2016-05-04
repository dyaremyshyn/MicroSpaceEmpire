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
public class InterspeciesCommerce extends Tecnologia{

    public InterspeciesCommerce() {
        super("Interspecies Commerce",1,2);
    }    
    
    @Override
    public String Descricao()
    {
     return " torna possivel as trocas entre metal e riqueza";
    }
}
