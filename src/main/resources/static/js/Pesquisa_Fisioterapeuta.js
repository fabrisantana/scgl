const urlFisio = 'http://localhost:8080/fisioterapeutas/'
const optionsGet = {
    method: 'GET',
    mode: 'no-cors',
    cache: 'default'
}

var usuarioLogado = document.getElementById('usuarioLogado')
usuarioLogado.innerText = localStorage.getItem("loginUsuario")


//Criando o layout da tabela com DataTable JQuery
const getFisioterapeutas = async() => {
  const response = await fetch(urlFisio, optionsGet);
  const data = await response.json();
  //$('#loadingLabel').hide();
  $('#tableFisio').DataTable({
    data: data,
    bLengthChange: true,
    columns: [
      { data: 'fisioterapeutaNome', title: 'Nome' },
      { data: 'fisioterapeutaCpf', title: 'Cpf' },
      { data: 'fisioterapeutaEmail', title: 'E-mail' },
      { data: 'fisioterapeutaStatus', title: 'Status' }
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
getFisioterapeutas();
