package fxgui;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tn.esprit.infini.micro_credit.entities.Account;
import tn.esprit.infini.micro_credit.entities.CardOffer;
import tn.esprit.infini.micro_credit.entities.CardRequest;
import tn.esprit.infini.micro_credit.services.CardOfferServiceRemote;
import tn.esprit.infini.micro_credit.services.CardRequestServiceRemote;

public class ProceedCardRequest {
	static TableView<CardRequest> table;

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
		


		// id column
		TableColumn<CardRequest, String> nameColumn = new TableColumn<>("cardoffer_id");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("cardoffer_id"));

		// cripto column
		TableColumn<CardRequest, Double> priceColumn = new TableColumn<>("account_id");
		priceColumn.setMinWidth(100);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("account_id"));

		// table
		table = new TableView<>();
		table.setItems(getCardOffers());
		table.getColumns().addAll(nameColumn, priceColumn);

		// Create two buttons
		Button yesButton = new Button("add card request");
		
		
		// Clicking will set answer and close window
		yesButton.setOnAction(e -> {

			
			window.close();

		});

		VBox layout = new VBox();

		// Add buttons
		layout.getChildren().addAll( yesButton, table);
		// layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 600, 600);
		window.setScene(scene);
		scene.getStylesheets().add("Viper.css");
		window.show();
		scene.getStylesheets().add("Viper.css");
		// Make sure to return answer
		return false;
	}

	private static ObservableList<CardRequest> getCardOffers() {
		ObservableList<CardRequest> observableList = FXCollections.observableArrayList();
		List<CardRequest> cardRequests = null;
		try {
			Context context = new InitialContext();
			CardOfferServiceRemote cardOfferServiceRemote = (CardOfferServiceRemote) context.lookup(
					"micro-credit-ear/micro-credit-service/CardOfferService!tn.esprit.infini.micro_credit.services.CardOfferServiceRemote");
			CardRequestServiceRemote cardRequestServiceRemote = (CardRequestServiceRemote) context.lookup(
					"micro-credit-ear/micro-credit-service/CardRequestService!tn.esprit.infini.micro_credit.services.CardRequestServiceRemote");
			cardRequests = cardRequestServiceRemote.findAllRequests();

		} catch (NamingException e) {
			e.printStackTrace();
		}
		for (CardRequest c : cardRequests) {
			observableList.add(c);
		}
		return observableList;
	}

}