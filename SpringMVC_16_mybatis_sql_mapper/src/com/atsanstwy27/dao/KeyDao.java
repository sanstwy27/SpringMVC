package com.atkjs927.dao;

import com.atkjs927.bean.Key;

import java.util.List;

public interface KeyDao {

    public Key getKeyById(Integer id);
    public Key getKeyByIdSimple(Integer id);
    public List<Key> getKeysByLockId(Integer id);
}
