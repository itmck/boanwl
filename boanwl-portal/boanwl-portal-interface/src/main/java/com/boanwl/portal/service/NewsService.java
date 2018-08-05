package com.boanwl.portal.service;

import com.boanwl.common.dto.NewsSlorDTO;

/**
 * User: Boan
 * Date: 2018/8/5
 * Time: 15:52
 * Version:V1.0
 */
public interface NewsService {

    NewsSlorDTO search(String keyword, int page, int rows)  throws Exception;

}
