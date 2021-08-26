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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author capur
 */
@Entity
@Table(name = "tipousuario", catalog = "GA", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Tipousuario.findAll", query = "SELECT t FROM Tipousuario t"),
    @NamedQuery(name = "Tipousuario.findByIdtipousu", query = "SELECT t FROM Tipousuario t WHERE t.idtipousu = :idtipousu"),
    @NamedQuery(name = "Tipousuario.findByNombre", query = "SELECT t FROM Tipousuario t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tipousuario.findByDescripcion", query = "SELECT t FROM Tipousuario t WHERE t.descripcion = :descripcion")})
public class Tipousuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipousu")
    private Short idtipousu;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipousu")
    private Collection<Usuario> usuarioCollection;

    public Tipousuario() {
    }

    public Tipousuario(Short idtipousu) {
        this.idtipousu = idtipousu;
    }

    public Tipousuario(Short idtipousu, String nombre, String descripcion) {
        this.idtipousu = idtipousu;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Short getIdtipousu() {
        return idtipousu;
    }

    public void setIdtipousu(Short idtipousu) {
        this.idtipousu = idtipousu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipousu != null ? idtipousu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipousuario)) {
            return false;
        }
        Tipousuario other = (Tipousuario) object;
        if ((this.idtipousu == null && other.idtipousu != null) || (this.idtipousu != null && !this.idtipousu.equals(other.idtipousu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Tipousuario[ idtipousu=" + idtipousu + " ]";
    }
    
}
