<%@ page import="com.svalero.padel.dao.Database" %>
<%@ page import="com.svalero.padel.dao.JugadorDao" %>
<%@ page import="com.svalero.padel.domain.Jugador" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@include file="includes/header.jsp"%>

<main class="container">
    <section class="mb-5">

        <%
        try {
            String nombre = request.getParameter("nombre");
            String nivel = request.getParameter("nivel");
            Database database = new Database();
            JugadorDao jugadorDao = new JugadorDao(database.getConnection());
            List<Jugador> listJugadores = jugadorDao.search(nombre, nivel);
            if (listJugadores.size() == 0) {
        %>
            <div>
                <h1>NO HAY RESULTADOS</h1>
            </div>
        <%
        } else {
            for (Jugador jugador : listJugadores) {
        %>
        <div class="row mb-1">
            <div class="col">
                <div class="card shadow-sm">
                    <div>
                        <p class="text-center mt-2"><%= jugador.getId_jugador() %></p>
                        <p class="text-center mt-2"><%= jugador.getNombre() %></p>
                        <p class="text-center mt-2"><%= jugador.getGenero() %></p>
                        <p class="text-center mt-2"><%= jugador.getNivel() %></p>
                        <p class="text-center mt-2"><%= jugador.getEdad() %></p>
                        <p class="text-center mt-2"><%= jugador.getPosicion() %></p>
                    </div>
                </div>
            </div>
        </div>
        <%
            }
        }
        database.close();
        } catch (SQLException sqle) {}
        %>

    </section>
</main>

<%@include file="includes/footer.jsp"%>
