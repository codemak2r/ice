package tech.abite.ice.utils;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

public class FileUtils {
    private static String CLASS_SUFFIX = "class";

    public static List<File> loopClassFiles(String path){
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return FileUtil.getSuffix(file).equals(CLASS_SUFFIX);
            }
        };

        return FileUtil.loopFiles(FileUtil.getAbsolutePath(path), fileFilter);
    }
}
