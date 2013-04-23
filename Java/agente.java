/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package funcoes_usuario;

/**
 *
 * @author fabiano
 */
public class agente {

    //Constantes
    static final int caminho = 4; //Faz parte de um caminho já completo
    static final int bloqueado=3; //Não sai do caminho mais
    static final int atacando=2;  //Esta atacando
    static final int fugindo=1;   //Esta fugindo de um ataque
    static final int aguardando=0;//Esta aguardando ser satisfeito

    //Variáveis
    //Armazena a posição atual do agente no tabuleiro
    private int posicao_atual_x;
    private int posicao_atual_y;
    //Armazena a posição objetivo do agente no tabuleiro
    private int posicao_objetivo_x;
    private int posicao_objetivo_y;
    //Estado do agente(atacando=2,fugindo=1,aguardando=0)
    private int estado;
    //Caminho bloqueado
    private int bloqueio_x;
    private int bloqueio_y;
    //Armazena a informação se o agente está satisfeito "1" ou se não "0"
    private int satisfeito;
    //Armazena a informação se o agente está sofrendo algum ataque "1" ou se não "0"
    private int agredido;
    //Armazena o número da peça ou do azulejo
    private int numero;
    //Distancia do vazio
    private int distVazio;
    //Tabuleiro onde o agente está
    private agente[][] tabuleiro;
    //Tamanho do tabuleiro
    private int tamanho;
    //Armazena apontador para o vazio
    private agente vazio;
    //Armazena qual agente esta atacando
    private agente atacante;
    //Se o agente é o primeiro do caminho
    private int primeiro;
    //Se o agente é o primeiro do caminho
    private int ultimo;
    //Armazena movimentos da solução
    solucaoPuzzle solucao;
    //Construtor do agente
    int trocas;
    public agente(int x,int y)
    {
        posicao_atual_x = x;
        posicao_atual_y = y;
        estado = aguardando;
        bloqueio_x = -1;
        bloqueio_y = -1;
        primeiro = 0;
        ultimo = 0;
        solucao = null;
        trocas = 0;
    }

