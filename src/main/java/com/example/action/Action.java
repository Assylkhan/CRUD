package com.example.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface Action {
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp);
}
