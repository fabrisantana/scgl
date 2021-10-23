const urlFisio = 'http://localhost:8080/fisioterapeutas/'
const optionsGet = {
        method: 'GET',
        mode: 'no-cors',
        cache: 'default'
    }
//window.addEventListener("load", alertFisioDanger(false));
//window.addEventListener("load", alertFisioSuccess(false));
const form = document.getElementById('formFisio')
const inputCpfFisio = document.getElementById('inputCpfFisio')
const btnSalvar = document.getElementById('btnSalvar')
const btnCancelar = document.getElementById('btnCancelar')
var idAltera;


btnCancelar.addEventListener("click", erroClickCancelar =>{
    erroClickCancelar.preventDefault()
    document.location.reload(true)
});

/*
function alertFisio(msg){
    //var criarDiv = document.getElementById("alertFisio");
    var alertFisio = document.getElementById("alertFisio");

    //criarDiv.setAttribute("class", "alert alert-danger");
    //criarDiv.setAttribute("role", "alert");

    alertFisio.innerText = msg;
}*/

/*
function alertFisioDanger(acao , msg){
    var mensagem = document.getElementById("alertFisioDanger");

    mensagem.innerHTML = msg;
    mensagem.style.display = (acao ? "block" : "none");
    

    if (!acao){
     setTimeout(function() { alertFisioDanger(false); }, 5000);
    }
}

function alertFisioSuccess(acao , msg){
    var mensagem = document.getElementById("alertFisioSuccess");

    mensagem.innerHTML = msg;
    mensagem.style.display = (acao ? "block" : "none");
    

    if (!acao){
     setTimeout(function() { alertFisioSuccess(false); }, 5000);
    }
}
*/
//GET Fisioterapeutas
inputCpfFisio.addEventListener("change", erroBlurGet =>{
    erroBlurGet.preventDefault()
    fetch(urlFisio, optionsGet)
    .then(respostaJsonGet => respostaJsonGet.json()
    .then(respostaGet => {
        let respostaDirecionamento;

        for(let i = 0; i < respostaGet.length; i++){
            if(replace(inputCpfFisio.value) == respostaGet[i].fisioterapeutaCpf){

                //respostaDirecionamento = confirm("CPF já existe! Deseja alterar cadastro?");
                window.alert("CPF já cadastrado!")
                
                //if(respostaDirecionamento){
                    inputNomeFisio.value = respostaGet[i].fisioterapeutaNome;
                	inputDtNascFisio.value = respostaGet[i].fisioterapeutaDataNascimento.substring(0, 4) + '-' + 
                    respostaGet[i].fisioterapeutaDataNascimento.substring(5, 7) + '-' + respostaGet[i].fisioterapeutaDataNascimento.substring(8, 10);
                	inputRgFisio.value = respostaGet[i].fisioterapeutaRg;
                	inputEmailFisio.value = respostaGet[i].fisioterapeutaEmail;
                	inputTelefoneFisio.value = respostaGet[i].fisioterapeutaTelefone;
                	inputStatusFisio.value = respostaGet[i].fisioterapeutaStatus;
                	idAltera = respostaGet[i].fisioId; 
                	inputCpfFisio.disabled = true;
                	                    
                //} else{
                    //alertFisioDanger(true, "CPF já cadastrado!");
                    //document.location.reload(true)
               // }
                
                //document.location.reload(true)               
            } 
        }
    }))
    .catch(erroGet => console.log('Erro no GET: '+ erroGet.message))
})



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
        fisioterapeutaNome: inputNomeFisio.value.trim().toUpperCase(),
        fisioterapeutaDataNascimento: inputDtNascFisio.value,
        fisioterapeutaRg: inputRgFisio.value,
        fisioterapeutaCpf: replace(inputCpfFisio.value),
        fisioterapeutaEmail: inputEmailFisio.value.trim(),
        fisioterapeutaTelefone: replace(inputTelefoneFisio.value).trim(),
        fisioterapeutaDtExclusao: dataExclusao(),
        fisioterapeutaStatus: inputStatusFisio.value,
        fisioterapeutaDtAtualizacao: dataHoraAtual
    }
    const optionsPost = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dadosPost)
    }

    fetch(urlFisio, optionsPost)
    .then(respostaPost => {
        if(respostaPost.ok){
            window.alert("Fisioterapeuta: " + inputNomeFisio.value.trim().toUpperCase() + " cadastrado com sucesso!")
            document.location.reload(true)
        }else{
			window.alert("Não foi possível cadastrar o Fisioterapeuta!")
		}        
    })
    .catch(erroPost => console.log('Erro no POST:' + erroPost))
}

//Início PUT
function realizaAlteracao(){
    const dadosPut = {
        fisioId: idAltera,
        fisioterapeutaNome: inputNomeFisio.value.trim().toUpperCase(),
        fisioterapeutaDataNascimento: inputDtNascFisio.value,
        fisioterapeutaRg: inputRgFisio.value,
        fisioterapeutaCpf: replace(inputCpfFisio.value),
        fisioterapeutaEmail: inputEmailFisio.value.trim(),
        fisioterapeutaTelefone: replace(inputTelefoneFisio.value).trim(),
        fisioterapeutaDtExclusao: dataExclusao(),
        fisioterapeutaStatus: inputStatusFisio.value,
        fisioterapeutaDtAtualizacao: dataHoraAtual
    }
    const optionsPut = {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dadosPut)
    }

    fetch(urlFisio + idAltera, optionsPut)
    .then(respostaPut => {
        if(respostaPut.ok){
            window.alert("Fisioterapeuta: " + inputNomeFisio.value.trim().toUpperCase() + " alterado com sucesso!")
            document.location.reload(true);
        }else{
			window.alert("Não foi possível cadastrar o Fisioterapeuta!")
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
    if(inputStatusFisio.value == "Ativo"){
        return null;
    }else{
        return dataHoraAtual
    }
}