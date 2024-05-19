package Model;

public class Administrador extends Cliente{
    private final String matricula;
    public Administrador(String matricula, String id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        this.matricula = matricula;
    }
    public String getMatricula() {
        return matricula;
    }
}
