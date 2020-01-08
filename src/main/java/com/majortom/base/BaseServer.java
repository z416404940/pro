package com.majortom.base;


import com.majortom.annotation.Exclude;
import com.majortom.annotation.PrimaryKey;
import com.majortom.utils.DBHelper;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class BaseServer<T,K> {

    private Class<T> tClass;
    private Class<K> kClass;
    private BaseMapper mapper;
    public BaseServer() {
        tClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        kClass = (Class<K>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        mapper =(BaseMapper)DBHelper.getMapper(kClass);
    }

    /**
     * 增
     */
    public boolean add(T bean){
        ziZeng(bean);
        return mapper.add(bean)>0;
    }

    public void ziZeng(T bean) {
        List<Field> pfields = getPrimarkKeyFields(bean.getClass());
        pfields.get(0).setAccessible(true);
        try {
            pfields.get(0).set(bean, getMaxId()+1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删
     */
    public boolean delete(T bean){
        return mapper.delete(bean)>0;
    }
    public boolean deleteById(Long id){
        return mapper.deleteById(id,tClass)>0;
    }

    /**
     * 改
     */
    public boolean update(T bean){
        return mapper.update(bean)>0;
    }
    public boolean updateByColumn(Long id,String column,Object content){
        return mapper.updateByColumn(id,tClass,column,content)>0;
    }

    /**
     * 查
     */
    public T get(T bean){
        return (T)mapper.get(bean);
    }
    public T getById(Long id){
        return (T)mapper.getById(id,tClass);
    }
    public int count(){
        return mapper.count(tClass);
    }
    public Long getMaxId(){
        return mapper.getMaxId(tClass)==null?0L:mapper.getMaxId(tClass);
    }
    public List<T> getByLimit(int start, int limit){
        return mapper.getByLimit(tClass,start,limit)==null?new ArrayList<T>():mapper.getByLimit(tClass,start,limit);
    }
    public List<T> getByColumn(String column,Object content){
        return mapper.getByColumn(tClass,column,content)==null?new ArrayList<T>():mapper.getByColumn(tClass,column,content);
    }
    public Object getColumn(Long id,String column){return mapper.getColumn(tClass, id, column);}


    public List<Field> getPrimarkKeyFields(Class clazz) {
        List<Field> primaryKeyField = new ArrayList<>();
        List<Field> fields = getFields(clazz);
        for (Field field : fields) {
            field.setAccessible(true);
            PrimaryKey key = field.getAnnotation(PrimaryKey.class);
            if (key != null) {
                primaryKeyField.add(field);
            }
        }
        return primaryKeyField;
    }
    public List<Field> getFields(Class clazz) {
        List<Field> fieldList = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Exclude key = field.getAnnotation(Exclude.class);
            if (key == null) {
                fieldList.add(field);
            }
        }
        return fieldList;
    }
}
