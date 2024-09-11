<main>
    <section class="border border-1 p-5 rounded">
        <form id="form" action="add-jugador" method="post">
            <div class="row mb-3">
                <label for="id_jugador" class="col-sm-2 col-form-label">Id jugador</label>
                <div class="col-sm-10">
                    <input name="id_jugador" type="text" class="form-control w-25" id="id_jugador"  />
                </div>
            </div>
            <div class="row mb-3">
                <label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="nombre" name="nombre" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="genero" class="col-sm-2 col-form-label">Genero</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="genero" name="genero" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="nivel" class="col-sm-2 col-form-label">Nivel</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="nivel" name="nivel" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="edad" class="col-sm-2 col-form-label">Edad</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="edad" name="edad" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="posicion" class="col-sm-2 col-form-label">Posicion</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="posicion" name="posicion" />
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Salvar cambios</button>
            <button type="reset" class="btn btn-primary">Limpiar formulario</button>
        </form>
    </section>
</main>