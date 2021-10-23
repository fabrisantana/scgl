package br.com.SCGLapi.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControleAcessoTelas {

	@RequestMapping("/Menu")
	public String menu(){
		return "menu";
	}
	
	@RequestMapping("/")
	public String index(){
		return "menu";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(){
		return "logout";
	}
	
	//Administração de Usuários
	@RequestMapping("/usuarioCadastro") //Apelido mesmo do href
    public String cadastraUsuario() {
        return "usuarioCadastro";
    }
	
	@RequestMapping("/usuarioPesquisa") //Apelido mesmo do href
    public String pesquisaUsuario() {
        return "usuarioPesquisa";
    }
		
	
	//Administração de Fisioterapeutas
	@RequestMapping("/fisioterapeutaCadastro") //Apelido mesmo do href
    public String cadastroFisioterapeuta() {
        return "fisioterapeutaCadastro";
    }

	
	@RequestMapping("/fisioterapeutaPesquisa") //Apelido mesmo do href
    public String pesquisaFisioterapeuta() {
        return "fisioterapeutaPesquisa";
    }
	
	//Administração de Sessões Laborais
	@RequestMapping("/sessaoRegistraParticipacao") //Apelido mesmo do href
    public String participacaoGinastica() {
        return "sessaoRegistraParticipacao";
    }
	
	//Usu�rio inativo
	@RequestMapping(value = "/inativo")
    public String inativo() {
        return "inativo";
    }
	
	//Administra��o de Fisioterapeutas
	@RequestMapping("/colaboradorCadastro") 
    public String cadastroColaboradores() {
        return "colaboradorCadastro";
	}
}
