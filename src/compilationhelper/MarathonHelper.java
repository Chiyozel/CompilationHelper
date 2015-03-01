/*
 * I personnally wouldn't want to commentate that but yeah since you guys
 * are probably reading that better commentate the shit out of that code.
 * Also, LE DESSERT.
 */
package compilationhelper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.FolderUtils;
import utils.MapUtils;

/**
 *
 * @author Gezochan
 */
public class MarathonHelper extends MapUtils implements FolderUtils {

    /**
     * Constructor of NoteChart.
     */
    public MarathonHelper() {

        /* You know, to input the values you need that, in console.*/
        Scanner sc = new Scanner(System.in);

        /* This is so we know whether the file is new or not */
        this.isNewFile = false;

        /* Checks if the osu!maps folder exists. If it's not the case, then the
         program creates it. It will close itself after 5 seconds.
         */
        folder = new File("./osuMaps/");
        boolean created = FolderUtils.checkForFolder(folder);
        if (created) {
            closeProgram();
        }
        /* Input file Array. Since the folder exists, it will search for maps
         in the folder ./osuMaps — and adds a file f if for some reason one
         gets to use 1 file only (not supported yet).
         */
        CopyOnWriteArrayList<File> files = FolderUtils.listFiles(new File("./osuMaps/"));
        if (f != null) {
            files.add(f);
        }

        /* Output file. I think I'll leave it as Notes.osu, despite the .osu
         extension being technically unnecessary since the user just has to
         append the output file to the used .osu file.
         The file, if not existing, must be created.
         */
        newChart = new File("./Notes.osu");
        if (!newChart.exists()) {
            try {
                System.out.println("Notes.osu created.");
                newChart.createNewFile();
                isNewFile = true;
            } catch (IOException ex) {
                Logger.getLogger(MarathonHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        /* Creates an empty list of notes and then processes the files in the 
         folder.
         If there are no files present, it will notice the user.
         */
        notes = new CopyOnWriteArrayList<>();
        if (files.size() > 0) {
            files.stream().forEach((file) -> {
                extractNotes(file, sc);
            });
        } else {
            System.out.println("No files found!");
        }
        /* Closes the program after 5 seconds. */
        closeProgram();
    }

    /**
     * Constructor of NoteChart. Does the same thing except that it will take
     * one more file.
     *
     * @param input The known file.
     */
    public MarathonHelper(File input) {
        this();
        f = input;
    }

    /**
     * Checks if the folder exists.
     *
     * @return boolean
     */
    /**
     *
     * @return a string containing all the notes.
     */
    @Override
    public String toString() {

        String s = "Notes :\n";
        s = notes.stream().map((n) -> n.toString() + "\n").reduce(s, String::concat);
        return s;
    }

    /**
     * Closes the program automatically.
     */
    private void closeProgram() {
        System.out.println("This program will close itself in 5 seconds.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MarathonHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }

}
