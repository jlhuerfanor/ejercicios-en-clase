async function crearUsuario($event) {
    $event.preventDefault();
    const formulario = document.getElementById("nuevoUsuario");
    const datos = new FormData(formulario);

    await fetch('/api/usuarios', {
        method: "POST",
        body: JSON.stringify(Object.fromEntries(datos.entries())),
        headers: { "Content-type": "application/json" }
    }).then(response => {
        if(response.ok) {
            window.location.href = "index.html"
        }
    }).catch(reason => console.log(reason));
}

async function obtenerListaUsuarios() {
    const listaUsuarios = document.getElementById("listaUsuarios");
    const nuevaLista = document.createElement("tbody");
    const resultado = await fetch('/api/usuarios', { method: "GET" })
        .then(response => response.ok ? response.json() : Promise.resolve([ ]));

    nuevaLista.id = "listaUsuarios";

    console.log(resultado);

    resultado.forEach(usuario => {
            const fila = document.createElement("tr");
            const datoNombre = document.createElement("td")
            const datoApellido = document.createElement("td")
            const datoEdad = document.createElement("td")

            datoNombre.textContent = usuario["nombre"];
            datoApellido.textContent = usuario["apellido"];
            datoEdad.textContent = usuario["edad"];

            fila.appendChild(datoNombre);
            fila.appendChild(datoApellido);
            fila.appendChild(datoEdad);

            nuevaLista.appendChild(fila);
        });

    listaUsuarios.parentNode.replaceChild(nuevaLista, listaUsuarios);
}
