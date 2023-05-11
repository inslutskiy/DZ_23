package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {
    @Test
    public void ipRU() {
        GeoServiceImpl geoService = new GeoServiceImpl();

        Country x = geoService.byIp("172.").getCountry();
        Country y = new Location(null, Country.RUSSIA, null, 0).getCountry();

        Assertions.assertEquals(y,x);
    }

    @Test
    public void ipUSA() {
        GeoServiceImpl geoService = new GeoServiceImpl();

        Country x = geoService.byIp("96.").getCountry();
        Country y = new Location(null, Country.USA, null, 0).getCountry();

        Assertions.assertEquals(y,x);
    }
}