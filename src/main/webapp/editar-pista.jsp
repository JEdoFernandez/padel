<%@ page import="com.svalero.padel.dao.Database" %>
<%@ page import="com.svalero.padel.dao.PistaDao" %>
<%@ page import="com.svalero.padel.domain.Pista" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.Optional" %>
<%@include file="includes/header.jsp"%>

<main>
    <%
    try{
    String nombre_pista = request.getParameter("nombre_pista");
    Database database = new Database();
    PistaDao pistaDao = new PistaDao(database.getConnection());
    Pista pista = pistaDao.findByName(nombre_pista);
    %>
    <section class="border border-1 p-5 rounded">
        <form id="form" action="editar-pista" method="post">
            <div class="row mb-3">
                <label for="nombre_pista" class="col-sm-2 col-form-label">Nombre pista</label>
                <div class="col-sm-10">
                    <input name="nombre_pista" type="text" class="form-control w-25" id="nombre_pista" value ="<%=pista.getNombre_pista()%>" hidden/>
                    <span><%=pista.getNombre_pista()%></span>
                </div>
            </div>
            <div class="row mb-3">
                <label for="cubierta" class="col-sm-2 col-form-label">Nivel</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="cubierta" name="cubierta" value ="<%=pista.getCubierta()%>"/>
                </div>
            </div>
            <div class="row mb-3">
                <label for="material" class="col-sm-2 col-form-label">nivel</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="material" name="material" value ="<%=pista.getMaterial()%>"/>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Salvar cambios</button>
        </form>
    </section>
    <%
    database.close();
    }catch(SQLException sqle){}
    %>
</main>

