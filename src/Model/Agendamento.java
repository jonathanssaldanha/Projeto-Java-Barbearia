/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonat
 */
public class Agendamento {
    
    private int id; // id = 36
    private Cliente cliente;    // que dentro desta variavel eu vor guardar um objeto do tipo cliente
    private Servico servico;
    private float valor;
    private Date data;
    private String observacao;

    public Agendamento(int id, Cliente cliente, Servico servico, float valor, String data) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.valor = valor;
        try {
            this.data = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
                    } catch (ParseException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Agendamento(int id, Cliente cliente, Servico servico, float valor, String data, String observacao) {
        this(id,cliente,servico,valor,data);
        this.observacao = observacao;
    }
       

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    //FORMATAÇAO DA DATA 
    public String getDataFormatada(){
        return new SimpleDateFormat("dd/MM/yyy").format(data);    
    }
    
    // FORMATAÇAO DA HORA
    public String getHoraFormatada(){
        return new SimpleDateFormat("HH:mm").format(data);
    }
    
    
    public void setData(Date data) {
        this.data = data;
    }
    
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
       
    
}
