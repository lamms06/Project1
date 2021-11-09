package marktplaats.SystemApplication;

import marktplaats.service.ProductService;

import java.util.Properties;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

    @Path("properties")
    public class PropertiesResource {

        @Inject
        ProductService productservice;

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Properties getProperties() {
            return System.getProperties();
        }


        @Path("findall")
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public String getArtikelen(){
            return productservice.findAll().toString();
        }

        @Path("string")
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public String getString(){
            return ("testString");
        }
    }

