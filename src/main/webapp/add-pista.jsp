<main>
    <section class="border border-1 p-5 rounded">
        <form id="form" action="add-pista" method="post">
            <div class="row mb-3">
                <label for="nombre_pista" class="col-sm-2 col-form-label">Nombre de pista</label>
                <div class="col-sm-10">
                    <input name="nombre_pista" type="text" class="form-control w-25" id="nombre_pista"  />
                </div>
            </div>
            <div class="row mb-3">
                <label for="cubierta" class="col-sm-2 col-form-label">cubierta</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="cubierta" name="cubierta" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="material" class="col-sm-2 col-form-label">material</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="material" name="material" />
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Salvar cambios</button>
            <button type="reset" class="btn btn-primary">Limpiar formulario</button>
        </form>
    </section>
</main>