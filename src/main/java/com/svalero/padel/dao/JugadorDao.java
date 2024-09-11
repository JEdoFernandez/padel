package com.svalero.padel.dao;

import com.svalero.padel.domain.ClubPadel;
import com.svalero.padel.domain.Jugador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class JugadorDao {
    private Connection connection;

    public JugadorDao(Connection connection) {
        this.connection = connection;
    }

    public void add(Jugador jugador) throws SQLException, Exception {
        try {
            String sql = "INSERT INTO JUGADOR (ID_JUGADOR, NOMBRE, GENERO, NIVEL, EDAD, POSICION) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, jugador.getId_jugador());
            statement.setString(2, jugador.getNombre());
            statement.setString(3, jugador.getGenero());
            statement.setString(4, jugador.getNivel());
            statement.setInt(5, jugador.getEdad());
            statement.setString(6, jugador.getPosicion());

            statement.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Error al insertar datos");
            sqle.printStackTrace();
        }
    }

    public boolean delete(String idJugador) throws SQLException {
        try {
            String sql = "DELETE FROM JUGADOR WHERE ID_JUGADOR = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, idJugador);
            int rows = statement.executeUpdate();

            return rows == 1;
        } catch (SQLException sqle) {
            System.out.println("Error borrando datos");
            sqle.printStackTrace();
            return false;
        }
    }

    public boolean modify(String idJugador, Jugador jugador) throws SQLException {
        try {
            String sql = "UPDATE JUGADOR SET NOMBRE = ?, GENERO = ?, NIVEL = ?, EDAD = ?, POSICION = ? WHERE ID_JUGADOR = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, jugador.getNombre());
            statement.setString(2, jugador.getGenero());
            statement.setString(3, jugador.getNivel());
            statement.setInt(4, jugador.getEdad());
            statement.setString(5, jugador.getPosicion());
            statement.setString(6, idJugador);

            int rows = statement.executeUpdate();
            return rows == 1;
        } catch (SQLException sqle) {
            System.out.println("Error modificando registro");
            sqle.printStackTrace();
            return false;
        }
    }

    public ArrayList<Jugador> showAll() throws SQLException {
        String sql = "SELECT * FROM JUGADOR ORDER BY ID_JUGADOR";
        ArrayList<Jugador> listJugador = new ArrayList<>();

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Jugador jugador = new Jugador();
            jugador.setId_jugador(resultSet.getString("ID_JUGADOR"));
            jugador.setNombre(resultSet.getString("NOMBRE"));
            jugador.setGenero(resultSet.getString("GENERO"));
            jugador.setNivel(resultSet.getString("NIVEL"));
            jugador.setEdad(resultSet.getInt("EDAD"));
            jugador.setPosicion(resultSet.getString("POSICION"));

            listJugador.add(jugador);
        }

        return listJugador;
    }

    public Jugador findById(String idJugador) throws SQLException {
        String sql = "SELECT * FROM JUGADOR WHERE ID_JUGADOR = ?";
        Jugador jugador = new Jugador();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, idJugador);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            jugador.setId_jugador(resultSet.getString("ID_JUGADOR"));
            jugador.setNombre(resultSet.getString("NOMBRE"));
            jugador.setGenero(resultSet.getString("GENERO"));
            jugador.setNivel(resultSet.getString("NIVEL"));
            jugador.setEdad(resultSet.getInt("EDAD"));
            jugador.setPosicion(resultSet.getString("POSICION"));
        }

        return jugador;
    }

    public ArrayList<Jugador> search(String nombre, String nivel) throws SQLException {
        String sql = "SELECT * FROM JUGADOR WHERE LOWER(nombre) LIKE ? and LOWER(nivel) LIKE ?";
        ArrayList<Jugador> listJugador = new ArrayList<>();
        if(nombre != null){
            nombre = nombre.trim().toLowerCase();
            nombre = "%" + nombre + "%";
        } else{
            nombre = "%";
        }
        if(nivel != null){
            nivel = nivel.trim().toLowerCase();
            nivel = "%" + nivel + "%";
        } else{
            nivel = "%";
        }
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nombre );
        statement.setString(2, nivel );
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Jugador jugador = new Jugador();
            jugador.setId_jugador(resultSet.getString("ID_JUGADOR"));
            jugador.setNombre(resultSet.getString("NOMBRE"));
            jugador.setGenero(resultSet.getString("GENERO"));
            jugador.setNivel(resultSet.getString("NIVEL"));
            jugador.setEdad(Integer.parseInt(resultSet.getString("EDAD")));
            jugador.setPosicion(resultSet.getString("POSICION"));

            listJugador.add(jugador);
        }

        return listJugador;
    }
}
