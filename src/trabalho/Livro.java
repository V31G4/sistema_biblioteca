package trabalho;
import java.util.Date;

public class Livro {
    private String titulo;
    private String autor;
    private boolean disponivel;
    private Date dataReserva;
    private String usuarioReserva;
    private static int contadorLivros = 1;
    private int numero; 

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
        this.dataReserva = null;
        this.usuarioReserva = null;
        this.numero = contadorLivros++;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public String getUsuarioReserva() {
        return usuarioReserva;
    }

    public void setUsuarioReserva(String cpfUsuario) {
        this.usuarioReserva = cpfUsuario;
    }
}