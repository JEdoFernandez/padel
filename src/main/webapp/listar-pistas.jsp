<%@ page import="com.svalero.padel.dao.Database" %>
<%@ page import="com.svalero.padel.dao.PistaDao" %>
<%@ page import="com.svalero.padel.domain.Pista" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@include file="includes/header.jsp"%>

<main class="container">
    <section class="mb-5">
        <%
        try {
            Database database = new Database();
            PistaDao pistaDao = new PistaDao(database.getConnection());
            List<Pista> listPistas = pistaDao.showAll();

            if (listPistas.size() == 0) {
        %>
            <div>
                <h1>No hay pistas registradas</h1>
            </div>
        <%
            } else {
                for (Pista pista : listPistas) {
        %>
        <div class="row mb-1">
            <div class="col">
                <div class="card shadow-sm">
                    <div>
                        <p class="text-center mt-2">
                            <a href="detalle-pista.jsp?nombre_pista=<%= pista.getNombre_pista() %>">
                                <%= pista.getNombre_pista() %>
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
            out.println("<p>Error al obtener las pistas: " + sqle.getMessage() + "</p>");
        }
        %>
    </section>
</main>

<%@include file="includes/footer.jsp"%>
