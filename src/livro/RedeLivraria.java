package livro;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RedeLivraria {

    public static void main(String[] args) {
        ArrayList<Livro> livros = new ArrayList();
        final int SAIR = 6;
        int opcao = leiaMenu();

        while (opcao != SAIR) {
            switch (opcao) {
                case 1:
                    criarBibliografia(livros);
                    break;
                case 2:
                    procurarLivro(livros);
                    break;
                case 3:
                    consultaTudo(livros);
                    break;
                case 4:
                    removerLivro(livros);
                case 5:
                    editaAutorLivro(livros);
            }
            opcao = leiaMenu();
        }
    }

    public static int leiaMenu() {
        int opcao;
        String menu = "{ ********* Menu********}";

        menu += "\n[1] - Incluir Livro";
        menu += "\n[2] - Buscar Livro";
        menu += "\n[3] - Consulta Livraria";
        menu += "\n[4] - Remover Livro";
        menu += "\n[5] - Editar Autor";
        menu += "\n[6] - Sair";

        opcao = verificaMenuEntrada(menu);
        return opcao;
    }

    public static int verificaMenuEntrada(String menu) {
        int opcao = 0;
        boolean ok = false;

        do {
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
                if ((opcao < 1) || (opcao > 6)) {
                    JOptionPane.showMessageDialog(null, "Erro: opcao invalida");
                } else {
                    ok = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor digite apenas numero !");
            }
        } while (!ok);
        return opcao;
    }

    public static String criarBibliografia(ArrayList<Livro> livros) {
        String titulo, editora;
        int ano;

        titulo = leTitulo(" Entre com o titulo ");
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                JOptionPane.showMessageDialog(null, "Titulo ja existe");
                return titulo;
            }
        }
        editora = leEditora(" Entre com a editora");
        ano = verificaAno(" Entre com o ano");
        Livro criarLivro = new Livro(titulo, editora, ano);
        adicionarAutores(criarLivro);
        livros.add(criarLivro);
        return null;
    }

    public static Livro adicionarAutores(Livro livro) {
        int opcao;

        do {
            String nome = leNome("Entre com o nome do autor");
            String sobrenome = leSobrenome("Entre com o sobrenome");
            livro.inserirAutor(nome, sobrenome);
            JOptionPane.showMessageDialog(null, "Autor adicionado com sucesso");
            opcao = verificaEntrada("Deseja incluir mais autor \n 1 Sim \n 2 Nao");
        } while (opcao == 1);
        return livro;
    }

    public static int verificaEntrada(String mensagem) {
        int opcao = 0;
        boolean ok = false;

        do {
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja incluir mais autor \n 1 Sim \n 2 Nao"));
                if ((opcao < 1) || (opcao > 2)) {
                    JOptionPane.showMessageDialog(null, "Erro: Entrar com numero corretamente!");
                } else {
                    ok = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor digite apenas numero !");
            }
        } while (!ok);
        return opcao;
    }

    public static Livro inserirAutores(ArrayList<Livro> livros) {
        String titulo = leTitulo(" Entre com o titulo ");

        for (Livro livro : livros) {
            if ((livro.getTitulo().equalsIgnoreCase(titulo))) {
                String nome = leNome("Entre com o nome do autor");
                String sobrenome = leSobrenome("Entre com o sobrenome");
                livro.inserirAutor(nome, sobrenome);
                JOptionPane.showMessageDialog(null, "Autor adicionado com sucesso");
                JOptionPane.showMessageDialog(null, livro.leAutor());
                return livro;
            }
        }
        JOptionPane.showMessageDialog(null, "Titulo nao existe");
        return null;
    }

    public static Livro procurarLivro(ArrayList<Livro> livros) {
        String titulo = JOptionPane.showInputDialog(" Entre com o titulo");

        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                String leLivro = leLivro(livros);
                JOptionPane.showMessageDialog(null, "\n" + leLivro + "\n" + livro.leAutor());
                return livro;
            }
        }
        JOptionPane.showMessageDialog(null, "Titulo nao existe");
        return null;
    }

    public static Livro removerLivro(ArrayList<Livro> livros) {
        String titulo = JOptionPane.showInputDialog(" Entre com o titulo");

        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livros.remove(livro);
                JOptionPane.showMessageDialog(null, "Livro removido com sucesso");
                return livro;
            }
        }
        JOptionPane.showMessageDialog(null, "Livro nao encontrado");
        return null;
    }

    public static Autor removerAutor(ArrayList<Livro> livros) {
        String nome = leNome("Entre com o nome do autor");
        String sobrenome = leSobrenome("Entre com o sobrenome");

        for (Livro livro : livros) {
            for (Autor autor : livro.getAutores()) {
                if (autor.getNomeCompleto().equalsIgnoreCase(nome + " " + sobrenome)) {
                    livro.getAutores().remove(autor);
                    JOptionPane.showMessageDialog(null, "Autor removido com sucesso");
                    return null;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Autor nao encontrado");
        return null;
    }

    public static void consultaTudo(ArrayList<Livro> livros) {
        JOptionPane.showMessageDialog(null, livros.toString());
    }

    public static String leLivro(ArrayList<Livro> livros) {
        String leLivro = "";

        for (Livro livro : livros) {
            leLivro += livro + " \n";
            break;
        }
        return leLivro;
    }

    public static void editaAutorLivro(ArrayList<Livro> livros) {
        final int SAIR = 3;
        int opcao = menuIncluirMaisAutor();

        while (opcao != SAIR) {
            switch (opcao) {
                case 1:
                    inserirAutores(livros);
                    break;
                case 2:
                    removerAutor(livros);
                    break;
            }
            opcao = menuIncluirMaisAutor();
        }
    }

    public static int menuIncluirMaisAutor() {
        int opcao;
        String menu = "{ ********* Menu********}";

        menu += "\n[1] - Incluir mais autores";
        menu += "\n[2] - Remover autor";
        menu += "\n[3] - Sair";

        opcao = verificaMenuAutor(menu);
        return opcao;
    }

    public static int verificaMenuAutor(String menu) {
        int opcao = 0;
        boolean ok = false;

        do {
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
                if ((opcao < 1) || (opcao > 3)) {
                    JOptionPane.showMessageDialog(null, "Erro: opcao invalida");
                } else {
                    ok = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor digite apenas numero !");
            }
        } while (!ok);
        return opcao;
    }

    public static String leNome(String mensagem) {
        String nome;

        do {
            nome = JOptionPane.showInputDialog("Entre com o nome :");
            if (nome.length() == 0) {
                JOptionPane.showMessageDialog(null, "Erro: nome invalido");
            }
        } while (nome.length() == 0);
        return nome;
    }

    public static String leSobrenome(String mensagem) {
        String sobrenome;

        do {
            sobrenome = JOptionPane.showInputDialog("Entre com o sobrenome :");
            if (sobrenome.length() == 0) {
                JOptionPane.showMessageDialog(null, "Erro: sobrenome invalido");
            }
        } while (sobrenome.length() == 0);
        return sobrenome;
    }

    public static String leEditora(String mensagem) {
        String editora;

        do {
            editora = JOptionPane.showInputDialog("Entre com a editora :");
            if (editora.length() == 0) {
                JOptionPane.showMessageDialog(null, "Erro: editora invalido");
            }
        } while (editora.length() == 0);
        return editora;
    }

    public static String leTitulo(String mensagem) {
        String titulo;

        do {
            titulo = JOptionPane.showInputDialog("Entre com o titulo :");
            if (titulo.length() == 0) {
                JOptionPane.showMessageDialog(null, "Erro: titulo invalido");
            }
        } while (titulo.length() == 0);
        return titulo;
    }

    public static int verificaAno(String mensagem) {
        int ano = 0;
        boolean ok = false;

        do {
            try {
                ano = Integer.parseInt(JOptionPane.showInputDialog(" Entre com o ano"));
                if (ano < 0) {
                    JOptionPane.showMessageDialog(null, "Erro: Entrar com ano corretamente!");
                } else {
                    ok = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor digite apenas numero !");
            }
        } while (!ok);
        return ano;
    }
}
