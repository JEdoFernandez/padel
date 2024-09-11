package com.svalero.padel.servlet;

import com.svalero.padel.dao.JugadorDao;
import com.svalero.padel.dao.Database;
import com.svalero.padel.domain.Jugador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/add-jugador")
public class AddJugador extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            if (hasValidationErrors(request, response))
                return;

            Jugador jugador = new Jugador();
            jugador.setId_jugador(request.getParameter("id_jugador"));
            jugador.setNombre(request.getParameter("nombre"));
            jugador.setGenero(request.getParameter("genero"));
            jugador.setNivel(request.getParameter("nivel"));
            jugador.setEdad(Integer.parseInt(request.getParameter("edad")));
            jugador.setPosicion(request.getParameter("posicion"));

            Database database = new Database();
            JugadorDao jugadorDao = new JugadorDao(database.getConnection());
            Jugador registroExiste = jugadorDao.findById(jugador.getId_jugador());

            if (registroExiste.getId_jugador() == null) {
                jugadorDao.add(jugador);
                out.println("<div class='alert alert-success' role='alert'>Nuevo jugador añadido</div>");
            } else {
                out.println("<div class='alert alert-danger' role='alert'>Ese jugador ya existe</div>");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean hasValidationErrors(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean hasErrors = false;
        if (request.getParameter("id_jugador").isBlank()) {
            sendError("El campo ID del jugador no puede estar vacío", response);
            hasErrors = true;
        }
        if (request.getParameter("nombre").isBlank()) {
            sendError("El campo Nombre no puede estar vacío", response);
            hasErrors = true;
        }
        if (request.getParameter("edad").isBlank()) {
            sendError("El campo Edad no puede estar vacío", response);
            hasErrors = true;
        }
        return hasErrors;
    }

    private void sendError(String message, HttpServletResponse response) throws IOException {
        response.getWriter().println("<div class='alert alert-danger' role='alert'>" + message + "</div>");
    }
}
