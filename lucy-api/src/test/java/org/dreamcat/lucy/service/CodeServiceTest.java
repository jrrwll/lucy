package org.dreamcat.lucy.service;

import org.dreamcat.common.util.ClassLoaderUtil;
import org.dreamcat.lucy.BaseTest;
import org.dreamcat.lucy.service.impl.CodeServiceImpl;
import org.dreamcat.rita.annotation.Injected;
import org.junit.jupiter.api.Test;

/**
 * @author Jerry Will
 * @version 2025-11-05
 */
public class CodeServiceTest extends BaseTest {

    @Injected
    private CodeService codeService = new CodeServiceImpl();

    @Test
    void testFormat() throws Exception {
        String code = ClassLoaderUtil.getResourceAsString("codes/css.txt");
        String formatted = codeService.format(code, 4);
        System.out.println(formatted);
    }
}
