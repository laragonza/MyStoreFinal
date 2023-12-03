package com.example.mystore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador para la vista principal.
 */
public class MainViewController implements Initializable {

    @FXML
    private Button btnMostrarInicioSesion, btnMostrarRegistro;

    @FXML
    private TextField txtMostrar;

    @FXML
    private MediaView mediaView;

    File file = new File("C:\\Users\\Raúl\\IdeaProjects\\MyStore\\src\\main\\resources\\Vid\\VideoPrincipal.mp4");
    private Media media;
    private MediaPlayer mediaPlayer;

    // Esto sirve para añadir el enlace a las vistas
    HelloApplication main = new HelloApplication();

    // Dirección de las diferentes vistas que se podrán usar
    FXMLLoader loaderLogin = new FXMLLoader(getClass().getResource("LoginView.fxml"));
    FXMLLoader loaderRegistro = new FXMLLoader(getClass().getResource("RegistroView.fxml"));

    /**
     * Inicializa la vista principal.
     *
     * @param url            La URL de inicialización.
     * @param resourceBundle El paquete de recursos de inicialización.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        // Botones de relleno
        mediaPlayer.play();
    }

    /**
     * Muestra la vista de inicio de sesión.
     *
     * @param event El evento de acción.
     */
    @FXML
    void MostrarViewInicioSesion(ActionEvent event) {
        try {
            // Creamos objeto del Main para poder llamar al método start2
            main.cerrarPagina(event, btnMostrarInicioSesion);
            main.mostrarPagina(event, loaderLogin);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra la vista de registro.
     *
     * @param event El evento de acción.
     */
    @FXML
    void MostrarViewRegistro(ActionEvent event) {
        try {
            // Creamos objeto del Main para poder llamar al método start2
            main.cerrarPagina(event, btnMostrarRegistro);
            main.mostrarPagina(event, loaderRegistro);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