    public agente(int x,int y, solucaoPuzzle s)
    {
        posicao_atual_x = x;
        posicao_atual_y = y;
        estado = aguardando;
        bloqueio_x = -1;
        bloqueio_y = -1;
        primeiro = 0;
        ultimo = 0;
        solucao = s;
    }
//Encontra posição ou agente mais próximo do objetivo
    public agente agenteProxObjetivo(int obj_x,int obj_y)
    {
        //Agente mais próximo ao objetivo no inicio é ele mesmo
        agente a = this;
        agente a_temp = null;
        //Coordenadas do agente mais próximo
        int x_agente = 0;
        int y_agente = 0;
        //Distância até o agente mais proximo
        int distProx = tamanho*2;
        //Distância temporária
        int distTemp,distTemp1,distTemp2;
        //Comportamentos
        boolean comp0,comp1,comp2,comp3,comp4,comp5,comp6;
        //Testa todas possibilidades possíveis de movimento
       for(int pos=0;pos<5;pos++)
       {
           switch (pos)
           {
               //Agente à esquerda
               case 0:
               x_agente=this.posicao_atual_x;
               y_agente=this.posicao_atual_y-1;
               break;
               //Agente na parte inferior
               case 1:
               x_agente=this.posicao_atual_x+1;
               y_agente=this.posicao_atual_y;
               break;
               //Agente à direita
               case 2:
               x_agente=this.posicao_atual_x;
               y_agente=this.posicao_atual_y+1;
               break;
               //Agente na parte superior
               case 3:
               x_agente=this.posicao_atual_x-1;
               y_agente=this.posicao_atual_y;
               break;
               //Se tentou tudo, tenta atacar agente que o atacou
               case 4:
                   if(this.atacante !=null && a==this)
                   {
                   //Executa contra ataque
                         System.out.println("Contra ataque!");
                         return atacante;
                   }
                   //  //Vai para posição bloqueada
                   //  a = tabuleiro[this.bloqueio_x][this.bloqueio_y];
                     //Bloqueia posição atual
                   //  this.setBloqueio_x(this.posicao_atual_x);
                   //  this.setBloqueio_y(this.posicao_atual_y);
                   //  System.out.println("Não encontrou nenhum caminho");
                   //}
               //a = tabuleiro[this.bloqueio_x][bloqueio_y];
               //break;
               //Caso não tenha encontrado nenhum agente "aguardando"
               //case 4:
               //x_agente=this.posicao_atual_x;
               //y_agente=this.posicao_atual_y+1;
               //break;
           }

           //Verifica se  a posição está dentro do tabuleiro
           if(x_agente>=0 && x_agente<tamanho && y_agente>=0 && y_agente<tamanho)
           {
               //Agente candidato mais próximo
               a_temp = tabuleiro[x_agente][y_agente];
               //if(a_temp.getNumero()==2)
               //    a_temp.imprimeAgente();
               //{
                    //Calcula distância absoluta até o objetivo
                    //distTemp1 = Math.abs(x_agente-obj_x) + 1;
                    distTemp1 = Math.abs(x_agente-obj_x);
                    //distTemp2 = Math.abs(y_agente-obj_y) + 1;
                    distTemp2 = Math.abs(y_agente-obj_y);
                    distTemp = distTemp1 + distTemp2;
                    //if(distTemp1>distTemp2)
                    //    distTemp = distTemp1;
                    //else
                    //    distTemp = distTemp2;


                    //Só aceita se a posição não estiver bloqueada e se o agente não está atacando outro ou fugindo (-1 a posição esta livre)
                    //comp0=((((x_agente!=this.getBloqueio_x() || y_agente!=this.getBloqueio_y())||(a_temp.getBloqueio_x()==-1 && a_temp.getBloqueio_y()==-1 )) && a_temp.getEstado()!=fugindo && a_temp.getEstado()!=atacando));

                    //Atualiza comportamentos (Verdadeiro ou Falso) em função do agente (posição) escolhido

                    //O agente escolhido não é o próprio agente que o atacou e não está fugindo e nem atacando e não esta em um caminho
                    comp0 = (a_temp!= this.atacante && a_temp.getEstado()!=caminho);
                    //comp0 = (a_temp!= this.atacante && a_temp.getEstado()!=fugindo && a_temp.getEstado()!=atacando);

                    //Se o agente estiver sastisfeito(bloqueado para sair do caminho), só troca se for para o mesmo caminho
                    comp1=(this.getEstado()==bloqueado);

                    //Comportamento caso a posição mais próxima seja a posição objetivo
                    comp2=(obj_x==x_agente && obj_y==y_agente);

                    //Comportamento caso tenha encontrado uma menor distância em relação a atual ou que estege aguardando
                    comp3=((distTemp<distProx && a_temp.getEstado()!=bloqueado && a_temp.getEstado()!=atacando) || (a_temp.getEstado()==aguardando && (a.getEstado()==bloqueado || a.getEstado()==atacando))||(a==this && (a_temp.getEstado()==bloqueado || a_temp.getEstado()==atacando)));

                    //Comportamento caso a posição mais proxima seja o vazio (mesma distância anterior)
                    comp4 =(a_temp.getNumero()==0 && distTemp<=distProx);

                    //Comportamento caso tenha encontrado uma posição com mesma distância mas com agente não bloqueado nem atacando
                    //comp5= (a_temp.getEstado()==aguardando && (a.getEstado()==bloqueado || a.getEstado()==atacando) && distTemp==distProx);
                    comp5= (a_temp.getEstado()==aguardando && (a.getEstado()==bloqueado || a.getEstado()==atacando));

                    //Só permite ataque de agentes não bloqueados a agentes bloqueados caso estes sejam o primeiro ou ultimo do caminho
                    comp6=(a_temp.getEstado()!=bloqueado || a_temp.getUltimo()==1);
                    //|| a_temp.getPrimeiro()==1
           //Executa comportamento
           //Só aceita se a posição não estiver bloqueada
           if(comp0)
           {
          //Se o agente já está sastisfeito (no caminho ou posição correta) só troca com outro ou com vazio  se tiverem no mesmo caminho
                if(comp1)
                    {
                    //Maior distancia entre o agente e o vazio(objetivo)
                        if((tamanho-x_agente)>(tamanho-y_agente))
                            distTemp1=(tamanho-x_agente);
                        else
                            distTemp1=(tamanho-y_agente);
                        //Verifica se a_temp esta no mesmo caminho
                        //if(this.getDistVazio()==a_temp.getDistVazio())
                        if(this.getDistVazio()==distTemp1)
                            //if((a_temp.getEstado()==bloqueado) || a_temp.getNumero()==0)
                            return a_temp;
                    }
                else
                //Só permite ataque de agentes não bloqueados a agentes bloqueados caso estes sejam o primeiro ou ultimo do caminho
                if(comp6)
                {
                    //Se o agente não está sastisfeito
                    //else
                        //Se a posição mais próxima for a posição objetivo
                        if(comp2)
                        {
                            distProx = distTemp;
                            a = a_temp;
                            return a;
                        }
                        else
                            //Se encontrou uma menor distância em relação a atual
                            if(comp3)
                            {
                                distProx = distTemp;
                                a = a_temp;
                            }
                            else
                                //Se a posição mais proxima é o vazio mas com mesma distância anterior
                                if(comp4)
                                    a = a_temp;
                                else
                                    //Se encontrou uma posição com mesma distância mas com agente não bloqueado
                                    if(comp5)
                                        a = a_temp;
               }//If Comp6

           }//If Comp0
                    //Verifica se a ditancia encontra é menor que a atual ou se o agente tem igual distancia mais tem melhor estado
                    //Só retorna o agente a objetivo (dis)
                    //if(distTemp<distProx || (a_temp.getEstado()==aguardando && a.getEstado()==bloqueado && distTemp==distProx))
                    //{
                    //   distProx = distTemp;
                    //   a = a_temp;
                    //}
           }
       }
       return a;
    }

