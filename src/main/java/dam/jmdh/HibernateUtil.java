package dam.jmdh;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    static final String COLOR_AZUL = "\u001B[34m";
    static final String COLOR_DEFECTO = "\u001B[0m";
    private static final SessionFactory sessionFactory;

    // Lee configuración del fichero hibernate.cfg.xml y genera un SessionFactory.
    static {
        try {
             sessionFactory = new Configuration().configure().buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Fallo al crear el SessionFactory");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void print (String s){
        System.out.println(COLOR_AZUL + s + COLOR_DEFECTO);
    }

}
