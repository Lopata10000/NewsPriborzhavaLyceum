const form = document.getElementById('user-form');
var eventTime = document.getElementById('eventTime').value;
var moment = window.moment; // use the global Moment.js object

var formattedEventTime = moment(eventTime, 'HH:mm').format('HH:mm:ss'); // format as HH:mm:ss
var data = { "eventTime": formattedEventTime };

form.addEventListener('submit', (event) => {
    event.preventDefault();
    const formData = new FormData(form);

    $.ajax({
        type: "POST",
        url: "/api/events/new",
        data: JSON.stringify(Object.fromEntries(formData)),
        contentType: "application/json",

        success: function (response) {
            Swal.fire({
                title: 'Створено нову подію.',
                icon: 'success',
                confirmButtonText: 'OK'
            });
        },
        error: function (xhr, textStatus, errorThrown) {
            // handle error
        }
    });
});