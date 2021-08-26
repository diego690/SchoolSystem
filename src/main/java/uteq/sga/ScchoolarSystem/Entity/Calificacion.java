/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author capur
 */
@Entity
@Table(name = "calificacion", catalog = "GA", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Calificacion.findAll", query = "SELECT c FROM Calificacion c"),
    @NamedQuery(name = "Calificacion.findByIdcalificacion", query = "SELECT c FROM Calificacion c WHERE c.idcalificacion = :idcalificacion"),
    @NamedQuery(name = "Calificacion.findByCalificacion", query = "SELECT c FROM Calificacion c WHERE c.calificacion = :calificacion"),
    @NamedQuery(name = "Calificacion.findByObservacion", query = "SELECT c FROM Calificacion c WHERE c.observacion = :observacion"),
    @NamedQuery(name = "Calificacion.findByEnvio", query = "SELECT c FROM Calificacion c WHERE c.envio = :envio")})
public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcalificacion")
    private Integer idcalificacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "calificacion")
    private BigDecimal calificacion;
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @Column(name = "Envio")
    private String envio;
    @JoinColumn(name = "idperiodomatricula", referencedColumnName = "idperiodomatricula")
    @ManyToOne(optional = false)
    private Periodomatriculacurso idperiodomatricula;
    @JoinColumn(name = "idtareas", referencedColumnName = "idtareas")
    @ManyToOne(optional = false)
    private Tareas idtareas;

    public Calificacion() {
    }

    public Calificacion(Integer idcalificacion) {
        this.idcalificacion = idcalificacion;
    }

    public Calificacion(Integer idcalificacion, String envio) {
        this.idcalificacion = idcalificacion;
        this.envio = envio;
    }

    public Integer getIdcalificacion() {
        return idcalificacion;
    }

    public void setIdcalificacion(Integer idcalificacion) {
        this.idcalificacion = idcalificacion;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEnvio() {
        return envio;
    }

    public void setEnvio(String envio) {
        this.envio = envio;
    }

    public Periodomatriculacurso getIdperiodomatricula() {
        return idperiodomatricula;
    }

    public void setIdperiodomatricula(Periodomatriculacurso idperiodomatricula) {
        this.idperiodomatricula = idperiodomatricula;
    }

    public Tareas getIdtareas() {
        return idtareas;
    }

    public void setIdtareas(Tareas idtareas) {
        this.idtareas = idtareas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcalificacion != null ? idcalificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.idcalificacion == null && other.idcalificacion != null) || (this.idcalificacion != null && !this.idcalificacion.equals(other.idcalificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Calificacion[ idcalificacion=" + idcalificacion + " ]";
    }
    
}
