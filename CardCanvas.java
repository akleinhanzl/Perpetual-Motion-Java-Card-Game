/**
 * This class is the main class that inforces rules, and allows the user to play the game
 * @author Alex Kleinhanzl
 * @version 12/18/2018
 * */
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import java.util.Stack;
import java.util.EmptyStackException;

/**
 * these are used to set the sizes of the column and where they are on the screen
 * */
public class CardCanvas extends Canvas {
  public static final double CARD_HEIGHT = 150;
  public static final double CARD_WIDTH = 100;
  public static final double REFILLY = 300;
  public static final double COLUMN_Y = 50;
  public static final double REFILLX = 200;
  public static final double COLUMNX1 = 20;
  public static final double COLUMNX2 = 140;
  public static final double COLUMNX3 = 260;
  public static final double COLUMNX4 = 380;
  public static final int W_WIDTH = 500;
  public static final int W_HEIGHT = 500;
  public static final Color W_COLOR = Color.YELLOW;
  
  public Deck a;
  public ManyCards[] cardDeck;
  public CardStack cs;
  public Stack<ManyCards> stockPile;
  public Stack<ManyCards> column1;
  public Stack<ManyCards> column2;
  public Stack<ManyCards> column3;
  public Stack<ManyCards> column4;
  public boolean enforceRules;
  
  /**
   * The Constructor initializes the instance variables 
   * */
  public CardCanvas(){
    super(W_WIDTH,W_HEIGHT);
    this.enforceRules = false;
    ClickHandler handler = new ClickHandler();
    this.addEventHandler(MouseEvent.MOUSE_CLICKED,handler);
    this.a = new Deck();
    this.cs = new CardStack();
    this.cardDeck = a.makeCards();
    a.shuffle(this.cardDeck);
    this.stockPile = cs.newStack(cardDeck);
    this.column1 = new Stack<ManyCards>();
    this.column2 = new Stack<ManyCards>();
    this.column3 = new Stack<ManyCards>();
    this.column4 = new Stack<ManyCards>();  
  }
  
