// checkToken.js

// Функція для перевірки наявності токена
function checkToken() {
    const token = localStorage.getItem('refreshToken');
    return token;
}

// Функція для відображення кнопок залежно від токена
function toggleButtons() {
    const token = checkToken();
    const loginButton = document.getElementById('loginButton');
    const signUpButton = document.getElementById('signUpButton');
    const applicationsButton = document.getElementById('applicationsButton');
    const newEventButton = document.getElementById('newEventButton');

    if (token) {
        loginButton.style.display = 'none';
        signUpButton.style.display = 'none';
        applicationsButton.style.display = 'block';
        newEventButton.style.display = 'block';
    } else {
        loginButton.style.display = 'block';
        signUpButton.style.display = 'block';
        applicationsButton.style.display = 'none';
        newEventButton.style.display = 'none';
    }
}

// Виклик функції при завантаженні сторінки
window.onload = toggleButtons;
