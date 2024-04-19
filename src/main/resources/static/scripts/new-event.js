const form = document.getElementById('user-form');
<a href="/html/access-denied.html" />

form.addEventListener('submit', (event) => {
    event.preventDefault();
    const formData = new FormData(form);

    $.ajax({
        type: "POST",
        url: "/api/events/new",
        data: JSON.stringify(Object.fromEntries(formData)),
        contentType: "application/json",
        success: function (response) {
            window.location.href = "/html/resources.html";

        },
        error: function (xhr, textStatus, errorThrown) {
            <a href="/html/access-denied.html" />
        }
    });
});

