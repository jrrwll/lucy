package org.dreamcat.lucy.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Create by tuke on 2020/6/22
 */
public interface NetworkService {

    String detectIP(HttpServletRequest request);
}
