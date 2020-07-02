package com.zyd.blog.framework.object;

import java.util.List;

/**


 * @version 1.0
 * @date 2019/4/16 16:26
 * @since 1.0
 */
public interface AbstractService<T, PK> {

    T insert(T entity);

    default void insertList(List<T> entities) {

    }

    boolean removeByPrimaryKey(PK primaryKey);

    boolean updateSelective(T entity);

    T getByPrimaryKey(PK primaryKey);

    default List<T> listAll() {
        return null;
    }
}