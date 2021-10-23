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
inputLogin.addEventListener("blur", inputLoginGet =>{
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
                inputStatusUsuario.value = respostaGet[i].statusUsuario;
                
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
		realizaAlteracao()
	}else{
		realizaCadastro()
	}
})

//Início PUT
function realizaAlteracao(){
    const dadosPut = {
        loginUsuario: loginInformado.value,
        tipoRole: textoTipoRole(inputTipoUsuario.value),
        dataHoraAtualizacao: dataHoraAtual,
        emailUsuario: inputEmailUsuario.value,
        nomeUsuario: inputNomeUsuario.value.trim().toUpperCase(),
        statusUsuario: inputStatusUsuario.value
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
            if(inputStatusUsuario.value == 'Ativo'){
				window.alert("Sucesso atualiza��o de cadastro!");
				liberaAcessoUsuario()
			}else{
				window.alert("Usuário alterado com status Inativo. Não fará login no sistema!");
            	//retiraAcessoUsuario()
            	document.location.reload(true)
			}
        }        
    })
    .catch(erroPut => window.alert('Erro no PUT:' + erroPut))
}

//Início POST Usuários
function realizaCadastro(){
    const dadosPostUsuarioRole = {
        loginUsuario: loginInformado.value,
        tipoRole: textoTipoRole(inputTipoUsuario.value),
        dataHoraAtualizacao: dataHoraAtual,
        emailUsuario: inputEmailUsuario.value,
        nomeUsuario: inputNomeUsuario.value.trim().toUpperCase(),
        statusUsuario: inputStatusUsuario.value
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
			
			if(inputStatusUsuario.value == 'Ativo'){
				window.alert("Sucesso no cadastro!");
				liberaAcessoUsuario()
			}else{
				window.alert("Usuário cadastrado com status Inativo. Não fará login no sistema!")
            	document.location.reload(true)
			}
       	}else{
			window.alert("Verifique os dados digitados!")
		}       
    })
    .catch(erroPost => window.alert('Erro no POST:' + erroPost))
}
	
//Grava usuário criado na tabela Usuários Role, se não gravar aqui, o usuário não fará login
function liberaAcessoUsuario(){
	const dadosPostUsuario = {
        login: loginInformado.value.trim(),
        senha: senhaInicial,
        dataHoraAtualizacao: dataHoraAtual,
        statusUsuario: inputStatusUsuario.value
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
			//realizaCadastro()
            window.alert("Usuário cadastrado/alterado e acesso liberado ao sistema!")
            document.location.reload(true)
        }else{
			window.alert("Verifique os dados digitados!")
		}       
    })
    .catch(erroPost => window.alert('Erro no POST:' + erroPost));
}

/*
//Função que deleta o usuário da tabela Usuario, retirando o acesso ao sistema
function retiraAcessoUsuario(){
	const optionsDeleteUsuario = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    }

    //fetch(urlUsuarios + loginInformado.value, optionsDeleteUsuario)
    .then(respostaDelete => {
        if(respostaDelete.ok){
            window.alert("Retirado acesso ao sistema!")
            document.location.reload(true)
        }else{
			window.alert("Verifique os dados digitados!")
		}       
    })
    .catch(erroPost => window.alert('Erro no POST:' + erroPost));
}
*/



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
	if(tipoSelecionado == "Inativo"){
		return "ROLE_INA"
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
	if(tipoSelecionado == "ROLE_INA"){
		return "Inativo"
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