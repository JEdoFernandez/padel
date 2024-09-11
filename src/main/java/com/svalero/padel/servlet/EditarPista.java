package com.svalero.padel.servlet;

import com.svalero.padel.dao.PistaDao;
import com.svalero.padel.dao.Database;
import com.svalero.padel.domain.Pista;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/editar-pista")
public class EditarPista extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Pista pista = new Pista();
            pista.setNombre_pista(request.getParameter("nombre_pista"));
            pista.setCubierta(request.getParameter("cubierta"));
            pista.setMaterial(request.getParameter("material"));

            Database database = new Database();
            PistaDao pistaDao = new PistaDao(database.getConnection());
            boolean modificado = pistaDao.modify(pista.getNombre_pista(), pista);
            response.sendRedirect("list-pista.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
