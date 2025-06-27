package ao.uan.fc.dam.anunciosl.models;

public class Chave {

    private String id;
    private String chave;
    private String valor;
    private boolean padrao; // <- importante para a exibição e lógica

    // Construtor vazio
    public Chave() {}

    // Construtor sem ID (caso não use)
    public Chave(String chave, String valor, boolean padrao) {
        this.chave = chave;
        this.valor = valor;
        this.padrao = padrao;
    }

    // Construtor completo (com id)
    public Chave(String id, String chave, String valor, boolean padrao) {
        this.id = id;
        this.chave = chave;
        this.valor = valor;
        this.padrao = padrao;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getChave() { return chave; }
    public void setChave(String chave) { this.chave = chave; }

    public String getValor() { return valor; }
    public void setValor(String valor) { this.valor = valor; }

    public boolean isPadrao() { return padrao; }
    public void setPadrao(boolean padrao) { this.padrao = padrao; }
}
