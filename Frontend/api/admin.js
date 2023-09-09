function login() {
  var username = document.getElementById("yourUsername").value;
  var password = document.getElementById("yourPassword").value;

  if (username === "admin@gmail.com" && password === "1234") {
    // Save the admin's email in session storage
    sessionStorage.setItem("email", username);

    // Redirect to the admin dashboard
    window.location.href = "./Admin Dashboard/index.html";
  } else {
    alert("Invalid username or password.");
  }
}
