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
@Table(name = "perfil_chave", catalog = "bd_anuncios", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilChave.findAll", query = "SELECT p FROM PerfilChave p"),
    @NamedQuery(name = "PerfilChave.findById", query = "SELECT p FROM PerfilChave p WHERE p.id = :id"),
    @NamedQuery(name = "PerfilChave.findByChave", query = "SELECT p FROM PerfilChave p WHERE p.chave = :chave"),
    @NamedQuery(name = "PerfilChave.findByValor", query = "SELECT p FROM PerfilChave p WHERE p.valor = :valor")})
public class PerfilChave implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "chave")
    private String chave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "valor")
    private String valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idChave")
    private List<RestricaoChave> restricaoChaveList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idChave")
    private List<ChaveUtilizador> chaveUtilizadorList;

    public PerfilChave() {
    }

    public PerfilChave(Integer id) {
        this.id = id;
    }

    public PerfilChave(Integer id, String chave, String valor) {
        this.id = id;
        this.chave = chave;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @XmlTransient
    public List<RestricaoChave> getRestricaoChaveList() {
        return restricaoChaveList;
    }

    public void setRestricaoChaveList(List<RestricaoChave> restricaoChaveList) {
        this.restricaoChaveList = restricaoChaveList;
    }

    @XmlTransient
    public List<ChaveUtilizador> getChaveUtilizadorList() {
        return chaveUtilizadorList;
    }

    public void setChaveUtilizadorList(List<ChaveUtilizador> chaveUtilizadorList) {
        this.chaveUtilizadorList = chaveUtilizadorList;
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
        if (!(object instanceof PerfilChave)) {
            return false;
        }
        PerfilChave other = (PerfilChave) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.PerfilChave[ id=" + id + " ]";
    }
    
}
