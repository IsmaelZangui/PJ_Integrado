package ao.uan.fc.dam.anunciosl.models;

import java.util.List;

public class Restricao {

    private String id;
    private String tipo; // "whitelist" ou "blacklist"
    private List<Chave> chaves;

    // Construtor vazio
    public Restricao() {}

    // Construtor completo
    public Restricao(String id, String tipo, List<Chave> chaves) {
        this.id = id;
        this.tipo = tipo;
        this.chaves = chaves;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public List<Chave> getChaves() { return chaves; }
    public void setChaves(List<Chave> chaves) { this.chaves = chaves; }
}
