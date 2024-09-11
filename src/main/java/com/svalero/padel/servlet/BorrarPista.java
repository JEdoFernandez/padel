package com.svalero.padel.servlet;

import com.svalero.padel.dao.PistaDao;
import com.svalero.padel.dao.Database;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/borrar-pista")
public class BorrarPista extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nombre_pista = request.getParameter("nombre_pista");
            Database database = new Database();
            PistaDao pistaDao = new PistaDao(database.getConnection());
            boolean borrado = pistaDao.delete(nombre_pista);
            response.sendRedirect("list-pista.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
