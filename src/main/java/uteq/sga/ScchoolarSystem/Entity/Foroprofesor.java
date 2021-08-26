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
@Table(name = "foroprofesor", catalog = "GA", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Foroprofesor.findAll", query = "SELECT f FROM Foroprofesor f"),
    @NamedQuery(name = "Foroprofesor.findByIdforoprofesor", query = "SELECT f FROM Foroprofesor f WHERE f.idforoprofesor = :idforoprofesor"),
    @NamedQuery(name = "Foroprofesor.findByMensaje", query = "SELECT f FROM Foroprofesor f WHERE f.mensaje = :mensaje"),
    @NamedQuery(name = "Foroprofesor.findByFecha", query = "SELECT f FROM Foroprofesor f WHERE f.fecha = :fecha")})
public class Foroprofesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idforoprofesor")
    private Integer idforoprofesor;
    @Basic(optional = false)
    @Column(name = "mensaje")
    private String mensaje;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "idforo", referencedColumnName = "idforo")
    @ManyToOne(optional = false)
    private Foro idforo;
    @JoinColumn(name = "idprofesor", referencedColumnName = "idprofesor")
    @ManyToOne(optional = false)
    private Profesor idprofesor;

    public Foroprofesor() {
    }

    public Foroprofesor(Integer idforoprofesor) {
        this.idforoprofesor = idforoprofesor;
    }

    public Foroprofesor(Integer idforoprofesor, String mensaje, Date fecha) {
        this.idforoprofesor = idforoprofesor;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public Integer getIdforoprofesor() {
        return idforoprofesor;
    }

    public void setIdforoprofesor(Integer idforoprofesor) {
        this.idforoprofesor = idforoprofesor;
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

    public Foro getIdforo() {
        return idforo;
    }

    public void setIdforo(Foro idforo) {
        this.idforo = idforo;
    }

    public Profesor getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(Profesor idprofesor) {
        this.idprofesor = idprofesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idforoprofesor != null ? idforoprofesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Foroprofesor)) {
            return false;
        }
        Foroprofesor other = (Foroprofesor) object;
        if ((this.idforoprofesor == null && other.idforoprofesor != null) || (this.idforoprofesor != null && !this.idforoprofesor.equals(other.idforoprofesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Foroprofesor[ idforoprofesor=" + idforoprofesor + " ]";
    }
    
}
