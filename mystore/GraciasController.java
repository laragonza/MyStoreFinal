package com.example.mystore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

/**
 * Controlador para la vista de agradecimiento.
 */
public class GraciasController {

    @FXML
    private Button btnHome;

    HelloApplication main = new HelloApplication();
    FXMLLoader loaderGracias = new FXMLLoader(getClass().getResource("HomeView.fxml"));

    /**
     * Muestra la vista de inicio desde la vista de agradecimiento.
     *
     * @param event El evento de acción.
     */
    @FXML
    void showHome(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnHome);
            main.mostrarPagina(event, loaderGracias);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
