/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jonat
 */
public class AgendaHelper implements IHelper{
    
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    
    // funaçao preenche tabela
    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
        // primeiro tenho que ter acesso a tabela
        // o codigo busca o modelo default tableModel
        DefaultTableModel tableModel =  (DefaultTableModel) view.getjTableAgendamentos().getModel();
        tableModel.setNumRows(0);
        
        //percorrer a lista preenchendo o table model
        
        for(Agendamento agendamento : agendamentos){
            
            tableModel.addRow(new Object[]{
            
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),
                agendamento.getObservacao()
                    
            });
        }
    }

    public void preecherClientes(ArrayList<Cliente> clientes) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxCliente().getModel();
        for(Cliente cliente : clientes){
            comboBoxModel.addElement(cliente);      // aqui esta o truque | AQUI EU PEGO UMA STRING DE REFERENCIA DO OBJETO CLIENTE
        }
    }

    public void preencherServico(ArrayList<Servico> servicos) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxServico().getModel();
        for (Servico servico : servicos){
            comboBoxModel.addElement(servico);
        }
    }

    public Cliente obterCliente(){
        return (Cliente) view.getjComboBoxCliente().getSelectedItem(); // para pegar a informaçoes que o usuario selecionou no campo box cliente
    }
    
    public Servico obterServico() {
        return (Servico) view.getjComboBoxServico().getSelectedItem(); // para pegar a informaçao que o usuario selecionou no campo box servico
        
    }
    
    public void setarValor(float valor){
        view.getjTextValor().setText(valor+" "); //devido a um erro de passagem de float como string
    
    }

    @Override
    public Agendamento obterModelo() {
        
        //new Agendamento();
        String idString = view.getjTextId().getText();           // peguei o valor do Id e coloquei dentro do objeto dString
        int id = Integer.parseInt(idString);                    // converti o objeto string em um objeto inteito
        Cliente cliente = obterCliente();
        Servico servico = obterServico();
        String valorString = view.getjTextValor().getText();
        float valor = Float.parseFloat(valorString);
        String data = view.getjTextData1().getText();
        String hora = view.getjTextHora().getText();
        String dataHora = data + " " + hora;
        String observacao = view.getjTextAreaObservacao().getText();
        
        // aqui eu salvo tudo que o usuario digito no formulario
        Agendamento agendamento = new Agendamento(id, cliente, servico, valor, dataHora, observacao);
        return agendamento;
    }

    @Override
    public void limparTela() {
        view.getjTextId().setText("0");
        view.getjTextData1().setText("");
        view.getjTextHora().setText("");
        view.getjTextAreaObservacao().setText("");
    }
    
    
    
    
    
}
