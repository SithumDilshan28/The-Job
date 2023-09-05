function updateUser() {
  // Collect data from the form fields
  const updatedUserData = {
      firstname: $("#input1").val(),
      lastname: $("#input2").val(),
      company: $("#input3").val(),
      phone: $("#input4").val(),
      email: $("#input5").val(),
      address: $("#input6").val()
  };

  // Get the userEmail from the session variable
  const userEmail = sessionStorage.getItem("userEmail");

  // Make an AJAX request to update the user data
  $.ajax({
      type: "PUT",  // Use the appropriate HTTP method (PUT in this case)
      url: `http://localhost:8080/user/updateuserbyemail/${userEmail}`,  // Replace with your API endpoint
      contentType: "application/json",
      data: JSON.stringify(updatedUserData),
      success: function(data) {
          // Handle success
          console.log("User data updated:", data);
          // Show a success pop-up alert
          alert("User data updated successfully!");
      },
      error: function(error) {
          // Handle error
          console.error("Error updating user data:", error);
          // Show an error pop-up alert
          alert("Failed to update user data.");
      }
  });
}

// Attach the updateUser function to the button's click event
$("#updateButton").on("click", function() {
  updateUser();
});
