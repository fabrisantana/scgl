const urlUsuariosRole = 'http://localhost:8080/usuariosRole/'
const optionsGet = {
    method: 'GET',
    mode: 'no-cors',
    cache: 'default'
}

//Criando o layout da tabela com DataTable JQuery
const getUsuarios = async() => {
  const response = await fetch(urlUsuariosRole, optionsGet);
  const dataUsuarios = await response.json();
  console.log(dataUsuarios);
  $('#tableUsuario').DataTable({
    data: dataUsuarios,
    bLengthChange: true,
    columns: [     
      { data: 'nomeUsuario', title: 'Nome' },
      { data: 'loginUsuario', title: 'Login' },
      { data: 'emailUsuario', title: 'E-mail' },
      { data: 'statusUsuario', title: 'Status' },
      { data: 'tipoRole', title: 'Perfil' }
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
getUsuarios();

