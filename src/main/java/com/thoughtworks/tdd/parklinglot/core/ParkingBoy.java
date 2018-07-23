package com.thoughtworks.tdd.parklinglot.core;

import java.util.*;

public class ParkingBoy  {
    protected List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLotList){
        this.parkingLots = parkingLotList;
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLots;
    }

    public Receipt park(Car car) throws ParkingLotFullException {

        ParkingLot currentParkingLot = null;
        try {
            currentParkingLot = parkingLots.stream()
                    .filter((ParkingLot parkingLot) -> !parkingLot.isFull())
                    .findFirst().get();
        }catch(NoSuchElementException e){
            throw new ParkingLotFullException(e);
        }
        return currentParkingLot.park(car);
    }

    public boolean isFull() {
        return parkingLots.stream().allMatch((ParkingLot parkingLot) -> parkingLot.isFull());
    }

    public Car getCar(Receipt parkingTicket) {
        ParkingLot currentParkingLot = null;
        try {
            currentParkingLot = parkingLots.stream()
                    .filter((ParkingLot parkingLot) -> parkingLot.containCar(parkingTicket))
                    .findFirst().get();
        } catch (NoSuchElementException e) {
            return null;
        }
        return currentParkingLot.unPark(parkingTicket);
    }

    public void addParkingLot(String name, int size) {
        ParkingLot parkingLot = new ParkingLot(UUID.randomUUID().toString(),name,size);
        this.getParkingLotList().add(parkingLot);
    }



}
