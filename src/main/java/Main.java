import Entity.Ticket;
import Service.ClientCrudService;
import Service.CrudService;
import Service.PlanetCrudService;
import Service.TicketCrudService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Database db = new Database();
        db.init();

        testTicket();
//        testClient();
//        testPlanet();
    }

    public static void testTicket(){
        TicketCrudService ticketServis = new TicketCrudService();

        List allTickets = ticketServis.listAll();
        System.out.println("All Tickets: ");
        System.out.println(allTickets);

    }

    public static void testClient(){
        ClientCrudService clientService = new ClientCrudService();

        List allClient = clientService.listAll();
        System.out.println("All Clients: ");
        System.out.println(allClient);

        clientService.updateById(2, "Bobo");

        allClient = clientService.listAll();
        System.out.println("All Clients: ");
        System.out.println(allClient);

    }

    public static void testPlanet(){
        PlanetCrudService planetService = new PlanetCrudService();

        List allPlanets = planetService.listAll();
        System.out.println("All Planets: ");
        System.out.println(allPlanets);

        planetService.create("MAR2","Mars");

        allPlanets = planetService.listAll();
        System.out.println("All Planets: ");
        System.out.println(allPlanets);

        planetService.deleteById("PLU");
    }
}
