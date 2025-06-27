// Funções para simular login/logout
function simulateLogin(userType) {
    localStorage.setItem('user_type', userType);
    console.log(`Simulando login como: ${userType}`);
}

function simulateLogout() {
    localStorage.removeItem('user_type');
    console.log('Sessão limpa. Usuário deslogado.');
}

// Funções para obter o tipo de usuário
function getUserType() {
    return localStorage.getItem('user_type');
}

