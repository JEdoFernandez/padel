<%@ page import="com.svalero.padel.dao.Database" %>
<%@ page import="com.svalero.padel.dao.ClubPadelDao" %>
<%@ page import="com.svalero.padel.domain.ClubPadel" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@include file="includes/header.jsp"%>

<main class="container">
    <section class="mb-5">
        <%
        try {
            Database database = new Database();
            ClubPadelDao clubPadelDao = new ClubPadelDao(database.getConnection());
            List<ClubPadel> listClubsPadel = clubPadelDao.showAll();

            if (listClubsPadel.size() == 0) {
        %>
            <div>
                <h1>No hay clubes de pádel registrados</h1>
            </div>
        <%
            } else {
                for (ClubPadel club : listClubsPadel) {
        %>
        <div class="row mb-1">
            <div class="col">
                <div class="card shadow-sm">
                    <div>
                        <p class="text-center mt-2">
                            <a href="detalle-club-padel.jsp?nombre_club=<%= club.getNombre_club() %>">
                                <%= club.getNombre_club() %>
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
            out.println("<p>Error al obtener los clubes: " + sqle.getMessage() + "</p>");
        }
        %>
    </section>
</main>

<%@include file="includes/footer.jsp"%>
