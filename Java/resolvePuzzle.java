/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package funcoes_usuario;

/**
 *
 * @author fabiano
 */
public class resolvePuzzle extends Thread{

puzzleMultiAgente m;
puzzleBacktracking b;
//Problema
Integer[][] tabuleiro;
//Objetivo
Integer[][] objetivo;
//Tamanho do puzzle
int n;
//Qual metodo de resolução usar
String metodo;
//Medir tempo de execução
long t1,t2;

public void setMultiagente()
{
    metodo = "m";
}

public void setBacktracking()
{
    metodo = "b";
}

public resolvePuzzle(Integer[][] tab,Integer[][] obj,int tam)
{
    //Metodo padrão éo o Multiagente
    metodo = "m";
    n =tam;
    objetivo = obj;
    tabuleiro = tab;
}

public void setTamanho(int n) {
    this.n = n;
}

public void setObjetivo(Integer[][] objetivo) {
    this.objetivo = objetivo;
}

public void setTabuleiro(Integer[][] tabuleiro) {
    this.tabuleiro = tabuleiro;
}



@Override
public void run()
{
    if(metodo.compareTo("m")==0)
    {
        System.out.println("\n Thread Solução com Multiagente");

         //Aplica Solução com multiagentes
        m= new puzzleMultiAgente(n);

        //Gera caminho apartir da função objetivo
        m.geraCaminho(objetivo);
        m.imprimeTabuleiro();

        //Tempo inicial
        t1 = System.currentTimeMillis();

        //Resolve o puzzle
        m.rezolvePuzzle(tabuleiro);

        //Tempo final
        t2 = (System.currentTimeMillis() - t1);
        System.out.println("\nO tempo gasto com multiagentes foi de:" + t2 + "ms");
        
        //Número de trocas
        m.numeroTrocas();
    }

    else
    {
        System.out.println("\n Thread Solução com Backtracking");
        
        //Aplica Solução com Backtracking
        b = new puzzleBacktracking();

        //Seta objetivo
        b.setTabuleiroObjetivo(objetivo);

        //Tempo inicial
        t1 = System.currentTimeMillis();

        //Resolve o puzzle
        b.resolvePuzzle(tabuleiro);

        System.out.println("O tempo gasto com tentativa e erro foi de:" + t2 + "ms");
        //b.imprimePuzzle();
        //b.aplicaSolucao();
    }
}

}
