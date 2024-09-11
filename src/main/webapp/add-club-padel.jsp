<main>
    <section class="border border-1 p-5 rounded">
        <form id="form" action="add-club-padel" method="post">
            <div class="row mb-3">
                <label for="nombre_club" class="col-sm-2 col-form-label">Nombre</label>
                <div class="col-sm-10">
                    <input name="nombre_club" type="text" class="form-control w-25" id="nombre_club"  />
                </div>
            </div>
            <div class="row mb-3">
                <label for="direccion" class="col-sm-2 col-form-label">Direccion</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="direccion" name="direccion" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="telefono" class="col-sm-2 col-form-label">Telefono</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="telefono" name="telefono" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="web" class="col-sm-2 col-form-label">Web</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="web" name="web" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="web" class="col-sm-2 col-form-label">Federacion</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="federacion" name="federacion" />
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Salvar cambios</button>
            <button type="reset" class="btn btn-primary">Limpiar formulario</button>
        </form>
    </section>
</main>