
package livro;

import java.util.ArrayList;

public class Autor {
    private String nome,sobrenome;

    public Autor() {
    }

    public Autor(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    public String getNomeCompleto() {
        String nomeCompleto;
                
        nomeCompleto = nome + " " + sobrenome;
        return nomeCompleto;
    }
    
    public String getCitacaoBibliografica() {
        nome = nome.substring(0);
        sobrenome = sobrenome.toUpperCase();
        return sobrenome + " " + nome;
    }
    
    @Override
    public String toString() {
        return " Autor " + "\n Nome: " + nome + "\n Sobrenome: " + sobrenome;
    }
    
}
