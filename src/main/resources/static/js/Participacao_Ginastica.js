const urlSetores = 'http://localhost:8080/setoresEmpresa/';
const urlAlunos = 'http://localhost:8080/colaboradores/';
const urlEmpresas = 'http://localhost:8080/clientes/';
const urlSessoesLaborais = 'http://localhost:8080/sessoesLaborais/';
const urlParticipacoes = 'http://localhost:8080/participacoes/';
const optionsGet = {
    method: 'GET',
    mode: 'no-cors',
    cache: 'default'
}

const btnSalvar = document.getElementById('btnSalvar')
const comboEmpresas = document.getElementById('comboEmpresas')
const comboSetores = document.getElementById('comboSetores')
const tableBodyChamada = document.getElementById('tableBodyChamada')
const btnCarregar = document.getElementById('btnCarregar')
const btnCancelar = document.getElementById('btnCancelar')


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
});


//GET Setores
comboEmpresas.addEventListener("change", erroGetSetores =>{
    fetch(urlSetores, optionsGet)
    .then(respostaJsonGet => respostaJsonGet.json()
    .then(respostaGetSetores => {
        document.getElementById("comboSetores").innerHTML = ""; 
        for(let i = 0; i < respostaGetSetores.length; i++){
            if(respostaGetSetores[i].idCliente == idEmpresaSelecionada){
                let optionSetores = new Option(respostaGetSetores[i].siglaSetorEmpresa, respostaGetSetores[i].idSetorEmpresa);
                comboSetores.add(optionSetores);
            }
        }
        
    }))
    .catch(erroGetSet => console.log('Erro no GET: '+ erroGetSet.message))
});


//Pega o value do setor selecionado e carrega a tabela de alunos daquele setor
comboSetores.addEventListener('change', event =>{
    idSetorSelecionado = $("#comboSetores option:selected").val();
    siglaSetorSelecionado = $("#comboSetores option:selected").text();

    //Carrega a tabela de alunos
    btnCarregar.addEventListener("click", erroGetAlunos =>{
        erroGetAlunos.preventDefault()
        fetch(urlAlunos, optionsGet)
        .then(respostaJsonGetAlunos => respostaJsonGetAlunos.json()
        .then(respostaGetAlunos => {
            document.getElementById("tableBodyChamada").innerHTML = "";
            for(let i = 0; i < respostaGetAlunos.length; i++){
                if(respostaGetAlunos[i].colaboradorStatus == 'Ativo' && respostaGetAlunos[i].idSetorEmpresa == idSetorSelecionado){
                    let txtNome = document.createTextNode(respostaGetAlunos[i].colaboradorNome.toUpperCase());
                    let txtSetor = document.createTextNode(siglaSetorSelecionado);
                    let idColaborador = respostaGetAlunos[i].colaboradorId;
                    preencherTabela(txtNome, txtSetor, idColaborador);
                    quantAlunosSetor (1)
                }
            }
        }))
    .catch(erroGetAlunos => console.log('Erro no GET: '+ erroGetAlunos.message))
    });
});

//Função que grava a quantidade de alunos no setor selecionado na variável
var quantAlunos = 0;
var listaAlunos = [];
function quantAlunosSetor(quant){
    quantAlunos = quantAlunos + quant
}

//Função que preenche a tabela alunos do setor selecionado
function preencherTabela(txtNome, txtSetor, idColaborador){
    var tableChamada = document.getElementById("tableChamada");
    var criarBody = document.getElementById("tableBodyChamada");
    var criarLinha = document.createElement("tr");
    var criarColunaNome = document.createElement("td");
    var criarColunaSetor = document.createElement("td");
    var criarColunaFrequencia = document.createElement("td");
    checkboxParticipacao = document.createElement("input");
    checkboxParticipacao.type = 'checkbox';
    checkboxParticipacao.setAttribute("class", 'ligaDesligaCheckbox');
    checkboxParticipacao.id = "checkbox" + idColaborador;
    var checkboxParticipacaoLb = document.createElement("label");
    checkboxParticipacaoLb.setAttribute("for", "checkbox" + idColaborador);
    checkboxParticipacaoLb.setAttribute("class", "ligaDesligaBotao");

    criarColunaSetor.setAttribute("class", "thead-light text-center");
    criarColunaFrequencia.setAttribute("class", "thead-light text-center");

    listaAlunos.push(idColaborador)

    criarBody.appendChild(criarLinha);
    criarLinha.appendChild(criarColunaNome);
    criarColunaNome.appendChild(txtNome);
    criarLinha.appendChild(criarColunaSetor);
    criarColunaSetor.appendChild(txtSetor);
    criarLinha.appendChild(criarColunaFrequencia);
    criarColunaFrequencia.appendChild(checkboxParticipacao);
    criarColunaFrequencia.appendChild(checkboxParticipacaoLb);

    tableChamada.appendChild(criarBody);
}


//POST da Sessão Laboral
btnSalvar.addEventListener("click", erroSubmitPost =>{
    erroSubmitPost.preventDefault()
    const dadosPostSessaoLaboral = {
        idFisioterapeuta: idFisio.value, //CAMPO PROVISÓRIO, RETIRAR QUANDO TIVER O ID NO LOGIN DO FISIOTERAPEUTA
        idCliente: idEmpresaSelecionada,
        dataHoraSessaoLaboral: dataHoraAtual
    }
    const optionsPostSessao = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dadosPostSessaoLaboral)
    }
    fetch(urlSessoesLaborais, optionsPostSessao)
    .then(response => response.json()
    .then(data => ({
        data: data,
    }))
    .then(res => {
        if(response.ok){
            gravaParticipacao(res.data.idSessaoLaboral)
            window.alert("Chamada gravada com sucesso!")
            document.location.reload(true) 
        }
    }))
    .catch(erroPostSess => window.alert('Erro ao gravar sessão laboral:' + erroPostSess))
});

//POST da Participação
function gravaParticipacao(idSessaoLaboral){         
    for(let i = 0; i < quantAlunos; i++){ 
        const dadosPostParticipacao = {
            participacaoFrequencia: $("#checkbox"+listaAlunos[i]).is(':checked'),
            dataParticipacao: dataHoraAtual,
            participacaoJustificativa: null,
            idSessaoLaboral: idSessaoLaboral,
            idColaborador: listaAlunos[i],
            idSetorEmpresa: idSetorSelecionado
        }
        const optionsPostParticipacao = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dadosPostParticipacao)
        }
        fetch(urlParticipacoes, optionsPostParticipacao)
        .then(respostaPost => {

        })
        .catch(erroPost => window.alert('Erro no POST:' + erroPost))
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

//Seta a data atual no campo de data da chamada
dataParticipacao.value = hoje


/*
var $th = $('.container').find('thead th')
$('.container').on('scroll', function() {
  $th.css('transform', 'translateY('+ this.scrollTop +'px)');});
*/