  /**
   * 
   * Method
   * newGame creates a new Game and it can redraw the board
   * */
  public void newGame(){
    this.a = new Deck();
    this.cs = new CardStack();
    this.cardDeck = a.makeCards();
    a.shuffle(this.cardDeck);
    this.stockPile = cs.newStack(cardDeck);
    this.column1 = new Stack<ManyCards>();
    this.column2 = new Stack<ManyCards>();
    this.column3 = new Stack<ManyCards>();
    this.column4 = new Stack<ManyCards>();
    this.draw();
  }
  /**
   * Method
   * Draws the coulumns
   * */
  public void draw() {
    this.clear();
    GraphicsContext gc = this.getGraphicsContext2D();
    if(!stockPile.empty()){
      ManyCards card = this.stockPile.peek();
      card.draw(gc);
    }
    if(!column1.empty()){
      ManyCards cardT1 = this.column1.peek();
      cardT1.draw(gc);
    }
    if(!column2.empty()){
      ManyCards cardT2 = this.column2.peek();
      cardT2.draw(gc);
    }
    if(!column3.empty()){
      ManyCards cardT3 = this.column3.peek();
      cardT3.draw(gc);
    }
    if(!column4.empty()){
      ManyCards cardT4 = this.column4.peek();
      cardT4.draw(gc);
    } 
  }
  /**
   * Method
   * is called when the StockPile is clicked providing the inofrmation that youve emptied the StockPilePile of cards
   * */
  public void StockPileClicked(){
    for(int i =0; i< 4; i++){
      if(!stockPile.empty()){
        ManyCards clicked = this.stockPile.peek();
        movetoTableau(clicked,i);
      }
    }
    if(stockPile.empty()){
      System.out.println("You emptied the stockPile.");
    }
    this.draw();
  } 
  /**
   * Method
   * the moveCard method enforces some of the rules
   * */
  public void moveCard(Stack<ManyCards> column,int t){
    if(this. enforceRules == false){
      if(!column.empty()){
        column.pop();
        this.draw();
      }
      else{
        System.out.println("The column is empty");
      }
    }
    if(this.enforceRules == true){
      if(!column.empty()){
        if(!this.sameRank(t)){
          if(!this.sameSuit(t)){
            System.out.println("You cannot remove cards at this time");
          }
        }
      }
      else{
        System.out.println("The column is empty");
      } 
    }
  }
  /**
   * Method
   * the method sameRank chacks to see if the cards are the same rank 
   * */
  public boolean sameRank(int t){
    boolean getOne = false;
    boolean prePopped = false;
    int p1 = -1;
    int p2 = -2;
    int p3 = -3;
    int p4 = -4; 
    if(!column1.empty()){
      ManyCards t1 = column1.peek();
      p1 = t1.getRank();
    }
    if(!column2.empty()){
      ManyCards t2 = column2.peek();
      p2 = t2.getRank();
    }
    if(!column3.empty()){
      ManyCards t3 = column3.peek();
      p3 = t3.getRank();
    }
    if(!column4.empty()){
      ManyCards t4 = column4.peek();
      p4 = t4.getRank();
    }
    if(t == 1 && column1.empty() == false){ 
      if(p1 == p2 && column2.empty() == false){
        column1.pop();
        column2.pop();
        prePopped = true;
        getOne = true;
      }
      if(p1 == p3 && column3.empty() == false){
        if(!prePopped){
          column1.pop();
          prePopped = true;
        }
        column3.pop();
        getOne = true;
      }
      if(p1 == p4 && column4.empty() == false){
        if(!prePopped){
          column1.pop();
          prePopped = true;
        }
        column4.pop();
        getOne = true;
      }
    }
    if(t == 2 && column2.empty() == false){ 
      if(p2 == p1 && column1.empty() == false){
        column2.pop();
        column1.pop();
        prePopped = true;
        getOne = true;
      }
      if(p2 == p3 && column3.empty() == false){
        if(!prePopped){
          column2.pop();
          prePopped = true;
          getOne = true;
        }
        column3.pop();
      }
      if(p2 == p4 && column4.empty() == false){
        if(!prePopped){
          column2.pop();
          prePopped = true;
        }
        column4.pop();
        getOne = true;
      }
    }
    if(t == 3 && column3.empty() == false){ 
      if(p3 == p1 && column1.empty() ==false){
        column3.pop();
        column1.pop();
        prePopped = true; 
        getOne = true;
      }
      if(p3 == p2 && column2.empty() == false){
        if(!prePopped){
          column3.pop();
          prePopped = true;
        }
        column2.pop();
        getOne = true;
      }
      if(p3 == p4 && column4.empty() == false){
        if(!prePopped){
          column3.pop();
          prePopped = true;
        }
        column4.pop();
        getOne = true;
      }
    }
    if(t == 4 && column4.empty() == false){ 
      if(p4 == p1 && column1.empty() == false){
        column4.pop();
        column1.pop();
        prePopped = true; 
        getOne = true;
      }
      if(p4 == p2 && column2.empty() == false){
        if(!prePopped){
          column4.pop();
          prePopped = true;
        }
        column2.pop();
        getOne = true;
      }
      if(p4 == p3 && column3.empty() == false){
        if(!prePopped){
          column4.pop();
          prePopped = true;
        }
        column3.pop();
        getOne = true;
      }
    }
    this.draw();
    return getOne;
  } 
  /**
   * Method
   * this method checks to see if cards are the same suit
   * */
  public boolean sameSuit(int t){
    boolean itMatches = false;
    int c1 = -1;
    int c2 = -2;
    int c3 = -3;
    int c4 = -4;
    int p1 = -1;
    int p2 = -1;
    int p3 = -1;
    int p4 = -1;
    if(!column1.empty()){
      ManyCards t1 = column1.peek();
      c1 = t1.getSuit();
      p1 = t1.getRank();
    }
    if(!column2.empty()){
      ManyCards t2 = column2.peek();
      c2 = t2.getSuit();
      p2 = t2.getRank();
    }
    if(!column3.empty()){
      ManyCards t3 = column3.peek();
      c3 = t3.getSuit();
      p3 = t3.getRank();
    }
    if(!column4.empty()){
      ManyCards t4 = column4.peek();
      c4 = t4.getSuit();
      p4 = t4.getRank();
    }
    if(t == 1 && column1.empty() == false){
      if(c1 == c2 && p2 > p1 && column2.empty() == false){
        column1.pop();
        itMatches = true;
      }
      else if(c1 == c3 && p3 > p1 && column3.empty() == false){
        column1.pop();
        itMatches = true;
      }
      else if(c1 == c4 && p4 > p1 && column4.empty() == false){
        column1.pop();
        itMatches = true;
      }
    }
    if(t == 2 && column2.empty() == false){
      if(c1 == c2 && p1 > p2 && column1.empty() == false){
        column2.pop();
        itMatches = true;
      }
      else if(c2 == c3 && p3 > p2 && column3.empty() == false){
        column2.pop();
        itMatches = true;
      }
      else if(c2 == c4 && p4 > p2 && column4.empty() == false){
        column2.pop();
        itMatches = true;
      }
    }
    if(t == 3 && column3.empty() == false){
      if(c1 == c3 && p1 > p3 && column1.empty() == false){
        column3.pop();
        itMatches = true;
      }
      else if(c2 == c3 && p2 > p3 && column2.empty() == false){
        column3.pop();
        itMatches = true;
      }
      else if(c3 == c4 && p4 > p3 && column4.empty() == false){
        column3.pop();
        itMatches = true;
      }
    }
    if(t == 4 && column4.empty() == false){
      if(c1 == c4 && p1 > p4 && column1.empty() == false){
        column4.pop();
        itMatches = true;
      }
      else if(c4 == c2 && p2 > p4 && column2.empty() == false){
        column4.pop();
        itMatches = true;
      }
      else if(c4 == c3 && p3 > p4 && column3.empty() == false){
        column4.pop();
        itMatches = true;
      }
    }
    this.draw();
    return itMatches;
  } 
  /**
   * Method
   * calls four top cards and sets it as tableau
   * */
  public void movetoTableau(ManyCards clicked,int i){
    clicked.setFaceUp(true);
    if(i == 0){
      clicked.setX(COLUMNX1);
      clicked.setY(COLUMN_Y);
      this.column1.push(clicked);
    }
    if(i == 1){
      clicked.setX(COLUMNX2);
      clicked.setY(COLUMN_Y);
      this.column2.push(clicked);
    }
    if(i == 2){
      clicked.setX(COLUMNX3);
      clicked.setY(COLUMN_Y);
      this.column3.push(clicked);
    }
    if(i == 3){
      clicked.setX(COLUMNX4);
      clicked.setY(COLUMN_Y);
      this.column4.push(clicked);
    }
    this.stockPile.pop();
    this.draw(); 
  }
  /**
   * Method 
   * Helper method in draw 
   * clears the board by drawing the background
   * */
  public void clear(){
    GraphicsContext gc = this.getGraphicsContext2D();
    gc.setFill(W_COLOR);
    gc.fillRect(0,0,W_WIDTH, W_HEIGHT);
    stackBoxes();  
  }
  /**
   * Prints is rules are or are not inforced
   * */
  public void ruleEnforcer(boolean enforceRules){
    if(enforceRules){
      System.out.println("The Rules Enforcer is turned on");
      this.enforceRules = true;  
    }
    
    else{
      System.out.println("The Rules Enforcer is turned off");
      this.enforceRules = false;
    }  
  }
  /**
   * method
   * this shows a balnk box if the column is emptied
   * */
  private void stackBoxes(){
    GraphicsContext gc = this.getGraphicsContext2D();
    gc.setStroke(Color.BLACK);
    gc.strokeRect(200,300,100,150);
    gc.strokeRect(20,50,100,150);
    gc.strokeRect(140,50,100,150);
    gc.strokeRect(260,50,100,150);
    gc.strokeRect(380,50,100,150); 
  }
  /**
   *class that allows taking clicking as an input and implementing it onto your code
   * */
  private class ClickHandler implements EventHandler<MouseEvent>{ 
    /**
     * method that implements what to do when certain part of screen is pressed
     * */
    public void handle(MouseEvent e){
      double x = e.getX();
      double y = e.getY();
      if (x>REFILLX && x<REFILLX+CARD_WIDTH && y>REFILLY && y<REFILLY+CARD_HEIGHT){
        System.out.println("StockPile");
        StockPileClicked();
      }
      if (x>COLUMNX1 && x<COLUMNX1+CARD_WIDTH && y>COLUMN_Y && y<COLUMN_Y+CARD_HEIGHT){
        System.out.println("COLUMN1");
        moveCard(column1,1);
      }
      if (x>COLUMNX2 && x<COLUMNX2+CARD_WIDTH && y>COLUMN_Y && y<COLUMN_Y+CARD_HEIGHT){
        System.out.println("COLUMN2");
        moveCard(column2,2);
      }
      if (x>COLUMNX3 && x<COLUMNX3+CARD_WIDTH && y>COLUMN_Y && y<COLUMN_Y+CARD_HEIGHT){
        System.out.println("COLUMN3");   
        moveCard(column3,3);
      }
      if (x>COLUMNX4 && x<COLUMNX4+CARD_WIDTH && y>COLUMN_Y && y<COLUMN_Y+CARD_HEIGHT){
        System.out.println("COLUMN4");
        moveCard(column4,4);
      }
      if(stockPile.empty() && column1.empty() & column2.empty() && column3.empty() && column4.empty()){
        System.out.println("Congrats, you won!");
      }          
    }
  }
}

