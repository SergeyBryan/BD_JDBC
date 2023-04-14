package com.example.bd_jdbc.dao;


import javax.persistence.*;

public class PersistenceReader {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
}
