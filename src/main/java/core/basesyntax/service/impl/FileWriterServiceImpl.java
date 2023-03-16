package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void write(File file, String data) {
        try {
            if (!file.getParentFile().getName().equals("resources")) {
                throw new RuntimeException("Wrong path: " + file.toPath());
            }
            Files.writeString(file.toPath(), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + file.toPath());
        }
    }
}