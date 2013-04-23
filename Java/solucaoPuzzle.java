/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package funcoes_usuario;

import java.util.ArrayList;

/**
 *
 * @author fabiano
 */
public class solucaoPuzzle {
    int posicao_x;
    int posicao_y;
    //Array com a solução do puzzleBackTracking
    int[][] posicoes;
    //Array com a solução do puzzleBackTracking
    ArrayList lista;
    int n_troca;

    public solucaoPuzzle()
    {
        lista = new ArrayList();
    }

    public solucaoPuzzle(int n)
    {
        posicoes = new int [n][4];
    }

    public void adicionaSolucao(agente a, agente v)
    {
        agente p = new agente(a.getPosicao_atual_x(),a.getPosicao_atual_y());
        //Armazena a posição objetivo (vazio)
        p.setNumero(a.getNumero());
        p.setPosicao_objetivo_x(v.getPosicao_atual_x());
        p.setPosicao_objetivo_y(v.getPosicao_atual_y());
        lista.add(p);

    }

    public void adicionaSolucao(int x,int y)
    {

    }

    //Executa solução na matriz

    public void executaSolucao(agente[][] p)
    {
        agente a = (agente) lista.get(0);
        //a.satisfacaSemAtacar(a.getVazio());
    }

    public void imprime()
    {
        //int passos;
        System.out.println("\nOrdem das trocas dos agentes");
        for(int i=0;i<lista.size();i++)
        {
           agente a = (agente) lista.get(i);
           System.out.println("\nAgente " + a.getNumero() + " da posicao P(" + a.getPosicao_atual_x() + "," + a.getPosicao_atual_y() + ") vai para posicao P(" + a.getPosicao_objetivo_x() + "," + a.getPosicao_objetivo_y() + ")" );
           //a.imprimeAgente();
        }
        //passos = lista.size()
        System.out.println("\nNumero de trocas:"+ lista.size());

    }

}