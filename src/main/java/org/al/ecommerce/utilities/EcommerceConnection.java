package org.al.ecommerce.utilities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EcommerceConnection {
    public static EntityManagerFactory createFactoryManager()
    {
        EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory("EccomPersistence");

        return entityManagerFactory;
    }
}
