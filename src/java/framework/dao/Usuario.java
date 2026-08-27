package framework.dao;

// Bean -- Objeto Persistente.
public class Usuario {
    
    private int id;
    private String nome;
    private String senha;

    public Usuario(int id) {
        setId(id);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        if( id < 0 ) {
            throw new IllegalArgumentException("id não pode ser < 0");
        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if( senha == null ) {
            throw new IllegalArgumentException("senha não pode ser null");
        }
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "(" + getId() + ", " + getNome() + ", " + getSenha() + ")";
    }
    
}