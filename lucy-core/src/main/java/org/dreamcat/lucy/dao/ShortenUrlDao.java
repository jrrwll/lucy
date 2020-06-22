package org.dreamcat.lucy.dao;

import org.dreamcat.lucy.entity.ShortenUrl;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

/**
 * Create by tuke on 2020/5/13
 */
@Repository
public interface ShortenUrlDao extends CassandraRepository<ShortenUrl, String> {

}
