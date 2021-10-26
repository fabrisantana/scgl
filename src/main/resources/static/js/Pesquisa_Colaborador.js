const urlSetores = 'http://localhost:8080/setoresEmpresa/';
const urlAlunos = 'http://localhost:8080/colaboradores/';
const urlEmpresas = 'http://localhost:8080/clientes/';
const optionsGet = {
    method: 'GET',
    mode: 'no-cors',
    cache: 'default'
}

//Criando o layout da tabela com DataTable JQuery
const getColaboradores = async() => {
  const colaboradores = await fetch(urlAlunos, optionsGet);
  const dataColab = await colaboradores.json();
  const setores = await fetch(urlSetores, optionsGet);
  const dataSetores = await setores.json();
  for(let i = 0; i < dataColab.length; i++){
	for(let x = 0; x < dataSetores.length; x++){
		if(dataColab[i].idSetorEmpresa == dataSetores[x].idSetorEmpresa){
			console.log(dataColab.dataSetores[x].siglaSetorEmpresa)
		}
	}
  }
  //console.log(dataColab.length)
  $('#tableColab').DataTable({
    data: dataColab,
    bLengthChange: true,
    columns: [
      { data: 'colaboradorNome', title: 'Nome' },
      { data: 'colaboradorCpf', title: 'Cpf' },
      { data: 'colaboradorEmail', title: 'E-mail' },
      { data: 'colaboradorStatus', title: 'Status' },
      { data: 'colaboradorStatus', title: 'Setor' },
      { data: 'colaboradorStatus', title: 'Empresa' }
    ],
    "oLanguage": {
		"sProcessing": "Processando...",
	    "sLengthMenu": "Mostrando _MENU_ registros por página",
	    "sZeroRecords": "Nada encontrado",
	    "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
	    "sInfoEmpty": "Nenhum registro disponível",
	    "sInfoFiltered": "(filtrado de _MAX_ registros no total)",
	    "sSearch": "Buscar:",
	    "sUrl": "",
	    "oPaginate": {
			"sFirst": "Primeiro",
			"sPrevious": "Anterior",
			"sNext": "Seguinte",
			"sLast": "Último"
		}
	}
  });
};

//Chamada de função
getColaboradores();
