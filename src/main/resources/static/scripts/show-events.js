const app = new Vue({
    el: '#app',
    data() {
        return {
            events: []
        }
    },
    methods: {
        async fetchEvents() {
            const response = await axios.get('/api/events');
            this.events = response.data; // Оновлення events з даними про події з сервера

        },
        async register(event) {
            try {
                await axios.post('https://your-api-url.com/register', event);
                // Обробка успішної реєстрації
            } catch (error) {
                console.error(error);
            }
        }
    },
    mounted() {
        this.fetchEvents();
    }
});