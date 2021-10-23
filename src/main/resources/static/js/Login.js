const username = document.getElementById('loginUsuario')


addEventListener("change", capturaLoginUsuario =>{
	capturaLoginUsuario.preventDefault()
	localStorage.setItem("loginUsuario", username);
	console.log($("#loginUsuario").val())
})
