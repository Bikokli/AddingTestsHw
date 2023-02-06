
//import org.example.BonusService;
import org.example.untitled7.untitled7mvn.services.BonusService;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {

        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    //незарегестриваные пользователти привышаюшие лимит
    @org.junit.jupiter.api.Test
    void shouldBeCalculatedForNotRegisteredAndExceedingTheLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    //незарегистрированных и находящихся под лимитом
    @org.junit.jupiter.api.Test
    void shouldBeCalculatedForUnregisteredAndUnderTheLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1000;
        boolean registered = false;
        long expected = 10;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    // негативный тестинг
    @org.junit.jupiter.api.Test
    void negativeShouldCalculateForRegisteredAndUnderLimit() {

        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 1000;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertNotEquals(expected, actual);
    }

    // негативный тестинг
    @org.junit.jupiter.api.Test
    void negativeShouldCalculateForRegisteredAndUnderLimitt() {

        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = false;
        long expected = 1000;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertNotEquals(expected, actual);
    }

    // негативный тестинг
    @org.junit.jupiter.api.Test
    void negativeShouldBeCalculatedForNotRegisteredAndExceedingTheLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = false;
        long expected =1_000_000;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertNotEquals(expected, actual);
    }

    // негативный тестинг
    @org.junit.jupiter.api.Test
    void negativeShouldBeCalculatedForNotRegisteredAndExceedingTheLimitt() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected =1_000_000;
        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertNotEquals(expected, actual);

    }
}
