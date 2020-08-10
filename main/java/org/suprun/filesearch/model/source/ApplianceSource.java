package org.suprun.filesearch.model.source;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplianceSource {

    static String fileName = "appliances_db.txt";

    public Stream<String> receiveApplianceStream() {
        Path path = null;
        Stream<String> applianceStream = Stream.empty();
        URL url = this.getClass().getClassLoader().getResource(fileName);
        if (url != null) {
            path = Path.of(url.getPath().substring(3));
        }
        try{
            applianceStream = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return applianceStream;
    }
}
