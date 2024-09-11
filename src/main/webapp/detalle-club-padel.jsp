<%@ page import="com.svalero.padel.dao.Database" %>
<%@ page import="com.svalero.padel.dao.ClubPadelDao" %>
<%@ page import="com.svalero.padel.domain.ClubPadel" %>
<%@ page import="java.sql.SQLException" %>
<%@include file="includes/header.jsp"%>

<main class="container">
    <section class="mb-5">
        <%
        try {
            String nombreClub = request.getParameter("nombre_club");
            Database database = new Database();
            ClubPadelDao clubPadelDao = new ClubPadelDao(database.getConnection());
            ClubPadel club = clubPadelDao.findByName(nombreClub).orElse(null);

            if (club == null) {
        %>
            <div>
                <h1>Club de pádel no encontrado</h1>
            </div>
        <%
            } else {
        %>
        <div class="row">
            <div class="col">
                <div class="card shadow-sm">
                    <div>
                        <p class="text-center mt-2">Nombre: <%= club.getNombre_club() %></p>
                        <p class="text-center mt-2">Dirección: <%= club.getDireccion() %></p>
                        <p class="text-center mt-2">Teléfono: <%= club.getTelefono() %></p>
                        <p class="text-center mt-2">Web: <%= club.getWeb() %></p>
                        <p class="text-center mt-2">Federación: <%= club.getFederacion() %></p>
                    </div>
                </div>
            </div>
        </div>
        <%
            }
            database.close();
        } catch (SQLException sqle) {
            out.println("<p>Error al obtener el club: " + sqle.getMessage() + "</p>");
        }
        %>
    </section>
</main>

<%@include file="includes/footer.jsp"%>
