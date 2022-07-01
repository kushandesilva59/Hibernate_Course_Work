package Util;

import Entity.Reserve;
import Entity.Room;
import Entity.Student;
import Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() throws IOException {
        try{
            Configuration configuration = new Configuration();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            configuration.addAnnotatedClass(User.class)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Room.class)
                    .addAnnotatedClass(Reserve.class);

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error");
        }


       /* Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(User.class)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Room.class)
                    .addAnnotatedClass(Reserve.class);

            sessionFactory = configuration.buildSessionFactory();*/

    }
    public static FactoryConfiguration getInstance() throws IOException {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration()
                : factoryConfiguration;
    }
    public Session getSession() {
        return sessionFactory.openSession();
    }
}
