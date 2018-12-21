package com.employee.util;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImagePath {

    public static String uploadDirectory ="C:\\Users\\Sarkhan\\Desktop\\test";

        public static String deploy(MultipartFile uploadFile) throws IOException {

        File convFile = new File(uploadFile.getOriginalFilename());

            System.out.println("filename : " + convFile.getName());
            String filename = convFile.getName();
            moveFileToDirectory(convFile, uploadDirectory);
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(uploadFile.getBytes());
            fos.close();
           return filename;
        }

    private static boolean moveFileToDirectory(File sourceFile, String targetPath) {
        File tDir = new File(targetPath);
        if (tDir.exists()) {
            String newFilePath = targetPath + File.separator + sourceFile.getName();
            File movedFile = new File(newFilePath);
            if (movedFile.exists())
                movedFile.delete();
            return sourceFile.renameTo(new File(newFilePath));
        } else {
            System.out.println("unable to move file " + sourceFile.getName() + " to directory " + targetPath + " -> target directory does not exist");
            return false;
        }
    }
}
