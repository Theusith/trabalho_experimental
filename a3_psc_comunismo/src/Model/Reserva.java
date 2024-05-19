package Model;

public class Reserva {
    private static int proximoId = 1;

    private int id;
    private Pessoa pessoa;
    private String origem;
    private String destino;
    private String dataViagem;

    public Reserva(Pessoa pessoa, String origem, String destino, String dataViagem) {
        this.id = proximoId++;
        this.pessoa = pessoa;
        this.origem = origem;
        this.destino = destino;
        this.dataViagem = dataViagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int proximoId) {
        this.id = proximoId;
    }

    public Pessoa getCliente() {
        return pessoa;
    }

    public void setCliente(Pessoa pessoa) {
        this.pessoa = pessoa;
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
        return "\nId = " + id + "\nOrigem: " + origem + "\nDestino: " + destino + "\nData de viagem: " + dataViagem;
    }
}
