package com.github.visual;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * THE FOLLOWING PROGRAM EXAMPLE WAS MADE BY TIM KOCHETKOV WITH ASSISTANCE OF Michael B., his dear friend.
 * Michael's GitHub --- https://github.com/KolyanPie
 * TIM's GitHub --- https://github.com/TimofeyKochetkov
 */
public class MandelbrotSetVisualApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });
        primaryStage.setResizable(false);
        primaryStage.setTitle("Mandelbrot set visual test");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main_window.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
