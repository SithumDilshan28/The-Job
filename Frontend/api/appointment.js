function saveAppointment() {
  const consultantname = $("#input1").val();
  const clientname = $("#input2").val();
  const email = $("#input3").val();
  const date = $("#input4").val();
  const time = $("#input5").val();
  const clientphone = $("#input6").val();

  // Check if any of the fields are empty
  if (!consultantname || !clientname || !email || !date || !time || !clientphone) {
    alert("All fields are required.");
    return;
  }

  const appointmentData = {
    consultantname: consultantname,
    clientname: clientname,
    email: email,
    date: date,
    time: time,
    clientphone: clientphone,
  };

  $.ajax({
    type: "POST",
    url: "http://localhost:8080/appointment/saveappointment", // Make sure the URL is correct
    contentType: "application/json",
    data: JSON.stringify(appointmentData),
    success: function (data) {
      alert("Appointment Added Successfully");
      // Optionally, you can redirect to another page on success
      // window.location.href = "./consultant.html";
    },
    error: function (xhr, status, error) {
      if (xhr.status === 405) {
        alert("HTTP Method Not Allowed. Check your backend configuration.");
      } else if (xhr.status === 500) {
        alert("Internal Server Error. Check the server logs for details.");
      } else {
        alert("Failed to Add Appointment: " + error);
      }
    },
  });
}

function checkUserSession() {
  // Check if the user email is stored in session storage
  const userEmail = sessionStorage.getItem("userEmail");

  if (userEmail) {
    getUserByEmail(userEmail);
    return;
  } else {
    // User email doesn't exist in session storage, redirect to login page
    window.location.href = "./login.html";
  }
}

// Call the checkUserSession function when your page loads
window.addEventListener("load", checkUserSession);

function getUserByEmail(email) {
  // Define the URL of your backend endpoint
  const apiUrl = `http://localhost:8080/user/getuserbyemail/${email}`;

  // Make an AJAX request to get the user by email
  $.ajax({
    type: "GET",
    url: apiUrl,
    success: function (data) {
      // Handle the success response from the server
      console.log("User found:", data);

      // Bind the user data to the HTML inputs
      $("#input2").val(data.firstname);
      $("#input6").val(data.phone);

      // You can further process the data or perform other actions here
    },
    error: function (error) {
      // Handle errors or user not found
      console.error("User not found:", error);
      // You can display an error message or perform other actions here
    },
  });
}

window.onload = function () {
  var urlParams = new URLSearchParams(window.location.search);
  var c_name = urlParams.get('name'); 
  var c_email = urlParams.get('email');
  
  // Get the input fields by their IDs
  var clientNameInput = document.getElementById("input1");
  var clientEmailInput = document.getElementById("input3");
  
  // Set the values of the input fields
  if (c_name) {
    clientNameInput.value = c_name;
  }
  
  if (c_email) {
    clientEmailInput.value = c_email;
  }
  
  console.log(c_name);
}
