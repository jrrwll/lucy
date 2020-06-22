package org.dreamcat.lucy.dao;

import org.dreamcat.lucy.entity.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

/**
 * Create by tuke on 2020/5/14
 */
@Repository
public interface AccountDao extends CassandraRepository<Account, Long> {

    Account findByToken(String token);
}
