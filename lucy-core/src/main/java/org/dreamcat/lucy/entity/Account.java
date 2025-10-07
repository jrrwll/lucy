package org.dreamcat.lucy.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * Create by tuke on 2020/5/14
 */
@Data
@Table("account")
public class Account {
    @Id
    private Long uid;
    private String token;
}
