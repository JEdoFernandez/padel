<%@ page import="com.svalero.padel.dao.Database" %>
<%@ page import="com.svalero.padel.dao.ClubPadelDao" %>
<%@ page import="com.svalero.padel.domain.ClubPadel" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.Optional" %>
<%@include file="includes/header.jsp"%>

<main>
    <%
    try{
        String nombre_club = request.getParameter("nombre_club");
        Database database = new Database();
        ClubPadelDao clubPadelDao = new ClubPadelDao(database.getConnection());
        Optional<ClubPadel> optClubPadel = clubPadelDao.findByName(nombre_club);
        ClubPadel clubPadel = optClubPadel.orElse(null);
     %>
    <section class="border border-1 p-5 rounded">
        <form id="form" action="editar-club-padel" method="post">
            <div class="row mb-3">
                <label for="nombre_club" class="col-sm-2 col-form-label">Nombre</label>
                <div class="col-sm-10">
                    <input name="nombre_club" type="text" class="form-control w-25" id="nombre_club" value ="<%=clubPadel.getNombre_club()%>" hidden/>
                    <span><%=clubPadel.getNombre_club()%></span>
                </div>
            </div>
            <div class="row mb-3">
                <label for="direccion" class="col-sm-2 col-form-label">Direccion</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="direccion" name="direccion" value ="<%=clubPadel.getDireccion()%>"/>
                </div>
            </div>
            <div class="row mb-3">
                <label for="telefono" class="col-sm-2 col-form-label">Telefono</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="telefono" name="telefono" value ="<%=clubPadel.getTelefono()%>"/>
                </div>
            </div>
            <div class="row mb-3">
                <label for="web" class="col-sm-2 col-form-label">Web</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="web" name="web" value ="<%=clubPadel.getWeb()%>"/>
                </div>
            </div>
            <div class="row mb-3">
                <label for="federacion" class="col-sm-2 col-form-label">Federacion</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="federacion" name="federacion" value ="<%=clubPadel.getFederacion()%>"/>
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

