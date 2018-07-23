package com.thoughtworks.tdd.parklinglot.shell.controller;

import com.thoughtworks.tdd.parklinglot.core.ParkingBoy;
import com.thoughtworks.tdd.parklinglot.shell.io.Request;
import com.thoughtworks.tdd.parklinglot.shell.io.Response;

public class DeleteParkingLotController implements BaseController {
    private Request request;
    private Response response;
    private ParkingBoy parkingBoy;

    public DeleteParkingLotController(Request request, Response response, ParkingBoy parkingBoy) {
        this.request = request;
        this.response = response;
        this.parkingBoy = parkingBoy;
    }

    @Override
    public String process() {
        try {
            parkingBoy.deleteParkingLotById(request.getCommand());
            response.send("停车场删除成功！");
        }catch (ParkingLotNotEmptyException e1){
            response.send("停车场删除失败，原因：此停车场中，依然停有汽车，无法删除！");
        }catch (ParkingLotNotExistException e2){
            response.send("停车场删除失败，原因：此停车场不存在！");
        }
        return "forward:main";
    }
}
