/**
 * Creates a GUI for the game
 * @author Alex Kleinhanzl
 * @version 12/18/2018
 * */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.FlowPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
/**
 * this creates a checkbox for enforcing rules
 **/
public class GameGUI extends Application {
  CardCanvas mc;
  CheckBox checkbox = new CheckBox("Enforce the Rules");
  
  /**
   * this sets up the frame
   **/
  public void start(Stage primaryStage){
    this.mc = new CardCanvas();
    mc.draw();
    
    CheckBoxClickHandler checkhandler = new CheckBoxClickHandler();
    checkbox.setOnAction(checkhandler);
    
    Button newGame = new Button("Click for a New Game");
    ButtonClickHandler handler = new ButtonClickHandler();
    newGame.setOnAction(handler);
    
    FlowPane pane2 = new FlowPane();
    pane2.getChildren().add(checkbox);
    pane2.getChildren().add(newGame);
    
    BorderPane pane = new BorderPane();
    pane.setCenter(mc);
    pane.setAlignment(pane2,Pos.CENTER);
    pane.setBottom(pane2);
    
    Scene scene = new Scene(pane);
    
    primaryStage.setTitle("Perpetual Motion, Idiots Delight, The Card Game");
    primaryStage.setScene(scene);
    primaryStage.show();
    
  }
  /**
   * this starts the program
   */
  public static void main(String[] args){
    launch(args);
  }
  /**
   * this gives persission to interpret button clicks on the board
   * */
  private class ButtonClickHandler implements EventHandler<ActionEvent> {
    /**
     * this handles the button for newGame
     * */
    public void handle(ActionEvent e) {
      mc.newGame();
    }
  }
  /**
   * this will handle the checkbox of wether or not the game is ruled
   * */
  private class CheckBoxClickHandler implements EventHandler<ActionEvent> {
    /**
     * itll intrusct the GUI to turn on or off the rules
     * */
    public void handle(ActionEvent e){
      mc.ruleEnforcer(checkbox.isSelected());
      
    }
  }
}
