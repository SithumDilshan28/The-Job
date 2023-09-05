getAllcontact();

function getAllcontact() {
  $.ajax({
      method: "GET",
      url: "http://localhost:8080/contact/getcontact",
      async: true,
      success: function (data) {
          populateTable(data);
      },
      error: function (xhr, exception) {
          alert("Error");
      },
  });
}

function populateTable(data) {
  var tableBody = $("#prodTable");
  // Clear the existing table body
  tableBody.empty();
  // Loop through the data and append rows to the table
  $.each(data, function (index, element) {
      var row = $("<tr>");
      row.append($("<td>").text(element.id));
      row.append($("<td>").text(element.name));
      row.append($("<td>").text(element.email));
      row.append($("<td>").text(element.phone));
      row.append($("<td>").text(element.message));
      tableBody.append(row);
  });
}