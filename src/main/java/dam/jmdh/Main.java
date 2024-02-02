package dam.jmdh;

import dam.jmdh.entities.*;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        System.out.println("Probando conexión...");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Conexión/Sesion establecida con éxito!!!");

            /// Prebas varias. Luego lo haremos utilizando un DAO y clase controlador

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

            // Estamos haciendo que el objeto cliente sea persistente

            session.beginTransaction();
            session.persist(cliente1);
            session.persist(cliente2);
            //System.exit(0);

            System.out.println("Borrando factura de las patatas y peras. NumFactura =  " +factura1.getNumFactura());

            session.remove(factura1);
            cliente1.getFacturas().remove(factura1);
            session.getTransaction().commit();

        } catch (Exception e){
            System.err.println("Se ha producido un error");
            e.printStackTrace();
        }



    }


}