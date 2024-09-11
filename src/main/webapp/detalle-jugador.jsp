<%@ page import="com.svalero.padel.dao.Database" %>
<%@ page import="com.svalero.padel.dao.JugadorDao" %>
<%@ page import="com.svalero.padel.domain.Jugador" %>
<%@ page import="java.sql.SQLException" %>
<%@include file="includes/header.jsp"%>

<main class="container">
    <section class="mb-5">
        <%
        try {
            String idJugador = request.getParameter("id_jugador"); // Se obtiene el parámetro del jugador
            Database database = new Database();
            JugadorDao jugadorDao = new JugadorDao(database.getConnection());
            Jugador jugador = jugadorDao.findById(idJugador); // Obtenemos el jugador directamente

            if (jugador == null) {
        %>
            <div>
                <h1>Jugador no encontrado</h1>
            </div>
        <%
            } else {
        %>
        <div class="row">
            <div class="col">
                <div class="card shadow-sm">
                    <div>
                        <p class="text-center mt-2">Nombre: <%= jugador.getNombre() %></p>
                        <p class="text-center mt-2">Genero: <%= jugador.getGenero() %></p>
                        <p class="text-center mt-2">Nivel: <%= jugador.getNivel() %></p>
                        <p class="text-center mt-2">Edad: <%= jugador.getEdad() %></p>
                        <p class="text-center mt-2">Posicion: <%= jugador.getPosicion() %></p>
                    </div>
                </div>
            </div>
        </div>
        <%
            }
            database.close();
        } catch (SQLException sqle) {
            out.println("<p>Error al obtener el jugador: " + sqle.getMessage() + "</p>");
        }
        %>
    </section>
</main>

<%@include file="includes/footer.jsp"%>
