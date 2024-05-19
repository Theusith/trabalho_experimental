package Model;

public class Administrador extends Pessoa {
    private String matricula;
    public Administrador(int id, String nome, String cpf, String email, String senha, String matricula) {
        super(id, nome, cpf, email, senha);
        this.matricula = matricula;
    }
    public String getMatricula() {
        return matricula;
    }
}
