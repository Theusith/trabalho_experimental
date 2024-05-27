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
        if(!reservas.isEmpty()){
            for(Reserva r : reservas){
                System.out.println(r);
            }
        }else{
            System.out.println("Nenhum reserva encontrado");
        }

    }
    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void removerReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

}
