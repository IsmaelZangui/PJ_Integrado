/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Cláudio Santos
 */
@Entity
@Table(name = "restricao", catalog = "bd_anuncios", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restricao.findAll", query = "SELECT r FROM Restricao r"),
    @NamedQuery(name = "Restricao.findById", query = "SELECT r FROM Restricao r WHERE r.id = :id"),
    @NamedQuery(name = "Restricao.findByTipo", query = "SELECT r FROM Restricao r WHERE r.tipo = :tipo")})
public class Restricao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRestricao")
    private List<Anuncio> anuncioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRestricao")
    private List<RestricaoChave> restricaoChaveList;

    public Restricao() {
    }

    public Restricao(Integer id) {
        this.id = id;
    }

    public Restricao(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Anuncio> getAnuncioList() {
        return anuncioList;
    }

    public void setAnuncioList(List<Anuncio> anuncioList) {
        this.anuncioList = anuncioList;
    }

    @XmlTransient
    public List<RestricaoChave> getRestricaoChaveList() {
        return restricaoChaveList;
    }

    public void setRestricaoChaveList(List<RestricaoChave> restricaoChaveList) {
        this.restricaoChaveList = restricaoChaveList;
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
        if (!(object instanceof Restricao)) {
            return false;
        }
        Restricao other = (Restricao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Restricao[ id=" + id + " ]";
    }
    
}
