package com.svalero.padel.dao;

import com.svalero.padel.domain.ClubPadel;
import com.svalero.padel.domain.Pista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class PistaDao {
    private Connection connection;

    public PistaDao(Connection connection) {
        this.connection = connection;
    }

    public void add(Pista pista) throws SQLException, Exception {
        try {
            String sql = "INSERT INTO PISTA (NOMBRE_PISTA, CUBIERTA, MATERIAL) VALUES (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pista.getNombre_pista());
            statement.setString(2, pista.getCubierta());
            statement.setString(3, pista.getMaterial());

            statement.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Error al insertar datos");
            sqle.printStackTrace();
        }
    }

    public boolean delete(String nombrePista) throws SQLException {
        try {
            String sql = "DELETE FROM PISTA WHERE NOMBRE_PISTA = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombrePista);
            int rows = statement.executeUpdate();

            return rows == 1;
        } catch (SQLException sqle) {
            System.out.println("Error borrando datos");
            sqle.printStackTrace();
            return false;
        }
    }

    public boolean modify(String nombrePista, Pista pista) throws SQLException {
        try {
            String sql = "UPDATE PISTA SET CUBIERTA = ?, MATERIAL = ? WHERE NOMBRE_PISTA = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pista.getCubierta());
            statement.setString(2, pista.getMaterial());
            statement.setString(3, nombrePista);

            int rows = statement.executeUpdate();
            return rows == 1;
        } catch (SQLException sqle) {
            System.out.println("Error modificando registro");
            sqle.printStackTrace();
            return false;
        }
    }

    public ArrayList<Pista> showAll() throws SQLException {
        String sql = "SELECT * FROM PISTA ORDER BY NOMBRE_PISTA";
        ArrayList<Pista> listPista = new ArrayList<>();

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Pista pista = new Pista();
            pista.setNombre_pista(resultSet.getString("NOMBRE_PISTA"));
            pista.setCubierta(resultSet.getString("CUBIERTA"));
            pista.setMaterial(resultSet.getString("MATERIAL"));

            listPista.add(pista);
        }

        return listPista;
    }

    public Pista findByName(String nombrePista) throws SQLException {
        String sql = "SELECT * FROM PISTA WHERE NOMBRE_PISTA = ?";
        Pista pista = new Pista();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nombrePista);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            pista.setNombre_pista(resultSet.getString("NOMBRE_PISTA"));
            pista.setCubierta(resultSet.getString("CUBIERTA"));
            pista.setMaterial(resultSet.getString("MATERIAL"));
        }

        return pista;
    }

    public ArrayList<Pista> search(String nombre, String material) throws SQLException {
        String sql = "SELECT * FROM PISTA WHERE LOWER(NOMBRE_PISTA) LIKE ? and LOWER(MATERIAL) LIKE ?";
        ArrayList<Pista> listPista = new ArrayList<>();
        if(nombre != null){
            nombre = nombre.trim().toLowerCase();
            nombre = "%" + nombre + "%";
        } else{
            nombre = "%";
        }
        if(material != null){
            material = material.trim().toLowerCase();
            material = "%" + material + "%";
        } else{
            material = "%";
        }
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nombre );
        statement.setString(2, material );
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Pista pista = new Pista();
            pista.setNombre_pista(resultSet.getString("NOMBRE_PISTA"));
            pista.setCubierta(resultSet.getString("CUBIERTA"));
            pista.setMaterial(resultSet.getString("MATERIAL"));

            listPista.add(pista);
        }

        return listPista;
    }

}
