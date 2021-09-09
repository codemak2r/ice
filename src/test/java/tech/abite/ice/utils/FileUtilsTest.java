package tech.abite.ice.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

@Slf4j
public class FileUtilsTest {
    @Test
    public void testLoopClassFiles(){
        List<File> fileList = FileUtils.loopClassFiles("/Users/jackson/projects/stock-admin/stock-admin/target");
        for(File file : fileList) {
            log.info(file.getAbsolutePath());
        }
    }
}
