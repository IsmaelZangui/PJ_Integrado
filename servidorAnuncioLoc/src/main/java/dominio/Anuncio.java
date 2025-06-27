/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Cláudio Santos
 */
@Entity
@Table(name = "anuncio", catalog = "bd_anuncios", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anuncio.findAll", query = "SELECT a FROM Anuncio a"),
    @NamedQuery(name = "Anuncio.findById", query = "SELECT a FROM Anuncio a WHERE a.id = :id"),
    @NamedQuery(name = "Anuncio.findByData", query = "SELECT a FROM Anuncio a WHERE a.data = :data"),
    @NamedQuery(name = "Anuncio.findByHora", query = "SELECT a FROM Anuncio a WHERE a.hora = :hora"),
    @NamedQuery(name = "Anuncio.findByDataFim", query = "SELECT a FROM Anuncio a WHERE a.dataFim = :dataFim"),
    @NamedQuery(name = "Anuncio.findByHoraFim", query = "SELECT a FROM Anuncio a WHERE a.horaFim = :horaFim"),
    @NamedQuery(name = "Anuncio.findByTitulo", query = "SELECT a FROM Anuncio a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "Anuncio.findByModo", query = "SELECT a FROM Anuncio a WHERE a.modo = :modo"),
    @NamedQuery(name = "Anuncio.findByIdLocal", query = "SELECT a FROM Anuncio a WHERE a.idLocal = :idLocal"),
    @NamedQuery(name = "Anuncio.findByTime", query = "SELECT a FROM Anuncio a WHERE a.time = :time")})
public class Anuncio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "data")
    private String data;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "hora")
    private String hora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "data_fim")
    private String dataFim;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "hora_fim")
    private String horaFim;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "mensagem")
    private String mensagem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "modo")
    private String modo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_local")
    private int idLocal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @JoinColumn(name = "utilizador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Utilizador utilizador;
    @JoinColumn(name = "id_restricao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Restricao idRestricao;

    public Anuncio() {
    }

    public Anuncio(Integer id) {
        this.id = id;
    }

    public Anuncio(Integer id, String data, String hora, String dataFim, String horaFim, String titulo, String mensagem, String modo, int idLocal, Date time) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.dataFim = dataFim;
        this.horaFim = horaFim;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.modo = modo;
        this.idLocal = idLocal;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public Restricao getIdRestricao() {
        return idRestricao;
    }

    public void setIdRestricao(Restricao idRestricao) {
        this.idRestricao = idRestricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anuncio)) {
            return false;
        }
        Anuncio other = (Anuncio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Anuncio[ id=" + id + " ]";
    }
    
}
