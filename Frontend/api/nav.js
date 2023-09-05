document.addEventListener("DOMContentLoaded", function () {
  const loginLink = document.getElementById("loginLink");
  const UemailDiv = document.getElementById("Uemail");

  // Check if the user is logged in by checking the presence of the "userEmail" session variable
  const userEmail = sessionStorage.getItem("userEmail");

  if (userEmail) {
      // User is logged in, hide the "Login" link and display the "Uemail" div
      loginLink.style.display = "none";
      UemailDiv.style.display = "block";

      // Update the content of the "Uemail" div with the user's email
      UemailDiv.innerHTML = `<a href="#"><i class="mdi mdi-account mr-2"></i>${userEmail}</a>
          <div class="submenu">
              <a href="Userprofile.html">Profile</a>
              <a href="Edituser.html">Edit Profile</a>
              <a href="#">Logout</a>
          </div>`;
  } else {
      // User is not logged in, display the "Login" link and hide the "Uemail" div
      loginLink.style.display = "block";
      UemailDiv.style.display = "none";
  }

  // You can add event listeners for login and logout actions to update the UI accordingly
  // For example, when the user clicks "Logout," you can remove the "userEmail" session variable and update the UI.
});



document.addEventListener("DOMContentLoaded", function () {
  const loginLink = document.getElementById("loginLink");
  const UemailDiv = document.getElementById("Uemail");

  // Check if the user is logged in by checking the presence of the "userEmail" session variable
  const userEmail = sessionStorage.getItem("userEmail");

  if (userEmail) {
      // User is logged in, hide the "Login" link and display the "Uemail" div
      loginLink.style.display = "none";
      UemailDiv.style.display = "block";

      // Update the content of the "Uemail" div with the user's email
      UemailDiv.innerHTML = `<a href="#"><i class="mdi mdi-account mr-2"></i>${userEmail}</a>
          <div class="submenu">
              <a href="Userprofile.html">Profile</a>
              <a href="Edituser.html">Edit Profile</a>
              <a id="logoutLink" href="#">Logout</a>
          </div>`;

      // Add an event listener to the "Logout" link
      const logoutLink = document.getElementById("logoutLink");
      logoutLink.addEventListener("click", function () {
          // Clear the session
          sessionStorage.clear();

          // Disable going back and forward
          window.history.forward(1);
          window.onbeforeunload = function () {
              return "You will be logged out. Are you sure you want to leave?";
          };

          // Redirect to the login page
          window.location.href = "login.html";
      });
  } else {
      // User is not logged in, display the "Login" link and hide the "Uemail" div
      loginLink.style.display = "block";
      UemailDiv.style.display = "none";
  }

  // You can add event listeners for login and other actions as needed
});
