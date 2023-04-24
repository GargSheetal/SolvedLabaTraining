package com.mytravelagencyV3;


import java.util.ArrayList;
import java.util.List;

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
		
		for(Car car: cars)
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
	
	public static void printCarList(List<Car> cars)
	{
		for(Car car: cars)
		{
			System.out.println(
					(cars.indexOf(car) + 1) + " | Reserve " +
					car.getCarType() + " at " +
					car.getLocation() + " (" +
					car.getPickupDate() + " - " +
					car.getDropOffDate()  + ") for $" +
					car.getPrice() + " per day"
					);
		}		
		
	}
	
	@Override
	public final String toString() {
		String s = (
				"Booked " +
				getCarType() + " at " +
				getLocation() + " (" +
				getPickupDate() + " - " +
				getDropOffDate()  + ") for $" +
				getPrice() + " per day"
		);	
		return s;
	}
	
	public static void printCar(Car car)
	{
			System.out.println(
					 "Booked " +
					car.getCarType() + " at " +
					car.getLocation() + " (" +
					car.getPickupDate() + " - " +
					car.getDropOffDate()  + ") for $" +
					car.getPrice() + " per day"
					);
				
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
	
	
	static Car[] cars = {
			new Car("Newyork", "2023-05-23", "2023-05-26", 30, "Sedan"),
			new Car("Newyork", "2023-05-23", "2023-05-26", 30, "SUV"),
			new Car("Newyork", "2023-05-23", "2023-05-26", 30, "Minivan"),
			new Car("Miami", "2023-05-23", "2023-05-26", 30, "Sedan"),
			new Car("Miami", "2023-05-23", "2023-05-26", 40, "Minivan"),
			new Car("Miami", "2023-05-23", "2023-05-26", 25, "SUV"),
			new Car("Miami", "2023-05-23", "2023-05-26", 35, "SUV"),
			new Car("LA","2023-05-23", "2023-05-26", 40, "Sedan"),
			new Car("LA","2023-05-23", "2023-05-26", 40, "SUV"),
			new Car("LA","2023-05-23", "2023-05-26", 40, "Minivan"),
			new Car("SF", "2023-05-23", "2023-05-26", 45, "Minivan"),
			new Car("SF", "2023-05-23", "2023-05-26", 45, "Sedan"),
			new Car("SF", "2023-05-23", "2023-05-26", 45, "SUV"),
			new Car("Las Vegas", "2023-05-23", "2023-05-26", 28, "SUV"),
			new Car("Seattle", "2023-05-23", "2023-05-26", 45, "Minivan"),
			
		};
	
	
	
}
