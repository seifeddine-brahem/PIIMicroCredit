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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tn.esprit.infini.micro_credit.entities.CardRequest;
import tn.esprit.infini.micro_credit.services.CardOfferServiceRemote;
import tn.esprit.infini.micro_credit.services.CardRequestServiceRemote;

public class ProceedCardRequest {
	static TableView<CardRequest> table;

	@SuppressWarnings("unchecked")
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
		TableColumn<CardRequest, String> nameColumn = new TableColumn<>("cardOffer");
		nameColumn.setMinWidth(100);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("cardOffer"));

		// cripto column
		TableColumn<CardRequest, String> priceColumn = new TableColumn<>("account");
		priceColumn.setMinWidth(100);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("account"));

		TableColumn<CardRequest, Boolean> status = new TableColumn<>("status");
		status.setMinWidth(100);
		status.setMinWidth(100);
		status.setCellValueFactory(new PropertyValueFactory<>("status"));

		// table
		table = new TableView<>();
		table.setItems(getCardOffers());
		table.getColumns().addAll(status, nameColumn, priceColumn);

		// Create two buttons
		Button yesButton = new Button("accept");
		Button noButton = new Button("refuse");

		// Clicking will set answer and close window
		yesButton.setOnAction(e -> {

			cardRequestServiceRemote.processCardRequest(table.getSelectionModel().getSelectedItem(), true, new Date());

			table.setItems(getCardOffers());

		});
		noButton.setOnAction(e -> {

			cardRequestServiceRemote.processCardRequest(table.getSelectionModel().getSelectedItem(), false, new Date());
			table.setItems(getCardOffers());

		});

		VBox layout = new VBox();

		// Add buttons
		layout.getChildren().addAll(noButton, yesButton, table);
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