package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorReservas {
    private GerenciadorContas gerenciadorContas;
    private List<Reserva> reservas;
    private static int proximoId = 1;

    private int gerarProximoId() {
        return proximoId++;
    }


    public GerenciadorReservas() {
        this.reservas = new ArrayList<>();
    }

    public void adicionarReserva(Reserva reserva) {
        reserva.setId(gerarProximoId());
        reservas.add(reserva);
    }

    public void removerReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public Reserva obterReservaPorId(Cliente cliente, int id) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == id && reserva.getCliente().equals(cliente)) {
                return reserva;
            }
        }
        return null; // Reserva não encontrada
    }

    public void visualizarReservasCliente(Cliente cliente) {
        //System.out.println("=== Suas Reservas ===");
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().equals(cliente)) {
                System.out.println(reserva);
            }else{
                System.out.println("Não há reservas para esse cliente.");
            }
        }
    }
}
