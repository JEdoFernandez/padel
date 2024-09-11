<%@ page import="com.svalero.padel.dao.Database" %>
<%@ page import="com.svalero.padel.dao.PistaDao" %>
<%@ page import="com.svalero.padel.domain.Pista" %>
<%@ page import="java.sql.SQLException" %>
<%@include file="includes/header.jsp"%>

<main class="container">
    <section class="mb-5">
        <%
        try {
            String nombrePista = request.getParameter("nombre_pista");
            Database database = new Database();
            PistaDao pistaDao = new PistaDao(database.getConnection());
            Pista pista = pistaDao.findByName(nombrePista); // Obtenemos la pista directamente

            if (pista == null) {
        %>
            <div>
                <h1>Pista no encontrada</h1>
            </div>
        <%
            } else {
        %>
        <div class="row">
            <div class="col">
                <div class="card shadow-sm">
                    <div>
                        <p class="text-center mt-2">Nombre: <%= pista.getNombre_pista() %></p>
                        <p class="text-center mt-2">Cubierta: <%= pista.getCubierta() %></p>
                        <p class="text-center mt-2">Material: <%= pista.getMaterial() %></p>
                    </div>
                </div>
            </div>
        </div>
        <%
            }
            database.close();
        } catch (SQLException sqle) {
            out.println("<p>Error al obtener la pista: " + sqle.getMessage() + "</p>");
        }
        %>
    </section>
</main>

<%@include file="includes/footer.jsp"%>
