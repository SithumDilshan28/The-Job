function saveContact() {
  let name = $("#name").val();
  let email = $("#email").val();
  let phone = $("#phone").val();
  let message = $("#input1").val();

  // Check if firstname, email, and password are empty
  if (name.trim() === "" || email.trim() === "" || phone.trim() === "" ) {
    alert("All the fields are required.");
    return; // Prevent the AJAX request if validation fails
  }

  $.ajax({
    method: "POST",
    contentType: "application/json",
    url: "http://localhost:8080/contact/savecontact",
    async: true,
    data: JSON.stringify({
      id: "",
      name: name,
      email: email,
      phone: phone,
      message: message,
    }),
    success: function (data) {
      alert("Message Added Successfully");
      window.location.href = '?refresh=true';
    },
    error: function (xhr, exception) {
      alert("Error");
    },
  });
}
