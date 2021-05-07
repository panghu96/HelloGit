package com.aura.git;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Author:panghu
 * Date:2021-05-07
 * Description:
 */
public class DeleteDir {
    public static void main(String[] args) {
        deleteAllByPath(new File("D:\\develop\\workspace\\git_clone"));
    }


    private static boolean deleteAllByPath(File rootFilePath) {
        File[] needToDeleteFiles = rootFilePath.listFiles();
        if (needToDeleteFiles == null) {
            return true;
        }
        for (int i = 0; i < needToDeleteFiles.length; i++) {
            if (needToDeleteFiles[i].isDirectory()) {
                deleteAllByPath(needToDeleteFiles[i]);
            }
            try {
                Files.delete(needToDeleteFiles[i].toPath());
            } catch (IOException e) {
                System.out.println("Delete temp directory or file failed." + e.getMessage());
                return false;
            }
        }
        return true;
    }
}
