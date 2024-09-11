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
            Database database = new Database();
            JugadorDao jugadorDao = new JugadorDao(database.getConnection());
            List<Jugador> listJugadores = jugadorDao.showAll();

            if (listJugadores.size() == 0) {
        %>
            <div>
                <h1>No hay jugadores registrados</h1>
            </div>
        <%
            } else {
                for (Jugador jugador : listJugadores) {
        %>
        <div class="row mb-1">
            <div class="col">
                <div class="card shadow-sm">
                    <div>
                        <p class="text-center mt-2">
                            <a href="detalle-jugador.jsp?id_jugador=<%= jugador.getId_jugador() %>">
                                <%= jugador.getNombre() %>
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <%
                }
            }
            database.close();
        } catch (SQLException sqle) {
            out.println("<p>Error al obtener los jugadores: " + sqle.getMessage() + "</p>");
        }
        %>
    </section>
</main>

<%@include file="includes/footer.jsp"%>
