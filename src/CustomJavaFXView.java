
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.media.*;

public class CustomJavaFXView extends Application{

	private Stage window;
	private Model model;
	private int closeCount;
	private int parentModeCount;
	private String color = "#ff0000";
	private int width;
	private int height;
	private boolean isShrinking;
	private boolean isExpanding;
//	private AudioClip pew;

	public static void main(String[] args){

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("hi");
		window = primaryStage;
		closeCount = 0;
		parentModeCount = 0;
		model = new  Model();
		window.getIcons().add(new Image("file:heart-icon.png"));
//		pew = new AudioClip("resources/pew.aiff");
		Random rand = new Random();
		window.setTitle("The Reasons I Love You");
		width = 800;
		height = 400;
		
		//Determines if shrinking and expanding
		if(rand.nextInt(3)==2){
			isShrinking = true;
			System.out.println("is shrinking");
		}else if(rand.nextInt(3) == 2){
			isExpanding = true;
			System.out.println("is expanding");
		}else{
			isShrinking = false;
			isExpanding = false;
		}
		
		//what to do on close
		window.setOnCloseRequest(e->{
			if(closeCount == 0){
				if(rand.nextInt(100)%3 ==0){
					e.consume();
					closeCount+=1;
				}else{
					e.consume();
					closeWindow();
				}
			}else{
				e.consume();
				closeCount+= 1;
				if(closeCount >= 3){
					alternateCloseWindow();
				}
			}
		});

		Text label = new Text("Here Are Some Of the Reasons Marcus Loves You\nClick to See");
		label.setFill(Color.WHITE);
		label.setTextAlignment(TextAlignment.CENTER);
		label.setFont(new Font("Verdana", 20));


		StackPane layout = new StackPane();
		layout.getChildren().addAll(label);
		layout.setStyle("-fx-background-color: #ff0000");

		Scene scene = new Scene(layout, width, height);
		scene.setOnMouseClicked(e -> {
			makeNewScene();
			window.setTitle("The Reasons I Love You");
		});
		
		//first slide key stuff
		scene.setOnKeyPressed(e ->{
			if(e.getCode() == KeyCode.P){
				parentModeCount+=1;
				if(parentModeCount >= 4){
					activateParentMode();
				}
			}
		});
		window.setScene(scene);
		window.show();

	}

	private void alternateCloseWindow() {
		TextBox.display("So you want to close the window?", "If you wish to close the window, you must answer this riddle.\nWho is the girl that Marcus loves the most?");
		window.close();
	}

	private void closeWindow() {
		Boolean answer = ConfirmBox.display("About to Close", "Are you sure you want to close?");
		if(answer){
			Boolean answer1 = ConfirmBox.display("Actually About to Close", "Are you really sure you want to close?");
			if(answer1){
				Boolean answer2 = ConfirmBox.display("Last One I Swear", "Do You Know Marcus Loves You?");
				if (answer2){
					AlertBox.display("I'm Closing Now I Swear", "Good, Cause He Really Does :)  <3", "Awe <3");
					window.close();
				}else{
					AlertBox.display("WHAT??", "Well Get Back To Clicking!!!", "Okay");
				}
			}
		}
	}

	private void makeNewScene(){
		Text label = new Text(model.getReason());
		label.setFill(Color.WHITE);
		label.setTextAlignment(TextAlignment.CENTER);
		label.setFont(new Font("Verdana", 20));
		window.setTitle("The Reasons I Love You");


		BorderPane layout = new BorderPane();
		layout.setCenter(label);
		//layout.getChildren().add(label);
//		String color = "#ff0000";
		layout.setStyle("-fx-background-color: "+ color);

		
		
		
		Scene scene = new Scene(layout, width, height);
		scene.setOnMouseClicked(e -> makeNewScene());
		scene.setOnKeyPressed(e ->{
			if(e.getCode() == KeyCode.P){
				parentModeCount+=1;
				if(parentModeCount >= 4){
					activateParentMode();
				}
			}else if(e.getCode() == KeyCode.B){
//				pew.play();
				this.color = "#1a53ff";
				layout.setStyle("-fx-background-color: "+ color);
			}else if(e.getCode() == KeyCode.R){
				this.color = "#ff0000";
				layout.setStyle("-fx-background-color: "+ color);
			}else if(e.getCode() == KeyCode.Y){
				this.color = "#ffff00";
				layout.setStyle("-fx-background-color: "+ color);
			}else if(e.getCode() == KeyCode.G){
				this.color = "#00cc00";
				layout.setStyle("-fx-background-color: "+ color);
			}else if(e.getCode() == KeyCode.I){
				this.color = "#ff99e6";
				layout.setStyle("-fx-background-color: "+ color);
			}else if(e.getCode() == KeyCode.O){
				this.color = "#ff8c1a";
				layout.setStyle("-fx-background-color: "+ color);
			}
		});
		window.setScene(scene);
		if(isExpanding){
			width += 4;
			height += 4;
		}else if(isShrinking){
			width -= 4;
			height -= 4;
		}
	}
	private void activateParentMode(){
		model.activateParentMode();
		window.setTitle("The Reasons L Love You");
	}

}
