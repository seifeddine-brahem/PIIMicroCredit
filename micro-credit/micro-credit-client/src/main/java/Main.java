import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tn.esprit.infini.micro_credit.entities.Role;
import tn.esprit.infini.micro_credit.entities.User;
import tn.esprit.infini.micro_credit.services.IdentityServiceRemote;

public class Main extends Application {

	Stage window;
	Scene scene, scene2;
	Context context;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane grid = new GridPane();
		scene = new Scene(grid, 300, 200);

		window = primaryStage;
		window.setTitle("Login Frame");

		// GridPane with 10px padding around edge

		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);

		// Name Label - constrains use (child, column, row)
		Label nameLabel = new Label("Username:");
		nameLabel.setId("bold-label");
		GridPane.setConstraints(nameLabel, 0, 0);

		// Name Input
		TextField nameInput = new TextField("");
		nameInput.setPromptText("login");
		GridPane.setConstraints(nameInput, 1, 0);

		// Password Label
		Label passLabel = new Label("Password:");
		GridPane.setConstraints(passLabel, 0, 1);

		// Password Input
		TextField passInput = new TextField();
		passInput.setPromptText("password");
		GridPane.setConstraints(passInput, 1, 1);

		// Login
		Button loginButton = new Button("Log In");
		GridPane.setConstraints(loginButton, 1, 2);

		loginButton.setOnAction(e -> System.out.println("jj" + nameInput.getText()));
		loginButton.setOnAction(e -> {
			window.hide();
			User userLoggedIn = null;
			try {
				context = new InitialContext();
			} catch (NamingException e1) {
				e1.printStackTrace();
			}
			try {
				IdentityServiceRemote identityServiceRemote = (IdentityServiceRemote) context.lookup(
						"micro-credit-ear/micro-credit-service/IdentityService!tn.esprit.infini.micro_credit.services.IdentityServiceRemote");
				//userLoggedIn = identityServiceRemote.login("u2@esprit.tn", "u2");
				userLoggedIn = identityServiceRemote.login(nameInput.getText(), passInput.getText());
			} catch (NamingException e1) {
				e1.printStackTrace();
			}
			try {
				if (userLoggedIn.getRole().equals(Role.agent)) {
					ConfirmBox.display("Bank Operations", "Are you sure ");
				} else if (userLoggedIn.getRole().equals(Role.client)) {
					CustomerHome.display("Bank Operations", ""+userLoggedIn.getId());
				} 
			} catch (Exception e2) {
				AlertBox.display("Bad Credentials", "Bad Credentials");
			}
			

		});

		// Add everything to grid
		grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);

		scene.getStylesheets().add("Viper.css");
		window.setScene(scene);
		window.show();
	}

}