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

public class ListCardOffers {
	static TableView<CardOffer> table;
	static ListView<String> listView;

	public static boolean display(String title, String message) throws NamingException {
		//listview
				listView = new ListView<>();

				listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		Context context = new InitialContext();
		CardRequestServiceRemote cardRequestServiceRemote = (CardRequestServiceRemote) context.lookup(
				"micro-credit-ear/micro-credit-service/CardRequestService!tn.esprit.infini.micro_credit.services.CardRequestServiceRemote");
		CardOfferServiceRemote cardOfferServiceRemote = (CardOfferServiceRemote) context.lookup(
				"micro-credit-ear/micro-credit-service/CardOfferService!tn.esprit.infini.micro_credit.services.CardOfferServiceRemote");
		List<Account> accounts = cardRequestServiceRemote.findAllAccountsByCustomer(Integer.parseInt(message));
		for (Account c : accounts) {
			listView.getItems().add(String.valueOf(c.getId()));
		}

		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		Label label = new Label();
		label.setText("Account number");


		// id column
		TableColumn<CardOffer, String> nameColumn = new TableColumn<>("id");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

		// cripto column
		TableColumn<CardOffer, Double> priceColumn = new TableColumn<>("cryptogramme");
		priceColumn.setMinWidth(100);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("cryptogramme"));

		// table
		table = new TableView<>();
		table.setItems(getCardOffers());
		table.getColumns().addAll(nameColumn, priceColumn);

		// Create two buttons
		Button yesButton = new Button("add card request");
		TextField accountInput = new TextField("");
		
		// Clicking will set answer and close window
		yesButton.setOnAction(e -> {
			// get selected element from listview
			String selectedValue = listView.getSelectionModel().getSelectedItem();
			System.out.println(selectedValue);

			Account account = cardRequestServiceRemote.findAccountById(Integer.parseInt(selectedValue));
			CardOffer cardOffer = cardOfferServiceRemote
					.findCardOfferById(table.getSelectionModel().getSelectedItem().getId());
			CardRequest cardRequest = new CardRequest(new Date(), new Date(), account, cardOffer);
			cardRequestServiceRemote.addCardRequest(cardRequest);
			window.close();

		});

		VBox layout = new VBox();

		// Add buttons
		layout.getChildren().addAll(label, accountInput, listView, yesButton, table);
		// layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 600, 600);
		window.setScene(scene);
		scene.getStylesheets().add("Viper.css");
		window.show();
		scene.getStylesheets().add("Viper.css");
		// Make sure to return answer
		return false;
	}

	private static ObservableList<CardOffer> getCardOffers() {
		ObservableList<CardOffer> observableList = FXCollections.observableArrayList();
		List<CardOffer> cardOffers = null;
		try {
			Context context = new InitialContext();
			CardOfferServiceRemote cardOfferServiceRemote = (CardOfferServiceRemote) context.lookup(
					"micro-credit-ear/micro-credit-service/CardOfferService!tn.esprit.infini.micro_credit.services.CardOfferServiceRemote");
			cardOffers = cardOfferServiceRemote.findAllCardOffers();

		} catch (NamingException e) {
			e.printStackTrace();
		}
		for (CardOffer c : cardOffers) {
			observableList.add(c);
		}
		return observableList;
	}

}