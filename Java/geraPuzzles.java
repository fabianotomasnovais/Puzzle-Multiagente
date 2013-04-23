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
public class geraPuzzles {

public geraPuzzles()
{

}

//Gera puzzle objetivo
public Integer [][] objetivoPuzzle(int tamanho)
{       int n=1;
        Integer [][] objetivo = new Integer[tamanho][tamanho];
        for(int x=0;x<tamanho;x++)
           for(int y=0;y<tamanho;y++)
           {
               objetivo[x][y]=n;
               n++;
           }
        objetivo[tamanho-1][tamanho-1]=0;

        return objetivo;
}

//Gera puzzle válidos
public Integer [][] geraPuzzleValido(int tamanho)
{
 int x,y,n,t;
 n=1;
 t=1000;
 int xv_atual=tamanho-1;
 int yv_atual=tamanho-1;

 int [] x_v ={1,-1,0,0};
 int [] y_v ={0,0,1,-1};

Random r = new Random(System.nanoTime());

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

//Gera puzzles válidos e inválidos
public Integer [][] geraPuzzle(int tamanho)
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

}


