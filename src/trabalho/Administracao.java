package trabalho;

public class Administracao extends TipoEntrada {
    private String matricula;

    public Administracao(String nome, String email, String matricula) {
        super(nome, email, matricula);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
}
