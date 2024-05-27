package Controller;

import Model.Cliente;
import Model.Reserva;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorReservas {
    private List<Reserva> reservas;
    private static int proximoId = 1;

    private int gerarProximoId() {
        return proximoId++;
    }


    public GerenciadorReservas() {
        this.reservas = new ArrayList<>();
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
        if(!reservas.isEmpty()) {
            for (Reserva reserva : reservas) {
            if (reserva.getCliente().equals(cliente)) {
                System.out.println(cliente);
                System.out.println(reserva);
            }
        }
        }else{
            System.out.println("Não há reservas para esse cliente.");
        }
    }

}
