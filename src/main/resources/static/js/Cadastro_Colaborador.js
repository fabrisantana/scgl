const urlSetores = 'http://localhost:8080/setoresEmpresa/';
const urlAlunos = 'http://localhost:8080/colaboradores/';
const urlEmpresas = 'http://localhost:8080/clientes/';
const optionsGet = {
	method: 'GET',
    mode: 'no-cors',
    cache: 'default'
}


const form = document.getElementById('formColab')
const inputCpfColab = document.getElementById('inputCpfColab')
const btnSalvar = document.getElementById('btnSalvar')
const btnCancelar = document.getElementById('btnCancelar')
var idAltera;


btnCancelar.addEventListener("click", erroClickCancelar =>{
    erroClickCancelar.preventDefault()
    document.location.reload(true)
});

//GET Empresas
addEventListener("load", erroGetEmpresas =>{
    erroGetEmpresas.preventDefault()
    fetch(urlEmpresas, optionsGet)
    .then(respostaJsonGetEmpresas => respostaJsonGetEmpresas.json()
    .then(respostaGetEmpresas => {
		empresasCarregadas = respostaGetEmpresas;
        for(let i = 0; i < respostaGetEmpresas.length; i++){
            if(respostaGetEmpresas[i].clienteStatus = "Ativo"){
                let optionEmpresas = new Option(respostaGetEmpresas[i].clienteNomeFantasia, respostaGetEmpresas[i].clienteId);
                comboEmpresas.add(optionEmpresas);
            }   
        }

    }))
    .catch(erroGetEmp => console.log('Erro no GET: '+ erroGetEmp.message))
});

//Pega o value da empresa selecionada
addEventListener('click', event =>{
    idEmpresaSelecionada = $("#comboEmpresas option:selected").val()
    empresaSelecionada = $("#comboEmpresas option:selected").text();
});


//GET Setores
comboEmpresas.addEventListener("change", erroGetSetores =>{
    fetch(urlSetores, optionsGet)
    .then(respostaJsonGet => respostaJsonGet.json()
    .then(respostaGetSetores => {
		setoresCarregados = respostaGetSetores;
        document.getElementById("comboSetores").innerHTML = ""; 
        for(let i = 0; i < respostaGetSetores.length; i++){
            if(respostaGetSetores[i].idCliente == idEmpresaSelecionada && respostaGetSetores[i].setorEmpresaStatus == 'Ativo'){
                let optionSetores = new Option(respostaGetSetores[i].siglaSetorEmpresa, respostaGetSetores[i].idSetorEmpresa);
                comboSetores.add(optionSetores);
            }
        }
    }))
    .catch(erroGetSet => console.log('Erro no GET: '+ erroGetSet.message))
});

//Pega o id e a sigla do setor selecionado
comboSetores.addEventListener('change', event =>{
    idSetorSelecionado = $("#comboSetores option:selected").val();
    siglaSetorSelecionado = $("#comboSetores option:selected").text();
});

//GET Colaboradores
inputCpfColab.addEventListener("change", erroBlurGet =>{
    erroBlurGet.preventDefault()
    fetch(urlAlunos, optionsGet)
    .then(respostaJsonGet => respostaJsonGet.json()
    .then(respostaGet => {
        for(let i = 0; i < respostaGet.length; i++){
            if(replace(inputCpfColab.value) == respostaGet[i].colaboradorCpf){
				window.alert("CPF já cadastrado!")
					               
                inputNomeColab.value = respostaGet[i].colaboradorNome;
            	inputDtNascColab.value = respostaGet[i].colaboradorDataNascimento.substring(0, 4) + '-' + 
                respostaGet[i].colaboradorDataNascimento.substring(5, 7) + '-' + respostaGet[i].colaboradorDataNascimento.substring(8, 10);
            	inputRgColab.value = respostaGet[i].colaboradorRg;
            	inputEmailColab.value = respostaGet[i].colaboradorEmail;
            	inputTelefoneColab.value = respostaGet[i].colaboradorTelefone;
            	inputStatusColab.value = respostaGet[i].colaboradorStatus;
            	idAltera = respostaGet[i].colaboradorId; 
            	inputCpfColab.disabled = true;
            	/*
            	fetch(urlSetores, optionsGet)
			    .then(respostaJsonGet => respostaJsonGet.json()
			    .then(respostaGetSetores => {
					//let optionSetores = new Option(respostaGetSetores.siglaSetorEmpresa, respostaGetSetores.idSetorEmpresa);
                	//comboSetores.add(optionSetores);
                	 
               	document.getElementById("comboSetores").innerHTML = ""; 
		        for(let x = 0; x < respostaGetSetores.length; x++){
		            if(respostaGetSetores[x].idCliente == idEmpresaSelecionada && respostaGetSetores[i].setorEmpresaStatus == 'Ativo'){  //Mudar para empresa que realizou login
						let optionSetores = new Option(respostaGetSetores[x].siglaSetorEmpresa, respostaGetSetores[x].idSetorEmpresa);
		                comboSetores.add(optionSetores);
		            }
		            if(respostaGetSetores[x].idSetorEmpresa == respostaGet[x].idSetorEmpresa){
						//comboSetores.options.selected = respostaGetSetores[x].siglaSetorEmpresa
						$("#comboSetores option:selected").text() = respostaGetSetores[x].siglaSetorEmpresa
						console.log($("#comboSetores option:selected").text())
		            }
		        }
				}))
			    .catch(erroGetSet => console.log('Erro no GET: '+ erroGetSet.message))
			    */
			    if(respostaGetSetores[x].idSetorEmpresa == respostaGet[x].idSetorEmpresa){
					//comboSetores.options.selected = respostaGetSetores[x].siglaSetorEmpresa
					$("#comboSetores option:selected").text() = respostaGetSetores[x].siglaSetorEmpresa
					console.log($("#comboSetores option:selected").text())
	            }
			    
            }
        }
    }))
    .catch(erroGet => console.log('Erro no GET: '+ erroGet.message))
})