    //Se há um caminho livre, foge para ele ao receber um ataque
    public int fugaSemAtaque(agente posObjetivo)
    {
        if(satisfacaSemAtacar(posObjetivo)==1)
          return 1;
          //      if(posObjetivo.tentaSatisfazer(vazio.posicao_atual_x, vazio.posicao_atual_y)==1)
          //return 1;
          return 0;
    }
    //Se não há caminho livre, ataque para poder fugir
    public int fugaComAtaque(agente posObjetivo)
    {
        //System.out.println("Agente numero "+ this.getNumero()+" ataca agente numero " + posObjetivo.getNumero());
        if(satisfacaComAtaque(posObjetivo)==1)
            return 1;
        return 0;
    }
    //Tenta fugir de um ataque de do agente "a"
    public int tentaFugir(agente a)
    {
        //Variávelcom sucesso da fuga
        int sucesso= 1;
        //Armazena posição objetivo
        int x_obj,y_obj;
        //Armazena posição atual
        int x_atual,y_atual;
        //Encontra posição mais próxima do vazio que não esteje bloqueada nem atacando
        //System.out.println("Agente "+ this.getNumero()+" da posicao P(" + this.posicao_atual_x+ ","+ this.posicao_atual_y +") tentando fugir para: P("+ this.vazio.posicao_atual_x + "," +this.vazio.posicao_atual_y +")");
        //Agente que esta atacando
        //agente atacante = tabuleiro[this.bloqueio_x][this.bloqueio_y];
         atacante = a;
        if(this.getEstado()==aguardando)
            this.setEstado(fugindo);
        //if(this.vazio!=null)
        //    System.out.println("É o vazio na posição: P("+ this.vazio.posicao_atual_x +"," + this.getPosicao_atual_y()+")");
        //else
        //    System.out.println("Vazio não existe");
        //if(this.getNumero()==10)
        //    System.out.println("Este é o 10 mesmo");
        x_obj = this.vazio.getPosicao_atual_x();
        y_obj = this.vazio.getPosicao_atual_y();
        x_atual = this.getPosicao_atual_x();
        y_atual = this.getPosicao_atual_y();
        //if(this.getNumero()==0)
        //    System.out.println("É o vazio na posição: P"+ x_obj +"," + y_obj);

        //Encontra posição para fuga
        agente objetivoFuga = agenteProxObjetivo(this.vazio.posicao_atual_x,this.vazio.posicao_atual_y);
        x_obj = objetivoFuga.getPosicao_atual_x();
        y_obj = objetivoFuga.getPosicao_atual_y();

        //if(this.numero==3)
        //    objetivoFuga.imprimeAgente();

        //Tenta fugir sem atacar
        if(fugaSemAtaque(objetivoFuga)==1)
        {
            if(this.getEstado()==fugindo)
                this.setEstado(aguardando);
            //Sucesso na fuga
            return sucesso;
        }

        //Precisou de contratacar
        if(atacante == objetivoFuga)
        {
            //Agente não conseguiu fugir
            sucesso = 0;
           //Desloqueia posição atual anterior ao ataque para não voltar para ela
           //this.setBloqueio_x(-1);
           //this.setBloqueio_y(-1);
           //Bloqueia atacante de atacar
           //atacante.setBloqueio_x(this.posicao_atual_x);
           //atacante.setBloqueio_y(this.posicao_atual_y);
        }

        if(fugaComAtaque(objetivoFuga)==1)
        {
            //if(objetivoFuga.getNumero()==10)
            //    System.out.println("É 10.2");
            satisfacaSemAtacar(tabuleiro[x_obj][y_obj]);
            //if(this.getEstado()==fugindo)
            //    this.setEstado(aguardando);
        }

        return sucesso;
    }
    //Se para alcançar sua meta o agente não precisa de atacar outro
    public int satisfacaSemAtacar(agente posObjetivo)
    {
        //Posição do vazio antes de trocar de lugar
        int temp_x,temp_y;
        //Troca, se a posição objetivo é o vazio ou seja sem atacar outro agente
        if(posObjetivo.numero==0)
        {
            solucao.adicionaSolucao(this,posObjetivo);
            System.out.println("Agente numero " + this.getNumero()+ " da posicao P(" + this.posicao_atual_x+ ","+ this.posicao_atual_y +")" + " vai para posicao P(" +posObjetivo.posicao_atual_x+ ","+posObjetivo.posicao_atual_y +")");
            temp_x = posObjetivo.posicao_atual_x;
            temp_y = posObjetivo.posicao_atual_y;
            tabuleiro[temp_x][temp_y]=this;
            tabuleiro[posicao_atual_x][posicao_atual_y]=posObjetivo;
            posObjetivo.setPosicao_atual_x(this.posicao_atual_x);
            posObjetivo.setPosicao_atual_y(this.posicao_atual_y);
            this.posicao_atual_x = temp_x;
            this.posicao_atual_y = temp_y;
            //Se tiver algum atacante limpa
            this.atacante = null;
            //Se o agente estava fugindo coloca no estado de aguardando
            if(this.getEstado()==fugindo)
                this.setEstado(aguardando);
            //Adiciona agente na solução
            trocas++;
            return 1;
        }
        return 0;
    }
    //Se  para alcançar sua meta o agente precisa de atacar outro
    public int satisfacaComAtaque(agente posObjetivo)
    {
        //Armazena posição objetivo
        int x_obj,y_obj,num;
        x_obj = posObjetivo.getPosicao_atual_x();
        y_obj = posObjetivo.getPosicao_atual_y();
        //Coloca o agente na posição de ataque
        //this.setEstado(atacando);
        //Bloqueia posição atual contra ataque do seu atacante
        posObjetivo.setBloqueio_x(this.posicao_atual_x);
        posObjetivo.setBloqueio_y(this.posicao_atual_y);
        //Tenta fugir do ataque
        //posObjetivo.tentaFugir();
        //Se conseguiu fugir, permiti mudar de posição
        //if(posObjetivo.getNumero()==10)
        //{
            //posObjetivo.tentaFugir();
        //    posObjetivo.imprimeAgente();
        //    num = posObjetivo.getNumero();
         //   System.out.println("Certo 10.3");
        //}
        if(posObjetivo.tentaFugir(this)==1)
        {
            if(tabuleiro[x_obj][y_obj].getNumero()==0)
            {
                //this.setEstado(bloqueado);
                posObjetivo.setBloqueio_x(-1);
                posObjetivo.setBloqueio_y(-1);
                return satisfacaSemAtacar(tabuleiro[x_obj][y_obj]);
            }
        }
        else
            return 0;
        //Desbloqueia agente e permiti atacar atacante
        //posObjetivo.setBloqueio_x(-1);
        //posObjetivo.setBloqueio_y(-1);
        //Passa como objetivo do agente atacado ir para o local mais próximo do vazio
        //if(posObjetivo.tentaSatisfazer(vazio.posicao_atual_x, vazio.posicao_atual_y)==1)
        //  return 1;
        return 1;
    }
    //Tenta satisfazer a si mesmo
    public int tentaSatisfazer(int obj_x,int obj_y)
    {
     //
     agente objetivoAtual;

     //int contador= tamanho+1;//
     //System.out.println("\nAgente "+this.getNumero()+" da posicao P(" + this.posicao_atual_x+ ","+ this.posicao_atual_y+ ") tentando ser satisfeito:");
     //Enquanto não alcança objetivo continua tentando
     while((obj_x!= this.getPosicao_atual_x() || obj_y!= this.getPosicao_atual_y()))
     {
         //contador--;
        //Encontra a posição mais próxima do se objetivo
        //objetivoAtual = agenteProxObjetivo(posicao_objetivo_x,posicao_objetivo_y);
        objetivoAtual = agenteProxObjetivo(obj_x,obj_y);
        System.out.println ("\nPosição objetivo atual:" + objetivoAtual.getNumero()+"\n");
        if(satisfacaSemAtacar(objetivoAtual)==1)
        {
            this.getSatisfeito();
            System.out.println("\nTabuleiro após agente tentar se satisfazer:");
            imprimeTabuleiro();
            continue;
        }
        else
            if(satisfacaComAtaque(objetivoAtual)==1)
                this.getSatisfeito();
            System.out.println("\nTabuleiro após agente tentar se satisfazer:");
            imprimeTabuleiro();
            //if(this.getDistVazio()==2)
     }

     //if(this.getSatisfeito()==1)
     //{
        this.setBloqueio_x(-1);
        this.setBloqueio_y(-1);
        System.out.println("\nAgente bloqueado:" + this.getNumero());
        this.setEstado(bloqueado);
     //}
     //else
     //   this.setEstado(aguardando);

        return 0;
    }

