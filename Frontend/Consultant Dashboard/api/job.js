getAllJobs();

function getAllJobs() {
  $.ajax({
      method: "GET",
      url: "http://localhost:8080/job/getjob",
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
      row.append($("<td>").text(element.role));
      row.append($("<td>").text(element.company));
      row.append($("<td>").text(element.experience));
      row.append($("<td>").text(element.country));
      row.append($("<td>").text(element.salary));
      row.append($("<td>").text(element.category));
      row.append($("<td>").text(element.type));
      row.append($("<td>").text(element.status));
      tableBody.append(row);
  });
}

