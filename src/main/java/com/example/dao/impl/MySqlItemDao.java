package com.example.dao.impl;

import com.example.dao.DaoException;
import com.example.dao.ItemDao;
import com.example.entity.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlItemDao implements ItemDao {
    private Connection connection;
    private static final String INSERT = "INSERT INTO ITEM (NAME, DESCRIPTION, COST) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE ITEM SET NAME=?, DESCRIPTION=?, COST=? WHERE ID=?";
    private static final String DELETE = "DELETE FROM ITEM WHERE ID=?";
    private static final String SELECT_BY_ID = "SELECT * FROM ITEM WHERE ID=?";
    private static final String SELECT_ALL = "SELECT * FROM ITEM";

    public MySqlItemDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Item insert(Item item) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setString(3, item.getCost());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0)
                throw new DaoException("inserting item failed, no rows affected");
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    Long id = resultSet.getLong(1);
                    item.setId(id);
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return item;
    }

    @Override
    public void update(Item item) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setString(3, item.getCost());
            statement.setLong(4, item.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteById(Long id) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Item findById(Long id) throws DaoException {
        Item item = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    item = getItemBean(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return item;
    }

    private Item getItemBean(ResultSet resultSet) throws SQLException {
        Item item = new Item();
        item.setId(resultSet.getLong("ID"));
        item.setName(resultSet.getString("NAME"));
        item.setDescription(resultSet.getString("DESCRIPTION"));
        item.setCost(resultSet.getString("COST"));
        return item;
    }

    @Override
    public List findAll() throws DaoException {
        List<Item> items = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_ALL)) {
                while (resultSet.next()) {
                    items.add(getItemBean(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return items;
    }
}
