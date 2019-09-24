/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wchian11part1;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.scene.shape.*;
import javafx.scene.control.*;

/**
 *
 * @author lilli
 */
public class Wchian11Part1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Create a Circle
        Circle c1 = new Circle(10, 10, 50, Color.YELLOW);
        c1.setStroke(Color.BLACK);
        c1.setStrokeWidth(2.0);

        //Create a Rectagle
        Rectangle r1 = new Rectangle(10, 50, Color.BLUE);

        //Create a Polygon
        Polygon p1 = new Polygon();
        p1.getPoints().addAll(new Double[]{
            0.0, 0.0,
            150.0, 130.0,
            150.0, 60.0});
        p1.setStroke(Color.PINK);
        // create a anonymous inner class
        p1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                p1.setFill(Color.PINK);
            }
        });
        //Create a line
        Line line = new Line(0, 0, 50, 0);
        line.setStrokeWidth(5.5);
        line.setStroke(Color.RED);

        line.setOnAction(e -> line_Clicked());
        
        //Create the GridPane layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setMinWidth(500);
        grid.setMaxWidth(800);
        
        //Create a HBox
        HBox hbCircle = new HBox(10);
        hbCircle.setSpacing(10);

        //set Halignments 
        grid.setHalignment(c1, HPos.CENTER);
        grid.setHalignment(r1, HPos.RIGHT);
        grid.setHalignment(p1, HPos.LEFT);
        grid.setHalignment(line, HPos.RIGHT);
        
        VBox vbox =  new VBox();
        vbox.setSpacing(10);
        //set Valignment
        grid.setValignment(c1, VPos.CENTER);
        grid.setValignment(r1, VPos.TOP);
        grid.setValignment(p1, VPos.CENTER);
        grid.setValignment(line, VPos.TOP);
        
        //add shapes to gridpane
        grid.getChildren().add(c1);
        grid.getChildren().add(r1);
        grid.getChildren().add(line);
        grid.getChildren().add(p1);

        //Create the mouse event handler
        EventHandler<MouseEvent> eventHandler
                = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                c1.setFill(Color.AQUA);
                r1.setFill(Color.PINK);

            }
        };

        //create mouse event for each shape
        c1.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        r1.addEventHandler(MouseEvent.MOUSE_DRAGGED, eventHandler);
        p1.addEventHandler(MouseEvent.MOUSE_ENTERED, eventHandler);
        line.addEventHandler(MouseEvent.MOUSE_EXITED, eventHandler);

        // grid.setOnKeyPressed(new EventHandler<KeyEvent>(){
        Scene scene = new Scene(grid, 300, 250);

        primaryStage.setTitle("Shapes!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Handle the key event
    private class Handler
            implements EventHandler<KeyEvent> {

        private Object stage;

        @Override
        public void handle(KeyEvent ke) {
            if (ke.getCode() == KeyCode.ESCAPE) {
                System.out.println("ENTER Pressed: " + ke.getCode());
                stage.getClass();
            }
        }
    }

    private void line_Clicked() {
        
      System.out.println("Click me");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}