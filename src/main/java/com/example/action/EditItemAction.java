package com.example.action;

import com.example.dao.DaoException;
import com.example.dao.DaoFactory;
import com.example.dao.DaoManager;
import com.example.dao.ItemDao;
import com.example.entity.Item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditItemAction implements Action {
    private ActionResult result = new ActionResult("items", true);

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        DaoFactory daoFactory = (DaoFactory) req.getServletContext().getAttribute("daoFactory");
        DaoManager daoManager = daoFactory.getDaoManager();
        ItemDao itemDao = daoManager.getItemDao();
        Long id = Long.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String cost = req.getParameter("cost");
        Item item = new Item();
        item.setId(id);
        item.setName(name);
        item.setDescription(description);
        item.setCost(cost);
        itemDao.update(item);
        return result;
    }
}
