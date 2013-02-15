/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Arthur Assuncao
 */
public class ConexaoBD {
    private static final SessionFactory sessionFactory;
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    //retorna uma sessao de comunicacao com o BD

    public static Session getInstance() {
        Session session = (Session) threadLocal.get();
        session = sessionFactory.openSession();
        threadLocal.set(session);
        return session;
    }
}
