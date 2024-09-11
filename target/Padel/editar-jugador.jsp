<%@ page import="com.svalero.padel.dao.Database" %>
<%@ page import="com.svalero.padel.dao.JugadorDao" %>
<%@ page import="com.svalero.padel.domain.Jugador" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.Optional" %>
<%@include file="includes/header.jsp"%>

<main>
    <%
    try{
    String idJugador = request.getParameter("id_jugador");
    Database database = new Database();
    JugadorDao jugadorDao = new JugadorDao(database.getConnection());
    Jugador jugador = jugadorDao.findById(idJugador);
    %>
    <section class="border border-1 p-5 rounded">
        <form id="form" action="editar-jugador" method="post">
            <div class="row mb-3">
                <div>
                    <input name="id_jugador" type="text" class="form-control w-25" id="id_jugador" value ="<%=jugador.getId_jugador()%>" hidden/>
                </div>
                <label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
                <div class="col-sm-10">
                    <input name="nombre" type="text" class="form-control w-25" id="nombre" value ="<%=jugador.getNombre()%>"/>
                </div>
            </div>
            <div class="row mb-3">
                <label for="genero" class="col-sm-2 col-form-label">Nivel</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="genero" name="genero" value ="<%=jugador.getGenero()%>"/>
                </div>
            </div>
            <div class="row mb-3">
                <label for="nivel" class="col-sm-2 col-form-label">nivel</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="nivel" name="nivel" value ="<%=jugador.getNivel()%>"/>
                </div>
            </div>
            <div class="row mb-3">
                <label for="edad" class="col-sm-2 col-form-label">Edad</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="edad" name="edad" value ="<%=jugador.getEdad()%>"/>
                </div>
            </div>
            <div class="row mb-3">
                <label for="posicion" class="col-sm-2 col-form-label">Posicion</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="posicion" name="posicion" value ="<%=jugador.getPosicion()%>"/>
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

