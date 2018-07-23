package com.thoughtworks.tdd.parklinglot.core;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private String name;
    private String id;
    private int size;
    private Map<Receipt, Car> parkedCars = new HashMap<>();

    public ParkingLot(String id,String name,int size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }

    public Receipt park(Car car) {
        if (parkedCars.size() == this.size) {
            throw new ParkingLotFullException();
        }

        Receipt key = new Receipt();
        this.parkedCars.put(key, car);
        return key;
    }

    public boolean containCar(Receipt parkingTicket) {
        return this.parkedCars.containsKey(parkingTicket);
    }


    public Car unPark(Receipt receipt) {
        return this.parkedCars.remove(receipt);
    }

    public boolean isFull() {
        return this.parkedCars.size() == size;
    }

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public int getSize() {
        return size;
    }
    public Map<Receipt, Car> getReceiptCar() {
        return parkedCars;
    }

}
