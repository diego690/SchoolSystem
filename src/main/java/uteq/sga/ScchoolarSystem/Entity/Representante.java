/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author capur
 */
@Entity
@Table(name = "representante", catalog = "GA", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Representante.findAll", query = "SELECT r FROM Representante r"),
    @NamedQuery(name = "Representante.findByIdrepresentante", query = "SELECT r FROM Representante r WHERE r.idrepresentante = :idrepresentante")})
public class Representante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrepresentante")
    private Integer idrepresentante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrepresentante")
    private Collection<Estudiante> estudianteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrepresentante")
    private Collection<Chatrepresentante> chatrepresentanteCollection;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idusuario;

    public Representante() {
    }

    public Representante(Integer idrepresentante) {
        this.idrepresentante = idrepresentante;
    }

    public Integer getIdrepresentante() {
        return idrepresentante;
    }

    public void setIdrepresentante(Integer idrepresentante) {
        this.idrepresentante = idrepresentante;
    }

    public Collection<Estudiante> getEstudianteCollection() {
        return estudianteCollection;
    }

    public void setEstudianteCollection(Collection<Estudiante> estudianteCollection) {
        this.estudianteCollection = estudianteCollection;
    }

    public Collection<Chatrepresentante> getChatrepresentanteCollection() {
        return chatrepresentanteCollection;
    }

    public void setChatrepresentanteCollection(Collection<Chatrepresentante> chatrepresentanteCollection) {
        this.chatrepresentanteCollection = chatrepresentanteCollection;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrepresentante != null ? idrepresentante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Representante)) {
            return false;
        }
        Representante other = (Representante) object;
        if ((this.idrepresentante == null && other.idrepresentante != null) || (this.idrepresentante != null && !this.idrepresentante.equals(other.idrepresentante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Representante[ idrepresentante=" + idrepresentante + " ]";
    }
    
}
