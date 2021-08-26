/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author capur
 */
@Entity
@Table(name = "foroestudiante", catalog = "GA", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Foroestudiante.findAll", query = "SELECT f FROM Foroestudiante f"),
    @NamedQuery(name = "Foroestudiante.findByMensaje", query = "SELECT f FROM Foroestudiante f WHERE f.mensaje = :mensaje"),
    @NamedQuery(name = "Foroestudiante.findByFecha", query = "SELECT f FROM Foroestudiante f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Foroestudiante.findByIdforoestudiante", query = "SELECT f FROM Foroestudiante f WHERE f.idforoestudiante = :idforoestudiante")})
public class Foroestudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "mensaje")
    private String mensaje;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idforoestudiante")
    private Integer idforoestudiante;
    @JoinColumn(name = "idestudiante", referencedColumnName = "idestudiante")
    @ManyToOne(optional = false)
    private Estudiante idestudiante;
    @JoinColumn(name = "idforo", referencedColumnName = "idforo")
    @ManyToOne(optional = false)
    private Foro idforo;

    public Foroestudiante() {
    }

    public Foroestudiante(Integer idforoestudiante) {
        this.idforoestudiante = idforoestudiante;
    }

    public Foroestudiante(Integer idforoestudiante, String mensaje, Date fecha) {
        this.idforoestudiante = idforoestudiante;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdforoestudiante() {
        return idforoestudiante;
    }

    public void setIdforoestudiante(Integer idforoestudiante) {
        this.idforoestudiante = idforoestudiante;
    }

    public Estudiante getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Estudiante idestudiante) {
        this.idestudiante = idestudiante;
    }

    public Foro getIdforo() {
        return idforo;
    }

    public void setIdforo(Foro idforo) {
        this.idforo = idforo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idforoestudiante != null ? idforoestudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Foroestudiante)) {
            return false;
        }
        Foroestudiante other = (Foroestudiante) object;
        if ((this.idforoestudiante == null && other.idforoestudiante != null) || (this.idforoestudiante != null && !this.idforoestudiante.equals(other.idforoestudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Foroestudiante[ idforoestudiante=" + idforoestudiante + " ]";
    }
    
}
