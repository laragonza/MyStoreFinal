package com.example.mystore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

/**
 * Controlador para la vista de la cesta de compras.
 */
public class CestaViewController {

    @FXML
    private TableView<Product> tablaCesta;

    @FXML
    private Button btnRealizarPago;

    HelloApplication main = new HelloApplication();
    Bd baseDatos = new Bd();
    FXMLLoader loaderRealizarPago = new FXMLLoader(getClass().getResource("MetodoPagoView.fxml"));

    /**
     * Maneja el evento de realizar el pago.
     *
     * @param event El evento de acción.
     */
    @FXML
    void realizarPago(ActionEvent event) {
        try {
            // Cierra la página actual
            main.cerrarPagina(event, btnRealizarPago);

            // Muestra la página de realizar pago
            main.mostrarPagina(event, loaderRealizarPago);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
