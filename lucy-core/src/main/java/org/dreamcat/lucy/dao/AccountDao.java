package org.dreamcat.lucy.dao;

import static org.dreamcat.lucy.entity.table.AccountTableDef.ACCOUNT;

import com.mybatisflex.core.BaseMapper;
import com.mybatisflex.core.query.QueryWrapper;
import org.dreamcat.lucy.entity.Account;

/**
 * Create by tuke on 2020/5/14
 */
public interface AccountDao extends BaseMapper<Account> {

    default Account findByToken(String token) {
        QueryWrapper query = QueryWrapper.create()
                .from(ACCOUNT).where(Account::getToken).eq(token);
        return selectOneByQuery(query);
    };
}
