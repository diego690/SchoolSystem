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
@Table(name = "tiporecurso", catalog = "GA", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Tiporecurso.findAll", query = "SELECT t FROM Tiporecurso t"),
    @NamedQuery(name = "Tiporecurso.findByIdtiporecurso", query = "SELECT t FROM Tiporecurso t WHERE t.idtiporecurso = :idtiporecurso"),
    @NamedQuery(name = "Tiporecurso.findByNombre", query = "SELECT t FROM Tiporecurso t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tiporecurso.findByDescripcion", query = "SELECT t FROM Tiporecurso t WHERE t.descripcion = :descripcion")})
public class Tiporecurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtiporecurso")
    private Integer idtiporecurso;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtiporecurso")
    private Collection<Recursos> recursosCollection;

    public Tiporecurso() {
    }

    public Tiporecurso(Integer idtiporecurso) {
        this.idtiporecurso = idtiporecurso;
    }

    public Tiporecurso(Integer idtiporecurso, String nombre, String descripcion) {
        this.idtiporecurso = idtiporecurso;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdtiporecurso() {
        return idtiporecurso;
    }

    public void setIdtiporecurso(Integer idtiporecurso) {
        this.idtiporecurso = idtiporecurso;
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

    public Collection<Recursos> getRecursosCollection() {
        return recursosCollection;
    }

    public void setRecursosCollection(Collection<Recursos> recursosCollection) {
        this.recursosCollection = recursosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtiporecurso != null ? idtiporecurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiporecurso)) {
            return false;
        }
        Tiporecurso other = (Tiporecurso) object;
        if ((this.idtiporecurso == null && other.idtiporecurso != null) || (this.idtiporecurso != null && !this.idtiporecurso.equals(other.idtiporecurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Tiporecurso[ idtiporecurso=" + idtiporecurso + " ]";
    }
    
}
