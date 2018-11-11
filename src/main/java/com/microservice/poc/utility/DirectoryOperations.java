package com.microservice.poc.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Lukman.Arogundade on 8/11/2015.
 */
public class DirectoryOperations {

    private static final Logger logger = LoggerFactory.getLogger(DirectoryOperations.class);


    public static boolean getNotificationStatement(Path filePath) {

        try {

            File file = new File(filePath.toFile().getAbsolutePath());
            if (file.exists()) {
                return true;
            }

        } catch (Exception x) {
            logger.error("getFilesInDirectory Exception: " + x.getMessage());
        }
        return false;
    }


    public static Path RenameFile(Path oldFileName, Path newFileName) {

        try {

            File file = new File(newFileName.toFile().getAbsolutePath());

            if (file.exists()) {
                if (file.delete()) {

                    logger.info(file.getName() + " is deleted!");

                } else {

                    logger.error("Delete operation failed.");
                }
            }

            if (oldFileName.toFile().renameTo(newFileName.toAbsolutePath().toFile())) {
                logger.info("Moved successful to :" + newFileName);
            } else {
                logger.error("Moved failed " + oldFileName);
            }
        } catch (Exception ex) {
            logger.error("[RenameFile()] " + ex.getMessage());
        }

        return newFileName;

    }

    public static String getFile(Path directoryName, String fileName) {//TODO Only PDF files

        File startingDirectory = new File(directoryName.toFile().getAbsolutePath());

        String fileInSFTP = null;
        /*
         * CHECK IF DIRECTORY IF VALID
         */
        validateDirectory(startingDirectory);

        Path dir = Paths.get(directoryName.toFile().getAbsolutePath());

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{pdf}")) {//PICK ONLY PDF FILES
            //  try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) { //PICK ANY FILES

            int i = 0;
            for (Path entry : stream) {

                if (fileName.equalsIgnoreCase(entry.getFileName().toString())) {
                    fileInSFTP = entry.getFileName().toString();
                    break;
                } else {
                    i++;
                    // continue;
                }
            }
        } catch (IOException x) {
            logger.error("getFile Exception: " + x.getMessage());
        }
        return fileInSFTP;
    }

    public static void validateDirectory(File aDirectory) {
        try {
            if (aDirectory == null) {
                throw new IllegalArgumentException("Directory should not be null.");
            }
            if (!aDirectory.exists()) {
                throw new FileNotFoundException("Directory does not exist: "
                        + aDirectory);
            }
            if (!aDirectory.isDirectory()) {
                throw new IllegalArgumentException("Is not a directory: "
                        + aDirectory);
            }
            if (!aDirectory.canRead()) {
                throw new IllegalArgumentException("Directory cannot be read: "
                        + aDirectory);
            }
        } catch (FileNotFoundException e) {
            logger.error("[validateDirectory ()] " + e.getMessage());
        }
    }

    public static int CountFilesInDirectory(Path directoryName) {
        int fileLength = 0;
        try {
            fileLength = new File(directoryName.toFile().getAbsolutePath()).listFiles().length;
        } catch (Exception e) {
            logger.error("[CountFilesInDirectory ()]" + e.getMessage());
        }
        return fileLength;

    }
}
