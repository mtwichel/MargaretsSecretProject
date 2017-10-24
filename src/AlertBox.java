import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.geometry.*;

public class AlertBox {
	
	public static void display(String title, String message, String buttonText){
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
//		window.setMinWidth(400);
		
		Label label = new Label(message);
		Button button = new Button(buttonText);
		button.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));

		layout.getChildren().addAll(label, button);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 300, 100);
		scene.setOnKeyPressed(ke ->{
			if(ke.getCode() == KeyCode.ENTER){
				 window.close();
			}
		});
		window.setScene(scene);
		window.showAndWait();
		
	}

}