    public int getDistVazio() {
        return distVazio;
    }

    public void setDistVazio(int distVazio) {
        this.distVazio = distVazio;
    }

    public int estaSatisfeito()
    {
        if((posicao_atual_x == posicao_objetivo_x) && (posicao_atual_y == posicao_objetivo_y))
            satisfeito = 1;
        else
            satisfeito = 0;

        return satisfeito;
    }


    public int getAgredido() {
        return agredido;
    }

    public void setAgredido(int agredido) {
        this.agredido = agredido;
    }

    public int getPosicao_restrita_x() {
        return posicao_restrita_x;
    }

    public void setPosicao_restrita_x(int posicao_restrita_x) {
        this.posicao_restrita_x = posicao_restrita_x;
    }

    public int getPosicao_restrita_y() {
        return posicao_restrita_y;
    }

    public void setPosicao_restrita_y(int posicao_restrita_y) {
        this.posicao_restrita_y = posicao_restrita_y;
    }
    private int posicao_restrita_x;
    private int posicao_restrita_y;

    public int getPosicao_atual_x() {
        return posicao_atual_x;
    }

    public void setPosicao_atual_x(int posicao_atual_x) {
        this.posicao_atual_x = posicao_atual_x;
    }

    public int getPosicao_atual_y() {
        return posicao_atual_y;
    }

