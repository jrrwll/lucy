package org.dreamcat.lucy.service.impl;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import lombok.extern.slf4j.Slf4j;
import org.dreamcat.common.web.exception.BadRequestException;
import org.dreamcat.lucy.service.CodeService;
import org.springframework.stereotype.Service;

/**
 * Create by tuke on 2020/6/22
 */
@Slf4j
@Service
public class CodeServiceImpl implements CodeService {

    // Instances of the formatter are immutable and thread-safe.
    private final Formatter formatter = new Formatter();

    @Override
    public String format(String code, String style) {
        try {
            return formatter.formatSource(code);
        } catch (FormatterException e) {
            throw new BadRequestException("invalid input");
        }
    }

    @Override
    public String compact(String code) {
        return null;
    }
}
