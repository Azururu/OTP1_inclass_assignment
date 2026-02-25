import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {
    @Test
    void testFahrenheitToCelsius() {
        double testFahrenheit1 = 98.6;
        double expectedCelsius1 = 37.0;

        double testFahrenheit2 = -32.0;
        double expectedCelsius2 = -35.6;

        double testFahrenheit3 = 2120.0;
        double expectedCelsius3 = 1160.0;

        TemperatureConverter converter = new TemperatureConverter();

        double celsius1 = converter.fahrenheitToCelsius(testFahrenheit1);
        double celsius2 = converter.fahrenheitToCelsius(testFahrenheit2);
        double celsius3 = converter.fahrenheitToCelsius(testFahrenheit3);

        assertEquals(expectedCelsius1, celsius1, 0.1);
        assertEquals(expectedCelsius2, celsius2, 0.1);
        assertEquals(expectedCelsius3, celsius3, 0.1);
    }

    @Test
    void testCelsiusToFahrenheit() {
        double celsius1 = 12.5;
        double expectedFahrenheit1 = 54.5;

        double celsius2 = 10000.0;
        double expectedFahrenheit2 = 18032.0;

        double negativeCelsius = -200.0;
        double expectedNegativeFahrenheit = -328.0;

        TemperatureConverter converter = new TemperatureConverter();

        double normalTemperatureFahrenheit = converter.celsiusToFahrenheit(celsius1);
        double highTemperatureFahrenheit = converter.celsiusToFahrenheit(celsius2);
        double negativeFahrenheit = converter.celsiusToFahrenheit(negativeCelsius);

        assertEquals(expectedFahrenheit1, normalTemperatureFahrenheit, 0.1);
        assertEquals(expectedFahrenheit2, highTemperatureFahrenheit, 0.1);
        assertEquals(expectedNegativeFahrenheit, negativeFahrenheit, 0.1);
    }

    @Test
    void testKelvinToCelsius() {
        double kelvin1 = 300;
        double expectedCelsius1 = 26.85;

        double kelvin2 = 10000;
        double expectedCelsius2 = 9726.85;

        double kelvin3 = 0;
        double expectedCelsius3 = -273.15;

        TemperatureConverter converter = new TemperatureConverter();

        double normalTemp = converter.kelvinToCelsius(kelvin1);
        double highTemp = converter.kelvinToCelsius(kelvin2);
        double absoluteZeroTemp = converter.kelvinToCelsius(kelvin3);

        assertEquals(expectedCelsius1, normalTemp, 0.1);
        assertEquals(expectedCelsius2, highTemp, 0.1);
        assertEquals(expectedCelsius3, absoluteZeroTemp, 0.1);
    }

    @Test
    void testIsExtremeTemperature() {
        double expectedExtremeLow = -45.0;
        double expectedExtremeLow2 = -250.0;

        double expectedExtremeHigh = 55.0;
        double expectedExtremeHigh2 = 10000.0;

        double expectedNormal = 20.0;
        double expectedNormal2 = -10.0;

        double boundaryValueLow = -40.0;
        double boundaryValueHigh = 50.0;

        TemperatureConverter converter = new TemperatureConverter();

        assertTrue(converter.isExtremeTemperature(expectedExtremeLow));
        assertTrue(converter.isExtremeTemperature(expectedExtremeLow2));

        assertTrue(converter.isExtremeTemperature(expectedExtremeHigh));
        assertTrue(converter.isExtremeTemperature(expectedExtremeHigh2));

        assertFalse(converter.isExtremeTemperature(expectedNormal));
        assertFalse(converter.isExtremeTemperature(expectedNormal2));

        assertFalse(converter.isExtremeTemperature(boundaryValueLow));
        assertFalse(converter.isExtremeTemperature(boundaryValueHigh));
    }
}