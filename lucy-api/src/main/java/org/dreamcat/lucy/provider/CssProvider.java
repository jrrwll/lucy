package org.dreamcat.lucy.provider;

import com.helger.commons.system.ENewLineMode;
import com.helger.css.*;
import com.helger.css.decl.*;
import com.helger.css.reader.*;
import com.helger.css.writer.*;
import lombok.SneakyThrows;
import org.dreamcat.common.util.StringUtil;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author Jerry Will
 * @version 2025-11-05
 */
public class CssProvider {

    @SneakyThrows
    public String format(String code, int ident) {
        CascadingStyleSheet sheet = CSSReader.readFromString(code, StandardCharsets.UTF_8, ECSSVersion.CSS30);
        if (sheet == null) {
            return code;
        }

        CSSWriterSettings settings = new CSSWriterSettings(ECSSVersion.CSS30)
                .setIndent(StringUtil.repeat(' ', ident))
                .setNewLineMode(ENewLineMode.UNIX);

        try (StringWriter writer = new StringWriter()) {
            new CSSWriter(settings).writeCSS(sheet, writer);
            return writer.toString();
        }
    }
}
