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
            String nombre = request.getParameter("nombre");
            String material = request.getParameter("material");
            Database database = new Database();
            PistaDao pistaDao = new PistaDao(database.getConnection());
            List<Pista> listPistas = pistaDao.search(nombre, material);
            if (listPistas.size() == 0) {
        %>
            <div>
                <h1>NO HAY RESULTADOS</h1>
            </div>
        <%
        } else {
            for (Pista pista : listPistas) {
        %>
        <div class="row mb-1">
            <div class="col">
                <div class="card shadow-sm">
                    <div>
                        <p class="text-center mt-2"><%= pista.getNombre_pista() %></p>
                        <p class="text-center mt-2"><%= pista.getCubierta() %></p>
                        <p class="text-center mt-2"><%= pista.getMaterial() %></p>
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
