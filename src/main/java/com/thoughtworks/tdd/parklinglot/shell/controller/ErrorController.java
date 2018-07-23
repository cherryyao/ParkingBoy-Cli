package com.thoughtworks.tdd.parklinglot.shell.controller;


import com.thoughtworks.tdd.parklinglot.shell.io.Request;
import com.thoughtworks.tdd.parklinglot.shell.io.Response;

public class ErrorController implements BaseController {
    private Request request;
    private Response response;

    public ErrorController(Request request, Response response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String process() {
        response.send("非法指令，请查证后再输入");
        return "forward:main";
    }
}
