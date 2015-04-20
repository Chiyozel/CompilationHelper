/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.FolderUtils;
import utils.MapUtils;
import utils.Storyboard;
import utils.TaikoUtils;

/**
 *
 * @author Gezochan
 */
public class TaikoReader extends MapUtils implements FolderUtils {

    /**
     * Constructor of NoteChart.
     */
    public TaikoReader() {

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
        newChart = new File("./TaikoNew.osu");
        if (!newChart.exists()) {
            try {
                System.out.println("Taiko.osu created.");
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
                readMap(file);
                if (contents.contains("Mode: 1")) {
                    taikoModification(file, sc);
                }
            });
        } else {
            System.out.println("No files found!");
        }
        /* Closes the program after 5 seconds. */
        closeProgram();
    }

    /**
     *
     * @return a string containing all the notes.
     */
    @Override
    public String toString() {
        
        String s = "Notes :\n";
    //    s = notes.stream().map((n) -> n.toString() + "\n").reduce(s, String::concat);
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

    /**
     * Modifies the Taiko map.
     */
    /**
     * Processes a map file.
     *
     * @param file
     * @param sc
     */
    private void taikoModification(File file, Scanner sc) {
        f = file;
        int type;

        /* Tells you what's the map to scan. filePath is a String that's usedfor
         listNotes.
         */
        filePath = f.getAbsolutePath();

        /* Asks the user if they want to process a file. Sometimes they may be
         clumsy and put a file without knowing. */
        System.out.println("Do you want to scan this file? (y/n) ");
        if (sc.next().equals("y")) {

            /* Where to extract notes. Useful for deleteNotes(). */
            System.out.println(
                    "What do you want to do?\n"
                    + "1.\tAbekobe mode (Invert all hitsounds)\n"
                    + "2.\tAll notes are big notes\n"
                    + "3.\tRandomize the map\n"
                    + "4.\tCenter all notes\n"
                    + "5.\tPart all notes per hitsound\n"
            );
            type = sc.nextInt();
            /* Lists notes in the whole osu! chart, then deletes them to keep only
             the interesting section the user keyed in.
             */
            this.copyMap();
            System.out.println("List created. Applying modification");
            switch (type) {
                case 1:
                    TaikoUtils.invertAllHitsounds(notes);
                    break;
                case 2:
                    TaikoUtils.capsNotes(notes);
                    break;
                case 3:
                    TaikoUtils.randomize(notes);
                    break;
                case 4:
                    TaikoUtils.centerAllNotes(notes);
                    break;
                case 5:
                    TaikoUtils.sortAllNotes(notes);
                    break;
                default:
                    System.out.println("Wrong choice.");
            }

            /* Then, after the deletion is finished, there's almost no chance
             the notes from the original map will end up in the compilation.
             So, the user must key in his desired spot for the first note.
             */
            System.out.println("Application of modification complete.");
            /* And then, the file is outputted.*/
        //    this.createFile();
        }
    }
    
    private boolean isTaikoMap() {
        return contents.contains("Mode: 1\nLetterboxInBreaks");
    }
}
