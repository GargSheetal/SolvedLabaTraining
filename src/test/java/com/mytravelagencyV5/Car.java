package com.mytravelagencyV5;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author sheetal
 *
 */

public final class Car {

	private String location;
	private String pickupDate;
	private String dropOffDate;
	private double price;
	private String carType;
	
	private static final Logger logger = LogManager.getLogger(Flight.class);
	
	public Car(String location, String pickupDate, String dropOffDate, double price, String carType) {
		this.location = location;
		this.pickupDate = pickupDate;
		this.dropOffDate = dropOffDate;
		this.price = price;
		this.carType = carType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}

	public String getDropOffDate() {
		return dropOffDate;
	}

	public void setDropOffDate(String dropOffDate) {
		this.dropOffDate = dropOffDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	
	public static List<Car> search(String location, String pickupDate, String dropOffDate) {
		
		List<Car> matchingCars = new ArrayList<>();
		
		for(Car car: readCarsFromCsv(new File("./src/test/resources/com/mytravelagency/testdata/carsData.csv")))
		{
			if(
					car.getLocation().equalsIgnoreCase(location) 
					&& car.getPickupDate().equals(pickupDate) 
					&& car.getDropOffDate().equals(dropOffDate)
				)
			{
				matchingCars.add(car);
			}	
		}
		
		return matchingCars;
			
	}
	
	@Override
	public final String toString() {
		String s = (
				getCarType() + " at " +
				getLocation() + " (" +
				getPickupDate() + " - " +
				getDropOffDate()  + ") for $" +
				getPrice() + " per day"
		);	
		return s;
	}
	
	public static List<Car> filter(List<Car> cars, double maxPrice, String carType) {
		
		List<Car> matchingCars = new ArrayList<>();
		
		for(Car car: cars)
		{
			if(
				car.getPrice() <= maxPrice 
				&& car.getCarType().equalsIgnoreCase(carType)
				)
			{
				matchingCars.add(car);
			}
		
		}
		return matchingCars;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(this == o)
		{
			return true;
		}
		if(!(o instanceof Hotel))
		{
			return false;
		}
		
		Car c = (Car) o;
		return this.carType.equals(c.carType) && this.price == c.price;
		
	}
	
	@Override
	public int hashCode() {
		
        final int prime = 31;
        int result = 1;
        result = (int) (prime * result + price);
        result = prime * result + ((carType == null) ? 0 : carType.hashCode());
        return result;
    }
	
	public static List<Car> readCarsFromCsv(File file) {
	    List<Car> cars = new ArrayList<>();

	    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	        String line;

	        while ((line = reader.readLine()) != null) {
	            String[] values = line.split(",");

	            String location = values[0];
	            String pickupDate = values[1];
	            String dropOffDate = values[2];
	            double price = Double.parseDouble(values[3]);
	            String carType =values[4];

	            Car car = new Car(location, pickupDate, dropOffDate, price, carType);
	            cars.add(car);
	        }

	    } catch (IOException e) {
	    	System.out.println("Error while fetching Car List: " + e.getMessage());
	        logger.fatal("Error while fetching Car List: {}", e.getMessage());
	        System.exit(1);;
	    }

	    return cars;
	}
	
//	static Car[] cars = {
//			new Car("Newyork", "2023-05-23", "2023-05-26", 30, "Sedan"),
//			new Car("Newyork", "2023-05-23", "2023-05-26", 30, "SUV"),
//			new Car("Newyork", "2023-05-23", "2023-05-26", 30, "Minivan"),
//			new Car("Miami", "2023-05-23", "2023-05-26", 30, "Sedan"),
//			new Car("Miami", "2023-05-23", "2023-05-26", 40, "Minivan"),
//			new Car("Miami", "2023-05-23", "2023-05-26", 25, "SUV"),
//			new Car("Miami", "2023-05-23", "2023-05-26", 35, "SUV"),
//			new Car("LA","2023-05-23", "2023-05-26", 40, "Sedan"),
//			new Car("LA","2023-05-23", "2023-05-26", 40, "SUV"),
//			new Car("LA","2023-05-23", "2023-05-26", 40, "Minivan"),
//			new Car("SF", "2023-05-23", "2023-05-26", 45, "Minivan"),
//			new Car("SF", "2023-05-23", "2023-05-26", 45, "Sedan"),
//			new Car("SF", "2023-05-23", "2023-05-26", 45, "SUV"),
//			new Car("Las Vegas", "2023-05-23", "2023-05-26", 28, "SUV"),
//			new Car("Seattle", "2023-05-23", "2023-05-26", 45, "Minivan"),
//			
//		};
	
	
	
}
