package fxgui;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tn.esprit.infini.micro_credit.services.ClaimServiceRemote;

public class CustomerHome {

	// Create variable
	static boolean answer;

	public static boolean display(String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Customer Home");
		window.setMinWidth(250);
		Label label = new Label();
		label.setText("Hi "+message);
		TextField accountInput = new TextField("");

		Button yesButton = new Button("list All Card-Offers");
		Button noButton = new Button("claim Card");
		

		// Clicking will set answer and close window
		yesButton.setOnAction(e -> {
			answer = true;
			window.close();
			try {
				ListCardOffers.display(title, message);
			} catch (NamingException e1) {
				e1.printStackTrace();
			}
		});
		Button logout = new Button("logout");
		logout.setOnAction(e -> {
			window.close();
		});
		noButton.setOnAction(e -> {
			try {
				Context context = new InitialContext();
				ClaimServiceRemote claimServiceRemote = (ClaimServiceRemote) context.lookup(
						"micro-credit-ear/micro-credit-service/ClaimService!tn.esprit.infini.micro_credit.services.ClaimServiceRemote");
				claimServiceRemote.unboundCard(Integer.parseInt(accountInput.getText()));
			} catch (NamingException e1) {
				e1.printStackTrace();
			}
			answer = false;
			CustomerHome.display(title, message);
			window.close();

		});

		VBox layout = new VBox(10);

		layout.getChildren().addAll(label, yesButton, noButton,accountInput,logout);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 600, 600);
		window.setScene(scene);
		window.show();
		scene.getStylesheets().add("Viper.css");

		return answer;
	}

}