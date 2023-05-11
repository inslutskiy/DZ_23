package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {
    private final GeoService geoService = Mockito.mock(GeoService.class);
    private final LocalizationService localizationService = Mockito.mock(LocalizationService.class);
    private final MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
    private final Map<String, String> headers = new HashMap<>();

    @Test
    public void messageRU() {
        Mockito.when(geoService.byIp("172."))
                .thenReturn(new Location(null, Country.RUSSIA,null,0));
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.");
        String x = messageSender.send(headers);
        String y = localizationService.locale(Country.RUSSIA);

        Assertions.assertEquals(y,x);
    }

    @Test
    public void messageUSA() {
        Mockito.when(geoService.byIp("96."))
                .thenReturn(new Location(null, Country.USA,null,0));
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.");
        String x = messageSender.send(headers);
        String y = localizationService.locale(Country.USA);

        Assertions.assertEquals(y,x);
    }
}