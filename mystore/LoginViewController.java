package com.example.mystore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controlador para la vista de inicio de sesión.
 */
public class LoginViewController {

    @FXML
    private TextField txtUsername;

    @FXML
    private Button btnAcceder;

    @FXML
    private ImageView imgInicio;

    int idUser = 0;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnRegistro;

    HelloApplication main = new HelloApplication();
    Bd baseDatos = new Bd();
    FXMLLoader loaderHome = new FXMLLoader(getClass().getResource("HomeView.fxml"));
    FXMLLoader loaderRegistro = new FXMLLoader(getClass().getResource("RegistroView.fxml"));

    /**
     * Muestra la vista de registro.
     *
     * @param event El evento de acción.
     */
    @FXML
    void MostrarViewRegistro(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnRegistro);
            main.mostrarPagina(event, loaderRegistro);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra la vista principal si el inicio de sesión es exitoso.
     *
     * @param event El evento de acción.
     */
    @FXML
    void showHome(ActionEvent event) {

        boolean encontrados = false;

        try {
            encontrados = baseDatos.iniciarSesion(txtUsername, txtPassword);

            // Una vez encontrado el usuario, accedo a la siguiente vista
            if(encontrados) {
                idUser = baseDatos.getIdUser(txtUsername, txtPassword);
                main.cerrarPagina(event, btnAcceder);
                showHome2(event, loaderHome, idUser);
            }

        } catch(Exception e) {
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
            Home pview = fxmlLoader.getController();
            pview.mostrarId(idUser);

            System.out.println("Usuario en vista login: " + idUser);

            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
