package com.svalero.padel.servlet;

import com.svalero.padel.dao.ClubPadelDao;
import com.svalero.padel.dao.Database;
import com.svalero.padel.domain.ClubPadel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/add-club-padel")
public class AddClubPadel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            if (hasValidationErrors(request, response))
                return;
            ClubPadel clubPadel = new ClubPadel();
            clubPadel.setNombre_club(request.getParameter("nombre_club"));
            clubPadel.setDireccion(request.getParameter("direccion"));
            clubPadel.setTelefono(request.getParameter("telefono"));
            clubPadel.setWeb(request.getParameter("web"));
            clubPadel.setFederacion(request.getParameter("federacion"));
            Database database = new Database();
            ClubPadelDao clubPadelDao = new ClubPadelDao(database.getConnection());
            Optional<ClubPadel> registroExiste = clubPadelDao.findByName(clubPadel.getNombre_club());
            if(registroExiste.orElse(null).getNombre_club() == null){
                clubPadelDao.add(clubPadel);
                out.println("<div class='alert alert-success' role='alert'>Nuevo club añadido</div>");
            }else{
                out.println("<div class='alert alert-danger' role='alert'>Ese club ya existe</div>");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean hasValidationErrors(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean hasErrors = false;
        if (request.getParameter("nombre_club").isBlank()) {
            sendError("El campo Nombre del club no puede estar vacío", response);
            hasErrors = true;
        }
        if (request.getParameter("federacion").isBlank()) {
            sendError("El campo Federacion no puede estar vacío", response);
            hasErrors = true;
        }
        if (request.getParameter("telefono").isBlank()) {
            sendError("El campo Telefono no puede estar vacío", response);
            hasErrors = true;
        }
        return hasErrors;

    }

    private void sendError(String message, HttpServletResponse response) throws IOException {
        response.getWriter().println("<div class='alert alert-danger' role='alert'>" + message + "</div>");
    }

    private void sendMessage (String message, HttpServletResponse response) throws IOException {
        response.getWriter().println("<div class='alert alert-success' role='alert'>" + message + "</div>");
    }

}
