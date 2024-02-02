package dam.jmdh.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "datos_cliente")
public class DatosCliente implements Serializable {
    @Id
    @Column(name = "id_datos_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDatosCliente;
    @Column(name = "fact_anual")
    Double factAnual;
    int antiguedad;

    public DatosCliente(int idDatosCliente, Double factAnual, int antiguedad) {
        this.idDatosCliente = idDatosCliente;
        this.factAnual = factAnual;
        this.antiguedad = antiguedad;
    }

    public DatosCliente(Double factAnual, int antiguedad) {
        this.factAnual = factAnual;
        this.antiguedad = antiguedad;
    }

    public DatosCliente() {
    }

    @Override
    public String toString() {
        return "datosCliente{" +
                "idDatosCliente=" + idDatosCliente +
                ", factAnual=" + factAnual +
                ", antiguedad=" + antiguedad +
                '}';
    }

    public int getIdDatosCliente() {
        return idDatosCliente;
    }

    public void setIdDatosCliente(int idDatosCliente) {
        this.idDatosCliente = idDatosCliente;
    }

    public Double getFactAnual() {
        return factAnual;
    }

    public void setFactAnual(Double factAnual) {
        this.factAnual = factAnual;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
}
