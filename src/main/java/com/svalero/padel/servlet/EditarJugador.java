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
import java.sql.SQLException;

@WebServlet("/editar-jugador")
public class EditarJugador extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Jugador jugador = new Jugador();
            jugador.setId_jugador(request.getParameter("id_jugador"));
            jugador.setNombre(request.getParameter("nombre"));
            jugador.setGenero(request.getParameter("genero"));
            jugador.setNivel(request.getParameter("nivel"));
            jugador.setEdad(Integer.parseInt(request.getParameter("edad")));
            jugador.setPosicion(request.getParameter("posicion"));

            Database database = new Database();
            JugadorDao jugadorDao = new JugadorDao(database.getConnection());
            boolean modificado = jugadorDao.modify(jugador.getId_jugador(), jugador);
            response.sendRedirect("list-jugador.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
