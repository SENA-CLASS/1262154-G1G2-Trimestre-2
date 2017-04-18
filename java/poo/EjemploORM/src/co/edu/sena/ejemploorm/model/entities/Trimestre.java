/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemploorm.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "trimestre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trimestre.findAll", query = "SELECT t FROM Trimestre t")
    , @NamedQuery(name = "Trimestre.findByNombreTrimestre", query = "SELECT t FROM Trimestre t WHERE t.trimestrePK.nombreTrimestre = :nombreTrimestre")
    , @NamedQuery(name = "Trimestre.findByJornadasiglaJornada", query = "SELECT t FROM Trimestre t WHERE t.trimestrePK.jornadasiglaJornada = :jornadasiglaJornada")})
public class Trimestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrimestrePK trimestrePK;
    @ManyToMany(mappedBy = "trimestreList", fetch = FetchType.EAGER)
    private List<ResultadoAprendizaje> resultadoAprendizajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trimestre", fetch = FetchType.EAGER)
    private List<FichaHasTrimestre> fichaHasTrimestreList;
    @JoinColumn(name = "Jornada_sigla_Jornada", referencedColumnName = "sigla_Jornada", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Jornada jornada;

    public Trimestre() {
    }

    public Trimestre(TrimestrePK trimestrePK) {
        this.trimestrePK = trimestrePK;
    }

    public Trimestre(String nombreTrimestre, String jornadasiglaJornada) {
        this.trimestrePK = new TrimestrePK(nombreTrimestre, jornadasiglaJornada);
    }

    public TrimestrePK getTrimestrePK() {
        return trimestrePK;
    }

    public void setTrimestrePK(TrimestrePK trimestrePK) {
        this.trimestrePK = trimestrePK;
    }

    @XmlTransient
    public List<ResultadoAprendizaje> getResultadoAprendizajeList() {
        return resultadoAprendizajeList;
    }

    public void setResultadoAprendizajeList(List<ResultadoAprendizaje> resultadoAprendizajeList) {
        this.resultadoAprendizajeList = resultadoAprendizajeList;
    }

    @XmlTransient
    public List<FichaHasTrimestre> getFichaHasTrimestreList() {
        return fichaHasTrimestreList;
    }

    public void setFichaHasTrimestreList(List<FichaHasTrimestre> fichaHasTrimestreList) {
        this.fichaHasTrimestreList = fichaHasTrimestreList;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trimestrePK != null ? trimestrePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trimestre)) {
            return false;
        }
        Trimestre other = (Trimestre) object;
        if ((this.trimestrePK == null && other.trimestrePK != null) || (this.trimestrePK != null && !this.trimestrePK.equals(other.trimestrePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.ejemploorm.model.entities.Trimestre[ trimestrePK=" + trimestrePK + " ]";
    }
    
}
