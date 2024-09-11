package com.svalero.padel.servlet;

import com.svalero.padel.dao.ClubPadelDao;
import com.svalero.padel.dao.Database;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/borrar-club-padel")
public class BorrarClubPadel extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String nombre_club = request.getParameter("nombre_club");
            Database database = new Database();
            ClubPadelDao clubPadelDao = new ClubPadelDao(database.getConnection());
            boolean borrado = clubPadelDao.delete(nombre_club);
            response.sendRedirect("index.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
