package com.example.mystore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.fxml.FXMLLoader;

/**
 * Controlador para la vista de detalles del producto.
 */
public class ProductDetailsViewController {

    @FXML
    private Label productNameLabel;

    @FXML
    private Label productPriceLabel;

    @FXML
    private Label productDescriptionLabel;

    @FXML
    private ImageView productImageView;

    @FXML
    private Button btnAdd, btnAd, btnHome, btnDescuentos;

    HelloApplication main = new HelloApplication();
    FXMLLoader loaderHome = new FXMLLoader(getClass().getResource("HomeView.fxml"));

    /**
     * Muestra la vista de inicio (Home).
     *
     * @param event El evento de acción.
     */
    @FXML
    void showHome(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnAdd);
            main.cerrarPagina(event, btnHome);
            main.mostrarPagina(event, loaderHome);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    FXMLLoader loaderDescuentos = new FXMLLoader(getClass().getResource("DescuentosView.fxml"));

    /**
     * Muestra la vista de descuentos.
     *
     * @param event El evento de acción.
     */
    @FXML
    void showDescuentos(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnAd);
            main.cerrarPagina(event, btnDescuentos);
            main.mostrarPagina(event, loaderDescuentos);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