//Ação para POST ou PUT
form.addEventListener("submit", realizaPostOuPut =>{
	realizaPostOuPut.preventDefault()
	if(idAltera > 0){
		realizaAlteracao()
	}else{
		realizaCadastro()
	}
})

//Início POST
function realizaCadastro(){
    const dadosPost = {
        colaboradorNome: inputNomeColab.value.trim().toUpperCase(),
        colaboradorDataNascimento: inputDtNascColab.value,
        colaboradorRg: inputRgColab.value,
        colaboradorCpf: replace(inputCpfColab.value),
        colaboradorEmail: inputEmailColab.value.trim(),
        colaboradorTelefone: replace(inputTelefoneColab.value).trim(),
        colaboradorDataExclusao: dataExclusao(),
        colaboradorStatus: inputStatusColab.value,
        colaboradorDataAtualizacao: dataHoraAtual,
        idSetorEmpresa: idSetorSelecionado
    }
    const optionsPost = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dadosPost)
    }

    fetch(urlAlunos, optionsPost)
    .then(respostaPost => {
        if(respostaPost.ok){
            window.alert("Colaborador: " + inputNomeColab.value.trim().toUpperCase() + " cadastrado no setor " + siglaSetorSelecionado + " com sucesso!")
            document.location.reload(true)
        }else{
			window.alert("Não foi possível cadastrar o Colaborador!")
		}        
    })
    .catch(erroPost => console.log('Erro no POST:' + erroPost))
}

//Início PUT
function realizaAlteracao(){
    const dadosPut = {
        colaboradorId: idAltera,
        colaboradorNome: inputNomeColab.value.trim().toUpperCase(),
        colaboradorDataNascimento: inputDtNascColab.value,
        colaboradorRg: inputRgColab.value,
        colaboradorCpf: replace(inputCpfColab.value),
        colaboradorEmail: inputEmailColab.value.trim(),
        colaboradorTelefone: replace(inputTelefoneColab.value).trim(),
        colaboradorDataExclusao: dataExclusao(),
        colaboradorStatus: inputStatusColab.value,
        colaboradorDataAtualizacao: dataHoraAtual,
        idSetorEmpresa: idSetorSelecionado
    }
    const optionsPut = {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dadosPut)
    }

    fetch(urlAlunos + idAltera, optionsPut)
    .then(respostaPut => {
        if(respostaPut.ok){
            window.alert("Colaborador: " + inputNomeColab.value.trim().toUpperCase() + " alterado com sucesso!")
            document.location.reload(true);
        }else{
			window.alert("Não foi possível alterar o Colaborador!")
		}       
    })
    .catch(erroPut => console.log('Erro no PUT:' + erroPut))
}


function replace(dadosReplace){
    let resultado = dadosReplace.replace(".", "");
    resultado = resultado.replace(".", "");
    resultado = resultado.replace("-", "");
    resultado = resultado.replace("(", "");
    resultado = resultado.replace(")", "");
    return resultado;
}

var dataHoraAtual = new Date()
dataHoraAtual = dataHoraAtual.getFullYear() + '-' + adicionaZero(dataHoraAtual.getMonth() + 1) + '-' + adicionaZero(dataHoraAtual.getDate()) + 'T' + 
adicionaZero(dataHoraAtual.getHours()) + ':' + adicionaZero(dataHoraAtual.getMinutes()) + ':' + adicionaZero(dataHoraAtual.getSeconds())

function adicionaZero(numero){
    if (numero <= 9) {
        return "0" + numero;
    }
    else{
        return numero; 
    }
}

function dataExclusao() {
    if(inputStatusColab.value == "Ativo"){
        return null;
    }else{
        return dataHoraAtual
    }
}

//Início validador CPF
function validarCPF(cpf){
    if(!_cpf(cpf.value) ){
        window.alert("CPF " + cpf.value + " inválido!" );
        cpf.value = "";
    }
}

function _cpf(cpf) {
    cpf = cpf.replace(/[^\d]+/g, '');

    if (cpf.length != 11 || cpf == "00000000000" || cpf == "11111111111" || cpf == "22222222222" || cpf == "33333333333" || cpf == "44444444444" || cpf == "55555555555" || cpf == "66666666666" || cpf == "77777777777" || cpf == "88888888888" || cpf == "99999999999"){
        return false;
    }
    
    add = 0;
    for (i = 0; i < 9; i++)
    add += parseInt(cpf.charAt(i)) * (10 - i);
    rev = 11 - (add % 11);
    if (rev == 10 || rev == 11)
    rev = 0;
    if (rev != parseInt(cpf.charAt(9)))
    return false;
    add = 0;
    for (i = 0; i < 10; i++)
    add += parseInt(cpf.charAt(i)) * (11 - i);
    rev = 11 - (add % 11);
    if (rev == 10 || rev == 11)
    rev = 0;
    if (rev != parseInt(cpf.charAt(10)))
    return false;
    return true;
}
//Fim validador CPF