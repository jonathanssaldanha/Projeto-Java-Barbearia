/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;

/**
 *
 * @author jonat
 */
public class AgendaController {
    
    private final Agenda view;
    private final AgendaHelper helper;
   

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
 
    public void atualizaTabela(){
        
        // buscar na lista com agendamentos do banco de dados
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        // com o Array eu busquei os agendamentos no meu banco de dados
        
        //eu quero mostrar os agendamentos que o barbeiro tem
        //exibir essa lista na View
        helper.preencherTabela(agendamentos);
    }

    
    public void atualizaCliente(){
        //BUSCAR CLIENTES DO BANCO DE DADOS
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        // EXIBIR CLIENTES NO COMBOBOX CLIENTE
        helper.preecherClientes(clientes);
    }
    
    public void atualizaServico(){
        // BUSCAR SERVICOS DO BANCO DE DADOS
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        // EXIBIR SERVICOS NO COMBOBOX SERVICO
        helper.preencherServico(servicos);
    }
    
    public void atualizaValor(){
        // BUSCA VALOR DO BANCO DE DADOS
        Servico servico = helper.obterServico();
        //EXIBIR VALOR NO CAMPO VALOR
        helper.setarValor(servico.getValor());
    }
    
    public void agendar(){
        // buscar objeto agendamento da tela
        Agendamento agendamento = helper.obterModelo();
        
        
        // salvar objeto no banco de dados
        new AgendamentoDAO().insert(agendamento);
        
        // inserir elemento na tabela
        atualizaTabela();
        helper.limparTela();
        
    }
    
    
       
    
}
