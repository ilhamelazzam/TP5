package com.example;

import com.example.dao.IDao;
import com.example.entities.Product;
import com.example.util.HibernateConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Presentation2 {
    public static void main(String[] args) {
        // Charger la configuration Spring
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        // Récupérer le bean DAO
        IDao<Product> productDao = context.getBean(IDao.class);

        // Créer un produit
        Product product = new Product();
        product.setName("Produit 1");
        product.setPrice(100.0);

        // Sauvegarder dans la base
        productDao.create(product);

        // Afficher le résultat
        System.out.println("Produit ajouté : " + product.getName() + " - Prix : " + product.getPrice());
    }
}
