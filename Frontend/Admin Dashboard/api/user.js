getAllUser();

function saveUser() {
  let firstname = $("#input1").val();
  let email = $("#input13").val();
  let password = $("#input14").val();

  // Check if firstname, email, and password are empty
  if (firstname.trim() === "" || email.trim() === "" || password.trim() === "") {
    alert("First Name, Email, and Password are required fields.");
    return; // Prevent the AJAX request if validation fails
  }

  // Other input field values
  let lastname = $("#input2").val();
  let nic = $("#input3").val();
  let dob = $("#input4").val();
  let phone = $("#input5").val();
  let address = $("#input6").val();
  let sex = $("#input7").val();
  let marital = $("#input8").val();
  let education = $("#input9").val();
  let college = $("#input10").val();
  let job = $("#input11").val();
  let role = $("#input12").val();

  $.ajax({
    method: "POST",
    contentType: "application/json",
    url: "http://localhost:8080/user/saveuser",
    async: true,
    data: JSON.stringify({
      id: "",
      firstname: firstname,
      lastname: lastname,
      nic: nic,
      dob: dob,
      phone: phone,
      address: address,
      sex: sex,
      maritalstatus: marital,
      education: education,
      college: college,
      job: job,
      role: role,
      email: email,
      password: password,
    }),
    success: function (data) {
      alert("Customer Added Successfully");
      window.location.href = '?refresh=true';
    },
    error: function (xhr, exception) {
      alert("Error");
    },
  });
}

function updateUser() {
  let id = getUserIdFromQueryParam(); // Define a function to get the user ID from the query parameter
  let firstname = $("#input1").val();
  let email = $("#input13").val();
  let password = $("#input14").val();

  // Check if firstname, email, and password are empty
  if (firstname.trim() === "" || email.trim() === "" || password.trim() === "") {
    alert("First Name, Email, and Password are required fields.");
    return; // Prevent the AJAX request if validation fails
  }

  // Other input field values
  let lastname = $("#input2").val();
  let nic = $("#input3").val();
  let dob = $("#input4").val();
  let phone = $("#input5").val();
  let address = $("#input6").val();
  let sex = $("#input7").val();
  let marital = $("#input8").val();
  let education = $("#input9").val();
  let college = $("#input10").val();
  let job = $("#input11").val();
  let role = $("#input12").val();

  $.ajax({
    method: "PUT",
    contentType: "application/json",
    url: "http://localhost:8080/user/updateuser/" + id, // Include the user ID in the URL
    async: true,
    data: JSON.stringify({
      id: id, // Include the user ID in the request data
      firstname: firstname,
      lastname: lastname,
      nic: nic,
      dob: dob,
      phone: phone,
      address: address,
      sex: sex,
      maritalstatus: marital,
      education: education,
      college: college,
      job: job,
      role: role,
      email: email,
      password: password,
    }),
    success: function (data) {
      alert("User Updated Successfully");
      window.location.href = '?refresh=true';
    },
    error: function (xhr, exception) {
      alert("Error");
    },
  });
}

// Define a function to get the user ID from the query parameter
function getUserIdFromQueryParam() {
  return new URLSearchParams(window.location.search).get("id");
}



function deleteUser() {
  let id = $("#input1").val();

  $.ajax({
      method: "DELETE",
      contentType: "application/json",
      url: "http://localhost:8080/user/deleteuser/"+id,
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

function getAllUser() {
  $.ajax({
      method: "GET",
      url: "http://localhost:8080/user/getuser",
      async: true,
      success: function (data) {
          populateTable(data);
      },
      error: function (xhr, exception) {
          alert("Error");
      },
  });
}



function resetUser() { 
  let firstname = $("#input1").val("");
  let lastname = $("#input2").val("");
  let nic = $("#input3").val("");
  let dob = $("#input4").val("");
  let phone = $("#input5").val("");
  let address = $("#input6").val("");
  let sex = $("#input7").val("");
  let education = $("#input9").val("");
  let college = $("#input10").val("");
  let job = $("#input11").val("");
  let role = $("#input12").val("");
  let email = $("#input13").val("");
  let password = $("#input14").val("");
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
    row.append($("<td>").text(element.firstname));
    row.append($("<td>").text(element.lastname));
    row.append($("<td>").text(element.nic));
    row.append($("<td>").text(element.dob));
    row.append($("<td>").text(element.sex));
    row.append($("<td>").text(element.phone));
    row.append($("<td>").text(element.address));
    row.append($("<td>").text(element.education));
    row.append($("<td>").text(element.role));

    var actions = $("<td>");
    var editIcon = $("<i>")
      .addClass("fas fa-edit edit-icon")
      .attr("data-id", element.id)
      .click(function () {
       
        window.location.href = "UpdateCustomer.html?id=" + element.id;
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


// Add a click event handler for the delete icons
$(document).on("click", ".delete-icon", function () {
  var id = $(this).attr("data-id");
  
  // Show a confirmation dialog
  var confirmDelete = window.confirm("Are you sure you want to delete this Customer?");
  
  if (confirmDelete) {
    // If the user confirms, send a delete request to your API endpoint
    $.ajax({
      url: "http://localhost:8080/user/deleteuser/" + id, // Replace with your API endpoint
      method: "DELETE",
      success: function (response) {
        getAllUser();
      },
      error: function (error) {
        // Handle error
        alert(id)
      },
    });
  }
});


