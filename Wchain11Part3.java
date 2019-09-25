/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wchain11part3;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author lilli
 */
public class Wchain11Part3 extends Application {

    //TextField for make and model
    TextField carMake;
    TextField carModel;

    //create a slider for year
    Slider Year;

    //Radio button for transmission type
    RadioButton Automatic;
    RadioButton Manual;

    //Check boxes for extra options
    CheckBox earView;
    CheckBox camera;
    CheckBox GPS;
    CheckBox satelliteNavigation;
    CheckBox airbags;
    CheckBox tinting;

    //buttons for new car and add car
    Button NewCar;
    Button AddCar;

    @Override
    public void start(Stage primaryStage) {
        //create a top pane
        Text textHeading = new Text("Choose your car!");
        textHeading.setFont(new Font(20));
        HBox paneTop = new HBox(textHeading);
        paneTop.setPadding(new Insets(20, 10, 20, 10));

        //Create car make label and text field
        Label lb1Make = new Label("Make");
        lb1Make.setPrefWidth(100);
        TextField txtMake = new TextField();
        txtMake.setPrefColumnCount(20);
        txtMake.setMaxWidth(Double.MAX_VALUE);
        HBox paneMake = new HBox(lb1Make, txtMake);

        //Create car model lable and text field
        Label lb1Model = new Label("Model");
        lb1Model.setPrefWidth(100);
        TextField txtModel = new TextField();
        txtModel.setPrefColumnCount(20);
        txtModel.setMaxWidth(Double.MAX_VALUE);
        HBox paneModel = new HBox(lb1Model, txtModel);

        //Create the car pane
        VBox paneCar = new VBox(10, paneMake, paneModel);

        //Create the transmission type pane
        Label lb1Trans = new Label("transmission type");
        RadioButton rdoAuto = new RadioButton("Automatic");
        RadioButton rdoManl = new RadioButton("Manual");
        rdoAuto.setSelected(true);
        ToggleGroup groupSize = new ToggleGroup();
        rdoAuto.setToggleGroup(groupSize);
        rdoManl.setToggleGroup(groupSize);

        VBox paneSize = new VBox(lb1Trans, rdoAuto, rdoManl);
        paneSize.setSpacing(10);

        //Create an extra option pane
        Label lb1ExOp = new Label("Extra Options");
        CheckBox chkEarView = new CheckBox("earView");
        CheckBox chkCamera = new CheckBox("Camera");
        CheckBox chkGPS = new CheckBox("GPS");
        CheckBox chkSatelliteNavigation = new CheckBox("Satellite Navigation");
        CheckBox chkAirbags = new CheckBox("Airbags");
        CheckBox chkTinting = new CheckBox("Tinting");

        //Create a button new car to reset 
        Button btnNC = new Button("New Car");
        btnNC.setPrefWidth(80);
        btnNC.setOnAction(e -> btnNC_Click());

        //Create a button of add car
        Button btnAC = new Button("Add Car");
        btnAC.setPrefWidth(80);
        btnAC.setOnAction(e -> btnAC_Click());

        Region spacer = new Region();

        HBox paneButton = new HBox(10, spacer, btnNC, btnAC);
        paneButton.setHgrow(spacer, Priority.ALWAYS);
        paneButton.setPadding(new Insets(20, 10, 20, 10));

        //Create a combo box contain body type
        ComboBox<String> cbox = new ComboBox<String>();
        cbox.getItems().addAll("SUV", "Sedan", "Hatch", "Ute");
        cbox.setPromptText("Choose a body type!");

        //Create a list view
        ListView list = new ListView();
        list.getItems().addAll("Collision Damage Waiver (CDW)",
                "Supplemental Liability Protection (SLP)",
                "Personal Accident Insurance (PAI)",
                "Personal Effects Coverage (PEC)");
        
        String insurances = "";
        ObservableList<String> insurances;
        insurances = list.getSelectionModel().getSelectedItems();
        for (String insurance : insurances) {
            insurances = insurance + "\n";
        }

        //Finish the pane'
        BorderPane paneMain = new BorderPane();
        paneMain.setTop(paneTop);
        Node paneCenter = null;
        paneMain.setCenter(paneCenter);
        Node paneBottom = null;
        paneMain.setBottom(paneBottom);

        //Create the scene and stage
        Scene scene = new Scene(paneMain);

        primaryStage.setTitle("Choose a Car!!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void btnNC_Click() {

    }

    public void btnAC_Click() {

    }
}