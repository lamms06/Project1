package marktplaats;

import marktplaats.dao.ArtikelDao;
import marktplaats.dao.WinkelwagenDao;
import marktplaats.domain.ArtikelCategorie;
import marktplaats.domain.ProductSoort;
import marktplaats.domain.SearchObject;
import marktplaats.utils.Util;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import marktplaats.service.CleanupService;
import marktplaats.service.ProductService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class App {

    @Inject
    ArtikelDao artikelDao;

    @Inject
    ProductService productService;

    @Inject
    WinkelwagenDao winkelwagenDao;

    @Inject
    CleanupService cleanupService;

    @Inject
    Util util;


    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer weldContainer = weld.initialize(); // de engine/container
        App app = weldContainer.select(App.class).get(); // vanaf hier kan ik in marktplaats.App en zijn dependencies (marktplaats.dao) @Inject gebruiken.
        app.start();
    }

    public void start() {
        System.out.println("Start");

        //cleanupService.startTimer();

            /* vullen database */
        //util.fillProducts();

            /*raadplegen producten */
        //productService.findAll();

            /*simpel zoeken (naam)*/
        //productService.findByName("harry");

            /*product weergeven (meer details)*/
        //productService.selectProduct(artikelDao.selectProduct(30));

        //productService.printSearchByCategorie(ArtikelCategorie.BOEKEN);

            /*geavanceerd zoeken (naam, Prijs, soort, Categorie) */

        SearchObject object = new SearchObject(null, 100 , null, ArtikelCategorie.BOEKEN);
        productService.advancedSearch(object);

            /*Artikelen aan winkelwagen toevoegen*/
       // winkelwagenDao.addArtikelToNewCart(48);
       // winkelwagenDao.addArtikelToExistingCart(45, 67); //48

        //productService.findAll();

            /*Winkelwagen bekijken*/
        //winkelwagenDao.checkWinkelwagen(67);

            /*Artikel uit winkelwagen verwijderen*/
        //winkelwagenDao.removeProductFromCart(45, 67);
        //winkelwagenDao.checkWinkelwagen(67);

            /*Winkelwagen verwijderen/leegmaken*/
        //winkelwagenDao.removeCartKeepArticles(67);


        //productService.findAll();

            /*Winkelwagen verwijderen, artikelen verwijderen/kopen*/
        //winkelwagenDao.addArtikelToNewCart(48);
        //winkelwagenDao.removeCartRemoveArticles(68);

            /*Idle winkelwagens leegmaken en verwijderen*/
        //winkelwagenDao.validateWinkelwagens();

        System.out.println("Done");
    }

}
