package com.example.mystore;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

/**
 * Controlador para la vista principal (Home).
 */
public class Home {

    @FXML
    private Label welcomeUserLabel, txtId;

    @FXML
    private Button btnDescuentos, btnCesta, btnImage1, btnImage2, btnImage9, btnImage20, btnImage21;

    int idUsuario = 0;

    Bd baseDatos = new Bd();

    /**
     * Muestra el ID del usuario y su nombre en la etiqueta de bienvenida.
     *
     * @param idUser ID del usuario.
     */
    public void mostrarId(int idUser) {
        txtId.setText(String.valueOf(idUser));
        idUsuario = Integer.parseInt(txtId.getText());
        System.out.println("El id recogido es: " + idUsuario);
        String nombreAux = baseDatos.mostrarNombre(idUsuario);
        welcomeUserLabel.setText("Bienvenido, " + nombreAux);
    }

    FXMLLoader loaderProduct1 = new FXMLLoader(getClass().getResource("ProductDetails1View.fxml"));
    FXMLLoader loaderProduct2 = new FXMLLoader(getClass().getResource("ProductDetails2View.fxml"));
    FXMLLoader loaderProduct3 = new FXMLLoader(getClass().getResource("ProductDetails3View.fxml"));
    FXMLLoader loaderProduct4 = new FXMLLoader(getClass().getResource("ProductDetails4View.fxml"));
    FXMLLoader loaderProduct5 = new FXMLLoader(getClass().getResource("ProductDetails5View.fxml"));

    /**
     * Muestra la vista del producto 1.
     *
     * @param event El evento de acción.
     */
    @FXML
    void showProduct1(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnImage1);
            main.mostrarPagina(event, loaderProduct1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showProduct2(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnImage2);
            main.mostrarPagina(event, loaderProduct2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showProduct9(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnImage9);
            main.mostrarPagina(event, loaderProduct3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showProduct20(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnImage20);
            main.mostrarPagina(event, loaderProduct4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showProduct21(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnImage21);
            main.mostrarPagina(event, loaderProduct5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    HelloApplication main = new HelloApplication();
    FXMLLoader loaderDescuentos = new FXMLLoader(getClass().getResource("DescuentosView.fxml"));

    /**
     * Muestra la vista de descuentos.
     *
     * @param event El evento de acción.
     */
    @FXML
    void MostrarViewDescuento(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnDescuentos);
            showHome2(event, loaderDescuentos, idUsuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    FXMLLoader loaderCesta = new FXMLLoader(getClass().getResource("CestaView.fxml"));

    /**
     * Muestra la vista de la cesta de compras.
     *
     * @param event El evento de acción.
     */
    @FXML
    void MostrarViewCesta(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnCesta);
            main.mostrarPagina(event, loaderCesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra la vista principal con el ID del usuario.
     *
     * @param event      El evento de acción.
     * @param fxmlLoader El cargador de FXML.
     * @param idUser     ID del usuario.
     */
    @FXML
    void showHome2(ActionEvent event, FXMLLoader fxmlLoader, int idUser) {
        try {
            Parent root1 = (Parent) fxmlLoader.load();
            DescuentosController pview = fxmlLoader.getController();
            pview.mostrarId(idUser);

            System.out.println("Usuario en vista login: " + idUser);

            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
