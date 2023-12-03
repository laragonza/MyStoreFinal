package com.example.mystore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * Clase principal de la aplicación.
 */
public class HelloApplication extends Application {

    /**
     * Inicia la aplicación cargando la vista principal.
     *
     * @param primaryStage El escenario principal de la aplicación.
     */
    @Override
    public void start(Stage primaryStage) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra una nueva página utilizando un FXMLLoader.
     *
     * @param event      El evento de acción.
     * @param fxmlLoader El cargador de FXML para la nueva página.
     */
    @FXML
    void mostrarPagina(ActionEvent event, FXMLLoader fxmlLoader) {
        try {
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cierra la página actual.
     *
     * @param event      El evento de acción.
     * @param btnEmpezar El botón que activó el evento.
     */
    @FXML
    public void cerrarPagina(ActionEvent event, Button btnEmpezar) {
        try {
            // Selecciona la vista a la que pertenece el botón
            Stage stage = (Stage) btnEmpezar.getScene().getWindow();
            // Haciendo .hide cierra la ventana con la opción de reabrir la vista
            stage.hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
