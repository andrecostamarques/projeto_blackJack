import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Player {
    final int id; //valor de id que vai sendo adicionado 1 para cada nova pessoa
    static int contador = 0;

    private String name;
    private int sumPontos;
    private ArrayList<Card> deckPlayer;
    Scanner sc= new Scanner(System.in);

    public Player(){
        this.sumPontos = 0;
        this.id = contador;
        contador++;
        this.deckPlayer = new ArrayList<Card>();
    }

    public void receberCarta(Card cartaRecebida) {
        if (Objects.equals(cartaRecebida.name, "Ás")) {   //verifica se é AS
                System.out.println("Qual valor de Ás deseja: 1/11");    //senao ele pergunta qual valor quer
                int temp = sc.nextInt();
                if (temp == 11) { //verifica os valores e define eles usando a função
                    cartaRecebida.setAs11();
                }
        }

        this.sumPontos = sumPontos + cartaRecebida.getValor();  //aumenta o valor da carta recebido na somatória
        this.deckPlayer.add(cartaRecebida); //insere o valor da carta direto no deck do plauyer

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getDeckPlayer() {    //funcoes de retornar valores
        return deckPlayer;
    }

    public int getSumPontos() {
        return sumPontos;
    }

}
