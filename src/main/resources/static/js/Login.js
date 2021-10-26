


addEventListener("change", capturaLoginUsuario =>{
	capturaLoginUsuario.preventDefault()
	var username = document.getElementById('loginUsuario')
	localStorage.setItem("loginUsuario", username.value);
	
	var usuarioLogado = document.getElementById('usuarioLogado')
	usuarioLogado.innerText = localStorage.getItem("loginUsuario")
})
