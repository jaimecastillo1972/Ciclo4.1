function traerInformacionProductos() {
  console.log("test");
  $.ajax({
    url: "http://localhost:8080/api/hairproducts/all",
    type: "GET",
    datatype: "JSON",
    success: function (respuesta) {
      console.log(respuesta);
      pintarRespuesta(respuesta);
    },
  });
}
function pintarRespuesta(respuesta) {
  let myTable = "<table>";
  for (i = 0; i < respuesta.length; i++) {
    myTable += "<tr>";

    myTable += "<td>" + respuesta[i].reference + "</td>";
    myTable += "<td>" + respuesta[i].brand + "</td>";
    myTable += "<td>" + respuesta[i].category + "</td>";
    myTable += "<td>" + respuesta[i].price + "</td>";
    myTable += "<td>" + respuesta[i].quantity + "</td>";
    myTable += "<td>" + respuesta[i].description + "</td>";
    myTable += "<td>" + respuesta[i].availability + "</td>";
    myTable += "<td>" + respuesta[i].photography + "</td>";
    myTable +=
      "<td> <button onclick=' agregarProducto(" +
      respuesta[i].idClient +
      ")'>Agregar</button>";
    myTable +=
      "<td> <button onclick='editarProducto(" +
      JSON.stringify(respuesta[i].reference) +
      ")'>Editar</button>";
    myTable +=
      "<td> <button onclick='borrarProducto(" +
      JSON.stringify(respuesta[i].reference) +
      ")'>Eliminar</button>";
    myTable += "</tr>";
  }
  myTable += "</table>";
  $("#resultado3").html(myTable);
}

function agregarProducto() {
  Swal.fire({
    title: "Tu nombre",
    input: "text",
    showCancelButton: true,
    confirmButtonText: "Guardar",
    cancelButtonText: "Cancelar",
  }).then((resultado) => {
    if (resultado.value) {
      let nombre = resultado.value;
      console.log("Hola, " + nombre);
    }
  });
}

function borrarProducto(reference) {
  console.log(reference);
  let myData = {
    id: reference,
  };
  let dataToSend = JSON.stringify(myData);
  console.log(dataToSend);
  $.ajax({
    url: "http://localhost:8080/api/hairproducts/" + reference,
    type: "DELETE",
    data: dataToSend,
    contentType: "application/JSON",
    datatype: "JSON",
    success: function (respuesta) {
      $("#resultado").empty();
      traerInformacionProductos();
    },
  });
}

function editarProducto(id) {
  let data = {
    reference: $("#reference").val(),
    brand: $("#brand").val(),
    category: $("#category").val(),
    price: $("#price").val(),
    quantity: $("#quantity").val(),
    description: $("#description").val(),
    availability: $("#availability").val(),
    photography: $("#photography").val(),
  };
  let dataToSend = JSON.stringify(data);
  console.log(dataToSend);
  $.ajax({
    url: "http://localhost:8080/api/hairproducts/update",
    type: "PUT",
    data: dataToSend,
    contentType: "application/json",
    dataType: "json",
    success: function (respuesta) {
      $("#resultado").empty();
      $("#reference").val("");
      $("#brand").val("");
      $("#category").val("");
      $("#price").val("");
      $("#quantity").val("");
      $("#description").val("");
      $("#availability").val("");
      $("#photography").val("");
      traerInformacionProductos();
    },
  });
}
