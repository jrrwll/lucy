package org.dreamcat.lucy;

import org.dreamcat.rita.annotation.RitaBootApplication;
import org.dreamcat.rita.boot.RitaApplication;

/**
 * Create by tuke on 2020/5/13
 */
@RitaBootApplication
public class LucyApplication {

    public static void main(String[] args) {
        // RitaApplication.run(LucyApplication.class, args);
        RitaApplication app = RitaApplication.create(LucyApplication.class, args);
        app.start();
    }
}
