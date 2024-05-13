package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorReservas {
    private List<Reserva> reservas;
    public Scanner scanner = new Scanner(System.in);

    public GerenciadorReservas() {
        this.reservas = new ArrayList<>();
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> obterReservasCliente(Cliente cliente) {
        List<Reserva> reservasCliente = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().equals(cliente)) {
                reservasCliente.add(reserva);
            }
        }
        return reservasCliente;
    }

    public void visualizarReservasCliente(Cliente cliente) {
        List<Reserva> reservasCliente = obterReservasCliente(cliente);
        if (reservasCliente.isEmpty()) {
            System.out.println("Você não possui reservas.");
        } else {
            System.out.println("Suas reservas:");
            for (Reserva reserva : reservasCliente) {
                System.out.println(reserva);
            }
        }
    }

    private void editarReserva(Cliente cliente) {
        System.out.println("=== Editar Model.Reserva ===");
        System.out.print("ID da Model.Reserva: ");
        int idReserva = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        // Obter a reserva com o ID fornecido
        Reserva reservaParaEditar = obterReservaPorId(cliente, idReserva);
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
    public Reserva obterReservaPorId(Cliente cliente, int idReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getIdReserva() == idReserva && reserva.getCliente().equals(cliente)) {
                return reserva;
            }
        }
        return null; // Model.Reserva não encontrada
    }

}
