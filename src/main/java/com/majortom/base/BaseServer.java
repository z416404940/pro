package com.majortom.base;


import com.majortom.utils.DBHelper;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unchecked")
public class BaseServer<T,K> {

    private BaseMapper mapper;
    private Class<T> tClass;

    public BaseServer() {
        tClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Class<K> kClass = (Class<K>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        mapper = (BaseMapper)DBHelper.getMapper(kClass);
    }

    /**
     * 增
     */
    public boolean add(T bean){
        return mapper.add(bean)>0;
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
    public List<T> getByLimit(int start, int limit){
        return mapper.getByLimit(tClass,start,limit);
    }
    public List<T> getByColumn(String column,Object content){
        return mapper.getByColumn(tClass,column,content);
    }
}
