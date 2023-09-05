getAllJobs();

function saveJob() {
  let role = $("#input1").val();
  let company = $("#input2").val();
  let experience = $("#input3").val();

  // Check if firstname, email, and password are empty
  if (role.trim() === "" || company.trim() === "" || experience.trim() === "") {
    alert("Role, Company, and Experience are required fields.");
    return; // Prevent the AJAX request if validation fails
  }

  // Other input field values
  let category = $("#input4").val();
  let salary = $("#input5").val();
  let status = $("#input6").val();
  let country = $("#input7").val();
  let type = $("#input8").val();
  let imageurl = $("#input9").val();

  $.ajax({
    method: "POST",
    contentType: "application/json",
    url: "http://localhost:8080/job/savejob",
    async: true,
    data: JSON.stringify({
      id: "",
      role: role,
      company: company,
      experience: experience,
      category: category,
      salary: salary,
      status: status,
      country: country,
      type: type,
      imageurl: imageurl,
    }),
    success: function (data) {
      alert("Job Added Successfully");
      window.location.href = '?refresh=true';
    },
    error: function (xhr, exception) {
      alert("Error");
    },
  });
}

function updateJob() {
  let id = getJobIdFromQueryParam(); // Define a function to get the job ID from the query parameter
  let role = $("#input1").val();
  let company = $("#input2").val();
  let experience = $("#input3").val();

  // Check if role, company, and experience are empty
  if (role.trim() === "" || company.trim() === "" || experience.trim() === "") {
    alert("Role, Company, and Experience are required fields.");
    return; // Prevent the AJAX request if validation fails
  }

  // Other input field values
  let category = $("#input4").val();
  let salary = $("#input5").val();
  let status = $("#input6").val();
  let country = $("#input7").val();
  let type = $("#input8").val();
  let imageurl = $("#input9").val();

  $.ajax({
    method: "PUT",
    contentType: "application/json",
    url: "http://localhost:8080/job/updatejob/" + id, // Include the job ID in the URL
    async: true,
    data: JSON.stringify({
      id: id, // Include the job ID in the request data
      role: role,
      company: company,
      experience: experience,
      category: category,
      salary: salary,
      status: status,
      country: country,
      type: type,
      imageurl: imageurl,
    }),
    success: function (data) {
      alert("Job Updated Successfully");
      window.location.href = '?refresh=true';
    },
    error: function (xhr, exception) {
      alert("Error");
    },
  });
}

// Define a function to get the job ID from the query parameter
function getJobIdFromQueryParam() {
  return new URLSearchParams(window.location.search).get("id");
}



function deleteConsultant() {
  // let id = $("#input1").val();
  let id = 3;
  $.ajax({
      method: "DELETE",
      contentType: "application/json",
      url: "http://localhost:8080/job/deletejob/" + id,
      async: true,
      success: function (data) {
          alert("Job Deleted Successfully");
          getAllUser();
          window.location.href = '?refresh=true';
      },
      error: function (xhr, exception) {
          alert("Error");
      },
  });
}

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

function resetJob() { 
  let role = $("#input1").val("");
  let company = $("#input2").val("");
  let experience = $("#input3").val("");
  let category = $("#input4").val("");
  let salary = $("#input5").val("");
  let status = $("#input6").val("");
  let country = $("#input7").val("");
  let type = $("#input8").val("");
  let imageurl = $("#input9").val("");
}


// Define the populateTable function
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

    // Add Edit and Delete icons in the Actions column
    var actions = $("<td>");
    var editIcon = $("<i>")
      .addClass("fas fa-edit edit-icon")
      .attr("data-id", element.id)
      .click(function () {
        // Redirect to UpdateJob.html with Job ID as a query parameter
        window.location.href = "UpdateJob.html?id=" + element.id;
      });
    var deleteIcon = $("<i>")
      .addClass("fas fa-trash delete-icon")
      .attr("data-id", element.id)
      .click(function () {
        // Show a confirmation dialog before deleting
        var confirmDelete = window.confirm("Are you sure you want to delete this Job?");
        if (confirmDelete) {
          // Handle the delete operation here, e.g., call a delete function
          handleDelete(element.id);
        }
      });

    // Add margin to icons
    editIcon.css("margin-right", "5px");
    deleteIcon.css("margin-left", "5px");

    actions.append(editIcon).append(deleteIcon);
    row.append(actions);

    tableBody.append(row);
  });
}

// Function to handle the delete operation (you can replace this with your actual delete logic)
function handleDelete(jobId) {
  $.ajax({
    url: "http://localhost:8080/job/deletejob/" + jobId, // Replace with your API endpoint
    method: "DELETE",
    success: function (response) {
      // Handle the success response, e.g., reload the table or perform other actions
      // You can call getAllConsultant() here to refresh the table if needed
      getAllJobs();
    },
    error: function (error) {
      // Handle the error, e.g., show an alert or log the error
      alert("Error deleting job: " + error);
    },
  });
}





