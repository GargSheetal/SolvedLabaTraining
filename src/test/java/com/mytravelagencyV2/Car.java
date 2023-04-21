package com.mytravelagencyV2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sheetal
 *
 */

public class Car {

	private String location;
	private LocalDate pickupDate;
	private LocalDate dropOffDate;
	private double price;
	private String carType;
	
	public Car(String location, LocalDate pickupDate, LocalDate dropOffDate, double price, String carType) {
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

	public LocalDate getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(LocalDate pickupDate) {
		this.pickupDate = pickupDate;
	}

	public LocalDate getDropOffDate() {
		return dropOffDate;
	}

	public void setDropOffDate(LocalDate dropOffDate) {
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
	
	
	public Car[] search(String location, LocalDate pickupDate, LocalDate dropOffDate) {
		
		List<Car> matchingCars = new ArrayList<>();
		
		for(Car car: cars)
		{
			if(location.equalsIgnoreCase(getLocation()))
			{
				matchingCars.add(car);
			}	
		}
		
		return matchingCars.toArray(new Car[0]);
			
	}
	
	public void printCars()
	{
		Car[] listMatchingCars = search(location, pickupDate, dropOffDate);
		
		for(Car matchingCar: listMatchingCars)
		{
			System.out.println(matchingCar);
		}		
		
	}
	
	public void filter(double maxPrice, String carType) {
		
		Car[] listMatchingCars = search(location, pickupDate, dropOffDate);
		
		for(Car car: listMatchingCars)
		{
			while(maxPrice >= price)
			{
				if(carType.equals(getCarType()))
				{
					System.out.println(car);
				}
			}
		}
		
	}
	
	
	Car[] cars = {
			new Car("Newyork",LocalDate.parse("2023-05-23"), LocalDate.parse("2023-05-26"), 30, "Sedan"),
			new Car("Miami", LocalDate.parse("2023-0-23"), LocalDate.parse("2023-05-26"), 25, "SUV"),
			new Car("LA",LocalDate.parse("2023-05-23"), LocalDate.parse("2023-05-26"), 40, "Sedan"),
			new Car("SF", LocalDate.parse("2023-05-23"), LocalDate.parse("2023-05-26"), 45, "Minivan"),
			new Car("Las Vegas", LocalDate.parse("2023-05-23"), LocalDate.parse("2023-05-26"), 28, "SUV"),
			new Car("Seattle", LocalDate.parse("2023-05-23"), LocalDate.parse("2023-05-26"), 45, "Minivan"),
			
		};
	
	
	
}
