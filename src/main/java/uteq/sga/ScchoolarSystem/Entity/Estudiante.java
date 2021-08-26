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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author capur
 */
@Entity
@Table(name = "estudiante", catalog = "GA", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByIdestudiante", query = "SELECT e FROM Estudiante e WHERE e.idestudiante = :idestudiante")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestudiante")
    private Integer idestudiante;
    @JoinColumn(name = "idmatricula", referencedColumnName = "idmatricula")
    @ManyToOne(optional = false)
    private Matricula idmatricula;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @JoinColumn(name = "idrepresentante", referencedColumnName = "idrepresentante")
    @ManyToOne(optional = false)
    private Representante idrepresentante;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idusuario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private Asistenciaestudiante asistenciaestudiante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestudiante")
    private Collection<Foroestudiante> foroestudianteCollection;

    public Estudiante() {
    }

    public Estudiante(Integer idestudiante) {
        this.idestudiante = idestudiante;
    }

    public Integer getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Integer idestudiante) {
        this.idestudiante = idestudiante;
    }

    public Matricula getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(Matricula idmatricula) {
        this.idmatricula = idmatricula;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    public Representante getIdrepresentante() {
        return idrepresentante;
    }

    public void setIdrepresentante(Representante idrepresentante) {
        this.idrepresentante = idrepresentante;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Asistenciaestudiante getAsistenciaestudiante() {
        return asistenciaestudiante;
    }

    public void setAsistenciaestudiante(Asistenciaestudiante asistenciaestudiante) {
        this.asistenciaestudiante = asistenciaestudiante;
    }

    public Collection<Foroestudiante> getForoestudianteCollection() {
        return foroestudianteCollection;
    }

    public void setForoestudianteCollection(Collection<Foroestudiante> foroestudianteCollection) {
        this.foroestudianteCollection = foroestudianteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestudiante != null ? idestudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.idestudiante == null && other.idestudiante != null) || (this.idestudiante != null && !this.idestudiante.equals(other.idestudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Estudiante[ idestudiante=" + idestudiante + " ]";
    }
    
}
