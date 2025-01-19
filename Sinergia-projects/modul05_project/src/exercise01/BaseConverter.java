package exercise01;

abstract class BaseConverter {
    public abstract double convert(double celsius);
}

class CelsiusToKelvinConverter extends BaseConverter {
    @Override
    public double convert(double celsius) {
        return celsius + 273.15;
    }
}

class CelsiusToFahrenheitConverter extends BaseConverter {
    @Override
    public double convert(double celsius) {
        return celsius * 9 / 5 + 32;
    }
}