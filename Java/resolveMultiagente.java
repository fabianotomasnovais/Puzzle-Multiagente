/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package funcoes_usuario;

/**
 *
 * @author fabiano
 */
public class resolveMultiagente {
public resolveMultiagente()
{

}
public String resolve(Integer[][] tab,Integer[][] obj,Integer tam)
{
       //Aplica Solução com multiagentes
        puzzleMultiAgente mult = new puzzleMultiAgente(tam);

  //Gera caminho apartir da função objetivo
        mult.geraCaminho(obj);
        mult.imprimeTabuleiro();

        //p.rezolvePuzzle(problema);
        mult.rezolvePuzzle(tab);
        return "MultiAgente pronto";
}
}