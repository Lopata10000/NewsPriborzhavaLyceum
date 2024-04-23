
const app = new Vue({
    el: '#app',
    data() {
        return {
            events: []
        }
    },
    methods: {
        async fetchEvents() {
            const headers = {};
            const response = await axios.get('/api/events');
            this.events = response.data;

        },
        async register(event) {
            var token = localStorage.getItem('refreshToken');


            try {
                const eventId = event.id;

                const applicationData = {
                    eventId: eventId,
                    userId: 1,
                    applicantName: "Ім'я користувача",
                    note: "Примітка про заявку"
                };

                const headers = {
                    'Authorization': `Bearer ${token}`
                };

                await axios.post('/api/applications/create', applicationData, {
                    headers: headers
                });
                Swal.fire({
                    title: 'Ваша заявка надіслана.',
                    text: 'Ваша заявка падіслана на розгляд',
                    icon: 'success',
                    confirmButtonText: 'OK'
                });

            } catch (error) {
                window.location.href = "/html/access-denied.html";

            }
        }
    },
    mounted() {
        this.fetchEvents();
    }
});