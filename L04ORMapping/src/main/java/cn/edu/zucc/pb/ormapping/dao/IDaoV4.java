package cn.edu.zucc.pb.ormapping.dao;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-03-19 10:27
 */
public interface IDaoV4<T> {
    T getEntity(String key, String clazz);
}
