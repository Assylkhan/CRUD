package com.example.action;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
    private static Map<String, Action> actions = new HashMap<>();

    public ActionFactory() {
        actions.put("GET/", new ShowPageAction("home"));
        actions.put("GET/item", new ShowItemAction());
        actions.put("GET/items", new ShowItemsAction());
        actions.put("GET/new", new ShowPageAction("new"));
        actions.put("POST/create", new CreateItemAction());
        actions.put("GET/edit", new ShowEditItemAction());
        actions.put("POST/edit", new EditItemAction());
        actions.put("POST/delete", new DeleteItemAction());
    }

    public Action getAction(String actionName) {
        return actions.get(actionName);
    }
}
