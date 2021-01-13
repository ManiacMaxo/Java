package org.elsys.victor.services;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class IndexService {

    public File[] listDir(String path) {
//        FilenameFilter filter = (dir, name) -> name.startsWith(".");
        File file = new File(path);
        if (!file.isDirectory()) return null;
        return file.listFiles();
    }
}
