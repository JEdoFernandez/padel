package com.svalero.padel.servlet;

import com.svalero.padel.dao.JugadorDao;
import com.svalero.padel.dao.Database;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/borrar-jugador")
public class BorrarJugador extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id_jugador = request.getParameter("id_jugador");
            Database database = new Database();
            JugadorDao jugadorDao = new JugadorDao(database.getConnection());
            boolean borrado = jugadorDao.delete(id_jugador);
            response.sendRedirect("list-jugador.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
