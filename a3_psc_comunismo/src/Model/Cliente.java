package Model;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa{
    private List<Reserva> reservas;
    public Cliente(int iD, String nome, String cpf, String email, String senha){
        super(iD, nome, cpf, email, senha);
        this.reservas = new ArrayList<>();
    }

    public void getReservas(){
        for(Reserva r : reservas){
            System.out.println(r);
        }
    }
    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void removerReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

}
