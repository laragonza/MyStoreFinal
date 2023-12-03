package com.example.mystore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Controlador para la vista de registro de usuarios.
 */
public class RegistroViewController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtMail;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnAcceder;

    @FXML
    private Button btnLogin;

    HelloApplication main = new HelloApplication();
    Bd baseDatos = new Bd();
    FXMLLoader loaderLogin = new FXMLLoader(getClass().getResource("LoginView.fxml"));

    /**
     * Muestra la vista de inicio de sesión.
     *
     * @param event El evento de acción.
     */
    @FXML
    void MostrarViewInicioSesion(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnLogin);
            main.mostrarPagina(event, loaderLogin);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra la vista principal después de realizar el registro de un nuevo usuario.
     *
     * @param event El evento de acción.
     */
    @FXML
    void showHome(ActionEvent event) {
        boolean encontrados = false;

        try {
            encontrados = baseDatos.iniciarSesion(txtMail, txtPassword);

            // Una vez encontrado el usuario, accede a la siguiente vista
            if (!encontrados) {
                baseDatos.guardarUsuario(txtNombre, txtApellidos, txtMail, txtPassword);
                main.cerrarPagina(event, btnAcceder);
                main.mostrarPagina(event, loaderLogin);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