    public void setPosicao_atual_y(int posicao_atual_y) {
        this.posicao_atual_y = posicao_atual_y;
    }

    public int getPosicao_objetivo_x() {
        return posicao_objetivo_x;
    }

    public void setPosicao_objetivo_x(int posicao_objetivo_x) {
        this.posicao_objetivo_x = posicao_objetivo_x;
    }

    public int getPosicao_objetivo_y() {
        return posicao_objetivo_y;
    }

    public void setPosicao_objetivo_y(int posicao_objetivo_y) {
        this.posicao_objetivo_y = posicao_objetivo_y;
    }

    public int getSatisfeito() {
        return satisfeito;
    }

    public void setSatisfeito(int satisfeito) {
        this.satisfeito = satisfeito;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setTabuleiro(agente[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void setVazio(agente vazio) {
        this.vazio = vazio;
    }

    public int getBloqueio_x() {
        return bloqueio_x;
    }

    public void setBloqueio_x(int bloqueio_x) {
        this.bloqueio_x = bloqueio_x;
    }

    public int getBloqueio_y() {
        return bloqueio_y;
    }

    public void setBloqueio_y(int bloqueio_y) {
        this.bloqueio_y = bloqueio_y;
    }

    public void imprimeAgente()
    {
        System.out.println("Número do agente:"+this.getNumero());
        //System.out.println("    Posição atual: P("+this.getPosicao_atual_x() +"," + this.getPosicao_atual_y()+")");
        System.out.println("    Posição objetivo: P("+this.getPosicao_objetivo_x() +"," + this.getPosicao_objetivo_y()+")");
        //System.out.println("    Posição bloqueada: P("+this.getBloqueio_x() +"," + this.getBloqueio_y()+")");
        System.out.println("    Estado atual:" + this.getEstado());
        System.out.print("\n");
    }

    public agente getVazio() {
        return vazio;
    }

    public int getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(int primeiro) {
        this.primeiro = primeiro;
    }

    public int getUltimo() {
        return ultimo;
    }

    public void setUltimo(int ultimo) {
        this.ultimo = ultimo;
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


}