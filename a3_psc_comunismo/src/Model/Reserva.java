package Model;

public class Reserva {
    private static int proximoId = 1;

    private int idReserva;
    private Cliente cliente;
    private String origem;
    private String destino;
    private String dataViagem;

    public Reserva(Cliente cliente, String origem, String destino, String dataViagem) {
        this.idReserva = proximoId++;
        this.cliente = cliente;
        this.origem = origem;
        this.destino = destino;
        this.dataViagem = dataViagem;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setId(int proximoId) {
        this.idReserva = proximoId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDataViagem() {
        return dataViagem;
    }

    public void setDataViagem(String dataViagem) {
        this.dataViagem = dataViagem;
    }

    @Override
    public String toString() {
        return "\nId = " + idReserva + "\nOrigem: " + origem + "\nDestino: " + destino + "\nData de viagem: " + dataViagem;
    }
}
