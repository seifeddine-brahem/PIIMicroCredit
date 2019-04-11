package fxgui;

import javax.naming.NamingException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AgentHome {

	// Create variable
	static boolean answer;

	public static boolean display(String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		Label label = new Label();
		label.setText("hi M/Ms : " + message);

		// Create two buttons
		Button yesButton = new Button("Proceed card requests");
		Button noButton = new Button("list of Accounts by Customer");
		Label label2 = new Label();
		label2.setText("account id");
		TextField accountInput = new TextField("");
		Button addOfferButton = new Button("add Card Offer");

		// Clicking will set answer and close window
		yesButton.setOnAction(e -> {
			try {
				ProceedCardRequest.display("", "");
			} catch (NamingException e1) {
				e1.printStackTrace();
			}
			window.close();
		});
		noButton.setOnAction(e -> {
			try {
				ListCardOfferByCustomer.display("", "");
			} catch (NamingException e1) {
				e1.printStackTrace();
			}
			window.close();
		});
		addOfferButton.setOnAction(e -> {
			try {
				AddCardOffer.display("", "");
			} catch (NamingException e1) {
				e1.printStackTrace();
			}
			window.close();
		});

		VBox layout = new VBox(10);

		// Add buttons
		layout.getChildren().addAll(label, yesButton, noButton,label2,accountInput, addOfferButton);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 300, 300);
		window.setScene(scene);
		window.showAndWait();

		// Make sure to return answer
		return answer;
	}

}