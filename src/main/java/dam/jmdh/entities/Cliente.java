package dam.jmdh.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name="cliente")
public class Cliente  implements Serializable {
    @Id
    @Column(length = 9)
    private String dni;
    @Column(length = 40)
    private String apellidos;
    @Column(length = 40)
    private String nombre;

    // Establece relación uno a uno unidireccional con DAtosCliente
    @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name = "id_datos_cliente")
    DatosCliente datosCliente;

    // Relación uno a muchos con facturas
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    // Creará columna dni_cliente en tabla factura, que será la FK. (De paso evita creación de tabla intermedia)
    @JoinColumn(name ="dni_cliente" )
    List<Factura> facturas = new ArrayList<>();

    public void setDatosCliente(DatosCliente datosCliente) {
        this.datosCliente = datosCliente;
    }
    public DatosCliente getDatosCliente() {
        return datosCliente;
    }


    public Cliente(String dni, String apellidos, String nombre, DatosCliente datosCliente, List<Factura> facturas) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.datosCliente = datosCliente;
        this.facturas = facturas;
    }

    public Cliente() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public void addFactura(Factura factura){
        if (this.facturas == null)
            facturas = new ArrayList<>();
        this.facturas.add(factura);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ", datosCliente=" + datosCliente +
                ", facturas=" + facturas +
                '}';
    }


}
