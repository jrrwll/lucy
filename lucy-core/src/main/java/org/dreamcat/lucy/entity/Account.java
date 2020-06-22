package org.dreamcat.lucy.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * Create by tuke on 2020/5/14
 */
@Data
@Table("account")
public class Account {
    @PrimaryKey
    private Long uid;
    private String token;
}
