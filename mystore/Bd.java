package com.example.mystore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.TextField;

/**
 * Clase que gestiona la conexión a la base de datos y realiza operaciones relacionadas con usuarios.
 */
public class Bd {

    private static Connection conexion = null;
    private static Statement sentenciaSQL = null;

    /**
     * Constructor de la clase Bd.
     */
    public Bd() {
        super();
    }

    //----------------------------------------------------------------------------------------------------------

    /**
     * Conectar a la base de datos.
     *
     * @throws SQLException Excepción en caso de error de SQL.
     */
    final void conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/MyStore", "root", "root");
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        }
    }

    /**
     * Desconectar de la base de datos.
     *
     * @throws SQLException Excepción en caso de error de SQL.
     */
    final void desconectar() throws SQLException {
        try {
            sentenciaSQL.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Guardar un nuevo usuario al registrarse.
     *
     * @param nombre    Nombre del usuario.
     * @param apellidos Apellidos del usuario.
     * @param email     Correo electrónico del usuario.
     * @param password  Contraseña del usuario.
     */
    public void guardarUsuario(TextField nombre, TextField apellidos, TextField email, TextField password) {
        int result;
        String sql;

        String nombreAux = nombre.getText();
        String apellidosAux = apellidos.getText();
        String emailAux = email.getText();
        String passwordAux = password.getText();

        try {

            // ANTES TENEMOS QUE VERIFICAR SI EL USUARIO EXISTE

            conectar();
            sentenciaSQL = conexion.createStatement();

            // Sentencia para añadir usuarios a la tabla
            sql = "INSERT INTO usuarios (userName, userSurname, userMail, userPassword) VALUES ('" + nombreAux + "', '" + apellidosAux + "', '" + emailAux + "', '" + passwordAux + "')";
            result = sentenciaSQL.executeUpdate(sql);

            // Se incrementa el valor de los personajes almacenados en el arrayList
            System.out.println("Usuario añadido");

            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al guardar el usuario");
        }
    }

    /**
     * Iniciar sesión de un usuario.
     *
     * @param email    Correo electrónico del usuario.
     * @param password Contraseña del usuario.
     * @return true si el usuario se encuentra, false de lo contrario.
     */
    public boolean iniciarSesion(TextField email, TextField password) {
        boolean encontrado = false;
        ResultSet result;
        String sql;
        String emailAux = email.getText();
        String passwordAux = password.getText();

        try {
            conectar();
            sentenciaSQL = conexion.createStatement();

            // Sentencia para añadir usuarios a la tabla
            sql = "SELECT userMail, userPassword FROM usuarios where userMail = '" + emailAux + "' and userPassword = '" + passwordAux + "'";
            result = sentenciaSQL.executeQuery(sql);

            // Siempre se ejecuta cada vez que encuentre un dato buscado en la secuencia
            if (result.next()) {
                System.out.println("User found");
                encontrado = true;
            }

            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al encontrar el usuario");
        }

        return encontrado;
    }

    /**
     * Obtener el ID de un usuario.
     *
     * @param txtUsername Nombre de usuario o correo electrónico.
     * @param txtPassword Contraseña del usuario.
     * @return ID del usuario.
     */
    public int getIdUser(TextField txtUsername, TextField txtPassword) {
        int id = 0;

        ResultSet result;
        String sql;

        String emailAux = txtUsername.getText();
        String passwordAux = txtPassword.getText();

        try {

            conectar();
            sentenciaSQL = conexion.createStatement();

            // Sentencia para añadir usuarios a la tabla
            sql = "SELECT idUsuarios FROM usuarios where userMail = '" + emailAux + "' and userPassword = '" + passwordAux + "'";
            result = sentenciaSQL.executeQuery(sql);

            // Siempre se ejecuta cada vez que encuentre un dato buscado en la secuencia
            if(result.next()) {
                id = result.getInt("idusuarios");
                System.out.println("El id del usuario en el sql es : " + id);
            }

            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al obtener el id del usuario");
        }

        return id;
    }

    /**
     * Mostrar el nombre de un usuario dado su ID.
     *
     * @param idUser ID del usuario.
     * @return Nombre del usuario.
     */
    public String mostrarNombre (int idUser){

        ResultSet result;
        String sql;
        String nombreAux = "";


        try {

            conectar();
            sentenciaSQL = conexion.createStatement();

            // Sentencia para añadir usuarios a la tabla
            sql = "SELECT userName FROM usuarios where idUsuarios = '" + idUser + "'";
            result = sentenciaSQL.executeQuery(sql);

            // Siempre se ejecuta cada vez que encuentre un dato buscado en la secuencia
            if(result.next()) {
                nombreAux = result.getString("userName");
                System.out.println("El nombre del usuario en el sql es : " + nombreAux);
            }

            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al obtener el id del usuario");
        }
        return nombreAux;
    }
}
