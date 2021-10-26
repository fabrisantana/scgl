package br.com.SCGLapi.resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControleAcessoTelas {

	
	@RequestMapping("/Menu")
	public String menu(){
		return "menu";
	}
	
	@RequestMapping("/")
	public String index(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
		return "menu";
	}

	/*
	@GetMapping(value = "/list-servers")
    public ModelAndView listServers(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list-servers");
        modelAndView.addObject("servers", accountService.findAllServersAccount(username));
        return modelAndView;
    }
	*/
	
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
	
	//Usuário inativo
	@RequestMapping(value = "/inativo")
    public String inativo() {
        return "inativo";
    }
	
	//Administração de Colaboradores
	@RequestMapping("/colaboradorCadastro") 
    public String cadastroColaboradores() {
        return "colaboradorCadastro";
	}
	
	@RequestMapping("/colaboradorPesquisa") //Apelido mesmo do href
    public String pesquisaColaborador() {
        return "colaboradorPesquisa";
    }
}
