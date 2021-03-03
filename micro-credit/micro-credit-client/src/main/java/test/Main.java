package test;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.esprit.infini.micro_credit.entities.CardOffer;
import tn.esprit.infini.micro_credit.services.CardOfferServiceRemote;

public class Main extends Application {

	Stage window;
	TableView<CardOffer> table;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("thenewboston - JavaFX");

		// Name column
		TableColumn<CardOffer, String> nameColumn = new TableColumn<>("id");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

		// Price column
		TableColumn<CardOffer, Double> priceColumn = new TableColumn<>("cryptogramme");
		priceColumn.setMinWidth(100);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("cryptogramme"));

		table = new TableView<>();
		
		table.getColumns().addAll(nameColumn, priceColumn);
		table.setItems(getProduct());
		VBox vBox = new VBox();
		vBox.getChildren().addAll(table);

		Scene scene = new Scene(vBox);
		window.setScene(scene);
		window.show();
	}

	// Get all of the products
	public ObservableList<CardOffer> getProduct() {
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