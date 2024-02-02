package dam.jmdh.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Proveedor {
    long id;
    String dni;
    String nombre;
    double importe;

}
