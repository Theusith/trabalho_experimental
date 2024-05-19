package Model;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorContas {
    private List<Cliente> clientes;
    private List<Administrador> administradores;
    private static int proximoId = 1;

    public GerenciadorContas() {
        this.clientes = new ArrayList<>();
        this.administradores = new ArrayList<>();
        // Adicionar conta de administrador pré-existente
        adicionarAdministradorPadrao("adm", "adm", "ADM001");
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void adicionarAdministrador(Administrador administrador) {
        administradores.add(administrador);
    }

    public Cliente obterClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null; // Cliente não encontrado
    }

    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public Pessoa autenticarPessoa(String email, String senha) {
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
                return cliente;
            }
        }
        for (Administrador administrador : administradores) {
            if (administrador.getEmail().equals(email) && administrador.getSenha().equals(senha)) {
                return administrador;
            }
        }
        return null; // Pessoa não encontrada ou senha incorreta
    }

    // Método para adicionar um administrador pré-existente
    private void adicionarAdministradorPadrao(String email, String senha, String matricula) {
        Administrador administrador = new Administrador(proximoId++, "Administrador", "", email, senha, matricula);
        administradores.add(administrador);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public int gerarProximoId() {
        return proximoId++;
    }
}
