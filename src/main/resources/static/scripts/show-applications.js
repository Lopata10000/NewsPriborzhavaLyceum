const app = new Vue({
    el: '#app',
    data() {
        return {
            applications: []
        }
    },

    methods: {
        async fetchApplications() {
            try {
                const response = await axios.get('/api/applications');
                this.applications = response.data;
            } catch (error) {
                window.location.href = "/html/access-denied.html";
            }
        },
        async acceptApplication(applicationId) {

            try {
                const token = localStorage.getItem('refreshToken');

                const headers = {
                    'Authorization': `Bearer ${token}`
                };

                // Отримати всі дані про заявку за її ID
                const applicationToUpdate = this.applications.find(app => app.id === applicationId);

                const updatedApplication = {
                    id: applicationToUpdate.id,
                    eventId: applicationToUpdate.eventId,
                    userId: applicationToUpdate.userId,
                    status: 'accepted', // Оновлений статус
                    applicantName: applicationToUpdate.applicantName,
                    note: applicationToUpdate.note
                };

                await axios.put(`/api/applications/${applicationId}`, updatedApplication, {
                    headers: headers
                });

                Swal.fire({
                    title: 'Заявку прийнято.',
                    icon: 'success',
                    confirmButtonText: 'OK'
                });
                this.fetchApplications();
            } catch (error) {
                window.location.href = "/html/access-denied.html";
            }
        },
        async rejectApplication(applicationId) {
            try {
                const token = localStorage.getItem('refreshToken');

                const headers = {
                    'Authorization': `Bearer ${token}`
                };

                // Отримати всі дані про заявку за її ID
                const applicationToUpdate = this.applications.find(app => app.id === applicationId);

                // Оновлений об'єкт з усіма полями заявки
                const updatedApplication = {
                    id: applicationToUpdate.id,
                    eventId: applicationToUpdate.eventId,
                    userId: applicationToUpdate.userId,
                    status: 'rejected', // Оновлений статус
                    applicantName: applicationToUpdate.applicantName,
                    note: applicationToUpdate.note
                };

                await axios.put(`/api/applications/${applicationId}`, updatedApplication, {
                    headers: headers
                });
                Swal.fire({
                    title: 'Заявку відхилено.',
                    icon: 'error',
                    confirmButtonText: 'OK'
                });
                // Оновити список заявок після відхилення
                this.fetchApplications();
            } catch (error) {
                window.location.href = "/html/access-denied.html";
            }
        }
    },
    mounted() {
        this.fetchApplications();
    }
});
