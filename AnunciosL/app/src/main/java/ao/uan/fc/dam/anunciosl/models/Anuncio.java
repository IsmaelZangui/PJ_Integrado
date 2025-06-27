package ao.uan.fc.dam.anunciosl.models;

import java.util.Date;

public class Anuncio {

    private String id;
    private String titulo;
    private String descricao;
    private String modo;
    private String mensagem;
    private String localDestino;
    private Date dataInicio;
    private Date dataFim;
    private String horaInicio;
    private String horaFim;
    private Utilizador autor;
    private Restricao politica;

    // Construtor vazio
    public Anuncio() {}

    // Construtor completo
    public Anuncio(String id, String titulo, String descricao, String modo, String mensagem,
                   String localDestino, Date dataInicio, Date dataFim,
                   String horaInicio, String horaFim, Utilizador autor, Restricao politica) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.modo = modo;
        this.mensagem = mensagem;
        this.localDestino = localDestino;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.autor = autor;
        this.politica = politica;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getModo() { return modo; }
    public void setModo(String modo) { this.modo = modo; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public String getLocalDestino() { return localDestino; }
    public void setLocalDestino(String localDestino) { this.localDestino = localDestino; }

    public Date getDataInicio() { return dataInicio; }
    public void setDataInicio(Date dataInicio) { this.dataInicio = dataInicio; }

    public Date getDataFim() { return dataFim; }
    public void setDataFim(Date dataFim) { this.dataFim = dataFim; }

    public String getHoraInicio() { return horaInicio; }
    public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }

    public String getHoraFim() { return horaFim; }
    public void setHoraFim(String horaFim) { this.horaFim = horaFim; }

    public Utilizador getAutor() { return autor; }
    public void setAutor(Utilizador autor) { this.autor = autor; }

    public Restricao getPolitica() { return politica; }
    public void setPolitica(Restricao politica) { this.politica = politica; }
}
