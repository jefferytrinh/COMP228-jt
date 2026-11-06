package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

	public void start(Stage stage) {

		BorderPane root = new BorderPane();

		// top
		root.setTop(new HBox(new Label("Student Registration")));

		// left
		root.setLeft(new VBox(10,
				new Button("Dashboard"),
				new Button("Registration"),
				new Button("Courses"),
				new Button("Help")));

		// form fields
		TextField id = new TextField();
		TextField name = new TextField();
		TextField email = new TextField();
		TextField program = new TextField();

		GridPane form = new GridPane();
		form.setHgap(10);
		form.setVgap(10);

		form.addRow(0, new Label("Student ID"), id);
		form.addRow(1, new Label("Full Name"), name);
		form.addRow(2, new Label("Email"), email);
		form.addRow(3, new Label("Program"), program);

		Label status = new Label();

		Button register = new Button("Register");
		Button clear = new Button("Clear");

		// when prsesed "register"
		register.setOnAction(e -> 
		{
			if (id.getText().isEmpty() ||
					name.getText().isEmpty() ||
					email.getText().isEmpty() ||
					program.getText().isEmpty()) 
			{

				status.setText("Fill all fields");
			} 
			else 
			{
				status.setText("Registered");
			}
		}
		);
		
		// when pressed "clear"
		clear.setOnAction(e -> {
			id.clear();
			name.clear();
			email.clear();
			program.clear();
			status.setText("");
		}
		);

		VBox center = new VBox(10,
				form,
				new HBox(10, register, clear),
				status);

		center.setPadding(new Insets(10));

		root.setCenter(center);

		stage.setScene(new Scene(root, 600, 350));
		stage.setTitle("Registration");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}