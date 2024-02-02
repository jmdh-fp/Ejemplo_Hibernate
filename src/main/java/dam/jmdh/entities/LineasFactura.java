package dam.jmdh.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "lineas_factura")
public class LineasFactura implements Serializable {
    @Id
       @Column(name="num_linea_factura")
            @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int numLineaFactura;
    @Column(length = 50)
    private String concepto;
    private Double importe;

    public LineasFactura(int numLineaFactura, String concepto, Double importe) {
        this.numLineaFactura = numLineaFactura;
        this.concepto = concepto;
        this.importe = importe;
    }

    public LineasFactura(String concepto, Double importe) {
        this.concepto = concepto;
        this.importe = importe;
    }

    public LineasFactura() {
    }

    @Override
    public String toString() {
        return "LineasFactura{" +
                "numLineaFactura=" + numLineaFactura +
                ", concepto='" + concepto + '\'' +
                ", importe=" + importe +
                '}';
    }

    public int getNumLineaFactura() {
        return numLineaFactura;
    }

    public void setNumLineaFactura(int numLineaFactura) {
        this.numLineaFactura = numLineaFactura;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }
}
