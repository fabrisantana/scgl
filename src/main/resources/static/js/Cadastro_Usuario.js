const urlUsuarios = 'http://localhost:8080/usuarios/'
const urlUsuariosRole = 'http://localhost:8080/usuariosRole/'
const optionsGet = {
	method: 'GET',
    mode: 'no-cors',
    cache: 'default'
}

const form = document.getElementById('formUsuario')
var senhaInicial = '123';
var loginInformado = document.getElementById('inputLogin');
var idUsuarioAltera = 0;


btnCancelar.addEventListener("click", erroClickCancelar =>{
    erroClickCancelar.preventDefault()
    document.location.reload(true)
});

//GET Role Usuario para preencher o tipo de usuario a ser alterado
inputLogin.addEventListener("change", inputLoginGet =>{
    inputLoginGet.preventDefault()
    fetch(urlUsuariosRole, optionsGet)
    .then(respostaJsonGet => respostaJsonGet.json()
    .then(respostaGet => {

        for(let i = 0; i < respostaGet.length; i++){
            if(loginInformado.value == respostaGet[i].loginUsuario){
				loginInformado.disabled = true;
                inputTipoUsuario.value = textoTipoRoleGet(respostaGet[i].tipoRole);
                inputNomeUsuario.value = respostaGet[i].nomeUsuario.trim().toUpperCase();
                inputEmailUsuario.value = respostaGet[i].emailUsuario;
                inputLogin.value = respostaGet[i].loginUsuario;
                inputStatusUsuario.value = statusUsuarioGet(respostaGet[i].statusUsuario);
                
                idUsuarioAltera = respostaGet[i].loginUsuario;
                window.alert("Usuário já cadastrado!")
            } 
        }
    }))
    .catch(erroGet => console.log('Erro no GET: '+ erroGet.message))
})


//Ação para POST ou PUT
form.addEventListener("submit", realizaPostOuPut =>{
	realizaPostOuPut.preventDefault()
	if(idUsuarioAltera > 0){
		alteraAcessoUsuario()
	}else{
		realizaCadastroUsuario()
	}
})


	
//POST Usuários
function realizaCadastroUsuario(){
	const dadosPostUsuario = {
        login: loginInformado.value.trim(),
        senha: senhaInicial,
        dataHoraAtualizacao: dataHoraAtual,
        statusUsuario: statusUsuario()
    }
    const optionsPostUsuario = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dadosPostUsuario)
    }

    fetch(urlUsuarios, optionsPostUsuario)
    .then(respostaPost => {
        if(respostaPost.ok){
            realizaCadastroUsuarioRole()
        }else{
			window.alert("Verifique os dados digitados!")
		}       
    })
    .catch(erroPost => window.alert('Erro no POST:' + erroPost));
}

//PUT Usuários
function alteraAcessoUsuario(){
    const dadosPutUsuarios = {
        login: loginInformado.value.trim(),
        senha: senhaInicial,
        dataHoraAtualizacao: dataHoraAtual,
        statusUsuario: statusUsuario()
    }
    const optionsPutUsuarios = {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dadosPutUsuarios)
    }

    fetch(urlUsuarios + loginInformado.value, optionsPutUsuarios)
    .then(respostaPut => {
        if(respostaPut.ok){
            alteraUsuarioRole()
        }else{
			window.alert("Verifique os dados digitados!")
		}       
    })
    .catch(erroPut => window.alert('Erro no PUT:' + erroPut))
}

//PUT Usuários Role
function alteraUsuarioRole(){
    const dadosPut = {
        loginUsuario: loginInformado.value,
        tipoRole: textoTipoRole(inputTipoUsuario.value),
        dataHoraAtualizacao: dataHoraAtual,
        emailUsuario: inputEmailUsuario.value,
        nomeUsuario: inputNomeUsuario.value.trim().toUpperCase(),
        statusUsuario: statusUsuario()
    }
    const optionsPut = {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dadosPut)
    }

    fetch(urlUsuariosRole + loginInformado.value, optionsPut)
    .then(respostaPut => {
        if(respostaPut.ok){
            window.alert("Sucesso na atualização de cadastro!");
        }else{
			window.alert("Verifique os dados digitados!")
		}        
    })
    .catch(erroPut => window.alert('Erro no PUT:' + erroPut))
}

//POST Usuários Role
function realizaCadastroUsuarioRole(){
    const dadosPostUsuarioRole = {
        loginUsuario: loginInformado.value,
        tipoRole: textoTipoRole(inputTipoUsuario.value),
        dataHoraAtualizacao: dataHoraAtual,
        emailUsuario: inputEmailUsuario.value,
        nomeUsuario: inputNomeUsuario.value.trim().toUpperCase(),
        statusUsuario: statusUsuario()
    }
    const optionsPostUsuarioRole = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dadosPostUsuarioRole)
    }
    fetch(urlUsuariosRole, optionsPostUsuarioRole)
    .then(respostaPost => {
        if(respostaPost.ok){
            window.alert("Sucesso no cadastro!");
        }else{
			window.alert("Verifique os dados digitados!")
		}       
    })
    .catch(erroPost => window.alert('Erro no POST:' + erroPost))
}

//Transforma o texto do tipo Role conforme está cadastrado no banco para o POST
function textoTipoRole(tipoSelecionado){
	if(tipoSelecionado == "Administrador"){
		return "ROLE_ADM"
	}
	if(tipoSelecionado == "Cliente"){
		return "ROLE_CLI"
	}
	if(tipoSelecionado == "Fisioterapeuta"){
		return "ROLE_FIS"
	}
}

//Transforma o texto do tipo Role conforme está cadastrado no banco para o GET
function textoTipoRoleGet(tipoSelecionado){
	if(tipoSelecionado == "ROLE_ADM"){
		return "Administrador"
	}
	if(tipoSelecionado == "ROLE_CLI"){
		return "Cliente"
	}
	if(tipoSelecionado == "ROLE_FIS"){
		return "Fisioterapeuta"
	}
}

//Função que captura a data atual do cliente
var dataHoraAtual = new Date();

var hoje = new Date()
hoje = hoje.getFullYear() + '-' + adicionaZero(hoje.getMonth() + 1) + '-' + adicionaZero(hoje.getDate()) 

function adicionaZero(numero){
    if (numero <= 9) {
        return "0" + numero;
    }
    else{
        return numero; 
    }
}

//Transforma status ativo em true ou inativo em false, serve para bloquear o acesso do usuário ao sistema
function statusUsuario() {
    if(inputStatusUsuario.value == "Ativo"){
        return true;
    }else{
        return false
    }
}

//Transforma status ativo em true ou inativo em false, serve para bloquear o acesso do usuário ao sistema
function statusUsuarioGet(boolBanco) {
    if(boolBanco){
        return "Ativo";
    }else{
        return "Inativo"
    }
}