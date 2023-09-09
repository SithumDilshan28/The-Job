document.addEventListener("DOMContentLoaded", function () {
    const submitButton = document.getElementById("submit");
    const resultDiv = document.getElementById("result");

    // Function to fetch and display all jobs
    function displayAllJobs() {
        fetch("http://localhost:8080/job/getjob")
            .then((response) => response.json())
            .then((data) => {
                resultDiv.innerHTML = ""; // Clear previous content

                const rowDiv = document.createElement("div");
                rowDiv.className = "row"; // Create a Bootstrap row

                data.forEach((item) => {
                    const colDiv = document.createElement("div");
                    colDiv.className = "col-lg-4 col-md-6 col-sm-12 mb-4"; // Use Bootstrap col-* classes

                    colDiv.innerHTML = `
                        <div class="employers-list position-relative pb-3 pt-3 pl-2 pr-2 border rounded min-width-element">
                            <img src="${item.imageurl}" alt="" class="mx-auto d-block shadow border rounded-circle" width="100" height="100">
                            <div class="grid-list-desc text-center mt-3">
                                <h5 class="mb-2"><a href="#" class="text-dark name">${item.role}</a></h5>
                                <p class="text-muted mb-0"><i class="mdi mdi-domain mr-2"></i>${item.company}</p>
                                <p class="text-muted mb-0"><i class="mdi mdi-calendar-clock mr-2"></i>${item.type}</p>
                                <p class="text-muted mb-0"><i class="mdi mdi-currency-usd mr-2"></i>${item.salary}</p>
                                <p class="text-muted mb-0"><i class="mdi mdi-briefcase-outline mr-2"></i>${item.experience}</p>
                            </div>
                            <div class="apply-button text-center mt-3">
                                <a href="consultant.html "class="btn btn-primary btn-sm">More Info</a>
                            </div>
                            <div class="fav-collection fav-icon">
                                <i class="mdi mdi-heart" title="Collect Now"></i>
                            </div>
                        </div>
                    `;

                    rowDiv.appendChild(colDiv);
                });

                resultDiv.appendChild(rowDiv); // Add the row to the resultDiv
            })
            .catch((error) => {
                console.error("Error:", error);
            });
    }

    // Call the function to display all jobs when the page loads
    displayAllJobs();

    submitButton.addEventListener("click", function (event) {
        event.preventDefault(); // Prevent the default form submission behavior

        const country = document.getElementById("select-country").value;
        const category = document.getElementById("select-category").value;

        // Create the request object
        const requestData = {
            country: country,
            category: category,
        };

        // Send a POST request to the backend
        fetch("http://localhost:8080/job/search", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(requestData),
        })
        .then((response) => response.json())
        .then((data) => {
            // Handle the returned data and display it in the resultDiv
            resultDiv.innerHTML = ""; // Clear previous content

            if (data.length === 0) {
                // Display an alert and return early if no results are available
                alert("Please select another job category. No results found.");
                return;
            }

            const rowDiv = document.createElement("div");
            rowDiv.className = "row"; // Create a Bootstrap row

            data.forEach((item) => {
                const colDiv = document.createElement("div");
                colDiv.className = "col-lg-4 col-md-6 col-sm-12 mb-4"; // Use Bootstrap col-* classes

                colDiv.innerHTML = `
                    <div class="employers-list position-relative pb-3 pt-3 pl-2 pr-2 border rounded min-width-element">
                        <img src="${item.imageurl}" alt="" class="mx-auto d-block shadow border rounded-circle" width="100" height="100">
                        <div class="grid-list-desc text-center mt-3">
                            <h5 class="mb-2"><a href="#" class="text-dark name">${item.role}</a></h5>
                            <p class="text-muted mb-0"><i class="mdi mdi-domain mr-2"></i>${item.company}</p>
                            <p class="text-muted mb-0"><i class="mdi mdi-calendar-clock mr-2"></i>${item.type}</p>
                            <p class="text-muted mb-0"><i class="mdi mdi-currency-usd mr-2"></i>${item.salary}</p>
                            <p class="text-muted mb-0"><i class="mdi mdi-briefcase-outline mr-2"></i>${item.experience}</p>
                        </div>
                        <div class="apply-button text-center mt-3">
                            <a href="consultant.html "class="btn btn-primary btn-sm">More Info</a>
                        </div>
                        <div class="fav-collection fav-icon">
                            <i class="mdi mdi-heart" title="Collect Now"></i>
                        </div>
                    </div>
                `;

                rowDiv.appendChild(colDiv);
            });

            resultDiv.appendChild(rowDiv); // Add the row to the resultDiv
        })
        .catch((error) => {
            console.error("Error:", error);
        });
    });
});
