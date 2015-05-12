package arrays;

/**
 *
 * @author Vasia
 */
public class Card implements Comparable{
    
    String suitString;
    int suit; //0-3
    int value; //2-14

    public int getValue(){
        return value;
    }
    
    public int getSuit(){
        return suit;
    }
    
    public Card(int suit, int value){
        this.suit = suit;
        this.value = value;
        
        switch(suit){
            case 0: suitString = "clubs"; break;
            case 1: suitString = "diamond"; break;
                case 2: suitString = "<3"; break;
             case 3: suitString = "spades"; break;
        }
    }
    
    @Override
    public int compareTo(Object o) {
        Card card = (Card)o;
        if (suit > card.getSuit())
            return 1;
        else if (suit == card.getSuit()){
            if (value > card.getValue())
                return 1;
            else if (value == card.getValue())
                return 0;
            else return -1;
        }
        else return -1;
    }

}
