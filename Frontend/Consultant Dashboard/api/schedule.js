function saveSchedule() {
  let date = $("#input3").val();
  let time = $("#input1").val();
  let fullname = $("#input2").val();

  // Check if firstname, email, and password are empty
  if (date.trim() === "" || time.trim() === "" || fullname.trim() === "") {
    alert("Please Collect Data and Add Date and Time.");
    return; // Prevent the AJAX request if validation fails
  }

  // Other input field values
  let imageurl = $("#input4").val();
  let specilizedjobtype = $("#input5").val();
  let specilizedcountry = $("#input6").val();
  let phone = $("#input7").val();
  let email = $("#input8").val();

  $.ajax({
    method: "POST",
    contentType: "application/json",
    url: "http://localhost:8080/availability/saveavailability",
    async: true,
    data: JSON.stringify({
      id: "",
      date: date,
      timeslot: time,
      fullname: fullname,
      imageurl: imageurl,
      specilizedjobtype: specilizedjobtype,
      specilizedcountry: specilizedcountry,
      phone: phone,
      email: email,

    }),
    success: function (data) {
      alert("Avaialable Date Added Successfully");
      window.location.href = '?refresh=true';
    },
    error: function (xhr, exception) {
      alert("Error");
    },
  });
}

function resetSchedule() { 
  let date = $("#input3").val("");
  let time = $("#input1").val("");
  let fullname = $("#input2").val("");
  let imageurl = $("#input4").val("");
  let specilizedjobtype = $("#input5").val("");
  let specilizedcountry = $("#input6").val("");
  let phone = $("#input7").val("");
  let email = $("#input8").val("");
}


function fetchAvailability() {


  const email = sessionStorage.getItem("email");
  // Construct the API URL based on the provided email
  const apiUrl = "http://localhost:8080/consultant/setavailabledate/"+email;

  // Create a POST request to the constructed API URL with the email parameter
  fetch(apiUrl, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({ email: email }),
  })
    .then((response) => response.json())
    .then((data) => {
      // Check if the response is an array with at least one element
      if (Array.isArray(data) && data.length > 0) {
        // Extract data from the first element of the response array
        const consultantData = data[0];

        // Extract properties from the response
        const fullname = consultantData[0]; // Index 0 corresponds to 'fullname'
        const imageurl = consultantData[1]; // Index 1 corresponds to 'imageurl'
        const specilizedjobtype = consultantData[2]; // Index 2 corresponds to 'specilizedjobtype'
        const specilizedcountry = consultantData[3]; // Index 3 corresponds to 'specilizedcountry'
        const phone = consultantData[4]; // Index 4 corresponds to 'phone'
        const email = consultantData[5]; // Index 5 corresponds to 'email'

        // Update the input fields with the fetched data
        $("#input2").val(fullname);
        $("#input4").val(imageurl);
        $("#input5").val(specilizedjobtype);
        $("#input6").val(specilizedcountry);
        $("#input7").val(phone);
        $("#input8").val(email);
      } else {
        console.error('No data found for the given email.');
      }
    })
    .catch((error) => {
      console.error('Error fetching data:', error);
    });
}

