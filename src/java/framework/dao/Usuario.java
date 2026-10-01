package framework.dao;

import framework.util.Hash;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

// Bean -- Objeto Persistente.
public class Usuario {
    
    private int id;
    private String nome;
    private String senha;
    private int tipoUsuarioId;

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

    public void setSenha(String senha) throws Exception {
        
        if( senha == null ) {
            throw new IllegalArgumentException("senha não pode ser null");
        }
        
        String aux = Integer.toString( getId() ) + senha;
        String hash = Hash.stringToHash( aux, "SHA-256" );
        this.senha = hash;
    }
    
    public void setSenhaHash(String senha) {
        
        if( senha == null ) {
            throw new IllegalArgumentException("senha não pode ser null");
        }
        this.senha = senha;
    }

    public int getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(int tipoUsuarioId) {
        if( tipoUsuarioId < 0 ) {
            throw new IllegalArgumentException("tipoUsuarioId não pode ser < 0");
        }
        this.tipoUsuarioId = tipoUsuarioId;
    }
    
    @Override
    public String toString() {
        return "(" + getId() + ", " + getNome() + ", " + getSenha() + ")";
    }
    
}