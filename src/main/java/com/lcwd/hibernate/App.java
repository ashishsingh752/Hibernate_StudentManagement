package com.lcwd.hibernate;

import org.hibernate.SessionFactory;

import com.lcwd.hibernate.util.SessionProvider;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        SessionFactory sessionFactory = SessionProvider.getSessionFactory();
        System.out.println(sessionFactory);
    }
}
