package dam.jmdh.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
Ejemplo de uso de Lombok.
Este POJO es totalmento operativo.
Lombok a gnerado, getters, setters, constructores sin y con todos los argumentos,
toString, etc.
Los objetos instanciados de esta clase tienen todos esos métodos disponibles.
Se puden ver todos lo métodos en el panel Structure.
 */


@AllArgsConstructor @Data @NoArgsConstructor // Notaciones de Lombok
// @Entity(name="cliente")
public class Cliente_Lombok implements Serializable {
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

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
            @JoinColumn(name ="dni_cliente" )
    List<Factura> facturas = new ArrayList<>();




}
