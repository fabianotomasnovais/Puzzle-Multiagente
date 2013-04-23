/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package funcoes_usuario;

import java.util.Random;

/**
 *
 * @author fabiano
 */
public class puzzleBacktracking {
//Profundidade
static final int p = 30;
//Tabuleiro
private int[][] tabuleiro = new int [3][3];
//Copia inicial do tabuleiro
private int[][] tabuleiro_copia = new int [3][3];
//Tabuleiro objetivo
private int[][] tabuleiro_objetivo = new int [3][3];
//Solução
solucaoPuzzle solucao = new solucaoPuzzle(50);
//tiposolucao solucao;
//Marcador para o problema inicial
int inicial;
//Possíveis movimentos no tabuleiro
/*
 *  x,y
 *  1,0     //direita
 * -1,0     //esquerda
 *  0,1     //para cima
 *  0,-1    //para baixo
*/
int mov_horizontal[]={0,0,1,-1};
int mov_vertical[]={1,-1,0,0};
//Posição do vazio no momento
int posVaziox,posVazioy,profundidade;
int interacoes;
int num_retornos;


public void geraPuzzleOrdenado()
{
 int x,y,n;
 n=1;

for(x=0;x<3;x++)
    for(y=0;y<3 && n<9;y++,n++)
    {
        tabuleiro[x][y]=n;
        tabuleiro_copia[x][y]=n;
    }
//tabuleiro[2][0]=0;
//tabuleiro[2][2]=7;
posVaziox = 2;
posVazioy = 2;
}

public void geraPuzzle()
{
int x,y,n;
//srand(time(NULL));
Random r = new Random();
//Limpa tabuleiro, colocando -1 nos espaços vazios
for(x=0;x<3;x++)
    for(y=0;y<3;y++)
        tabuleiro[x][y]=-1;
//0 representa os espaço vazio
n = 0;
    while(n<9)
    {
         //x = rand() %3;
         //y = rand() %3;
        //x = (int) (Math.random() % 3);
        x = r.nextInt(3);
        y = r.nextInt(3);
        //y = (int) (Math.random() % 3);
        if(tabuleiro[x][y]==-1)
        {
            tabuleiro[x][y]=n;
            tabuleiro_copia[x][y]=n;
            //Armazena a posição do vazio
            if(n == 0)
            {
                posVaziox = x;
                posVazioy = y;
            }
            n++;
        }
    }
}
//Seta tabuleiro objetivo
public void setTabuleiroObjetivo(Integer tab[][])
{
        for(int x=0;x<3;x++)
            for(int y=0;y<3;y++)
                tabuleiro_objetivo[x][y]=tab[x][y];
}
//Retorna 0 se a solução foi encontrada
public int tabuleiroOrdenado()
{
 int x,y,estimador;
 //n = 1;
 //n = 0;
 estimador = 0;
    for(x=0;x<3;x++)
     //for(y=0;y<3 && n<9;y++,n++)
     for(y=0;y<3;y++)
     {  
         //if(tabuleiro[x][y]!=n)
         if(tabuleiro[x][y]!=tabuleiro_objetivo[x][y])
            estimador++;
        //    estimador += tabuleiro[x][y]-n;
        //else
        //    estimador += n-tabuleiro[x][y];
     }
        //if(tabuleiro[x][y]!=n)
        //   return 0;
//return 1;
return estimador;
}

//Retorna 1 se a solução é impossível
public int solucaoImpossivel()
{
int x,y,n;
 //n = 1;
 n = 0;
    for(x=0;x<3;x++)
     //for(y=0;y<3 && n<9;y++,n++)
     for(y=0;n<7&&y<3;y++,n++)
      if(tabuleiro[x][y]!=n)
         return 0;
     if(tabuleiro[2][1]==8)
        return 1;
     else
        return 0;
}

public int posicaoInicial()
{
int x,y;
 //n = 1;
    for(x=0;x<3;x++)
     //for(y=0;y<3 && n<9;y++,n++)
     for(y=0;y<3;y++)
        if(tabuleiro[x][y]!=tabuleiro_copia[x][y])
           return 0;
return 1;
}

public void imprimePuzzle()
{
 int x,y;
 //printf("Puzzle 3X3\n");
   System.out.printf("\nTotal de interações:" + interacoes);
   System.out.printf("\nTotal de retornos:" + num_retornos);
   System.out.printf("\nProfundidade:" + profundidade);
   System.out.printf("\n");
   
 for(x=0;x<3;x++)
 {
    System.out.printf("\n");

    for(y=0;y<3;y++)
    {
        //if(tabuleiro[x][y]!=0)
            System.out.printf(" " + tabuleiro[x][y]);
        //else
        //     System.out.printf("  ");
    }
    
 }
    System.out.printf("\n\n");
}

void imprimeSolucao_parcial()
{
//Imprime passo da passo da solução
    
         System.out.printf("\n");

         for(int x=0;x<3;x++)
        {
            //System.out.printf("\n");

            for(int y=0;y<3;y++)
            {
                //if(tabuleiro_copia[x][y]!=0)
                    System.out.printf(" " + tabuleiro_copia[x][y]);
                //else
                    //System.out.printf("  ");
            }

            System.out.printf("\n");
        }
}

public void insereTroca(int x_v,int y_v,int x_t,int y_t)
{

    //Posição atual do vazio
    solucao.posicoes[solucao.n_troca][0] = x_v;
    solucao.posicoes[solucao.n_troca][1] = y_v;
    //Posição do elemento a ser trocado
    solucao.posicoes[solucao.n_troca][2] = x_t;
    solucao.posicoes[solucao.n_troca][3] = y_t;
    //Incrementa numero da troca
    solucao.n_troca++;

}

public void removeTroca()
{
    solucao.n_troca--;
}

public void imprimeSolucao()
{
    //System.out.printf("\nSolução do puzzle:\n");

    for(int i=0;i<solucao.n_troca;i++)
    {
        //System.out.printf("\nTrocar V("+ solucao.posicoes[i][0]+ "," + solucao.posicoes[i][2] +") com P("+ solucao.posicoes[i][2] + "," + solucao.posicoes[i][3] +")");
    }
}

public void tentaPuzzle(int x,int y)
{
    int tent_possivel,x_vazio,y_vazio,x_ant,y_ant,ordenado,posicao,impossivel;
    //Inicializa tentativas
    tent_possivel = 0;
    //Armazena as posições anteriores
    x_ant = x;
    y_ant = y;
    //Armazena a posição atual
    x_vazio = posVaziox;
    y_vazio = posVazioy;
    //Incrementa número de interações
    interacoes++;
    //Incrementa a profundidade
    profundidade++;
    ordenado = tabuleiroOrdenado();
    impossivel = solucaoImpossivel();
    //do
    while(tent_possivel<4 && ordenado>0 && impossivel!=1)
    {

        //Seleciona uma nova posição das tentativas possíveis
        //x_vazio = mov_horizontal[tent_possivel] + posVaziox;
        posVaziox = mov_horizontal[tent_possivel] + x_vazio;
        //y_vazio = mov_vertical[tent_possivel] +y_vazio;
        posVazioy = mov_vertical[tent_possivel] +y_vazio;
        //printf("\nTroca posição P(%i,%i) com Q(%i,%)\n",tabuleiroOrdenado());
        //Verifica se a posição nova é válida e se não é uma posição anterior
        //printf("\n%i",posicao);
        if(posVaziox >-1 && posVaziox<3 && posVazioy >-1 && posVazioy<3 && !(x_ant== posVaziox && y_ant== posVazioy)&& profundidade<p)
        {
            //Troca elementos de lugar
            tabuleiro[x_vazio][y_vazio] = tabuleiro[posVaziox][posVazioy];
            tabuleiro[posVaziox][posVazioy] = 0;
            //Insere quais posições devem ser trocadas
            insereTroca(x_vazio,y_vazio,posVaziox,posVazioy);
            //imprimePuzzle();
            ordenado = tabuleiroOrdenado();
            impossivel = solucaoImpossivel();
            //if(ordenado&&!impossivel)
            //Ainda não achou uma solução possível ou impossível
            if(ordenado>0 && impossivel!=1)
            {
                //Tenta puzzle para nova posição se a posição atual não corresponder a primeira posição do tabuleiro
                posicao = posicaoInicial();
                if(posicao==0)
                {
                    tentaPuzzle(x_vazio,y_vazio);
                    ordenado = tabuleiroOrdenado();
                    impossivel = solucaoImpossivel();
                }

                //Verifica se conseguiu orndenar
                    if(ordenado>0 && impossivel!=1)
                    {
                      //if(posicao==0)
                      //   profundidade--;
                            //Decrementa a profundidade
                            //remove da lista de solucao
                      //Retorna os elementos para o lugar original
                        tabuleiro[posVaziox][posVazioy] = tabuleiro[x_vazio][y_vazio];
                        tabuleiro[x_vazio][y_vazio] = 0;
                        //Volta para posição "vazia"
                        posVaziox = x_vazio;
                        posVazioy = y_vazio;
                        removeTroca();
                        //printf("\nRetorna para posição anterior.");
                        //imprimePuzzle();
                    }
                    else
                        break;
            }
            else
                break;
        }

        tent_possivel++;
        ordenado = tabuleiroOrdenado();

            if(tent_possivel==4)
                {
                   //Retorna os elementos para o lugar original
                   //tabuleiro[posVaziox][posVazioy] = tabuleiro[x_vazio][y_vazio];
                   //tabuleiro[x_vazio][y_vazio] = 0;
                   //Aponta para a posição vazia original
                   posVaziox = x_vazio;
                   posVazioy = y_vazio;
                   profundidade--;
                   num_retornos++;
                   //profundidade--;
                }

        //if(profundidade<=1)
        //    inicial=1;
        //Volta para posição original após as 4 tentativas
        //else
        //{
            //x_vazio = x_vazio - mov_horizontal[tent_possivel];
            //y_vazio = y_vazio - mov_vertical[tent_possivel];
        //    if(tent_possivel==3)
        //    {
        //         posVaziox = x_vazio;
        //         posVazioy = y_vazio;
        //    }
        //}

    }
    //}while(tent_possivel<4);

/*if(!tabuleiroOrdenado())
            {
                 posVaziox = x_vazio;
                 posVazioy = y_vazio;
            }
*/
    //System.out.println("Trocas:"+ interacoes);
}

public void aplicaSolucao()
{
        //Posição atual do vazio
    int x_v,y_v,x_t,y_t;

    //System.out.printf("\nProblema inicial:");
    imprimeSolucao_parcial();
    System.out.printf("\nSolução com "+ solucao.n_troca +" trocas:\n");
    for(int i=0;i<solucao.n_troca;i++)
    {
        //Copia as posições das trocas
        //Posição do vazio
        x_v = solucao.posicoes[i][0];
        y_v = solucao.posicoes[i][1];
        //Posição do elemento a ser trocado
        x_t = solucao.posicoes[i][2];
        y_t =solucao.posicoes[i][3];

        //Troca os elementos com utilizando o passo i
        tabuleiro_copia[x_v][y_v] = tabuleiro_copia[x_t][y_t];
        tabuleiro_copia[x_t][y_t] = 0;

        //Imprimi passo da solução
        ////System.out.printf("\nPasso " + (i+1));
        //System.out.printf("\nPasso " + i);
        imprimeSolucao_parcial();
    }

}

public void resolvePuzzle(Integer tab[][])
{
    int impossivel;
    interacoes = 0;
    profundidade = 0;
    solucao.n_troca = 0;
    num_retornos = 0;
    //Copia puzzle
//    for(int x=0;x<3;x++)
//        for(int y=0;y<3;y++)
//        {
//            tabuleiro[x][y]=tab[x][y];
//            tabuleiro_copia[x][y]=tab[x][y];
//        }
    setTabuleiro(tab);
    System.out.printf("Antes da resolucao\n");
    imprimePuzzle();
    System.out.printf("\nAplica Backtracking:\n");
    tentaPuzzle(-1,-1);
    //System.out.printf("Depois da resolucao\n");
    impossivel = solucaoImpossivel();
    if(impossivel==1)
        System.out.printf("Não há solucao para este puzzle\n");
    imprimePuzzle();
    imprimeSolucao();

}

    public void setTabuleiro(Integer[][] tab) {
        //this.tabuleiro = tabuleiro;
        for(int x=0;x<3;x++)
            for(int y=0;y<3;y++)
            {
                this.tabuleiro[x][y]=tab[x][y];
                //Salva posição do vazio
                if(tab[x][y] == 0)
                {
                   posVaziox = x;
                   posVazioy = y;   
                }
            }
        //Faz uma copia do tabuleiro
        setTabuleiro_copia();
    }

    public void setTabuleiro_copia() {
        for(int x=0;x<3;x++)
            for(int y=0;y<3;y++)
                tabuleiro_copia[x][y]=tabuleiro[x][y];
    }

}