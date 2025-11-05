package org.dreamcat.lucy.service;

/**
 * Create by tuke on 2020/6/22
 */
public interface CodeService {

    String format(String code, Integer ident);

    String compact(String code);

}
