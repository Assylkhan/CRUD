package com.example.action;

import com.example.dao.DaoFactory;
import com.example.dao.DaoManager;
import com.example.dao.ItemDao;
import com.example.entity.Item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowEditItemAction implements Action {
    private ActionResult result = new ActionResult("edit");

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        DaoFactory daoFactory = (DaoFactory) req.getServletContext().getAttribute("daoFactory");
        DaoManager daoManager = daoFactory.getDaoManager();
        ItemDao itemDao = daoManager.getItemDao();
        Long id = Long.valueOf(req.getParameter("id"));
        Item item = itemDao.findById(id);
        req.setAttribute("item", item);
        return result;
    }
}
