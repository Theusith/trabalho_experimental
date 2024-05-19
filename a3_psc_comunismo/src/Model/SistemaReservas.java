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
        Cliente clienteLogado = gerenciadorContas.autenticarCliente(email, senha);
        if (clienteLogado != null) {
            System.out.println("Login bem-sucedido!");
            exibirMenuPrincipal(clienteLogado);
        } else {
            System.out.println("Email ou senha incorretos. Tente novamente.");
        }
    }

    private void criarConta() {
        // Implementar lógica de criação de conta
        System.out.println("=== Criar Conta ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        //Gerar numero de Identifidação = Id
        String id = "1";
        int temp = Integer.parseInt(id);
        temp++;
        id = String.valueOf(temp);


        // Criar um novo cliente com os dados fornecidos
        Cliente novoCliente = new Cliente(id,nome, cpf, email, senha);

        // Adicionar o novo cliente ao gerenciador de contas
        gerenciadorContas.adicionarCliente(novoCliente);

        System.out.println("Conta criada com sucesso!");
    }
    private void exibirMenuPrincipal(Cliente cliente) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Criar nova reserva");
            System.out.println("2. Visualizar reservas");
            System.out.println("3. Editar reserva");
            System.out.println("4. Excluir reserva");
            System.out.println("5. Logout");
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
                    editarReserva(cliente, gerenciadorReservas);
                    break;
                case 4:
                    excluirReserva(cliente);
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void criarNovaReserva(Cliente cliente) {
        System.out.println("=== Criar Nova Model.Reserva ===");
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

        System.out.println("Model.Reserva criada com sucesso!");
    }

    private void editarReserva(Cliente cliente, GerenciadorReservas gerenciadorReservas) {
        System.out.println("=== Editar Model.Reserva ===");
        System.out.print("ID da Model.Reserva: ");
        int idReserva = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        // Obter a reserva com o ID fornecido
        Reserva reservaParaEditar = gerenciadorReservas.obterReservaPorId(cliente, idReserva);
        if (reservaParaEditar == null) {
            System.out.println("Model.Reserva não encontrada.");
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

        System.out.println("Model.Reserva editada com sucesso!");
    }


    private void excluirReserva(Cliente cliente) {
        System.out.println("=== Excluir Model.Reserva ===");
        System.out.print("ID da Model.Reserva: ");
        int idReserva = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        // Obter a reserva com o ID fornecido
        Reserva reservaParaExcluir = gerenciadorReservas.obterReservaPorId(cliente, idReserva);
        if (reservaParaExcluir == null) {
            System.out.println("Model.Reserva não encontrada.");
            return;
        }

        System.out.println("Model.Reserva excluída com sucesso!");
    }

}


