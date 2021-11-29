package facade;

import dao.ContactDao;
import domain.Contact;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static util.Responses.badRequest;


@Path("contacts")
//@RequestScoped
public class ContactsResource {

    @Inject
    ContactDao contactDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> getAllStudents() {
        return contactDao.getContacts();
    }

    @GET @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Contact get(@PathParam("id") long id) {
        return contactDao.getContact(id).orElseThrow(() -> badRequest(id));
    }


    @GET @Path("{q}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> get(@PathParam("q")String q){
        return contactDao.getContacts(q);//.orElseThrow(() ->badRequest(q));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Contact add(Contact input) {
        return contactDao.add(input);
    }

/*    @GET @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public void testAddContact () {
        Contact stan = new Contact(null, "Bram", "Janssens", "bram.janssens@bramsmail.com");
        contactDao.add(stan);
    }*/

}
