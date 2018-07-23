package com.thoughtworks.tdd.parklinglot.shell.controller;

import com.thoughtworks.tdd.parklinglot.core.ParkingBoy;
import com.thoughtworks.tdd.parklinglot.shell.io.Request;
import com.thoughtworks.tdd.parklinglot.shell.io.Response;

public class MainController implements BaseController {
    private final Request request;
    private final Response response;
    private ParkingBoy parkingBoy;

    public MainController(Request request, Response response) {

        this.request = request;
        this.response = response;
    }


    @Override
    public String process() {
        response.send("1.停车服务\n" +
                "2.停车场管理\n" +
                "请输入您要进入的页面：");
        return "";
    }
}
