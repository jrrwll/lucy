package org.dreamcat.lucy.imgurl;

import org.dreamcat.rita.annotation.Injected;
import org.dreamcat.rita.annotation.PathVariable;
import org.dreamcat.rita.annotation.RitaBootApplication;
import org.dreamcat.rita.annotation.Route;
import org.dreamcat.rita.boot.RitaApplication;
import org.dreamcat.rita.renderer.ResponseEntity;

/**
 * Create by tuke on 2021/1/7
 */
@Route
@RitaBootApplication
public class LucyImageUrlApplication {

    @Injected
    private LucyImageUrlService service;

    public static void main(String[] args) {
        RitaApplication.run(LucyImageUrlApplication.class, args);
    }

    @Route(path = "/{year:[0-9]{4}]}/{month:[0-9]{2}]}/{name}")
    public ResponseEntity<?> download(
            @PathVariable("year") int year,
            @PathVariable("month") int month,
            @PathVariable("name") String name) {
        return service.download(year, month, name);
    }
}
