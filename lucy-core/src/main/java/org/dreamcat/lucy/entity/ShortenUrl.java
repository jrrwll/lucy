package org.dreamcat.lucy.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.util.Date;

/**
 * Create by tuke on 2020/5/13
 */
@Data
@Table("shorten_url")
public class ShortenUrl {
    @Id
    private String hash;
    private String url;
    private String password;
    private Date expiredAt;
}
