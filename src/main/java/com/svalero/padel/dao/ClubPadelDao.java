package com.svalero.padel.dao;

import com.svalero.padel.domain.ClubPadel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class ClubPadelDao {
    private Connection connection;

    public ClubPadelDao(Connection connection) {
        this.connection = connection;
    }


    public void add(ClubPadel clubPadel) throws SQLException, Exception{
        try{
            String sql = "INSERT INTO CLUB_DE_PADEL (NOMBRE_CLUB, DIRECCION, TELEFONO, WEB, FEDERACION) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, clubPadel.getNombre_club());
            statement.setString(2, clubPadel.getDireccion());
            statement.setString(3, clubPadel.getTelefono());
            statement.setString(4, clubPadel.getWeb());
            statement.setString(5, clubPadel.getFederacion());

            statement.executeUpdate();
        }catch (SQLException sqle){
            System.out.println("Error al insertar datos");
            sqle.printStackTrace();
        }
    }

    public boolean delete(String nombreClub) throws SQLException {
        try {
            String sql = "DELETE FROM CLUB_DE_PADEL WHERE NOMBRE_CLUB = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombreClub);
            int rows = statement.executeUpdate();
            return rows == 1;
        }catch (SQLException sqle){
            System.out.println("Error borrando datos");
            sqle.printStackTrace();
            return false;
        }
    }

    public boolean modify(ClubPadel clubPadel) throws SQLException {
        try{
            String sql = "UPDATE CLUB_DE_PADEL SET DIRECCION = ?, TELEFONO = ?, WEB = ?, FEDERACION = ?  WHERE NOMBRE_CLUB = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, clubPadel.getDireccion());
            statement.setString(2, clubPadel.getTelefono());
            statement.setString(3, clubPadel.getWeb());
            statement.setString(4, clubPadel.getFederacion());
            statement.setString(5, clubPadel.getNombre_club());

            int rows = statement.executeUpdate();
            return rows == 1;
        }catch (SQLException sqle){
            System.out.println("Error modificando registro");
            sqle.printStackTrace();
            return false;
        }
    }

    public ArrayList<ClubPadel> showAll() throws SQLException {
        String sql = "SELECT * FROM CLUB_DE_PADEL ORDER BY NOMBRE_CLUB";
        ArrayList<ClubPadel> listClubPadel = new ArrayList<>();

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            ClubPadel clubPadel = new ClubPadel();
            clubPadel.setNombre_club(resultSet.getString("NOMBRE_CLUB"));
            clubPadel.setDireccion(resultSet.getString("DIRECCION"));
            clubPadel.setTelefono(resultSet.getString("TELEFONO"));
            clubPadel.setWeb(resultSet.getString("WEB"));
            clubPadel.setFederacion(resultSet.getString("FEDERACION"));

            listClubPadel.add(clubPadel);
        }

        return listClubPadel;
    }

    public Optional<ClubPadel> findByName(String nombreClub) throws SQLException {
        String sql = "SELECT * FROM CLUB_DE_PADEL WHERE NOMBRE_CLUB = ?";
        ClubPadel clubPadel = new ClubPadel();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nombreClub);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            clubPadel.setNombre_club(resultSet.getString("NOMBRE_CLUB"));
            clubPadel.setDireccion(resultSet.getString("DIRECCION"));
            clubPadel.setTelefono(resultSet.getString("TELEFONO"));
            clubPadel.setWeb(resultSet.getString("WEB"));
            clubPadel.setFederacion(resultSet.getString("FEDERACION"));
        }

        return Optional.ofNullable(clubPadel);
    }

    public ArrayList<ClubPadel> search(String federacion, String nombre) throws SQLException {
        String sql = "SELECT * FROM CLUB_DE_PADEL WHERE LOWER(federacion) LIKE ? and LOWER(nombre_club) LIKE ?";
        ArrayList<ClubPadel> listClubPadel = new ArrayList<>();
        if(nombre != null){
            nombre = nombre.trim().toLowerCase();
            nombre = "%" + nombre + "%";
        } else{
            nombre = "%";
        }
        if(federacion != null){
            federacion = federacion.trim().toLowerCase();
            federacion = "%" + federacion + "%";
        } else{
            federacion = "%";
        }
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, federacion );
        statement.setString(2, nombre );
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            ClubPadel clubPadel = new ClubPadel();
            clubPadel.setNombre_club(resultSet.getString("NOMBRE_CLUB"));
            clubPadel.setDireccion(resultSet.getString("DIRECCION"));
            clubPadel.setTelefono(resultSet.getString("TELEFONO"));
            clubPadel.setWeb(resultSet.getString("WEB"));
            clubPadel.setFederacion(resultSet.getString("FEDERACION"));

            listClubPadel.add(clubPadel);
        }

        return listClubPadel;
    }

}
