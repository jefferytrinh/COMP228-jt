package com.mycompany.hospitalmanagementsystem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HospitalManagementSystem extends Application
{
    private TextField txtId = new TextField();
    private TextField txtName = new TextField();
    private TextField txtAge = new TextField();
    private TextField txtPhone = new TextField();
    private TextField txtDiagnosis = new TextField();

    private ComboBox<String> cboGender =
            new ComboBox<>();

    private DatePicker dpDate =
            new DatePicker();

    private Label lblStatus =
            new Label("Ready");

    private TableView<Patient> table =
            new TableView<>();

    @Override
    public void start(Stage stage)
    {
        BorderPane root = new BorderPane();

        Label lblTitle =
                new Label("Hospital Management System");

        Label lblSubtitle =
                new Label("Patient Registration Module");

        VBox topBox =
                new VBox(5, lblTitle, lblSubtitle);

        root.setTop(topBox);

        txtId.setEditable(false);

        cboGender.getItems().addAll(
                "Female",
                "Male",
                "Non-binary",
                "Prefer not to say"
        );

        GridPane form = new GridPane();

        form.setHgap(10);
        form.setVgap(10);

        form.add(new Label("Patient ID"),0,0);
        form.add(txtId,1,0);

        form.add(new Label("Name"),0,1);
        form.add(txtName,1,1);

        form.add(new Label("Age"),0,2);
        form.add(txtAge,1,2);

        form.add(new Label("Gender"),0,3);
        form.add(cboGender,1,3);

        form.add(new Label("Phone"),0,4);
        form.add(txtPhone,1,4);

        form.add(new Label("Diagnosis"),0,5);
        form.add(txtDiagnosis,1,5);

        form.add(new Label("Admission Date"),0,6);
        form.add(dpDate,1,6);

        Button btnAdd =
                new Button("Add Patient");

        Button btnUpdate =
                new Button("Update");

        Button btnDelete =
                new Button("Delete");

        Button btnClear =
                new Button("Clear");

        HBox buttonBox = new HBox(
                10,
                btnAdd,
                btnUpdate,
                btnDelete,
                btnClear);

        VBox leftSide =
                new VBox(
                        10,
                        form,
                        buttonBox);

        TableColumn<Patient,Integer> colId =
                new TableColumn<>("ID");

        colId.setCellValueFactory(
                new PropertyValueFactory<>("patientId"));

        TableColumn<Patient,String> colName =
                new TableColumn<>("Name");

        colName.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        TableColumn<Patient,Integer> colAge =
                new TableColumn<>("Age");

        colAge.setCellValueFactory(
                new PropertyValueFactory<>("age"));

        TableColumn<Patient,String> colGender =
                new TableColumn<>("Gender");

        colGender.setCellValueFactory(
                new PropertyValueFactory<>("gender"));

        TableColumn<Patient,String> colPhone =
                new TableColumn<>("Phone");

        colPhone.setCellValueFactory(
                new PropertyValueFactory<>("phone"));

        TableColumn<Patient,String> colDiagnosis =
                new TableColumn<>("Diagnosis");

        colDiagnosis.setCellValueFactory(
                new PropertyValueFactory<>("diagnosis"));

        TableColumn<Patient,LocalDate> colDate =
                new TableColumn<>("Admission Date");

        colDate.setCellValueFactory(
                new PropertyValueFactory<>("admissionDate"));

        table.getColumns().setAll(
        	    colId,
        	    colName,
        	    colAge,
        	    colGender,
        	    colPhone,
        	    colDiagnosis,
        	    colDate
        	);

        TextField txtSearch =
                new TextField();

        Button btnShowAll =
                new Button("Show All");

        HBox searchBox =
                new HBox(
                        10,
                        txtSearch,
                        btnShowAll);

        VBox rightSide =
                new VBox(
                        10,
                        searchBox,
                        table);

        HBox center =
                new HBox(
                        20,
                        leftSide,
                        rightSide);

        root.setCenter(center);

        root.setBottom(lblStatus);

        btnAdd.setOnAction(
                e -> addPatient());

        btnClear.setOnAction(
                e -> clearForm());

        btnShowAll.setOnAction(
                e -> loadPatients());

        Scene scene =
                new Scene(root,1000,600);

        stage.setScene(scene);
        stage.setTitle(
                "Hospital Management System");
        stage.show();

        loadPatients();
    }

    private boolean validateInput()
    {
        if(txtName.getText().trim().isEmpty())
            return false;

        try
        {
            int age =
                    Integer.parseInt(
                            txtAge.getText());

            if(age < 0 || age > 125)
                return false;
        }
        catch(Exception e)
        {
            return false;
        }

        if(cboGender.getValue() == null)
            return false;

        if(txtPhone.getText().trim().isEmpty())
            return false;

        if(txtDiagnosis.getText().trim().isEmpty())
            return false;

        if(dpDate.getValue() == null)
            return false;

        return true;
    }

    private void addPatient()
    {
        if(!validateInput())
        {
            lblStatus.setText(
                    "Invalid input.");

            return;
        }

        String sql =
                "INSERT INTO patients "
              + "(name,age,gender,phone,diagnosis,admission_date) "
              + "VALUES(?,?,?,?,?,?)";

        try(
            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql))
        {
            ps.setString(
                    1,
                    txtName.getText());

            ps.setInt(
                    2,
                    Integer.parseInt(
                            txtAge.getText()));

            ps.setString(
                    3,
                    cboGender.getValue());

            ps.setString(
                    4,
                    txtPhone.getText());

            ps.setString(
                    5,
                    txtDiagnosis.getText());

            ps.setDate(
                    6,
                    Date.valueOf(
                            dpDate.getValue()));

            ps.executeUpdate();

            lblStatus.setText(
                    "Patient added.");

            loadPatients();
            clearForm();
        }
        catch(Exception e)
        {
            lblStatus.setText(
                    e.getMessage());
        }
    }

    private void loadPatients()
    {
        ObservableList<Patient> patients =
                FXCollections.observableArrayList();

        String sql =
                "SELECT * FROM patients";

        try(
            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery())
        {
            while(rs.next())
            {
                patients.add(
                        new Patient(
                                rs.getInt("patient_id"),
                                rs.getString("name"),
                                rs.getInt("age"),
                                rs.getString("gender"),
                                rs.getString("phone"),
                                rs.getString("diagnosis"),
                                rs.getDate("admission_date")
                                        .toLocalDate()
                        ));
            }

            table.setItems(patients);
        }
        catch(Exception e)
        {
            lblStatus.setText(
                    e.getMessage());
        }
    }

    private void clearForm()
    {
        txtId.clear();
        txtName.clear();
        txtAge.clear();
        txtPhone.clear();
        txtDiagnosis.clear();

        cboGender.setValue(null);
        dpDate.setValue(null);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}