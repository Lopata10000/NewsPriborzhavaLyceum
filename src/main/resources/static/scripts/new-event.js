const form = document.getElementById('user-form');

form.addEventListener('submit', (event) => {
    event.preventDefault();
    const formData = new FormData(form);

    $.ajax({
        type: "POST",
        url: "/api/events/create",
        data: JSON.stringify(Object.fromEntries(formData)),
        contentType: "application/json",
        success: function (response) {
            window.location.href = "/html/resources.html";

        },
        error: function (xhr, textStatus, errorThrown) {
            showError(xhr.responseText);
        }
    });
});

function showError(responseText) {

    const error = JSON.parse(responseText);
    const errorMessage = error.message;
    document.getElementById('error-message').innerText = errorMessage;
    document.getElementById('error-message').style.display = 'block'
    setTimeout(() => {
        document.getElementById('error-message').style.display = 'none';
    }, 5000);
}