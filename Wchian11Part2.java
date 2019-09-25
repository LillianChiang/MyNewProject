/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wchian11part2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 *
 * @author lilli
 */
public class Wchian11Part2 extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        //create an image
        Image image = new Image(new FileInputStream("path of an image"));

        //Setting the image view
        ImageView imageView = new ImageView(image);

        //Setting the position of image
        imageView.setX(50);
        imageView.setY(25);

        // set the height and width of the image
        imageView.setFitHeight(455);
        imageView.setFitWidth(500);

        //set thr preserve ratio of image view
        imageView.setPreserveRatio(true);
        //add a polygon
        Polygon p1 = new Polygon();
        p1.getPoints().addAll(new Double[]{
            0.0, 0.0,
            150.0, 130.0,
            150.0, 60.0});
        
        //Create a group object
        Group root = new Group(imageView);

        //Create a scene
        Scene scene = new Scene(root, 600, 400);

        //set title of the stage
        stage.settTitle("Loading an image");

        //add scene to the stage
        stage.setScene(scene);

        //Display the stage
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}