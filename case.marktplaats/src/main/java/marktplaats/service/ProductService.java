package marktplaats.service;

import marktplaats.dao.ArtikelDao;
import marktplaats.dao.DienstDao;
import marktplaats.domain.*;
import marktplaats.utils.Util;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private final EntityManager em;

    @Inject
    public ProductService(EntityManager em) { // DIY dependency injection
        this.em = em;
    }

    /*static, geen instantie*/
    @Inject
    Util util;

    @Inject
    ArtikelDao artikelDao;

    @Inject
    DienstDao dienstDao;

    @Inject QueryBuilder queryBuilder;

    public void findByName(String name){
        for(Artikel a:artikelDao.findByName(name)){
            util.print(a.toString());
        }
        for(Dienst d: dienstDao.findByName(name)){
            util.print(d.toString());
        }
    }

    public List<AbstractProduct> findAll() {
        List<AbstractProduct> list = new ArrayList<>();
        for(Artikel a:artikelDao.findAll()){
            util.print(a.toString());
            list.add(a);
        }
        for(Dienst d:dienstDao.findAll()){
            util.print(d.toString());
            list.add(d);
        }
        return list;
    }

    public void selectProduct(AbstractProduct a){
        if (a instanceof Artikel){
            util.print(a.selectProduct());
        } else if (a instanceof Dienst) {
            util.print(a.selectProduct());
        }
    }

    public void advancedSearch(SearchObject object){
        List<AbstractProduct> results = executeAdvancedQuery(queryBuilder.buildQuery(object));
        for (AbstractProduct a: results)
        util.print(a.toString());
    }

    public List<AbstractProduct> executeAdvancedQuery(String query){
        Query query2 = em.createQuery(query);
        return query2.getResultList();
    }

    public void printSearchByCategorie(ArtikelCategorie categorie){
        List<Artikel> list = artikelDao.findByCategorie(categorie);
        for(Artikel a:list){
            System.out.println(a);
        }

    }

    /*    public void findAll() {
        for(Artikel a:artikelDao.findAll()){
            util.print(a.toString());
        }
        for(Dienst d:dienstDao.findAll()){
            util.print(d.toString());
        }
    }*/
}
