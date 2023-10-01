import java.security.SecureRandom; //puxa a funcao de random numbers
public class DeckofCards {  //classe deck of cards usa o objeto de cards pra criar o deck
    private static final int numberOfCards = 52; //variavel estatica para a quantidade de cartas no deck
    private static final SecureRandom randomNumbers = new SecureRandom(); //numero aleatorio
    private int contadorCard;   //contador das cartas
    private Card[] deck;

    public DeckofCards(){ //construtor da criação do baralho
        String[] faces = {"Ás", "Dois", "Três", "Quatro", "Cinco", "Seis",
                "Sete", "Oito", "Nove", "Dez", "Valete", "Dama", "Rei"};
        String[] suits = {"Copas", "Ouro", "Paus", "Espadas"};

        deck = new Card[numberOfCards]; //cria um array de cartas com a quantidade de cartas de 1 baralho
        contadorCard=0; //inicializa o contador de cartas como zero
        int temp = 0;   //cria um inteiro temporario para mandar o valor das cartas
        for(int count =0; count<deck.length;count++){   //popula o baralho das cartas

            if(count%13>8){
                temp = 10;}else{    //setando o valor de valete, dama e rei como 10
                temp = (count%13) + 1;    //tdo resto recebe seu valor normal
            }
            deck[count]=new Card(faces[count%13],suits[count/13],temp); //cria um array de cartas mandando os valores de nome, naipe e valor
        }
    }
    public void embaralhar(){
        contadorCard = 0;
        for(int count = 0; count < deck.length; count++){ //vai rodar o baralho inteiro
            int second = randomNumbers.nextInt(numberOfCards); //pega um numero aleatorio de 0 até 52-1

            Card temp = deck[count]; //pega a carta salva no local count do baralho
            deck[count]=deck[second];   //swap de posicao a carta aleatoria com a carta que foi salva
            deck[second]=temp;  //troca as cartas de lugar 52 vezes
        }
    }

    public Card dealCard() { //retorna o objeto de carta seguinte do baralho
        //Determine whether Cards remain to be dealt
        if (contadorCard < deck.length)
            return deck[contadorCard++]; //Return current Card in array
        else
            return null; //Return null to indicate that all Cards were dealt

    }
}
