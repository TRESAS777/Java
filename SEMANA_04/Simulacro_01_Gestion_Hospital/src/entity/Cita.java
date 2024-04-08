package entity;

import java.sql.Date;
import java.sql.Time;

public class Cita {

    private int id_Cita;
    private int id_Medico;
    private int id_Paciente;
    private Date fecha_Cita;
    private Time hora_Cita;
    private String motivo;

    public Cita() {
    }

    public Cita(int id_Cita, int id_Medico, int id_Paciente, Date fecha_Cita, Time hora_Cita, String motivo) {
        this.id_Cita = id_Cita;
        this.id_Medico = id_Medico;
        this.id_Paciente = id_Paciente;
        this.fecha_Cita = fecha_Cita;
        this.hora_Cita = hora_Cita;
        this.motivo = motivo;
    }

    public int getId_Cita() {
        return id_Cita;
    }

    public void setId_Cita(int id_Cita) {
        this.id_Cita = id_Cita;
    }

    public int getId_Medico() {
        return id_Medico;
    }

    public void setId_Medico(int id_Medico) {
        this.id_Medico = id_Medico;
    }

    public int getId_Paciente() {
        return id_Paciente;
    }

    public void setId_Paciente(int id_Paciente) {
        this.id_Paciente = id_Paciente;
    }

    public Date getFecha_Cita() {
        return fecha_Cita;
    }

    public void setFecha_Cita(Date fecha_Cita) {
        this.fecha_Cita = fecha_Cita;
    }

    public Time getHora_Cita() {
        return hora_Cita;
    }

    public void setHora_Cita(Time hora_Cita) {
        this.hora_Cita = hora_Cita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id_Cita=" + id_Cita +
                ", id_Medico=" + id_Medico +
                ", id_Paciente=" + id_Paciente +
                ", fecha_Cita=" + fecha_Cita +
                ", hora_Cita=" + hora_Cita +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}
