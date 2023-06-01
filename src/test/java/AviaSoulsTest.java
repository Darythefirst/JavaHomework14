import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Санкт-Петербург", "Москва", 5_000, 19, 20);
    Ticket ticket2 = new Ticket("Москва", "Сочи", 7_000, 16, 19);
    Ticket ticket3 = new Ticket("Екатеринбург", "Челябинск", 10_000, 11, 13);
    Ticket ticket4 = new Ticket("Сочи", "Краснодар", 7_000, 16, 17);
    Ticket ticket5 = new Ticket("Сочи", "Краснодар", 12_000, 12, 16);
    Ticket ticket6 = new Ticket("Сочи", "Краснодар", 9_500, 18, 20);

    @Test
    public void testCompareTo1() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        int expected = -1;
        int actual = ticket4.compareTo(ticket3);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testCompareTo2() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        int expected = 0;
        int actual = ticket2.compareTo(ticket4);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testCompareTo3() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        int expected = 1;
        int actual = ticket3.compareTo(ticket1);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testSearch() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        Ticket[] expected = {ticket4, ticket6, ticket5};
        Ticket[] actual = pass.search("Сочи", "Краснодар");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testSearchWithOneTicket() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        Ticket[] expected = {ticket1};
        Ticket[] actual = pass.search("Санкт-Петербург", "Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWithNoTicket() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = pass.search("Санкт-Петербург", "Сочи");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testComparator1() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        TicketTimeComparator ticketComparator = new TicketTimeComparator();

        int expected = -1;
        int actual = ticketComparator.compare(ticket6, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testComparator2() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        TicketTimeComparator ticketComparator = new TicketTimeComparator();

        int expected = 0;
        int actual = ticketComparator.compare(ticket4, ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testComparator3() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        TicketTimeComparator ticketComparator = new TicketTimeComparator();

        int expected = 1;
        int actual = ticketComparator.compare(ticket2, ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearchAndSort() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        TicketTimeComparator ticketComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4, ticket6, ticket5};
        Ticket[] actual = pass.searchAndSortBy("Сочи", "Краснодар", ticketComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortWithOneTicket() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        TicketTimeComparator ticketComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3};
        Ticket[] actual = pass.searchAndSortBy("Екатеринбург", "Челябинск", ticketComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortWithNoTicket() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        TicketTimeComparator ticketComparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = pass.searchAndSortBy("Москва", "Челябинск", ticketComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
