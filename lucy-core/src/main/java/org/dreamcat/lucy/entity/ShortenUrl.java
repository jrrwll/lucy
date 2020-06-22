package org.dreamcat.lucy.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * Create by tuke on 2020/5/13
 */
@Data
@Table("shorten_url")
public class ShortenUrl {
    @PrimaryKey
    private String hash;
    private String url;
    private String password;
}
