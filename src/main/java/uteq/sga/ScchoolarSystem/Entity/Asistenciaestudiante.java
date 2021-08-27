/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author capur
 */
@Entity
@Table(name = "asistenciaestudiante", catalog = "GA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistenciaestudiante.findAll", query = "SELECT a FROM Asistenciaestudiante a"),
    @NamedQuery(name = "Asistenciaestudiante.findById", query = "SELECT a FROM Asistenciaestudiante a WHERE a.id = :id"),
    @NamedQuery(name = "Asistenciaestudiante.findByIdestudiante", query = "SELECT a FROM Asistenciaestudiante a WHERE a.idestudiante = :idestudiante"),
    @NamedQuery(name = "Asistenciaestudiante.findByAsistencia", query = "SELECT a FROM Asistenciaestudiante a WHERE a.asistencia = :asistencia")})
public class Asistenciaestudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Id
    @Basic(optional = false)
    @Column(name = "idestudiante")
    private Integer idestudiante;
    @Basic(optional = false)
    @Column(name = "asistencia")
    private boolean asistencia;
    @JoinColumn(name = "idasistencia", referencedColumnName = "idasistencia")
    @ManyToOne(optional = false)
    private Asistencia idasistencia;
    @JoinColumn(name = "idestudiante", referencedColumnName = "idestudiante", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Estudiante estudiante;

    public Asistenciaestudiante() {
    }

    public Asistenciaestudiante(Integer idestudiante) {
        this.idestudiante = idestudiante;
    }

    public Asistenciaestudiante(Integer idestudiante, int id, boolean asistencia) {
        this.idestudiante = idestudiante;
        this.id = id;
        this.asistencia = asistencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Integer idestudiante) {
        this.idestudiante = idestudiante;
    }

    public boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public Asistencia getIdasistencia() {
        return idasistencia;
    }

    public void setIdasistencia(Asistencia idasistencia) {
        this.idasistencia = idasistencia;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
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
        if (!(object instanceof Asistenciaestudiante)) {
            return false;
        }
        Asistenciaestudiante other = (Asistenciaestudiante) object;
        if ((this.idestudiante == null && other.idestudiante != null) || (this.idestudiante != null && !this.idestudiante.equals(other.idestudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Asistenciaestudiante[ idestudiante=" + idestudiante + " ]";
    }
    
}
