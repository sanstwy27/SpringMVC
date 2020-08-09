package com.atkjs927.dao;

import com.atkjs927.bean.Lock;

public interface LockDao {

    public Lock getLockById(Integer id);
    public Lock getLockByIdSimple(Integer id);
    public Lock getLockByIdByStep(Integer id);
}
