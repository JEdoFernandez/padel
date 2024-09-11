<%@ page import="com.svalero.padel.dao.Database" %>
<%@ page import="com.svalero.padel.dao.ClubPadelDao" %>
<%@ page import="com.svalero.padel.domain.ClubPadel" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@include file="includes/header.jsp"%>

<main class="container">
    <section class="mb-5">


        <%
        try{
        String nombre = request.getParameter("nombre");
        String federacion = request.getParameter("federacion");
        Database database = new Database();
        ClubPadelDao clubPadelDao = new ClubPadelDao(database.getConnection());
        List<ClubPadel> listClubsPadel = clubPadelDao.search(federacion, nombre);
        if(listClubsPadel.size() == 0) {
        %>
            <div>
                <h1>NO HAY RESULTADOS</h1>
            </div>
        <%
        }else {
            for (ClubPadel club : listClubsPadel) {
        %>
        <div class="row mb-1">
            <div class="col ">
                <div class="card shadow-sm">
                    <div>
                        <p class="text-center mt-2"><%=club.getNombre_club()%></p>
                        <p class="text-center mt-2"><%=club.getDireccion()%></p>
                        <p class="text-center mt-2"><%=club.getTelefono()%></p>
                        <p class="text-center mt-2"><%=club.getWeb()%></p>
                        <p class="text-center mt-2"><%=club.getFederacion()%></p>
                    </div>
                    <div class="col-12 col-md-2 ms-md-2 text-truncate mt-2 d-flex justify-content-center">
                        <button type="button" class="btn me-3">
                            <a href="editar-club-padel.jsp?nombre_club=<%= club.getNombre_club() %>">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-pen" viewBox="0 0 16 16">
                                    <path
                                            d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z">
                                    </path>
                                </svg>
                                <span>Modificar</span>
                            </a>
                        </button>

                        <button type="submit" class="btn btn-outline-danger">
                            <a href="borrar-club-padel?nombre_club=<%= club.getNombre_club() %>">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-x-octagon-fill" viewBox="0 0 16 16">
                                    <path
                                            d="M11.46.146A.5.5 0 0 0 11.107 0H4.893a.5.5 0 0 0-.353.146L.146 4.54A.5.5 0 0 0 0 4.893v6.214a.5.5 0 0 0 .146.353l4.394 4.394a.5.5 0 0 0 .353.146h6.214a.5.5 0 0 0 .353-.146l4.394-4.394a.5.5 0 0 0 .146-.353V4.893a.5.5 0 0 0-.146-.353L11.46.146zm-6.106 4.5L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z">
                                    </path>
                                </svg>
                                <span>Borrar</span>
                            </a>
                        </button>
                    </div>
                </div>

            </div>
        </div>
        <%
            }
        }
        database.close();
        }catch(SQLException sqle){}
        %>

    </section>
</main>

<%@include file="includes/footer.jsp"%>
