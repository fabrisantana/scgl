const url = 'http://localhost:8080/fisioterapeutas/'
const optionsGet = {
    method: 'GET',
    mode: 'no-cors',
    cache: 'default'
}

const pesqFisio = document.getElementById('btnPesquisarFisio')
var pesqStatusFisio = document.getElementById('pesqStatusFisio')

//Retira pontos e traço do CPF e parênteses do telefone
function replace(dadosReplace){
    let resultado = dadosReplace.replace(".", "");
    resultado = resultado.replace(".", "");
    resultado = resultado.replace("-", "");
    resultado = resultado.replace("(", "");
    resultado = resultado.replace(")", "");
    return resultado;
}

//Preenche a tabela de Fisioterapeutas gravados no banco
function preencherTabela(txtCPF, txtNome, txtEmail, txtStatus){
    var tableFisio = document.getElementById("tableFisio");
    var criarBody = document.getElementById("tableBodyFisio");
    var criarLinha = document.createElement("tr");
    var criarColunaCpf = document.createElement("td");
    var criarColunaNome = document.createElement("td");
    var criarColunaEmail = document.createElement("td");
    var criarColunaStatus = document.createElement("td");

    criarLinha.setAttribute("class", "row");
    criarColunaCpf.setAttribute("class", "thead-light text-center col col-lg-2");
    criarColunaNome.setAttribute("class", "thead-light col col-lg-4");
    criarColunaEmail.setAttribute("class", "thead-light col col-lg-5");
    criarColunaStatus.setAttribute("class", "thead-light text-center col col-lg-1");

    criarBody.appendChild(criarLinha);
    criarLinha.appendChild(criarColunaCpf);
    criarColunaCpf.appendChild(txtCPF);
    criarLinha.appendChild(criarColunaNome);
    criarColunaNome.appendChild(txtNome);
    criarLinha.appendChild(criarColunaEmail);
    criarColunaEmail.appendChild(txtEmail);
    criarLinha.appendChild(criarColunaStatus);
    criarColunaStatus.appendChild(txtStatus);

    tableFisio.appendChild(criarBody);
}

//Limpa a tabela de Fisioterapeutas
function limparTabela(){
    document.getElementById("tableBodyFisio").innerHTML = "";
}

//Abre a página com a tabela carregada
addEventListener("load", erroClickGet =>{
    erroClickGet.preventDefault()
    fetch(url, optionsGet)
    .then(responseGet => responseGet.json()
    .then(respostaGetJson => { 
        
        for(let i = 0; i < respostaGetJson.length; i++){
            let txtCPF = document.createTextNode(respostaGetJson[i].fisioterapeutaCpf);
            let txtNome = document.createTextNode(respostaGetJson[i].fisioterapeutaNome);
            let txtEmail = document.createTextNode(respostaGetJson[i].fisioterapeutaEmail);
            let txtStatus = document.createTextNode(respostaGetJson[i].fisioterapeutaStatus);
            preencherTabela(txtCPF, txtNome, txtEmail, txtStatus);
        }
    }))
    .catch(erroCarregarPag => console.log('Erro GET: ' + erroCarregarPag.message))
})

//Monta a tabela com o Fisioterapeuta procurado, se este for encontrado
pesqFisio.addEventListener("click", erroClickGet =>{ //Testar com change
    limparTabela();
    erroClickGet.preventDefault()
    fetch(url, optionsGet)
    .then(responseGet => responseGet.json()
    .then(respostaGetJson => { 
        
        var fisioEncontrado = false;
        for(var posFisioPesq = 0; posFisioPesq < respostaGetJson.length; posFisioPesq++){
            if(pesqCpfFisio.value == '' && pesqNomeFisio.value == '' && pesqEmailFisio.value == '' 
                && pesqStatusFisio.value == respostaGetJson[posFisioPesq].fisioterapeutaStatus){
                fisioEncontrado = true;
                let txtCPF = document.createTextNode(respostaGetJson[posFisioPesq].fisioterapeutaCpf);
                let txtNome = document.createTextNode(respostaGetJson[posFisioPesq].fisioterapeutaNome);
                let txtEmail = document.createTextNode(respostaGetJson[posFisioPesq].fisioterapeutaEmail);
                let txtStatus = document.createTextNode(respostaGetJson[posFisioPesq].fisioterapeutaStatus);
                preencherTabela(txtCPF, txtNome, txtEmail, txtStatus);           
            }else{
                if(respostaGetJson[posFisioPesq].fisioterapeutaCpf.match(replace(pesqCpfFisio.value)) && 
                    respostaGetJson[posFisioPesq].fisioterapeutaNome.toLowerCase().match(pesqNomeFisio.value.toLowerCase()) &&
                    respostaGetJson[posFisioPesq].fisioterapeutaEmail.toLowerCase().match(pesqEmailFisio.value.toLowerCase() && 
                    pesqStatusFisio.value == respostaGetJson[posFisioPesq].fisioterapeutaStatus)){
                    fisioEncontrado = true;
                    let txtCPF = document.createTextNode(respostaGetJson[posFisioPesq].fisioterapeutaCpf);
                    let txtNome = document.createTextNode(respostaGetJson[posFisioPesq].fisioterapeutaNome);
                    let txtEmail = document.createTextNode(respostaGetJson[posFisioPesq].fisioterapeutaEmail);
                    let txtStatus = document.createTextNode(respostaGetJson[posFisioPesq].fisioterapeutaStatus);
                    preencherTabela(txtCPF, txtNome, txtEmail, txtStatus);            
                }
            } 
        } if(!fisioEncontrado || respostaGetJson.length == 0) {
            //document.location.reload(true);
            window.alert("Fisioterapeuta não encontrado ou nenhum Fisioterapeuta cadastrado!"); 
        }
    }))
    .catch(erroGetPesquisar => console.log('Erro GET: '+ erroGetPesquisar.message))
})


