import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.StringCache;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BonusServiceTest {

    @ParameterizedTest
    void shouldCalculateRegisteredAndBonusUnderLimit(String testName, long amount, boolean registered, long expected) {
        BonusService service = new BonusService();

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