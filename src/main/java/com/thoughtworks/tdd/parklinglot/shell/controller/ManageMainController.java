package com.thoughtworks.tdd.parklinglot.shell.controller;

import com.thoughtworks.tdd.parklinglot.shell.io.Request;
import com.thoughtworks.tdd.parklinglot.shell.io.Response;

public class ManageMainController implements BaseController {
    private Request request;
    private Response response;

    public ManageMainController(Request request, Response response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String process() {
        response.send("1.查看停车场详情\n" +
                "2.添加停车场\n" +
                "3.删除停车场");
        return "main/2";
    }
}