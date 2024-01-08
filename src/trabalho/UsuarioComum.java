package trabalho;

public class UsuarioComum extends TipoEntrada {
    public UsuarioComum(String nome, String email, String cpf) {
        super(nome, email, cpf);
    }
    
    public String getCpf() {
        return super.getCpf();
    }
}