
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DeckofCards baralho; //inicializando o objeto baralho da class deckofcards
        Player[] players;    //incia o array de players que contem a quantidade de jogadores
        Scanner input = new Scanner(System.in); //cria o scanner de input
        int qntJogadores;
        boolean flagGame = true; //<- ver com o takeo, nao precisa ter public? posso acessar de onde?



    System.out.println("Quantos jogadores terão: ");
        qntJogadores = input.nextInt();     //pega a quantidade de jogadores que terão
        input.nextLine();


        players = new Player[qntJogadores]; //cria uma array com a quantidade de jogadores

        for(int i =0;i<players.length;i++){
            System.out.println("Nome do jogador "+ i + ": ");
            String userName = input.nextLine();  // Read user input
            players[i] = new Player(userName);
        }

//        for (Player player : players) {
//            System.out.print(player);     debugando se os nomes estao sendo salvos certinho
//            System.out.println();
//        }

        baralho = new DeckofCards();    //inicializa a variavel baralho e embaralha ela
        baralho.embaralhar();   //embaralha pra caralho o brabo baralho nao embaralhado  <- trava lingua

        // --- até aqui: 1. inicializou os jogadores 2. criou e embaralhou o deck
        // --- falta: 1. inicializar o loop do jogo


            for(int i = 0; i < 2; i++) //
            {
                for(Player jogador: players)
                {
                    //cada jogador recebe uma carta do baralho por meio do método dealCard relacionado ao baralho
                    //no fim do for cada jogador terá recebido duas cartas
                    jogador.receberCarta(baralho.dealCard());
                    //recebe a carta no baralho da pessoa
                    //chega se é um As
                    //pergunta se vai valer 11 ou 1

                    if(Objects.equals(jogador.getDeckPlayer().get(i).getName(), "Ás")){
                        System.out.println("Jogador" + jogador.getName() + ", voce recebeu um Ás, deseja mudar o valor para 11? Se sim digite 11, se não digite 0: ");    //senao ele pergunta qual valor quer
                        int temp = input.nextInt();
                        if (temp == 11) { //verifica os valores e define eles usando a função
                            jogador.add10Pontos();
                        }
                    }
                }

                printarMesa(players); //printa a mesa dos jogadores toda rodada
                }   //so vai ser executa no incio uma vez

        for(Player jogador: players){
            if (jogador.getSumPontos() == 21) {
                flagGame = false;   //checa se tem alg vencedor dps da primeira rodada
                System.out.println("\nBlackjack! O jogador " + jogador + " venceu!");
                break;
            }
        }   //senao tiver o jogo cotinua com o loop dele

        while(flagGame){
            //agr começa a loop do jogo de fato
            //chamar a checkforwin aqui -> se alg ja tiver feito 21 no primeiro round deve ganhar

            for(Player jogador: players){
                System.out.println();
                System.out.println("Jogador("+jogador.getSumPontos()+")" + jogador.getName() +" voce deseja: (1) Receber mais uma carta / (2) Check.");
                //pega a proxima ação do jogador
                int tempflag = input.nextInt();
                if(tempflag == 1){
                    jogador.receberCarta(baralho.dealCard()); //jogador vai receber mais uma carta -> sua pontuação vai contar

                    if(Objects.equals(jogador.getDeckPlayer().get(jogador.getDeckPlayer().size()-1).getName(), "Ás")){    //ve se a ultima carta recebida é um As
                        System.out.println("Jogador " + jogador.getName() + ", você recebu um Ás, deseja mudar o valor para 11? Se sim digite 11, se não digite 0: ");    //senao ele pergunta qual valor quer
                        int temp = input.nextInt();
                        if (temp == 11) { //verifica os valores e def4ine eles usando a função
                            jogador.add10Pontos();
                        }
                    }
                    System.out.println("A carta recebida foi: " + jogador.getDeckPlayer().get(jogador.getDeckPlayer().size()-1));
                    System.out.println("\nAgora sua mão está somando: "+ jogador.getSumPontos() + " pontos.");

                    if(jogador.getSumPontos() > 21){
                        System.out.println("Sua somatória é maior que 21, você perdeu.");
                    }
                    if(jogador.getSumPontos() == 21){
                        System.out.println("\nBlackjack! O jogador " + jogador + " venceu!");
                    }
                }
                if(tempflag == 2){
                    System.out.println("Voce continua com: "+ jogador.getSumPontos() + " pontos.");
                }
                //checkforwin p ver se esse jogador ganhou a partida
                //se ganhou vai rodar a vez de td mundo e vai acabar a partida ->flaggame = false
                //se ngn ganhou, o jogo vai simplesmente rodar de novo


            }
            if(checkForWin(players) == 1){
                flagGame=false; //o jogo vai finalizar e printar o vencedor
            }
            //as maos do jogadores já estão montadas agora
            //falta ver quem quer mais e ver quem ganhou

        }

    }
    private static void printarMesa(Player[] playersaux){

        System.out.println();
        System.out.println("<==== Mesa ====>");

        for(Player j: playersaux){
            System.out.println("-------------------------");
            System.out.print("Player: ");
            System.out.print("\t" + j.getName()); //printa o nome do playe
            System.out.println("\nCartas:");

            for(Card c: j.getDeckPlayer()){     //roda a mao do jogador printando todas as cartas que ele tem
                System.out.println("\t" + c.toString());
            }

            System.out.println("Pontos -> ");
            System.out.println("\t" + j.getSumPontos()); //printa a somatoria dos pontos do jogador
            System.out.println();
        }
        System.out.println("*===* Mesa *===*");
        System.out.println();

    }

    //dava p colocar ao inves de static como Player, mas acho que ficaria mais confuso, ai passei por argumento mesmo
    public static int checkForWin(Player[] playersaux){
        //funcao que vai checar quem tem 21 pontos
        //retorna 1 se teve ganhador, 0 se nao teve
        //retorna NULL se nao teve ganhador
        //atualiza a somatoria dos maiores numeros

        int sumWinPoints = 0;

        for(Player jogador: playersaux){
            if(jogador.getSumPontos() == 21){
                return 1;
            }
            if(jogador.getSumPontos() >= sumWinPoints && jogador.getSumPontos() < 21){
                sumWinPoints = jogador.getSumPontos(); //Compara para ver qual jogador ganhou
            }
        }
        for(Player j: playersaux){
            if(j.getSumPontos() == sumWinPoints){
                System.out.println("\nO jogador: " + j + " venceu!");
                return 1; //retorna o player com mais pontos
            }
        }

        return 0;


    }
}