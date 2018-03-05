package com.zhoulin.demo.service.search;

/**
 * 检索接口
 */
public interface SearchService {

    /**
     * 索引目标资讯
     * @param id
     */
    boolean index(long id);

    /**
     * 移除资讯索引
     * @param id
     */
    void remove(long id);


}
