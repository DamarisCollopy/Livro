
package livro;

import java.util.ArrayList;

public class  Livro {
    private String titulo,editora;
    private int ano;
    ArrayList<Autor> autores;

    public Livro() {
        autores = new ArrayList<>();
    }

    public Livro(String titulo, String editora, int ano) {
        this.titulo = titulo;
        this.editora = editora;
        this.ano = ano;
        autores = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public String leAutor() {
        
        String leAutores = "";
        
        for (Autor autor : autores) {
            leAutores += autor.getCitacaoBibliografica() + "\n";
        }
        
        return leAutores;
    }
    
    public void inserirAutor(String nome, String sobrenome){
        Autor autor = new Autor(nome, sobrenome);
        autores.add(autor);
    }
    
    public String retornarNomeCompleto() {
        
        String nomeCompleto = "";
        for (Autor autor : autores){
            nomeCompleto += autor.getNomeCompleto();
            break;
        }
        return nomeCompleto; 
    }
    
    public String imprimirFichaCatalografica() {
        
        String nomeCompleto = "";
        for (Autor autor : autores){
            nomeCompleto += autor.getCitacaoBibliografica();
            break;
        }
        return nomeCompleto;
    }
    
    public String autorTodo() {
        
        String autor = "";
        autor.toString();
        return autor;
    }
    
    @Override
    public String toString() {
        return " \n Rede Bibliografica " + " \n Titulo: " + titulo + "\n Editora: " + editora + "\n Ano: " + ano;
    }
}