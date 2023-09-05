getAllConsultant();

function saveConsultant() {
  let fullname = $("#input1").val();
  let email = $("#input3").val();
  let password = $("#input4").val();

  // Check if firstname, email, and password are empty
  if (fullname.trim() === "" || email.trim() === "" || password.trim() === "") {
    alert("Full Name, Email, and Password are required fields.");
    return; // Prevent the AJAX request if validation fails
  }

  // Other input field values
  let nic = $("#input2").val();
  let phone = $("#input5").val();
  let address = $("#input6").val();
  let specilizedcountry = $("#input7").val();
  let specilizedjobtype = $("#input9").val();
  let imageurl = $("#input10").val();

  $.ajax({
    method: "POST",
    contentType: "application/json",
    url: "http://localhost:8080/consultant/saveconsultants",
    async: true,
    data: JSON.stringify({
      id: "",
      fullname: fullname,
      nic: nic,
      email: email,
      password: password,
      phone: phone,
      address: address,
      specilizedcountry: specilizedcountry,
      specilizedjobtype: specilizedjobtype,
      imageurl: imageurl,
    }),
    success: function (data) {
      alert("Consultant Added Successfully");
      window.location.href = '?refresh=true';
    },
    error: function (xhr, exception) {
      alert("Error");
    },
  });
}

function updateConsultant() {
  // Extract consultant ID from query parameter
  var consultantId = new URLSearchParams(window.location.search).get("id");

  let fullname = $("#input1").val();
  let email = $("#input3").val();
  let password = $("#input4").val();

  // Check if firstname, email, and password are empty
  if (fullname.trim() === "" || email.trim() === "" || password.trim() === "") {
    alert("Full Name, Email, and Password are required fields.");
    return; // Prevent the AJAX request if validation fails
  }

  // Other input field values
  let nic = $("#input2").val();
  let phone = $("#input5").val();
  let address = $("#input6").val();
  let specilizedcountry = $("#input7").val();
  let specilizedjobtype = $("#input9").val();
  let imageurl = $("#input10").val();

  $.ajax({
    method: "PUT",
    contentType: "application/json",
    url: "http://localhost:8080/consultant/updateconsultant/" + consultantId, // Use the correct ID here
    async: true,
    data: JSON.stringify({
      id: consultantId, // Pass the ID to the backend
      fullname: fullname,
      nic: nic,
      email: email,
      password: password,
      phone: phone,
      address: address,
      specilizedcountry: specilizedcountry,
      specilizedjobtype: specilizedjobtype,
      imageurl: imageurl,
    }),
    success: function (data) {
      alert("Consultant Update Successfully");
      window.location.href = '?refresh=true';
    },
    error: function (xhr, exception) {
      alert("Error");
    },
  });
}



function deleteConsultant() {
  let id = $("#input1").val();
  $.ajax({
      method: "DELETE",
      contentType: "application/json",
      url: "http://localhost:8080/consultant/deleteconsultant/" + id,
      async: true,
      success: function (data) {
          alert("Customer Deleted Successfully");
          getAllUser();
          window.location.href = '?refresh=true';
      },
      error: function (xhr, exception) {
          alert("Error");
      },
  });
}

function getAllConsultant() {
  $.ajax({
      method: "GET",
      url: "http://localhost:8080/consultant/getconsultant",
      async: true,
      success: function (data) {
          populateTable(data);
      },
      error: function (xhr, exception) {
          alert("Error");
      },
  });
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
    row.append($("<td>").text(element.fullname));
    row.append($("<td>").text(element.nic));
    row.append($("<td>").text(element.email));
    row.append($("<td>").text(element.phone));
    row.append($("<td>").text(element.address));
    row.append($("<td>").text(element.specilizedcountry));
    row.append($("<td>").text(element.specilizedjobtype));

    var actions = $("<td>");
    var editIcon = $("<i>")
      .addClass("fas fa-edit edit-icon")
      .attr("data-id", element.id)
      .click(function () {
        // Redirect to UpdateConsultant.html with consultant ID as query parameter
        window.location.href = "UpdateConsultant.html?id=" + element.id;
      });
    var deleteIcon = $("<i>")
      .addClass("fas fa-trash delete-icon")
      .attr("data-id", element.id);

    // Add margin to icons
    editIcon.css("margin-right", "5px"); // Adjust the margin as needed
    deleteIcon.css("margin-left", "5px"); // Adjust the margin as needed

    actions.append(editIcon).append(deleteIcon);
    row.append(actions);

    tableBody.append(row);
  });
}


function resetConsultant() { 
  let fullname = $("#input1").val("");
  let email = $("#input3").val("");
  let password = $("#input4").val("");
  let nic = $("#input2").val("");
  let phone = $("#input5").val("");
  let address = $("#input6").val("");
  let specilizedcountry = $("#input7").val("");
  let specilizedjobtype = $("#input9").val("");
  let imageurl = $("#input10").val("");
}


// Add a click event handler for the delete icons
$(document).on("click", ".delete-icon", function () {
  var id = $(this).attr("data-id");
  
  // Show a confirmation dialog
  var confirmDelete = window.confirm("Are you sure you want to delete this consultant?");
  
  if (confirmDelete) {
    // If the user confirms, send a delete request to your API endpoint
    $.ajax({
      url: "http://localhost:8080/consultant/deleteconsultant/" + id, // Replace with your API endpoint
      method: "DELETE",
      success: function (response) {
        getAllConsultant();
      },
      error: function (error) {
        // Handle error
        alert(id)
      },
    });
  }
});


