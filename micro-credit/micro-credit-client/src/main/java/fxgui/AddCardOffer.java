package fxgui;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tn.esprit.infini.micro_credit.entities.CardOffer;
import tn.esprit.infini.micro_credit.services.CardOfferServiceRemote;
import tn.esprit.infini.micro_credit.services.CardRequestServiceRemote;

public class AddCardOffer {

	public static boolean display(String title, String message) throws NamingException {
		Context context = new InitialContext();
		CardRequestServiceRemote cardRequestServiceRemote = (CardRequestServiceRemote) context.lookup(
				"micro-credit-ear/micro-credit-service/CardRequestService!tn.esprit.infini.micro_credit.services.CardRequestServiceRemote");
		CardOfferServiceRemote cardOfferServiceRemote = (CardOfferServiceRemote) context.lookup(
				"micro-credit-ear/micro-credit-service/CardOfferService!tn.esprit.infini.micro_credit.services.CardOfferServiceRemote");

		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);

		Label numCard = new Label();
		numCard.setText("Num Card");

		TextField numText = new TextField("");

		Label validity = new Label();
		validity.setText("validity");

		TextField validityText = new TextField("");

		Label cripto = new Label();
		cripto.setText("cripto");

		TextField criptoText = new TextField("");

		// Create two buttons
		Button yesButton = new Button("add card Offer");
		TextField accountInput = new TextField("");

		// Clicking will set answer and close window
		yesButton.setOnAction(e -> {

			CardOffer cardOffer = new CardOffer(numText.getText(), new Date(), Integer.parseInt(criptoText.getText()));
			cardOfferServiceRemote.addCardOffer(cardOffer);
			
			window.close();
			AgentHome agentHome=new AgentHome();
			agentHome.display("", "");

		});

		VBox layout = new VBox();

		// Add buttons
		layout.getChildren().addAll(numCard, numText, validity, validityText, cripto, criptoText, yesButton);
		// layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 600, 600);
		window.setScene(scene);
		scene.getStylesheets().add("Viper.css");
		window.show();
		scene.getStylesheets().add("Viper.css");
		// Make sure to return answer
		return false;
	}

}