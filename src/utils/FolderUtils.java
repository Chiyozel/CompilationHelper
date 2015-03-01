/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Gezochan
 */
public class FolderUtils {

    public static CopyOnWriteArrayList<File> listFiles(final File folder) {
        CopyOnWriteArrayList<File> files = new CopyOnWriteArrayList<>();
        if (folder.isDirectory()) {
            for (final File file : folder.listFiles()) {
                if (file.getName().endsWith(".osu")) {
                    files.add(file);
                }
            }
        }
        return files;
    }
}
