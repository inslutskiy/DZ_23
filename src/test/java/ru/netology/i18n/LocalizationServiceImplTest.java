package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    public void localRU(){
        LocalizationService localizationService = new LocalizationServiceImpl();

        String x = localizationService.locale(Country.RUSSIA);
        String y = "Добро пожаловать";

        Assertions.assertEquals(y, x);
    }

    @Test
    public void localUSA(){
        LocalizationService localizationService = new LocalizationServiceImpl();

        String x = localizationService.locale(Country.USA);
        String y = "Welcome";

        Assertions.assertEquals(y, x);
    }
}