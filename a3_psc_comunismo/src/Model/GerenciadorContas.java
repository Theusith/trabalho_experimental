package Model;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorContas {
    private List<Cliente> clientes;


    public GerenciadorContas() {
        this.clientes = new ArrayList<>();
        adicionarAdministradorPadrao("adm", "adm");

    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente autenticarCliente(String email, String senha) {
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
                return cliente;
            }
        }
        return null; // Model.Cliente não encontrado ou senha incorreta
    }

    // Método para adicionar um administrador pré-existente

    private void adicionarAdministradorPadrao(String email, String senha) {
        Cliente administrador = new Cliente("Administrador", "", email, senha);
        clientes.add(administrador);
    }
}
