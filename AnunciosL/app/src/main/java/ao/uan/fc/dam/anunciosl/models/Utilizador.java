package ao.uan.fc.dam.anunciosl.models;

import com.google.gson.Gson;

public class Utilizador {

    private String id;
    private String nome;
    private String email;
    private String senha;
    private String estado;
    private double saldo;

    // Construtor vazio
    public Utilizador() {}

    // Construtor completo
    public Utilizador(String id, String nome, String email, String senha, String estado, double saldo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.estado = estado;
        this.saldo = saldo;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    // Converter para JSON
    public String toJson() {
        return new Gson().toJson(this);
    }

    // Criar objeto a partir de JSON
    public static Utilizador fromJson(String json) {
        return new Gson().fromJson(json, Utilizador.class);
    }

    @Override
    public String toString() {
        return "Utilizador{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", estado='" + estado + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
