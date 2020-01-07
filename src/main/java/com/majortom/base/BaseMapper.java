package com.majortom.base;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BaseMapper<T> {

    /**
     * 增
     */
    @InsertProvider(method = "add",type= BaseSqlProvider.class)
    @Options(useGeneratedKeys=true)
    int add(T bean);

    /**
     * 删
     */
    @DeleteProvider(method = "delete",type=BaseSqlProvider.class)
    int delete(T bean);
    @DeleteProvider(method = "deleteById",type=BaseSqlProvider.class)
    int deleteById(Long id, Class clazz);


    /**
     * 改
     */
    @UpdateProvider(method = "update",type=BaseSqlProvider.class)
    int update(T bean);
    @UpdateProvider(method = "updateByColumn",type=BaseSqlProvider.class)
    int updateByColumn(Long id, Class clazz, String column, Object content);

    /**
     * 查
     */
    @SelectProvider(method = "get",type=BaseSqlProvider.class)
    T get(T bean);
    @SelectProvider(method = "getById",type=BaseSqlProvider.class)
    T getById(Long id, Class clazz);
    @SelectProvider(method = "count",type=BaseSqlProvider.class)
    int count(Class clazz);
    @SelectProvider(method = "getByLimit",type=BaseSqlProvider.class)
    List<T> getByLimit(Class clazz, int start, int limit);
    @SelectProvider(method = "getByColumn",type=BaseSqlProvider.class)
    List<T> getByColumn(Class clazz, String column, Object content);
}