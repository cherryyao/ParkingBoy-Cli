package com.thoughtworks.tdd.parklinglot.shell.controller;

import com.thoughtworks.tdd.parklinglot.core.ParkingBoy;
import com.thoughtworks.tdd.parklinglot.shell.io.Request;
import com.thoughtworks.tdd.parklinglot.shell.io.Response;

public class AddParkinglotController implements BaseController {
    private Request request;
    private Response response;
    private ParkingBoy parkingBoy;

    public AddParkinglotController(Request request, Response response, ParkingBoy parkingBoy) {
        this.request = request;
        this.response = response;
        this.parkingBoy = parkingBoy;
    }

    @Override
    public String process() {
        String[] build = request.getCommand().split("-");
        if(build.length != 2){
            response.send("输入格式有误！正确格式为（名称-车位）");
        }else{
            String name = build[0];
            String size = build[1];
            parkingBoy.addParkingLot(name,Integer.parseInt(size));
            response.send("停车场添加成功！");
        }
        return "forward:main";
    }
}