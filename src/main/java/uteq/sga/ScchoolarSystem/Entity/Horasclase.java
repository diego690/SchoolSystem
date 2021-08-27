/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author capur
 */
@Entity
@Table(catalog = "GA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horasclase.findAll", query = "SELECT h FROM Horasclase h"),
    @NamedQuery(name = "Horasclase.findByIdhoras", query = "SELECT h FROM Horasclase h WHERE h.idhoras = :idhoras"),
    @NamedQuery(name = "Horasclase.findByDia", query = "SELECT h FROM Horasclase h WHERE h.dia = :dia"),
    @NamedQuery(name = "Horasclase.findByHorainicio", query = "SELECT h FROM Horasclase h WHERE h.horainicio = :horainicio"),
    @NamedQuery(name = "Horasclase.findByHorafin", query = "SELECT h FROM Horasclase h WHERE h.horafin = :horafin")})
public class Horasclase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idhoras;
    @Basic(optional = false)
    private String dia;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date horainicio;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date horafin;
    @JoinColumn(name = "idmateriacurso", referencedColumnName = "idmateriacurso")
    @ManyToOne(optional = false)
    private Materiacurso idmateriacurso;

    public Horasclase() {
    }

    public Horasclase(Integer idhoras) {
        this.idhoras = idhoras;
    }

    public Horasclase(Integer idhoras, String dia, Date horainicio, Date horafin) {
        this.idhoras = idhoras;
        this.dia = dia;
        this.horainicio = horainicio;
        this.horafin = horafin;
    }

    public Integer getIdhoras() {
        return idhoras;
    }

    public void setIdhoras(Integer idhoras) {
        this.idhoras = idhoras;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Date getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Date horainicio) {
        this.horainicio = horainicio;
    }

    public Date getHorafin() {
        return horafin;
    }

    public void setHorafin(Date horafin) {
        this.horafin = horafin;
    }

    public Materiacurso getIdmateriacurso() {
        return idmateriacurso;
    }

    public void setIdmateriacurso(Materiacurso idmateriacurso) {
        this.idmateriacurso = idmateriacurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhoras != null ? idhoras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horasclase)) {
            return false;
        }
        Horasclase other = (Horasclase) object;
        if ((this.idhoras == null && other.idhoras != null) || (this.idhoras != null && !this.idhoras.equals(other.idhoras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Horasclase[ idhoras=" + idhoras + " ]";
    }
    
}
