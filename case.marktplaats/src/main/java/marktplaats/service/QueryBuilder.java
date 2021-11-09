package marktplaats.service;

import marktplaats.domain.ArtikelCategorie;
import marktplaats.domain.DienstCategorie;
import marktplaats.domain.ProductSoort;
import marktplaats.domain.SearchObject;

public class QueryBuilder {

    public String advancedSearchSelectClauseBuilder(){
        StringBuilder x = new StringBuilder();
        x.append("SELECT a ");
        return x.toString();
    }

    public String advancedSearchFromClauseBuilder(SearchObject object){
        StringBuilder x = new StringBuilder();
        x.append("FROM ");
        if(object.getSoort()!=null){
            System.out.println(object.getSoort().toString());
            x.append(object.getSoort().toString()).append(" a ");
        } else {
            x.append("Artikel").append(" a ");
        }
        return x.toString();
    }

    public String advancedSearchWhereClauseBuilder(SearchObject object) {
        StringBuilder x = new StringBuilder();
        int counter = 0;
        x.append("WHERE");
        if (object.getCategorie() instanceof ArtikelCategorie) {
            x.append(" categorie = marktplaats.domain.ArtikelCategorie.").append(object.getCategorie());
            counter++;
        }

        if(object.getNaam()!=null && counter == 0){
            x.append(" name = ").append("'").append(object.getNaam()).append("'");
            counter++;
        } else if (object.getNaam()!=null){
            x.append(" AND name = ").append(object.getNaam());
        }

        if(!(object.getPrijs()==0) && counter == 0){
            x.append(" price = ").append(object.getPrijs());
            counter++;
        } else if(!(object.getPrijs()==0)){
            x.append(" AND price = ").append(object.getPrijs());
        }

        if(object.getSoort() == ProductSoort.ARTIKEl && counter ==0){
            x.append(" soort = marktplaats.domain.Productsoort.").append(object.getSoort());
        } else if (object.getSoort() == ProductSoort.DIENST && counter == 0){
            x.append(" soort = marktplaats.domain.Productsoort.").append(object.getSoort());
        } else if (object.getSoort() == ProductSoort.ARTIKEl && counter > 0){
            x.append(" AND soort = marktplaats.domain.Productsoort.").append(object.getSoort());
        } else if (object.getSoort() == ProductSoort.DIENST && counter > 0){
            x.append(" AND soort = marktplaats.domain.Productsoort.").append(object.getSoort());
        }

        if(counter>0) {
            x.append(" AND inWinkelwagen = false");
        } else {
            x.append(" inWinkelwagen = false");
        }
        return x.toString();
    }

    public String buildQuery(SearchObject object){
        StringBuilder x = new StringBuilder();
        x.append(advancedSearchSelectClauseBuilder())
                .append(advancedSearchFromClauseBuilder(object))
                .append(advancedSearchWhereClauseBuilder(object));
        System.out.println("QUERY: " + x.toString());
        return x.toString();
    }
}
