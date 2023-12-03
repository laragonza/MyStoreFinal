package com.example.mystore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Controlador para la vista de descuentos.
 */
public class DescuentosController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField searchField;

    @FXML
    private Button btnCesta, btnImage22, btnImage23, btnImage30, btnImage41, btnImage42;
    @FXML
    private Button btnHome;

    @FXML
    private Label welcomeUserLabel, txtId;

    @FXML
    private VBox vBox;

    @FXML
    private HBox hBox1;

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

    HelloApplication main = new HelloApplication();
    FXMLLoader loaderHome = new FXMLLoader(getClass().getResource("HomeView.fxml"));

    /**
     * Muestra la vista de inicio.
     *
     * @param event El evento de acción.
     */
    @FXML
    void showViewHome(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnHome);
            showHome2(event, loaderHome, idUsuario);
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
     * Muestra la vista de inicio con el ID del usuario.
     *
     * @param event      El evento de acción.
     * @param fxmlLoader El cargador de FXML.
     * @param idUser     ID del usuario.
     */
    @FXML
    void showHome2(ActionEvent event, FXMLLoader fxmlLoader, int idUser) {
        try {
            Parent root1 = (Parent) fxmlLoader.load();
            Home pview = fxmlLoader.getController();
            pview.mostrarId(idUser);

            System.out.println("Usuario en vista login: " + idUser);

            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    FXMLLoader loaderProduct1 = new FXMLLoader(getClass().getResource("ProductDetails6View.fxml"));
    FXMLLoader loaderProduct2 = new FXMLLoader(getClass().getResource("ProductDetails7View.fxml"));
    FXMLLoader loaderProduct3 = new FXMLLoader(getClass().getResource("ProductDetails8View.fxml"));
    FXMLLoader loaderProduct4 = new FXMLLoader(getClass().getResource("ProductDetails9View.fxml"));
    FXMLLoader loaderProduct5 = new FXMLLoader(getClass().getResource("ProductDetailsView.fxml"));

    /**
     * Muestra la vista del producto 22.
     *
     * @param event El evento de acción.
     */
    @FXML
    void showProduct22(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnImage22);
            main.mostrarPagina(event, loaderProduct1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showProduct23(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnImage23);
            main.mostrarPagina(event, loaderProduct2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showProduct30(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnImage30);
            main.mostrarPagina(event, loaderProduct3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showProduct41(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnImage41);
            main.mostrarPagina(event, loaderProduct4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showProduct42(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnImage42);
            main.mostrarPagina(event, loaderProduct5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
