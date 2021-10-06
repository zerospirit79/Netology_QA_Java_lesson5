import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BonusServiceTest {

    @Test
    void shouldCalculateRegisteredAndBonusUnderLimit() {
        BonusService service = new BonusService();

        //Подготавливаем данные
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        //Вызываем целевой метод
        long actual = service.calculate(registered, amount);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredAndBonusOverLimit() {
        BonusService service = new BonusService();

        //Подготавливаем данные
        long amount = 1000_000_60;
        boolean registered = true;
        long expected = 500;
        //Вызываем целевой метод
        long actual = service.calculate(registered, amount);


      assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNotRegisteredAndBonusUnderLimit() {
        BonusService service = new BonusService();

        //Подготавливаем данные
        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;

        //Вызываем целевой метод
        long actual = service.calculate(registered, amount);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNotRegisteredAndBonusOverLimit() {
        BonusService service = new BonusService();

        //Подготавливаем данные
        long amount = 1000_000_60;
        boolean registered = false;
        long expected = 500;
        //Вызываем целевой метод
        long actual = service.calculate(registered, amount);


        assertEquals(expected, actual);
    }

}