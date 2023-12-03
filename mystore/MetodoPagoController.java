// MetodoPagoController.java
package com.example.mystore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Controlador para la vista de método de pago.
 */
public class MetodoPagoController {

    @FXML
    private TextField txtNombreTitular;

    @FXML
    private TextField txtNumeroTarjeta;

    @FXML
    private TextField txtFechaVencimiento;

    @FXML
    private TextField txtCVV;

    @FXML
    private Button btnPagar;

    @FXML
    private void realizarPago(ActionEvent event) {
        // Lógica para realizar el pago
        String nombreTitular = txtNombreTitular.getText();
        String numeroTarjeta = txtNumeroTarjeta.getText();
        String fechaVencimiento = txtFechaVencimiento.getText();
        String cvv = txtCVV.getText();

        try {
            // Cierra la página actual y muestra la vista de agradecimiento
            main.cerrarPagina(event, btnPagar);
            main.mostrarPagina(event, loaderGracias);
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("Pago realizado con éxito");
    }

    HelloApplication main = new HelloApplication();
    Bd baseDatos = new Bd();
    FXMLLoader loaderGracias = new FXMLLoader(getClass().getResource("GraciasView.fxml"));
}
