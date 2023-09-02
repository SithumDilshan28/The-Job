
    const dateInput = document.getElementById('input3');

// Function to set the minimum date to today's date
function setMinDate() {
    const today = new Date();
    const day = today.getDate().toString().padStart(2, '0');
    const month = (today.getMonth() + 1).toString().padStart(2, '0');
    const year = today.getFullYear();
    const minDate = `${year}-${month}-${day}`;
    dateInput.setAttribute('min', minDate);
}

// Call the function to set the minimum date initially
setMinDate();

// Add an event listener to update the minimum date if the input is focused
dateInput.addEventListener('focus', setMinDate);
