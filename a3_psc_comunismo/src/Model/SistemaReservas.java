package Model;

import java.util.Scanner;

public class SistemaReservas {

    private GerenciadorContas gerenciadorContas;
    private GerenciadorReservas gerenciadorReservas;
    private Scanner scanner;

    public SistemaReservas() {
        this.gerenciadorContas = new GerenciadorContas();
        this.gerenciadorReservas = new GerenciadorReservas();
        this.scanner = new Scanner(System.in);
    }

    public void executar() {
        boolean sair = false;
        while (!sair) {
            System.out.println("=== Sistema de Reservas ===");
            System.out.println("1. Fazer login");
            System.out.println("2. Criar conta");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    fazerLogin();
                    break;
                case 2:
                    criarConta();
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void fazerLogin() {
        System.out.println("=== Fazer Login ===");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();


        // Verificar se as credenciais correspondem a alguma conta


        Pessoa pessoaLogada = gerenciadorContas.autenticarPessoa(email, senha);
        if (pessoaLogada != null) {
            System.out.println("Login bem-sucedido!");
            if (pessoaLogada instanceof Administrador) {
                exibirMenuAdministrador((Administrador) pessoaLogada);
            } else if (pessoaLogada instanceof Cliente) {
                exibirMenuPrincipal((Cliente) pessoaLogada);
            }
        } else {
            System.out.println("Email ou senha incorretos. Tente novamente.");
        }
    }

    private void criarConta() {
        System.out.println("=== Criar Conta ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        // Criar um novo cliente com os dados fornecidos
        Cliente novoCliente = new Cliente(gerenciadorContas.gerarProximoId(), nome, cpf, email, senha);

        // Adicionar o novo cliente ao gerenciador de contas
        gerenciadorContas.adicionarCliente(novoCliente);

        System.out.println("Conta criada com sucesso!\nO seu ID é: " + novoCliente.getId());
    }

    private void exibirMenuPrincipal(Cliente cliente) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Criar nova reserva");
            System.out.println("2. Visualizar reservas");
            System.out.println("3. Editar reserva");
            System.out.println("4. Excluir reserva");
            System.out.println("5. Excluir conta");
            System.out.println("6. Logout");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    criarNovaReserva(cliente);
                    break;
                case 2:
                    gerenciadorReservas.visualizarReservasCliente(cliente);
                    break;
                case 3:
                    editarReserva(cliente);
                    break;
                case 4:
                    excluirReserva(cliente);
                    break;
                case 5:
                    excluirConta(cliente);
                    sair = true; // Forçar logout após excluir conta
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void excluirConta(Cliente cliente) {
        System.out.println("=== Excluir Conta ===");
        System.out.print("Tem certeza que deseja excluir sua conta? (S/N): ");
        String confirmacao = scanner.nextLine();
        if (confirmacao.equalsIgnoreCase("S")) {
            gerenciadorContas.removerCliente(cliente);
            System.out.println("Conta excluída com sucesso!");
        } else {
            System.out.println("Operação cancelada.");
        }
    }

    private void exibirMenuAdministrador(Administrador administrador) {

        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== Menu Administrador ===");
            System.out.println("1. Alterar dados pessoais de um cliente por ID");
            System.out.println("2. Exibir reservas de um cliente");
            System.out.println("3. Excluir conta de um cliente");
            System.out.println("4. Logout");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    alterarDadosClientePorId();
                    break;
                case 2:
                    int id1 = scanner.nextInt();
                    Cliente cl = gerenciadorContas.obterClientePorId(id1);
                    gerenciadorReservas.visualizarReservasCliente(cl);
                    break;
                case 3:
                    System.out.println("Digite o ID:");
                    int id = scanner.nextInt();
                    gerenciadorContas.removerCliente(id);
                    break;
                case 4:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void alterarDadosClientePorId() {
        System.out.println("=== Alterar Dados de Cliente ===");
        System.out.print("ID do cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        Cliente clienteParaAlterar = gerenciadorContas.obterClientePorId(idCliente);
        if (clienteParaAlterar == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.println("Alterando dados de: " + clienteParaAlterar.getNome());
        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo CPF: ");
        String novoCpf = scanner.nextLine();
        System.out.print("Novo email: ");
        String novoEmail = scanner.nextLine();
        System.out.print("Nova senha: ");
        String novaSenha = scanner.nextLine();

        clienteParaAlterar.setNome(novoNome);
        clienteParaAlterar.setCpf(novoCpf);
        clienteParaAlterar.setEmail(novoEmail);
        clienteParaAlterar.setSenha(novaSenha);

        System.out.println("Dados alterados com sucesso!");
    }

    private void criarNovaReserva(Cliente cliente) {
        System.out.println("=== Criar Nova Reserva ===");
        System.out.print("Origem: ");
        String origem = scanner.nextLine();
        System.out.print("Destino: ");
        String destino = scanner.nextLine();
        System.out.print("Data de Viagem (DD/MM/AAAA): ");
        String dataViagem = scanner.nextLine();

        // Criar uma nova reserva com os detalhes fornecidos
        Reserva novaReserva = new Reserva(cliente, origem, destino, dataViagem);

        // Adicionar a nova reserva ao gerenciador de reservas
        gerenciadorReservas.adicionarReserva(novaReserva);

        System.out.println("Reserva criada com sucesso!");
    }

    private void editarReserva(Cliente cliente) {
        System.out.println("=== Editar Reserva ===");
        System.out.print("ID da Reserva: ");
        int idReserva = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        // Obter a reserva com o ID fornecido a partir do gerenciador de reservas
        Reserva reservaParaEditar = gerenciadorReservas.obterReservaPorId(cliente, idReserva);
        if (reservaParaEditar == null) {
            System.out.println("Reserva não encontrada.");
            return;
        }

        // Solicitar novos detalhes da reserva ao cliente
        System.out.print("Nova Origem: ");
        String novaOrigem = scanner.nextLine();
        System.out.print("Novo Destino: ");
        String novoDestino = scanner.nextLine();
        System.out.print("Nova Data de Viagem (DD/MM/AAAA): ");
        String novaDataViagem = scanner.nextLine();

        // Atualizar os detalhes da reserva
        reservaParaEditar.setOrigem(novaOrigem);
        reservaParaEditar.setDestino(novoDestino);
        reservaParaEditar.setDataViagem(novaDataViagem);

        System.out.println("Reserva atualizada com sucesso!");
    }

    private void excluirReserva(Cliente cliente) {
        System.out.println("=== Excluir Reserva ===");
        System.out.print("ID da Reserva: ");
        int idReserva = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        // Obter a reserva com o ID fornecido a partir do gerenciador de reservas
        Reserva reservaParaExcluir = gerenciadorReservas.obterReservaPorId(cliente, idReserva);
        if (reservaParaExcluir == null) {
            System.out.println("Reserva não encontrada.");
            return;
        }

        // Remover a reserva do gerenciador de reservas
        gerenciadorReservas.removerReserva(reservaParaExcluir);

        System.out.println("Reserva excluída com sucesso!");
    }


}



