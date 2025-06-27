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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author Cláudio Santos
 */
@Entity
@Table(name = "restricao_chave", catalog = "bd_anuncios", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RestricaoChave.findAll", query = "SELECT r FROM RestricaoChave r"),
    @NamedQuery(name = "RestricaoChave.findById", query = "SELECT r FROM RestricaoChave r WHERE r.id = :id")})
public class RestricaoChave implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_chave", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PerfilChave idChave;
    @JoinColumn(name = "id_restricao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Restricao idRestricao;

    public RestricaoChave() {
    }

    public RestricaoChave(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PerfilChave getIdChave() {
        return idChave;
    }

    public void setIdChave(PerfilChave idChave) {
        this.idChave = idChave;
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
        if (!(object instanceof RestricaoChave)) {
            return false;
        }
        RestricaoChave other = (RestricaoChave) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.RestricaoChave[ id=" + id + " ]";
    }
    
}
