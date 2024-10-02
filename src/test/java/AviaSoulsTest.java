import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class AviaSoulsTest {

    @Test
    void testCompareTo() {
        AviaSouls m = new AviaSouls();
        Ticket t1 = new Ticket("Минск", "Париж", 200, 5, 7);
        Ticket t2 = new Ticket("Минск", "Берлин", 300, 12, 14);
        Ticket t3 = new Ticket("Минск", "Берлин", 100, 5, 8);
        Ticket t4 = new Ticket("Москва", "Чебоксары", 400, 4, 7);
        Ticket t5 = new Ticket("Минск", "Берлин", 500, 7, 10);

        m.add(t1);
        m.add(t2);
        m.add(t3);
        m.add(t4);
        m.add(t5);

        Ticket[] actual = m.search("Минск", "Берлин");
        Ticket[] expected = new Ticket[]{t3, t2, t5};

        assertArrayEquals(actual, expected);
    }

    @Test
    void testCompareToNoTicket() {
        AviaSouls m = new AviaSouls();
        Ticket t1 = new Ticket("Минск", "Париж", 200, 5, 7);
        Ticket t2 = new Ticket("Минск", "Берлин", 300, 12, 14);
        Ticket t3 = new Ticket("Минск", "Берлин", 100, 5, 8);
        Ticket t4 = new Ticket("Москва", "Чебоксары", 400, 4, 7);
        Ticket t5 = new Ticket("Минск", "Берлин", 500, 7, 10);

        m.add(t1);
        m.add(t2);
        m.add(t3);
        m.add(t4);
        m.add(t5);

        Ticket[] actual = m.search("Минск", "Владимир");
        Ticket[] expected = {};

        assertArrayEquals(actual, expected);
    }

    @Test
    void testCompareToOneTicket() {
        AviaSouls m = new AviaSouls();
        Ticket t1 = new Ticket("Минск", "Париж", 200, 5, 7);
        Ticket t2 = new Ticket("Минск", "Берлин", 300, 12, 14);
        Ticket t3 = new Ticket("Минск", "Берлин", 100, 5, 8);
        Ticket t4 = new Ticket("Москва", "Чебоксары", 400, 4, 7);
        Ticket t5 = new Ticket("Минск", "Берлин", 500, 7, 10);

        m.add(t1);
        m.add(t2);
        m.add(t3);
        m.add(t4);
        m.add(t5);

        Ticket[] actual = m.search("Москва", "Чебоксары");
        Ticket[] expected = {t4};

        assertArrayEquals(actual, expected);
    }

    @Test
    void testCompareToComparator() {
        AviaSouls m = new AviaSouls();
        Ticket t1 = new Ticket("Минск", "Париж", 200, 5, 8);
        Ticket t2 = new Ticket("Минск", "Берлин", 300, 12, 16);
        Ticket t3 = new Ticket("Минск", "Берлин", 100, 5, 8);
        Ticket t4 = new Ticket("Москва", "Чебоксары", 400, 4, 7);
        Ticket t5 = new Ticket("Минск", "Берлин", 500, 7, 12);

        m.add(t1);
        m.add(t2);
        m.add(t3);
        m.add(t4);
        m.add(t5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = m.searchAndSortBy("Минск", "Берлин", comparator);
        Ticket[] expected = new Ticket[]{t3, t2, t5};

        assertArrayEquals(actual, expected);
    }

    @Test
    void testCompareToNoTicketComparator() {
        AviaSouls m = new AviaSouls();
        Ticket t1 = new Ticket("Минск", "Париж", 200, 5, 7);
        Ticket t2 = new Ticket("Минск", "Берлин", 300, 12, 14);
        Ticket t3 = new Ticket("Минск", "Берлин", 100, 5, 8);
        Ticket t4 = new Ticket("Москва", "Чебоксары", 400, 4, 7);
        Ticket t5 = new Ticket("Минск", "Берлин", 500, 7, 10);

        m.add(t1);
        m.add(t2);
        m.add(t3);
        m.add(t4);
        m.add(t5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = m.searchAndSortBy("Минск", "Владимир", comparator);
        Ticket[] expected = {};

        assertArrayEquals(actual, expected);
    }

    @Test
    void testCompareToOneTicketComparator() {
        AviaSouls m = new AviaSouls();
        Ticket t1 = new Ticket("Минск", "Париж", 200, 5, 7);
        Ticket t2 = new Ticket("Минск", "Берлин", 300, 12, 14);
        Ticket t3 = new Ticket("Минск", "Берлин", 100, 5, 8);
        Ticket t4 = new Ticket("Москва", "Чебоксары", 400, 4, 7);
        Ticket t5 = new Ticket("Минск", "Берлин", 500, 7, 10);

        m.add(t1);
        m.add(t2);
        m.add(t3);
        m.add(t4);
        m.add(t5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = m.searchAndSortBy("Москва", "Чебоксары", comparator);
        Ticket[] expected = {t4};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void testFindAll() {
        AviaSouls aviaSouls = new AviaSouls();

        // Добавляем несколько билетов
        aviaSouls.add(new Ticket("Москва", "Санкт-Петербург", 1000, 9, 18));
        aviaSouls.add(new Ticket("Москва", "Ростов-на-Дону", 700, 6, 14));
        aviaSouls.add(new Ticket("Москва", "Казань", 500, 7, 16));
        aviaSouls.add(new Ticket("Санкт-Петербург", "Москва", 1200, 18, 22));
        aviaSouls.add(new Ticket("Ростов-на-Дону", "Москва", 1500, 12, 18));
        aviaSouls.add(new Ticket("Казань", "Москва", 800, 10, 14));

        // Проверка количества билетов
        Ticket[] actualTickets = aviaSouls.findAll();
        assertEquals(6, actualTickets.length);

        // Проверка содержимого билетов
        Ticket[] expectedTickets = new Ticket[]{
                new Ticket("Москва", "Санкт-Петербург", 1000, 9, 18),
                new Ticket("Москва", "Ростов-на-Дону", 700, 6, 14),
                new Ticket("Москва", "Казань", 500, 7, 16),
                new Ticket("Санкт-Петербург", "Москва", 1200, 18, 22),
                new Ticket("Ростов-на-Дону", "Москва", 1500, 12, 18),
                new Ticket("Казань", "Москва", 800, 10, 14)
        };
        assertArrayEquals(expectedTickets, actualTickets);
    }

    @Test
    public void testWhenTimesAreEqual() {
        Ticket t1 = new Ticket("Минск", "Париж", 200, 5, 7);
        Ticket t2 = new Ticket("Минск", "Берлин", 300, 12, 15);
        Ticket t3 = new Ticket("Минск", "Берлин", 100, 5, 8);
        Ticket t4 = new Ticket("Москва", "Чебоксары", 400, 4, 7);
        Ticket t5 = new Ticket("Минск", "Берлин", 500, 7, 9);

        TicketTimeComparator comparator = new TicketTimeComparator();

        assertEquals(0, comparator.compare(t1, t5));
    }

    @Test
    void testEqualsSelf() {
        Ticket ticket = new Ticket("Москва", "Санкт-Петербург", 1000, 9, 18);
        assertTrue(ticket.equals(ticket));
    }

    @Test
    void testNotEqualsDifferentClass() {
        Ticket ticket = new Ticket("Москва", "Санкт-Петербург", 1000, 9, 18);
        assertFalse(ticket.equals(new Object()));
    }

    @Test
    void testNotEqualsDifferentPrices() {
        Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 1000, 9, 18);
        Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 1200, 9, 18);
        assertFalse(ticket1.equals(ticket2));
    }

    @Test
    void testNotEqualsDifferentTimeFrom() {
        Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 1000, 9, 18);
        Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 1000, 12, 18);
        assertFalse(ticket1.equals(ticket2));
    }

    @Test
    void testNotEqualsDifferentTimeTo() {
        Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 1000, 9, 18);
        Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 1000, 9, 22);
        assertFalse(ticket1.equals(ticket2));
    }

    @Test
    void testNotEqualsDifferentFrom() {
        Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 1000, 9, 18);
        Ticket ticket2 = new Ticket("Нью-Йорк", "Санкт-Петербург", 1000, 9, 18);
        assertFalse(ticket1.equals(ticket2));
    }


    @Test
    void testNotEqualsDifferentTo() {
        Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 1000, 9, 18);
        Ticket ticket2 = new Ticket("Москва", "Токио", 1000, 9, 18);
        assertFalse(ticket1.equals(ticket2));
    }

    @Test
    void testNullEquality() {
        Ticket ticket = new Ticket("Москва", "Санкт-Петербург", 1000, 9, 18);
        assertFalse(ticket.equals(null));
    }

    @Test
    void testDifferentClasses() {
        Ticket ticket = new Ticket("Москва", "Санкт-Петербург", 1000, 9, 18);
        assertFalse(ticket.equals(new Object()));
    }

    @Test
    void testHashCodeForEqualObjects() {
        Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 1000, 9, 18);
        Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 1000, 9, 18);
        assertEquals(ticket1.hashCode(), ticket2.hashCode());
    }

    @Test
    void testHashCodeForUnequalObjects() {
        Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 1000, 9, 18);
        Ticket ticket2 = new Ticket("Москва", "Ростов-на-Дону", 700, 6, 14);
        assertNotEquals(ticket1.hashCode(), ticket2.hashCode());
    }

    @Test
    void testCompareToWithEqualPrices() {
        Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 1000, 9, 18);
        Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 1000, 9, 18);
        assertEquals(0, ticket1.compareTo(ticket2));
    }
}
