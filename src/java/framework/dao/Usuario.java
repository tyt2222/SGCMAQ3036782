package framework.dao;

import framework.util.Hash;

// Bean -- Objeto Persistente.
public class Usuario {

    private int id;
    private String nome;
    private String senha;
    private int tipoUsuarioId;
    private String nascimento;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String uf;
    private String cep;

    public Usuario(int id) {
        setId(id);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        if (id < 0) {
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

        if (senha == null) {
            throw new IllegalArgumentException("senha não pode ser null");
        }

        String aux = Integer.toString(getId()) + senha;
        String hash = Hash.stringToHash(aux, "SHA-256");
        this.senha = hash;
    }

    public void setSenhaHash(String senha) {

        if (senha == null) {
            throw new IllegalArgumentException("senha não pode ser null");
        }
        this.senha = senha;
    }

    public int getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(int tipoUsuarioId) {
        if (tipoUsuarioId < 0) {
            throw new IllegalArgumentException("tipoUsuarioId não pode ser < 0");
        }
        this.tipoUsuarioId = tipoUsuarioId;
    }

    @Override
    public String toString() {
        return "(" + getId() + ", " + getNome() + ", " + getSenha() + ")";
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
