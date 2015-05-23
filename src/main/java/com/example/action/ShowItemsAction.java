package com.example.action;

import com.example.dao.DaoFactory;
import com.example.dao.DaoManager;
import com.example.dao.ItemDao;
import com.example.entity.Item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowItemsAction implements Action {
    private ActionResult result = new ActionResult("items");

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        DaoFactory daoFactory = (DaoFactory) req.getServletContext().getAttribute("daoFactory");
        DaoManager daoManager = daoFactory.getDaoManager();
        ItemDao itemDao = daoManager.getItemDao();
        List<Item> items = itemDao.findAll();
        req.setAttribute("items", items);
        return result;
    }
}
