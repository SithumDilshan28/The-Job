// login.js

function loginUser() {
  const emailInput = document.getElementById("email");
  const passwordInput = document.getElementById("password");

  const email = emailInput.value;
  const password = passwordInput.value;

  // Make an AJAX request to your backend for authentication
  // Replace the URL with your actual backend endpoint
  fetch("http://localhost:8080/user/login", {
      method: "POST",
      headers: {
          "Content-Type": "application/json",
      },
      body: JSON.stringify({ email, password }),
  })
      .then((response) => response.json())
      .then((data) => {
          if (data.message === "User Login Successfully.") {
              // Save the user's email to a session variable
              sessionStorage.setItem("userEmail", email);

              // Redirect to index.html
              window.location.href = "index.html";
          } else {
              // Display an error message to the user
              alert("Login failed. Please check your credentials.");
          }
      })
      .catch((error) => {
          console.error("Error:", error);
      });
}



// registration.js

function registerUser() {
    // Get the input values
    var firstName = $("#firstname").val();
    var lastName = $("#lastname").val();
    var email = $("#email").val();
    var password = $("#password").val();
    var confirmPassword = $("#confirm_password").val();

    // Perform form validation
    if (firstName === '' || lastName === '' || email === '' || password === '' || confirmPassword === '') {
        alert("Please fill in all fields.");
        return;
    }

    if (password !== confirmPassword) {
        alert("Password and Confirm Password do not match.");
        return;
    }

    // Create a data object to send to the server
    var data = {
        firstname: firstName,
        lastname: lastName,
        email: email,
        password: password,
        confirmPassword: confirmPassword
    };

    // Send an AJAX request to your backend
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/user/saveuser", // Your backend endpoint URL
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function(response) {
            // Handle the success response from the server
            console.log("Registration successful:", response);
            alert("Registration successful. Redirecting to login page.");
            window.location.href = "login.html"; // Redirect to login page
        },
        error: function(error) {
            // Handle any errors from the server
            console.error("Registration failed:", error.responseText);
            alert("Registration failed. Please try again.");
        }
    });
}
