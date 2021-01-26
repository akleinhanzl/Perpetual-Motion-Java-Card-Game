/**
 * makes a Deck class
 * @author Alex Kleinhanzl
 * @version 12/18/2018
 * */
import java.util.Random;

public class Deck {
  /**
   * Constant variables
   * */
  public static final int NUMSUITS = 4;
  public static final int NUMRANKS = 13;
  public static final int NUMCARDS = 52;
  public static final int HEARTS = 0;
  public static final int DIAMONDS = 1;
  public static final int CLUBS = 2;
  public static final int SPADES = 3;
  private ManyCards[] card;
  private Random random;
  public Deck(){
    this.card = new ManyCards[NUMCARDS];
    this.random = new Random();
  }
  /**
   * Produces an array of cards implementing rank and suit
   * */
  public ManyCards[] makeCards(){
    int index = 0;
    for(int i = 0; i < NUMSUITS; i++){
      for(int j = 0; j < NUMRANKS; j++){
        if(i == HEARTS){
          card[index] = new Heart(200,300,i,j);
        }
        if(i == DIAMONDS){
          card[index] = new Diamond(200,300,i,j);
        }
        if(i == CLUBS){
          card[index] = new Club(200,300,i,j);
        }
        if(i == SPADES){
          card[index] = new Spade(200,300,i,j);
        }
        index++;
      }
    }
    return this.card; 
  }
  /**
   * This will randomaly generate a card
   * */
  public ManyCards[] shuffle(ManyCards[] card){
    for(int i=0; i < NUMCARDS; i++){
      int rand = this.random.nextInt(52);
      ManyCards shuffle1 = card[i];
      ManyCards shuffle2 = card[rand];
      card[i] = shuffle2;
      card[rand] = shuffle1;
    }
    
    return this.card;
  }
}

