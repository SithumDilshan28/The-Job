function checkUserSession() {
  // Check if the user email is stored in session storage
 const email = sessionStorage.getItem("email");

  if (email) {
    getUserByEmail(email);
    return;
  } else {
    // User email doesn't exist in session storage, redirect to login page
    window.location.href = "../staffLogin.html";
  }
}