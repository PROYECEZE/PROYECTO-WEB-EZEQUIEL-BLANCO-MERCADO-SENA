let slideIndex = 0;

function showSlide(n) {
    const slides = document.querySelectorAll('.slide');
    if (n >= slides.length) {
        slideIndex = 0;
    }
    if (n < 0) {
        slideIndex = slides.length - 1;
    }

    slides.forEach((slide) => {
        slide.style.transform = `translateX(-${slideIndex * 100}%)`;
    });
}

function nextSlide() {
    slideIndex++;
    showSlide(slideIndex);
}

function buscarcategorias() {
$('#search-input').val()
window.location.href = 'http://'+$('#search-input').val()+'.html';
}

function prevSlide() {
    slideIndex--;
    showSlide(slideIndex);
}

// Iniciar el carrusel
showSlide(slideIndex);

// Puedes agregar un temporizador para que el carrusel se mueva automáticamente
setInterval(nextSlide, 5000); 



const searchInput = document.getElementById('search-input');
const searchButton = document.getElementById('search-button');
const searchResults = document.getElementById('search-results');

searchButton.addEventListener('click', () => {
    const searchTerm = searchInput.value.trim();

    // Realiza la búsqueda o muestra un mensaje de error si no se ingresa un término de búsqueda válido
    if (searchTerm !== '') {
        // Aquí puedes realizar la búsqueda y mostrar los resultados en #search-results
        window.location.href = './'+searchTerm+'.html';

        searchResults.textContent = `Resultados de búsqueda para: ${searchTerm}`;
    } else {
        searchResults.textContent = 'Por favor, ingresa un término de búsqueda válido.';
    }
});