package com.example.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ShowPageAction implements Action {

    private ActionResult result;

    public ShowPageAction(String result) {
        this.result = new ActionResult(result);
    }

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        return result;
    }
}
