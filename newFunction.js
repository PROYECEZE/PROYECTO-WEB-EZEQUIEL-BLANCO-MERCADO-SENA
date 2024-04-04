// Acceder a los elementos del DOM
const loginForm = document.getElementById('login-form');
const registerForm = document.getElementById('register-form');

// Manejador de evento para el inicio de sesión
loginForm.addEventListener('submit', (e) => {
  e.preventDefault(); // Evitar el envío del formulario

  // Obtener los valores de usuario y contraseña
  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;

  console.log('Inicio de sesión:', username, password);

  // Restablecer el formulario
  loginForm.reset();
});

// Manejador de evento para el registro
registerForm.addEventListener('submit', (e) => {
  e.preventDefault(); // Evitar el envío del formulario

  // Obtener los valores de usuario, contraseña y correo electrónico
  const nombre = document.getElementById('nombre').value;
  const email = document.getElementById('email').value;
  const contraseña= document.getElementById('contraseña').value;

  console.log('Registro:', nombre, email, contraseña);

  // Restablecer el formulario
  registerForm.reset();
});

function registrarse()
{
  const nombre = document.getElementById('nombre').value;
  const email = document.getElementById('email').value;
  const contraseña= document.getElementById('contraseña').value;


  // const data = {
  //   nombre: nombre,
  //   email: email,
  //   contraseña: contraseña
  // };
  var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

var raw = JSON.stringify({
  "nombres": nombre,
  "usuario": email,
  "contraseña": contraseña
});

var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("http://localhost:8080/api/registrarse", requestOptions)
  .then(response => response.text())
  .then(result => alert("registro con exito"))
  .catch(error => console.log('error', error));
  
  // Configurar la opción para la solicitud POST

 console.log('Registro:', nombre, email, contraseña);
}


function iniciar_secion() {
  const email = document.getElementById('email').value;
  const contraseña = document.getElementById('password').value;

  var myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");

  var raw = JSON.stringify({
    "usuario": email,
    "contraseña": contraseña
  });

  var requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
  };

  fetch("http://localhost:8080/api/login", requestOptions)
    .then(response => response.text()) // Cambié response.text() a response.json() para manejar datos JSON
    .then(result => {
      if (result == "no") {
        alert("error de la autenticacion");
      } else {
     alert ("autenticación satisfactoria")
        // Puedes redirigir a otra página o realizar acciones adicionales después de la autenticación exitosa aquí.
      }
    })
    .catch(error => console.log('error', error));
}


