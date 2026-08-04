package com.c4networks.vrms.services.hibernate;

public class VRMSContextManager {

    public static void cleanup() {
        System.out.println("In VRMSContextManager. Calling HibernateSessionFactory.closeSession");
        HibernateSessionFactory.closeSession();
    }

}
