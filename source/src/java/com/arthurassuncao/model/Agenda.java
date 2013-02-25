/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Falcaoi3
 */
@Entity
@Table(name = "agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a"),
    @NamedQuery(name = "Agenda.findByDataHora", query = "SELECT a FROM Agenda a WHERE a.agendaPK.dataHora = :dataHora"),
    @NamedQuery(name = "Agenda.findByIdMedico", query = "SELECT a FROM Agenda a WHERE a.agendaPK.idMedico = :idMedico"),
    @NamedQuery(name = "Agenda.findByIdExame", query = "SELECT a FROM Agenda a WHERE a.agendaPK.idExame = :idExame"),
    @NamedQuery(name = "Agenda.findByIdPaciente", query = "SELECT a FROM Agenda a WHERE a.agendaPK.idPaciente = :idPaciente")})
public class Agenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AgendaPK agendaPK;
    @Lob
    @Size(max = 65535)
    @Column(name = "obs")
    private String obs;
    @Lob
    @Size(max = 65535)
    @Column(name = "resultado")
    private String resultado;
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paciente paciente;
    @JoinColumn(name = "idExame", referencedColumnName = "idExame", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Exame exame;
    @JoinColumn(name = "idMedico", referencedColumnName = "idMedico", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medico medico;

    public Agenda() {
    }

    public Agenda(AgendaPK agendaPK) {
        this.agendaPK = agendaPK;
    }

    public Agenda(Date dataHora, int idMedico, int idExame, int idPaciente) {
        this.agendaPK = new AgendaPK(dataHora, idMedico, idExame, idPaciente);
    }

    public AgendaPK getAgendaPK() {
        return agendaPK;
    }

    public void setAgendaPK(AgendaPK agendaPK) {
        this.agendaPK = agendaPK;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agendaPK != null ? agendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.agendaPK == null && other.agendaPK != null) || (this.agendaPK != null && !this.agendaPK.equals(other.agendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arthurassuncao.model.Agenda[ agendaPK=" + agendaPK + " ]";
    }
    
}
