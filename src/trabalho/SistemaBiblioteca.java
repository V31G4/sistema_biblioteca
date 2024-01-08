package trabalho;
import javax.swing.JOptionPane;

public class SistemaBiblioteca {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        boolean sair = false;

        while (!sair) {
            String modo = JOptionPane.showInputDialog("Selecione o modo:\n1. Administração\n2. Usuário\n0. Sair do sistema");

            if (modo.equals("1")) {
                while (true) {
                    String opcao = JOptionPane.showInputDialog("Selecione a opção:\n1. Cadastro de usuários\n2. Consulta de usuários\n3. Cadastro de livros\n4. Reserva de livros\n5. Consulta de livros\n6. Consulta de reservas\n7. Cancelamento de reservas\n0. Voltar para seleção de modo");

                    if (opcao.equals("1")) {
                        String nomeUsuario = JOptionPane.showInputDialog("Digite o nome do usuário:");
                        String emailUsuario = JOptionPane.showInputDialog("Digite o email do usuário:");
                        String cpfUsuario = JOptionPane.showInputDialog("Digite o CPF do usuário:");
                        biblioteca.cadastrarUsuario(nomeUsuario, emailUsuario, cpfUsuario, true);
                    } else if (opcao.equals("2")) {
                        biblioteca.consultarUsuarios();
                    } else if (opcao.equals("3")) {
                        String tituloLivro = JOptionPane.showInputDialog("Digite o título do livro:");
                        String autorLivro = JOptionPane.showInputDialog("Digite o autor do livro:");
                        biblioteca.cadastrarLivro(tituloLivro, autorLivro);
                    } else if (opcao.equals("4")) {
                    	String cpfUsuario = JOptionPane.showInputDialog("Digite o CPF do usuário para reserva:");
                    	int numeroLivro = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do livro para reserva:"));
                    	biblioteca.reservarLivro(numeroLivro, cpfUsuario);
                    } else if (opcao.equals("5")) {
                        biblioteca.consultarLivros();
                    } else if (opcao.equals("6")) {
                        biblioteca.consultarReservas();
                    } else if (opcao.equals("7")) {
                        int numeroLivro = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do livro para cancelar a reserva:"));
                        biblioteca.cancelarReserva(numeroLivro);
                    } else if (opcao.equals("0")) {
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                    }
                }
            } else if (modo.equals("2")) {
                while (true) {
                    String opcao = JOptionPane.showInputDialog("Selecione a opção:\n1. Consulta de livros\n2. Consulta de reservas\n3. Devolução de livros\n4. Cancelamento de reservas\n0. Voltar para seleção de modo");

                    if (opcao.equals("1")) {
                        biblioteca.consultarLivros();
                    } else if (opcao.equals("2")) {
                        biblioteca.consultarReservas();
                    } else if (opcao.equals("3")) {
                        int numeroLivro = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do livro para devolução:"));
                        biblioteca.devolverLivro(numeroLivro);
                    } else if (opcao.equals("4")) {
                        int numeroLivro = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do livro para cancelar a reserva:"));
                        biblioteca.cancelarReserva(numeroLivro);
                    } else if (opcao.equals("0")) {
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                    }
                }
            } else if (modo.equals("0")) {
                sair = true;
                JOptionPane.showMessageDialog(null, "Sistema encerrado.");
            } else {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}