/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Agendamento;
import Model.Cliente;
import Model.Pessoa;
import Model.Servico;
import Model.Usuario;

/**
 *
 * @author jonat
 */
public class Main {
    
    
    public static void main(String[] args){
    
        String nome = "Tiago";
        System.out.println(nome);
        
        Servico servico = new Servico(001, "Barba", 30);
        // como esse objeto do tipo Serviço e a variavel barba
        System.out.println(servico.getDescricao());
        //System.out.println(servico.getValor());
        
        Cliente cliente = new Cliente(1, "Jonathan", "Rua teste", "99999999" );
        System.out.println(cliente.getNome());
        
        Usuario usuario = new Usuario(1, "Barbeiro", "senha");
        System.out.println(usuario.getNome());
        
        Agendamento agendamento = new Agendamento(1, cliente, servico, 30, "10/03/2019 17:48");
        System.out.println(agendamento.getCliente().getNome());
        
        
        
    }
    
}
