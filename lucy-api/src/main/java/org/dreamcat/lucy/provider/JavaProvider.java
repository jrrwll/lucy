package org.dreamcat.lucy.provider;

import com.palantir.javaformat.java.Formatter;
import com.palantir.javaformat.java.JavaFormatterOptions;
import lombok.SneakyThrows;

/**
 * @author Jerry Will
 * @version 2025-11-05
 */
public class JavaProvider {

    @SneakyThrows
    public String format(String code, int ident) {
        JavaFormatterOptions options = JavaFormatterOptions.builder()
                .style(JavaFormatterOptions.Style.PALANTIR)
                .build();
        return Formatter.createFormatter(options).formatSource(code);
    }
}
