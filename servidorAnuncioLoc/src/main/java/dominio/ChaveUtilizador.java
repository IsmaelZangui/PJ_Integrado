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
@Table(name = "chave_utilizador", catalog = "bd_anuncios", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChaveUtilizador.findAll", query = "SELECT c FROM ChaveUtilizador c"),
    @NamedQuery(name = "ChaveUtilizador.findById", query = "SELECT c FROM ChaveUtilizador c WHERE c.id = :id")})
public class ChaveUtilizador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_utilizador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Utilizador idUtilizador;
    @JoinColumn(name = "id_chave", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PerfilChave idChave;

    public ChaveUtilizador() {
    }

    public ChaveUtilizador(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utilizador getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Utilizador idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public PerfilChave getIdChave() {
        return idChave;
    }

    public void setIdChave(PerfilChave idChave) {
        this.idChave = idChave;
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
        if (!(object instanceof ChaveUtilizador)) {
            return false;
        }
        ChaveUtilizador other = (ChaveUtilizador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.ChaveUtilizador[ id=" + id + " ]";
    }
    
}
