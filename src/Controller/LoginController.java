/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;
/**
 *
 * @author jonat
 */
public class LoginController {
    
    private final Login view;
    private LoginHelper helper;
    
    public LoginController(Login view){
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    // aqui vai ficar todas as regras de negocio
    
    
    
    public void entrarNoSitema(){
    
    // processo para pegar a informaçao do campo texto usuario no painel de login
    //helper.obterModelo();
    Usuario usuario = helper.obterModelo();
           
    
    // pesquisar usuario no banco
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
    
    // se o usuario da view tiver mesmo usuario e senha que o usuario vindo do banco, direcionar para menu
    if(usuarioAutenticado != null){     // verificar se o usuario e senha estao corretos
        //navegar para o menu principal
        MenuPrincipal menu = new MenuPrincipal();       // criar o objeto menu para ser tratado
        menu.setVisible(true);      // tornar visivel a janela de menu
        this.view.dispose();        // fechar a janela de login
    }else{
        view.exibeMensagem("Usuario ou senha invalido");
    }
    
    // se nao for igual vou mostrar uma mensagem ao usuario "Usuario ou senha Invalidos"
    
    
    
    
    }
    
    
    // exibir mensagem
    public void fizTarefa(){
        System.out.println("Busquei algo do banco de dados");
        this.view.exibeMensagem("Executei o fiz tarefa");
    }
    
    
    
    
    
}
