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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/add-pista")
public class AddPista extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            if (hasValidationErrors(request, response))
                return;

            Pista pista = new Pista();
            pista.setNombre_pista(request.getParameter("nombre_pista"));
            pista.setCubierta(request.getParameter("cubierta"));
            pista.setMaterial(request.getParameter("material"));

            Database database = new Database();
            PistaDao pistaDao = new PistaDao(database.getConnection());
            Pista registroExiste = pistaDao.findByName(pista.getNombre_pista());

            if (registroExiste.getNombre_pista() == null) {
                pistaDao.add(pista);
                out.println("<div class='alert alert-success' role='alert'>Nueva pista añadida</div>");
            } else {
                out.println("<div class='alert alert-danger' role='alert'>Esa pista ya existe</div>");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean hasValidationErrors(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean hasErrors = false;
        if (request.getParameter("nombre_pista").isBlank()) {
            sendError("El campo Nombre de la pista no puede estar vacío", response);
            hasErrors = true;
        }
        if (request.getParameter("material").isBlank()) {
            sendError("El campo Material no puede estar vacío", response);
            hasErrors = true;
        }
        if (request.getParameter("cubierta").isBlank()) {
            sendError("El campo Cubierta no puede estar vacío", response);
            hasErrors = true;
        }
        return hasErrors;
    }

    private void sendError(String message, HttpServletResponse response) throws IOException {
        response.getWriter().println("<div class='alert alert-danger' role='alert'>" + message + "</div>");
    }
}
