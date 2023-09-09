function updateUser() {
  // Collect data from the form fields
  const firstname = $("#input1").val();
  const lastname = $("#input2").val();
  const company = $("#input3").val();
  const phone = $("#input4").val();
  const email = $("#input5").val();
  const address = $("#input6").val();

  // Check if any of the fields are empty
  if (!firstname || !lastname || !company || !phone || !email || !address) {
    alert("Please fill in all fields.");
    return; // Prevent the AJAX request if any field is empty
  }

  // Get the userEmail from the session variable
  const userEmail = sessionStorage.getItem("userEmail");

  // Make an AJAX request to update the user data
  $.ajax({
    type: "PUT",
    url: `http://localhost:8080/user/updateuserbyemail/${userEmail}`,
    contentType: "application/json",
    data: JSON.stringify({
      firstname,
      lastname,
      company,
      phone,
      email,
      address,
    }),
    success: function (data) {
      console.log("User data updated:", data);
      alert("User data updated successfully!");
    },
    error: function (error) {
      console.error("Error updating user data:", error);
      alert("Failed to update user data.");
    },
  });
}

// Attach the updateUser function to the button's click event
$("#updateButton").on("click", function () {
  updateUser();
});
