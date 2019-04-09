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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.esprit.infini.micro_credit.entities.Role;
import tn.esprit.infini.micro_credit.entities.User;
import tn.esprit.infini.micro_credit.services.IdentityServiceRemote;

public class Main extends Application {

	Stage window;
	Button button;
	Scene scene, scene2;
	Context context;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane grid = new GridPane();
		scene = new Scene(grid, 300, 200);

		// Button 1
		Label label1 = new Label("Welcome to the first scene!");
		Button button1 = new Button("Go to scene 2");

		// Layout 1 - children laid out in vertical column
		VBox layout1 = new VBox(20);
		// layout1.getChildren().addAll(label1, button1);

		window = primaryStage;
		window.setTitle("thenewboston - JavaFX");

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

		// Sign up
		Button signUpButton = new Button("Sign Up");
		signUpButton.getStyleClass().add("button-blue");
		GridPane.setConstraints(signUpButton, 1, 3);

		button = new Button();
		button.setText("Click Me");

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
				userLoggedIn=identityServiceRemote.login("u@esprit.tn", "u");
			} catch (NamingException e1) {
				e1.printStackTrace();
			}
			if(userLoggedIn.getRole().equals(Role.agent)) {
				System.out.println("agent");
			}

			boolean result = ConfirmBox.display("Bank Operations", "Are you sure you want to send that pic?");
			System.out.println(result);
		});

		// Add everything to grid
		grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton, signUpButton, button);

		scene.getStylesheets().add("Viper.css");
		window.setScene(scene);
		window.show();
	}

}