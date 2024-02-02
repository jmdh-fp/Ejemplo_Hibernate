package dam.jmdh;

import dam.jmdh.entities.Cliente;
import dam.jmdh.entities.DatosCliente;
import dam.jmdh.entities.Factura;
import dam.jmdh.entities.LineasFactura;
import dam.jmdh.repositories.ClienteRepository;
import org.hibernate.Session;


import java.util.List;

import static dam.jmdh.HibernateUtil.print;

public class MainRep {
    public static void main(String[] args) {
        List<Cliente>  lc;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            ClienteRepository clienteRepository = new ClienteRepository(session);
           // Datos de ejemplo
            DatosCliente datosCliente = new DatosCliente(23.45, 10);
            DatosCliente datosCliente2 = new DatosCliente(24443.45, 1);
            Cliente cliente1 = new Cliente("12345678C","Domìnguez","Pepe",datosCliente,null);
            Cliente cliente2 = new Cliente("99999999X","Fernández","María",datosCliente2,null);

            Factura factura1 = new Factura(456.89);
            Factura factura2 = new Factura(100.0);
            Factura factura3 = new Factura(50.0);

            LineasFactura lf1 = new LineasFactura("Patatas", 78.0);
            LineasFactura lf2 = new LineasFactura("Peras", 728.20);
            LineasFactura lf3 = new LineasFactura("Platanos", 1888.345);

            factura1.addLineaFactura(lf1);
            factura1.addLineaFactura(lf2);
            factura2.addLineaFactura(lf3);

            cliente1.addFactura(factura1);
            cliente1.addFactura(factura2);
            cliente2.addFactura(factura3);

            // Persistir losdos clientes anteriores.
            print("Grabado clientes");
            clienteRepository.save(cliente1);
            clienteRepository.save(cliente2);

            print("Listado de todos los clientes:");

            clienteRepository.findAll().forEach(c->print(c.toString()));

            print("Extrayendo cliente con dni ");
            print(clienteRepository.findOneById("12345678C").toString());

            print("Borrando cliente cond dni 12345678C");
            clienteRepository.delete(cliente1);

            // El cliente ya no existe, por lo que si lo buscamos en BBDD de nuevo devuelve null.

            Cliente c = clienteRepository.findOneById("12345678C");
            if (c != null)  print(c.toString());

            print("Actualizando cliente cn dni " + cliente2.getDni());
            print("Su mobre pasa a ser Spock. (¡Larga vida y prosperidad!)");
            print("Su apellido vulcaniano es, como posiblemente sabréis, impronunciable. Lo ponemos a NULL...");
            cliente2.setNombre("Spock");
            cliente2.setApellidos(null);
            clienteRepository.update(cliente2);
        }

    }
}
