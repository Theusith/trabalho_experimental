package Model;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorContas {
    private List<Cliente> clientes;


    public GerenciadorContas() {
        this.clientes = new ArrayList<>();
        String matricula = "1";
        int temp = Integer.parseInt(matricula);
        temp++;
        matricula = String.valueOf(temp);
        adicionarAdministradorPadrao(matricula,"1","adm", "adm");

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

    private void adicionarAdministradorPadrao(String matricula,String id,String email, String senha) {
        Cliente administrador = new Administrador(matricula, id, "Administrador", "", email, senha);
        clientes.add(administrador);
    }
}
