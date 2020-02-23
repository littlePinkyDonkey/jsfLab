package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import org.hibernate.cfg.Configuration;

public class ConnectionCreator {
    private SessionFactory factory;

    public ConnectionCreator(Configuration config){
        factory = createFactory(config);
    }

    public SessionFactory getFactory() {
        return factory;
    }

    private SessionFactory createFactory(Configuration config){
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(config.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return config.buildSessionFactory(serviceRegistry);
    }
}
