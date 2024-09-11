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
import java.sql.SQLException;

@WebServlet("/editar-club-padel")
public class EditarClubPadel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            ClubPadel clubPadel = new ClubPadel();
            clubPadel.setNombre_club(request.getParameter("nombre_club"));
            clubPadel.setDireccion(request.getParameter("direccion"));
            clubPadel.setTelefono(request.getParameter("telefono"));
            clubPadel.setWeb(request.getParameter("web"));
            clubPadel.setFederacion(request.getParameter("federacion"));
            Database database = new Database();
            ClubPadelDao clubPadelDao = new ClubPadelDao(database.getConnection());
            boolean modificado = clubPadelDao.modify(clubPadel);
            response.sendRedirect("index.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
