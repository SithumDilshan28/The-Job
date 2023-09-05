getAllappointment();

function getAllappointment() {
  $.ajax({
      method: "GET",
      url: "http://localhost:8080/appointment/getappointment",
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
      row.append($("<td>").text(element.consultantname));
      row.append($("<td>").text(element.clientname));
      row.append($("<td>").text(element.clientphone));
      row.append($("<td>").text(element.date));
      row.append($("<td>").text(element.time));
      tableBody.append(row);
  });
}