package edu.umb.cs680.hw04;

public class Car {
    private String make, model;
    private int mileage, year;
    private float price;

    public Car(String make, String model, int mileage, int year, float price) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public static void main(String[] args) {
        Car car_instance = new Car("TATA","Tiago",30, 2021, 800000);

        String[] str = {car_instance.getMake(), car_instance.getModel(),
                String.valueOf(car_instance.getMileage()), String.valueOf(car_instance.getYear()),
                String.valueOf(car_instance.getPrice())};

        for(int i=0; i< str.length; i++){
            System.out.println(str[i]);
        }
    }
}
