const dateInput = document.getElementById('input3');

// Function to set the minimum date to today's date
function setMinDate() {
    const today = new Date();
    const day = today.getDate().toString().padStart(2, '0');
    const month = (today.getMonth() + 1).toString().padStart(2, '0');
    const year = today.getFullYear();
    
    // Check if today is Sunday (day 0 in JavaScript's Date object)
    if (today.getDay() === 0) {
        // If today is Sunday, set minDate to the next Monday
        today.setDate(today.getDate() + 1);
    }
    
    const minDate = `${year}-${month}-${day}`;
    dateInput.setAttribute('min', minDate);
}

// Call the function to set the minimum date initially
setMinDate();

// Add an event listener to update the minimum date if the input is focused
dateInput.addEventListener('focus', setMinDate);

// Add an event listener to prevent selection of Sundays
dateInput.addEventListener('input', function() {
    const selectedDate = new Date(dateInput.value);
    if (selectedDate.getDay() === 0) {
        dateInput.value = ''; // Clear the input value if Sunday is selected
    }
});
