package Low_Level_Design.Design_Patterns.Behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

//Weather monitoring system

//Publisher interface

interface Publisher {
    void attach(Subscriber s);
    void detach(Subscriber s);
    void notifySubscribers();
}

//Concrete Publisher



class WeatherData implements Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifySubscribers();
    }

    @Override
    public void attach(Subscriber s) {
        subscribers.add(s);
    }

    @Override
    public void detach(Subscriber s) {
        subscribers.remove(s);
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber s : subscribers) {
            s.update(temperature, humidity, pressure);
        }
    }
}

//Subscriber interface

interface Subscriber {
    void update(float temperature, float humidity, float pressure);
}

//Concrete Subscribers

class WeatherStation implements Subscriber {
    private String stationName;

    public WeatherStation(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Weather Station " + stationName + " received update - Temperature: "
                + temperature + ", Humidity: " + humidity + ", Pressure: " + pressure);
    }
}

class MobileDevice implements Subscriber {
    private String deviceName;

    public MobileDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Mobile Device " + deviceName + " received update - Temperature: "
                + temperature + ", Humidity: " + humidity + ", Pressure: " + pressure);
    }
}


public class ObserverClient {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        WeatherStation ws1 = new WeatherStation("WS1");
        WeatherStation ws2 = new WeatherStation("WS2");
        MobileDevice md1 = new MobileDevice("MD1");
        MobileDevice md2 = new MobileDevice("MD2");

        weatherData.attach(ws1);
        weatherData.attach(ws2);
        weatherData.attach(md1);
        weatherData.attach(md2);

        weatherData.setMeasurements(25.0f, 65.0f, 1013.0f);
        weatherData.setMeasurements(30.0f, 70.0f, 1012.0f);

        weatherData.detach(ws2);

        weatherData.setMeasurements(28.0f, 68.0f, 1011.0f);
    }
}
