import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox {
	
	static boolean answer;
	
	public static boolean display(String title, String message){
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		
		Label label = new Label(message);
		
//		two buttons
		Button buttonY = new Button("Yes");
		Button buttonN = new Button("No");
		
		buttonY.setOnAction(e -> {
			answer = true;
			window.close();
		});
		
		buttonN.setOnAction(e -> {
			answer = false;
			window.close();
		});


		
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));

		layout.getChildren().addAll(label, buttonY, buttonN);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
		
	}

}
