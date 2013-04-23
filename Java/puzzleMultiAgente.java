/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package funcoes_usuario;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author fabiano
 */
public class puzzleMultiAgente {

//Constantes
static final int caminho = 4; //Faz parte de um caminho já completo
static final int bloqueado=3; //Não sai do caminho mais
static final int atacando=2;  //Esta atacando
static final int fugindo=1;   //Esta fugindo de um ataque
static final int aguardando=0;//Esta aguardando ser satisfeito
//Tabuleiro com os agentes
private agente[][] tabuleiro;
private agente agente_vazio;
//private Integer[] caminho;
//Tamanho NxN do puzzle
private int tamanho;
//Caminho na ordem de execução dos agentes
ArrayList caminhoLista;
//Posicao correta do vazio;
private int x_vazio;
private int y_vazio;
//Array com a solução do puzzleBackTracking
solucaoPuzzle solucao = new solucaoPuzzle();
int trocas;
//ArrayList lista;
//Construtor do puzzle
public puzzleMultiAgente(int n)
{
    //Tabuleiro contendo n agentes
    tabuleiro = new agente[n][n];
 /*   //Cria tabuleiro contendo os agentes nas posições corretas ou seja no objetivo geral
    for(int x=0; x<n; x++)
    {
        for( int y=0; y<n;y++)
        {
            agente a = new agente(x,y);
            if((n-x)>(n-y))
                a.setDistVazio(n-x);
            else
                a.setDistVazio(n-y);
            a.setNumero(-1);
            //a.setPosicao_atual_x(x);
            //a.setPosicao_atual_y(y);
            //a.setPosicao_objetivo_x(x);
            //a.setPosicao_objetivo_y(y);
            //a.setNumero(num);
            tabuleiro[x][y] = a;
        }
    }*/
    tamanho = n;
    trocas = 0;
    //tabuleiro[0][0].setPosicao_objetivo_x(3);
    //tabuleiro[0][0].setPosicao_objetivo_y(3);
}
public Integer [][] geraPuzzleValido()
{
 int x,y,n,t;
 n=1;
 t=1000;
 int xv_atual=tamanho-1;
 int yv_atual=tamanho-1;

 int [] x_v ={1,-1,0,0};
 int [] y_v ={0,0,1,-1};

 Random r = new Random();
Integer[][] tab = new Integer [tamanho][tamanho];

        for(x=0;x<tamanho;x++)
           for(y=0;y<tamanho;y++)
           {
               tab[x][y]=n;
               n++;
           }
        tab[tamanho-1][tamanho-1]=0;

while(t>0|| tab[tamanho-1][tamanho-1]!=0)
{
        x = r.nextInt(tamanho);
        y = r.nextInt(tamanho);

  if(x>=0 && x<tamanho && y>=0 && y<tamanho)
  {
     for(int i=0;i<4;i++)
     {
        if(x==(x_v[i]+xv_atual) && y==(y_v[i]+yv_atual))
        {
            tab[xv_atual][yv_atual]=tab[x][y];
            tab[x][y] = 0;
            xv_atual = x;
            yv_atual = y;
            t--;
            //////System.out.println("Achou");
        }
    }
  }
}

  ////System.out.printf("Tabuleiro valido:"+ tamanho +"\n");

 for(x=0;x<tamanho;x++)
 {
    ////System.out.printf("\n");

    for(y=0;y<tamanho;y++)
    {
        //if(tab[x][y]!=0)
            ////System.out.printf(" " + tab[x][y]);
        //else
        //     ////System.out.printf("  ");
    }

 }

return tab;
}

public Integer [][] geraPuzzle()
{
int x,y,n,t;
//srand(time(NULL));
Integer[][] tab = new Integer [tamanho][tamanho];
Random r = new Random();
t= (tamanho*tamanho);
//Limpa tabuleiro, colocando -1 nos espaços vazios

for(x=0;x<tamanho;x++)
    for(y=0;y<tamanho;y++)
        tab[x][y]=-1;
tab[tamanho-1][tamanho-1]=0;
//0 representa os espaço vazio
n = 1;
    while(n<t)
    {
         //x = rand() %3;
         //y = rand() %3;
        //x = (int) (Math.random() % 3);
        x = r.nextInt(tamanho);
        y = r.nextInt(tamanho);
        //y = (int) (Math.random() % 3);
        if(tab[x][y]==-1 )
        {
            tab[x][y]=n;
            n++;
            /* //Armazena a posição do vazio
            if(n == 0)
            {
                posVaziox = x;
                posVazioy = y;
            }
            n++;*/
        }
    }

 ////System.out.printf("Tabuleiro sorteadode tamanho:"+ tamanho +"\n");

 for(x=0;x<tamanho;x++)
 {
    ////System.out.printf("\n");

    for(y=0;y<tamanho;y++)
    {
        //if(tab[x][y]!=0)
            ////System.out.printf(" " + tab[x][y]);
        //else
        //     ////System.out.printf("  ");
    }

 }

 //puzzleProblema(tab);
 //imprimeTabuleiro();
return tab;
}

public void rezolvePuzzle(Integer t)
{
    System.out.println("Nada feito");
}

public void rezolvePuzzle(Integer[][] p)
{
    agente a,a_temp;
    int cont;
    int num_agentes=tamanho*tamanho -1;
    //Localiza o vazio antes
    //Inicializa cada agente na posição do problema a ser resolvido
    puzzleProblema(p);
    /*
    for(int x=0;x<tamanho;x++)
    {
        for(int y=0;y<tamanho;y++)
        {
            //Varre todos
            for(int i=0 ;i<caminhoLista.size();i++)
            {
                a=(agente)caminhoLista.get(i);
                //Localiza agente com o numero igual a p[x][y] do problema
                if(a.getNumero()==p[x][y])
                {
                    a.setPosicao_atual_x(x);
                    a.setPosicao_atual_y(y);
                    tabuleiro[x][y]=a;
                    break;
                }
            }
        }
    }
    */

    ////System.out.print("\nProblema");
    imprimeTabuleiro();
    //////System.out.print("\nPosicao P(1,1)= " + tabuleiro[1][0].getNumero());
    //Tenta satisfazer os agentes na ordem do caminho gerado
    ////System.out.println("\nTenta satisfazer os agentes na ordem do caminho gerado");
    //for(int i=0;i<caminhoLista.size();i++)
    //O primeiro agente da lista é o primeiro do caminho
    a = (agente) caminhoLista.get(0);
    a.setPrimeiro(1);
    for(int i=0;i<num_agentes;i++)
    {
        a = (agente) caminhoLista.get(i);
        //Recupera agente anterior
        cont = i-1;
        if(cont>=0)
            a_temp = (agente) caminhoLista.get(cont);
        else
            a_temp = a;
        //Se o caminho do agente atual é dirente do anterior, bloqueia caminho anterior e muda o estado dos agentes
        if(a.getDistVazio()!= a_temp.getDistVazio())
        {
          //Agente "a" é o primeiro do proximo caminho
          a.setPrimeiro(1);
          //Muda estado do ultimo agente, bloqueando ele no caminho
          a_temp.setEstado(caminho);
          //Agente anterior é o ultimo
          a_temp.setUltimo(1);
            do
            {
                cont --;
                //Recupera agentes anteriores
                a_temp = (agente) caminhoLista.get(cont);
                //Muda estado do agente, colocando ele no caminho
                a_temp.setEstado(caminho);
            }while(cont>0);
        }
        //agente v = a.getVazio();
       //if(v!=null)
       //     ////System.out.println("É o vazio na posição: P("+ v.getPosicao_atual_x()+"," + v.getPosicao_atual_y()+")");
        //else
            //////System.out.println("Vazio não existe");
        a.setEstado(atacando);
        System.out.println("\nAgente "+a.getNumero()+" da posicao P(" + a.getPosicao_atual_x()+ ","+ a.getPosicao_atual_y()+ ") tenta ir para a posicao P(" + a.getPosicao_objetivo_x() + ","+ a.getPosicao_objetivo_y() + ") para ficar satisfeito:");
        a.tentaSatisfazer(a.getPosicao_objetivo_x(),a.getPosicao_objetivo_y());
        //caminho_ant = a.getDistVazio();

        //Se o agente não é o primeiro do caminho
        if(a.getPrimeiro()==0)
            {
               //O anterior deixa de ser o ultimo
               a_temp.setUltimo(0);
               //O próximo passa ser o último
               a.setUltimo(1);
            }
       //imprimeTabuleiro();
    }
}

public void imprimeSolucao()
{
    solucao.imprime();
}

//Gera puzzle (tabuleiro) de acordo com o problema
public void puzzleProblema(Integer[][] p)
{
    agente a;
    //Inicializa cada agente na posição do problema a ser resolvido
    for(int x=0;x<tamanho;x++)
    {
        for(int y=0;y<tamanho;y++)
        {
            //Varre todos
            for(int i=0 ;i<caminhoLista.size();i++)
            {
                a=(agente)caminhoLista.get(i);
                //Localiza agente com o numero igual a p[x][y] do problema
                if(a.getNumero()==p[x][y])
                {
                    a.setPosicao_atual_x(x);
                    a.setPosicao_atual_y(y);
                    tabuleiro[x][y]=a;
                    break;
                }
            }
        }
    }
}
//Cria caminho a partir do objetivo geral
public void geraCaminho(Integer[][] c)
{
    //Posição do azulejo no caminho
    int pos_x;
    int pos_y;
    //Agente temporario
    agente a;
    //Distancia da borda ao vazio
    int distVazio;
    //Cria array contendo o caminho para a solução
    caminhoLista = new ArrayList();


   //Encontra a posição do vazio e posicioa ele no canto
    for(int x=0;x<tamanho;x++)
        for(int y=0;y<tamanho;y++)
        {
            if(c[x][y]==0)
            {
                //Salva posição do vazio para retorna quando obter a solução
                x_vazio = x;
                y_vazio = y;
                //Posiciona o vazio no canto
                while(x<(tamanho-1))
                {
                    c[x][y]=c[x+1][y];
                    c[x+1][y]=0;
                    x++;
                }
                while(y<(tamanho-1))
                {
                    c[x][y]=c[x][y+1];
                    c[x][y+1]=0;
                    y++;
                }
                break;
            }
        }

    //Gera puzzle a partir do objetivo
    geraPuzzleOrdenado(c);


//Pega agente na posição mais a direita e da parte superior
    pos_x = 0;
    pos_y = tamanho -1;
    a = tabuleiro[pos_x][pos_y];
//Retorna distância de "a" até o "vazio"
    distVazio = a.getDistVazio();
    //Gera o caminho objetivo
    ////System.out.println("Caminho de execução de cada agente\n");
    while(distVazio>1)
    {
        //Borda superior e depois lateral esquerda
        //Linha
        for(int x=0;x<tamanho;x++)
        {
            //Coluna
            for(int y=(tamanho-1);y>=0;y--)
            {
               a = tabuleiro[x][y];
               //Pega agentes com a mesma distância do vazio
               if(a.getDistVazio()==distVazio)
               {
                //Armazena número do agente
                a.setNumero(c[x][y]);
                //Armazena posição do vazio
                a.setVazio(agente_vazio);
                //Limpa bloqueio do agente
                //a.setBloqueio_x(a.getBloqueio_x());
                //a.setBloqueio_y(a.getBloqueio_y());
                //Adiciona agente na lista
                caminhoLista.add(a);
                a.imprimeAgente();
               }
            }
        }
        //
        distVazio--;
        //Borda lateral esquerda e depois Borda superior
        //Linha
        for(int x=(tamanho-1);x>0;x--)
        {
            //Coluna
            for(int y=0;y<=(tamanho-1);y++)
            {
               a = tabuleiro[x][y];
               if(a.getDistVazio()==distVazio)
               {
                a.setNumero(c[x][y]);
                //Armazena posição do vazio
                a.setVazio(agente_vazio);
                //Limpa bloqueio do agente
                //a.setBloqueio_x(a.getBloqueio_x());
                //a.setBloqueio_y(a.getBloqueio_y());
                caminhoLista.add(a);
                a.imprimeAgente();
               }
            }
        }
        distVazio--;

    }
}
//Gera puzzle ordenado(tabuleiro) na ordem correta
public void geraPuzzleOrdenado(Integer[][] c)
{
   //Agente temporario
    agente a;
       //Cria tabuleiro contendo os agentes nas posições corretas ou seja no objetivo especifico de cada um
    for(int x=0; x<tamanho; x++)
    {
        for( int y=0; y<tamanho;y++)
        {
            a = new agente(x,y,solucao);
            //Maior distancia entre o agente e o zero
            if((tamanho-x)>(tamanho-y))
                a.setDistVazio(tamanho-x);
            else
                a.setDistVazio(tamanho-y);
            //Numero do agente
            a.setNumero(c[x][y]);
            //Objetivo do agente
            a.setPosicao_objetivo_x(x);
            a.setPosicao_objetivo_y(y);
            //Tabuleiro o qual o agente pertence
            a.setTabuleiro(tabuleiro);
            //Tamanho do tabuleiro
            a.setTamanho(tamanho);
            //Insere agente no tabuleiro na posição objetivo
            tabuleiro[x][y] = a;
            //Se o agente for o vazio guarda, armazena ele
            if(a.getNumero()==0)
              agente_vazio = a;
        }
    }


  /*
    //Número do agente (azulejo ou peça)
  int num = 0;
  //caminho = new Integer[tamanho*tamanho];

  //Inicializa os caminhos que ainda não foram percorridos com -1
  //for(int i=0;i<=tamanho*tamanho;i++)
  //{
  //    caminho[i]=-1;
  //}

  //Inicializa caminho pelas borda do topo do puzzle e à direita
  //caminho [0] = tabuleiro[0][tamanho-1].getNumero();

  for(int x=0; x<tamanho; x++)
    {
        for( int y=0; y<tamanho;y++)
        {
            //a.setPosicao_atual_x(x);
            //a.setPosicao_atual_y(y);
            tabuleiro[x][y].setPosicao_objetivo_x(x);
            tabuleiro[x][y].setPosicao_objetivo_y(y);
            tabuleiro[x][y].setNumero(num);
            num++;
        }
    }
    tabuleiro[1][1].setPosicao_objetivo_x(2);
    tabuleiro[1][1].setPosicao_objetivo_y(2);
    */
}


//Verifica se todos agentes estão satisfeitos
public void agentesSatisfeitos()
{
 int s = 0;
   for(int x=0; x<tamanho; x++)
    {
      //////System.out.print("\n");
      for( int y=0; y<tamanho;y++)
      {
          if(tabuleiro[x][y].estaSatisfeito() == 0)
          {
                ////System.out.print("O agente "+ tabuleiro[x][y].getNumero() +" da posição P["+ tabuleiro[x][y].getPosicao_atual_x()+","+ tabuleiro[x][y].getPosicao_atual_y() +"] não está satisfeito! ");
                ////System.out.print("Seu objetivo é : P[" + tabuleiro[x][y].getPosicao_objetivo_x() + "," + tabuleiro[x][y].getPosicao_objetivo_y() + "]\n");
                s = 1;
          }
      }
    }
 if(s == 0)
    System.out.print("Todos os agentes estão satisfeitos!\n");
}
public void imprimeTabuleiro()
{
System.out.print("\nTabuleiro " + tamanho + "x" + tamanho);
    for(int x=0; x<tamanho; x++)
    {
      System.out.print("\n");
      for( int y=0; y<tamanho;y++)
        {
          System.out.print(" "+tabuleiro[x][y].getNumero());
        }
    }
    System.out.print("\n");
}

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void numeroTrocas()
    {
        int num= 0;
        for(int i=0;i<caminhoLista.size();i++)
            num += ((agente) caminhoLista.get(i)).getNumero();
        System.out.println("Número de trocas dos agentes:"+num);
    }
}