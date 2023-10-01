public class Card {
    final String naipe; //instancia do naipe da carta
    final String name;  //instancia do nome da carta
    private int valor;  //instancia do valor da carta -> private pq pode ser mudado (no caso dos as)

    public Card(String name, String naipe, int valor){

        this.naipe = naipe;
        this.name = name;
        this.valor = valor;

    }

    public String toString(){
        return name + " de " + naipe;
    }

    public String getName() {
        return name;
    }

    public String getNaipe() {          //funcoes de pegar valores de instancia
        return naipe;
    }

    public int getValor() {
        return valor;
    }

    public void setAs11(){
        this.valor = 11;
    }



    //precisa criar uma funcao que muda o valor dos asesz
    //ja ta feita no deckofcards
}
