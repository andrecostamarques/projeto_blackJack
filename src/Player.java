import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Player {
    final int id; //valor de id que vai sendo adicionado 1 para cada nova pessoa
    static int contador = 0;

    final String name;
    private int sumPontos;
    private ArrayList<Card> deckPlayer;


    public Player(String name){
        this.name = name;
        this.sumPontos = 0;
        this.id = contador;
        contador++;
        this.deckPlayer = new ArrayList<Card>();
    }

    public void receberCarta(Card cartaRecebida) {
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

    public void add10Pontos(){
        sumPontos = sumPontos + 10;
    }

    public String toString(){
        return "Jogador " + name + " ("+ id + ")" + " com " + sumPontos + " pontos";
    }

}
