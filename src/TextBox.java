import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class TextBox {
	
	public static boolean answer;
	
	public static void display(String title, String message){
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		
		Label label = new Label(message);
		
//		two buttons
		TextField textField = new TextField();
		Button submit = new Button("Submit");
		
		textField.setOnAction(e -> submit.fire());
		submit.setOnAction(e -> {
			if (textField.getText().toLowerCase().equals("margaret")){
				AlertBox.display("Whew", "Correct! He loves you Margaret!", "Yay! I love him too!");
				window.close();
			}else{
				AlertBox.display("WHAT!!??", "Uhh that's not right", "Ill try again :(");
			}
			
		});
		


		
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));

		layout.getChildren().addAll(label, textField, submit);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
	}

}
