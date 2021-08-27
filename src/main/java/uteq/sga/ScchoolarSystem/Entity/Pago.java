/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
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
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p"),
    @NamedQuery(name = "Pago.findByIdpago", query = "SELECT p FROM Pago p WHERE p.idpago = :idpago"),
    @NamedQuery(name = "Pago.findByFecha", query = "SELECT p FROM Pago p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Pago.findByValor", query = "SELECT p FROM Pago p WHERE p.valor = :valor"),
    @NamedQuery(name = "Pago.findByTipo", query = "SELECT p FROM Pago p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Pago.findByEvidencia", query = "SELECT p FROM Pago p WHERE p.evidencia = :evidencia")})
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer idpago;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    private BigDecimal valor;
    @Basic(optional = false)
    private String tipo;
    @Basic(optional = false)
    private String evidencia;
    @JoinColumn(name = "idperiodomatriculacurso", referencedColumnName = "idperiodomatricula")
    @ManyToOne(optional = false)
    private Periodomatriculacurso idperiodomatriculacurso;

    public Pago() {
    }

    public Pago(Integer idpago) {
        this.idpago = idpago;
    }

    public Pago(Integer idpago, Date fecha, BigDecimal valor, String tipo, String evidencia) {
        this.idpago = idpago;
        this.fecha = fecha;
        this.valor = valor;
        this.tipo = tipo;
        this.evidencia = evidencia;
    }

    public Integer getIdpago() {
        return idpago;
    }

    public void setIdpago(Integer idpago) {
        this.idpago = idpago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(String evidencia) {
        this.evidencia = evidencia;
    }

    public Periodomatriculacurso getIdperiodomatriculacurso() {
        return idperiodomatriculacurso;
    }

    public void setIdperiodomatriculacurso(Periodomatriculacurso idperiodomatriculacurso) {
        this.idperiodomatriculacurso = idperiodomatriculacurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpago != null ? idpago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.idpago == null && other.idpago != null) || (this.idpago != null && !this.idpago.equals(other.idpago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Pago[ idpago=" + idpago + " ]";
    }
    
}
