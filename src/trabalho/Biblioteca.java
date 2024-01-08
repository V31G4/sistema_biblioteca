package trabalho;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Biblioteca {
    private ArrayList<UsuarioComum> usuarios;
    private ArrayList<Livro> livros;
    private ArrayList<Livro> reservas;
    private int numeroLivro;
    
    public Biblioteca() {
        usuarios = new ArrayList<>();
        livros = new ArrayList<>();
        reservas = new ArrayList<>();
        numeroLivro = 1;
        
        Livro livro1 = new Livro("Aprendendo Java", "John Smith");
        livros.add(livro1);
        
        Livro livro2 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien");
        livros.add(livro2);
        
        Livro livro3 = new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling");
        livros.add(livro3);
    }
    
    public void cadastrarUsuario(String nome, String email, String cpf, boolean isAdmin) {
        UsuarioComum usuario = new UsuarioComum(nome, email, cpf);
        usuarios.add(usuario);
        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
    }
    
    public void consultarUsuarios() {
        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado.");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Usuários cadastrados:\n");
            for (UsuarioComum usuario : usuarios) {
                sb.append("Nome: ").append(usuario.getNome()).append("\n");
                sb.append("Email: ").append(usuario.getEmail()).append("\n");
                sb.append("CPF: ").append(usuario.getCpf()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
    
    public void cadastrarLivro(String titulo, String autor) {
        Livro livro = new Livro(titulo, autor);
        livros.add(livro);
        JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
    }
    
    public void consultarLivros() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        for (Livro livro : livros) {
            sb.append("Número: ").append(livro.getNumero()).append("\n");
            sb.append("Título: ").append(livro.getTitulo()).append("\n");
            sb.append("Autor: ").append(livro.getAutor()).append("\n");
            sb.append("Disponível: ").append(livro.isDisponivel() ? "Sim" : "Não").append("\n");

            if (!livro.isDisponivel()) {
                Date dataReserva = livro.getDataReserva();
                sb.append("Data da reserva: ").append(dateFormat.format(dataReserva)).append("\n");
            }

            sb.append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Livros Disponíveis", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void consultarReservas() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        if (reservas.isEmpty()) {
            sb.append("Não há reservas no sistema.");
        } else {
            for (Livro reserva : reservas) {
                sb.append("Número do livro: ").append(reserva.getNumero()).append(", ");
                sb.append("Título: ").append(reserva.getTitulo()).append(", ");
                sb.append("Autor: ").append(reserva.getAutor());

                Date dataReserva = reserva.getDataReserva();
                if (dataReserva != null) {
                    sb.append(", Data da reserva: ").append(dateFormat.format(dataReserva));
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(dataReserva);
                    calendar.add(Calendar.DAY_OF_MONTH, 7);
                    Date dataEntrega = calendar.getTime();
                    sb.append(", Data de entrega: ").append(dateFormat.format(dataEntrega));
                }

                sb.append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public void reservarLivro(int numeroLivro, String cpfUsuario) {
        Livro livro = buscarLivro(numeroLivro);

        if (livro != null && livro.isDisponivel()) {
            UsuarioComum usuarioEncontrado = buscarUsuario(cpfUsuario);

            if (usuarioEncontrado != null) {
                livro.setDisponivel(false);
                livro.setDataReserva(new Date());
                livro.setUsuarioReserva(usuarioEncontrado.getCpf());
                reservas.add(livro);

                JOptionPane.showMessageDialog(null, "Livro reservado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Livro indisponível para reserva!");
        }
    }
    
    public void devolverLivro(int numeroLivro) {
        Livro livro = buscarLivro(numeroLivro);
        if (livro != null && !livro.isDisponivel()) {
            livro.setDisponivel(true);
            reservas.remove(livro);
            JOptionPane.showMessageDialog(null, "Livro devolvido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Livro não está em reserva!");
        }
    }

    public void cancelarReserva(int numeroLivro) {
        Livro livroCancelamento = buscarLivro(numeroLivro);
        
        if (livroCancelamento == null) {
            JOptionPane.showMessageDialog(null, "Livro não encontrado!");
        } else if (!livroCancelamento.isDisponivel() && reservas.contains(livroCancelamento)) {
            livroCancelamento.setDisponivel(true);
            reservas.remove(livroCancelamento);
            JOptionPane.showMessageDialog(null, "Reserva cancelada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Este livro não estava reservado!");
        }
    }

    public Livro buscarLivro(int numeroLivro) {
        for (Livro livro : livros) {
            if (livro.getNumero() == numeroLivro) {
                return livro;
            }
        }
        return null;
    }
    
    public UsuarioComum buscarUsuario(String cpfUsuario) {
        for (UsuarioComum usuario : usuarios) {
            if (usuario.getCpf().equals(cpfUsuario)) {
                return usuario;
            }
        }
        return null;
    }
}