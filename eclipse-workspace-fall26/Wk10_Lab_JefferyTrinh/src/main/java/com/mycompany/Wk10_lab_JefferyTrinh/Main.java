package com.mycompany.Wk10_lab_JefferyTrinh;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage stage)
    {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        TextField txtFullName = new TextField();
        TextField txtAddress = new TextField();
        TextField txtPhone = new TextField();
        TextField txtEmail = new TextField();
        TextField txtEducation = new TextField();
        TextField txtPosition = new TextField();
        TextField txtSalary = new TextField();
        TextField txtExplanation = new TextField();
        TextField txtSignature = new TextField();

        DatePicker dpAvailable = new DatePicker();

        RadioButton rbMale = new RadioButton("Male");
        RadioButton rbFemale = new RadioButton("Female");
        RadioButton rbOther = new RadioButton("Other");

        ToggleGroup genderGroup = new ToggleGroup();
        rbMale.setToggleGroup(genderGroup);
        rbFemale.setToggleGroup(genderGroup);
        rbOther.setToggleGroup(genderGroup);

        RadioButton rbAuthorizedYes = new RadioButton("Yes");
        RadioButton rbAuthorizedNo = new RadioButton("No");

        ToggleGroup authGroup = new ToggleGroup();
        rbAuthorizedYes.setToggleGroup(authGroup);
        rbAuthorizedNo.setToggleGroup(authGroup);

        RadioButton rbRelativeYes = new RadioButton("Yes");
        RadioButton rbRelativeNo = new RadioButton("No");

        ToggleGroup relativeGroup = new ToggleGroup();
        rbRelativeYes.setToggleGroup(relativeGroup);
        rbRelativeNo.setToggleGroup(relativeGroup);

        Button btnSubmit = new Button("Submit");

        grid.add(new Label("Full Name"), 0, 0);
        grid.add(txtFullName, 1, 0);

        grid.add(new Label("Current Address"), 0, 1);
        grid.add(txtAddress, 1, 1);

        grid.add(new Label("Contact Number"), 0, 2);
        grid.add(txtPhone, 1, 2);

        grid.add(new Label("Email Address"), 0, 3);
        grid.add(txtEmail, 1, 3);

        grid.add(new Label("Highest Educational Attainment"), 0, 4);
        grid.add(txtEducation, 1, 4);

        grid.add(new Label("Gender"), 0, 5);
        grid.add(rbMale, 1, 5);
        grid.add(rbFemale, 2, 5);
        grid.add(rbOther, 3, 5);

        grid.add(new Label("Date Available"), 0, 6);
        grid.add(dpAvailable, 1, 6);

        grid.add(new Label("Desired Position"), 0, 7);
        grid.add(txtPosition, 1, 7);

        grid.add(new Label("Desired Salary"), 0, 8);
        grid.add(txtSalary, 1, 8);

        grid.add(new Label("Authorized To Work"), 0, 9);
        grid.add(rbAuthorizedYes, 1, 9);
        grid.add(rbAuthorizedNo, 2, 9);

        grid.add(new Label("Relatives Working Here"), 0, 10);
        grid.add(rbRelativeYes, 1, 10);
        grid.add(rbRelativeNo, 2, 10);

        grid.add(new Label("Explanation"), 0, 11);
        grid.add(txtExplanation, 1, 11);

        grid.add(new Label("Signature"), 0, 12);
        grid.add(txtSignature, 1, 12);

        grid.add(btnSubmit, 1, 13);

        btnSubmit.setOnAction(e ->
        {
            try
            {
                String gender = "";

                if (rbMale.isSelected())
                    gender = "Male";
                else if (rbFemale.isSelected())
                    gender = "Female";
                else
                    gender = "Other";

                String authorized =
                        rbAuthorizedYes.isSelected() ? "Yes" : "No";

                String relatives =
                        rbRelativeYes.isSelected() ? "Yes" : "No";

                String sql =
                    "INSERT INTO applications " +
                    "(full_name,current_address,contact_number,email_address," +
                    "education,gender,date_available,desired_position," +
                    "desired_salary,authorized_to_work,relatives_working," +
                    "explanation,signature) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

                try (Connection conn = DBConnection.getConnection();
                     PreparedStatement ps = conn.prepareStatement(sql))
                {
                    ps.setString(1, txtFullName.getText());
                    ps.setString(2, txtAddress.getText());
                    ps.setString(3, txtPhone.getText());
                    ps.setString(4, txtEmail.getText());
                    ps.setString(5, txtEducation.getText());
                    ps.setString(6, gender);
                    ps.setDate(7, Date.valueOf(dpAvailable.getValue()));
                    ps.setString(8, txtPosition.getText());
                    ps.setString(9, txtSalary.getText());
                    ps.setString(10, authorized);
                    ps.setString(11, relatives);
                    ps.setString(12, txtExplanation.getText());
                    ps.setString(13, txtSignature.getText());

                    ps.executeUpdate();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("Application Saved!");
                    alert.showAndWait();
                }
            }
            catch (Exception ex)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
        });

        Scene scene = new Scene(grid, 800, 650);

        stage.setTitle("Employment Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}