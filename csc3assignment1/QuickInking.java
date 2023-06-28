/*
Author: Abigail Gaunt
Class: CSC 214
Section: 401
Date: 8/25/2022
Assignment: Mini Project
Description: This program will create a user interface that alerts a user when a printer cartridge
is low. It will also allow the user to view basic information about each printer.
 */

package com.example.csc3assignment1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class QuickInking extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuickInking.class.getResource("quick-inking.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Quick Inking");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}