/*
 * I personnally wouldn't want to commentate that but yeah since you guys
 * are probably reading that better commentate the shit out of that code.
 * Also, LE DESSERT.
 */
package compilationhelper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Note;

/**
 *
 * @author Gezochan
 */
public class NoteChart {

    private File newChart;
    private File file;
    private final int startTime;
    private final int endTime;
    private final int copyMarker;
    private final String filePath;
    private CopyOnWriteArrayList<Note> notes;
    private boolean isNewFile;

    /**
     * Constructor of NoteChart.
     */
    public NoteChart() {

        /* You know, to input the values you need that, in console.*/
        Scanner sc = new Scanner(System.in);

        /* This is so we know whether the file is new or not */
        this.isNewFile = false;

        /* Input file.
         This should be changed, someday. I will certainly make a
         file-per-file thing, but right now it's already working wonders.
         */
        file = new File("./ToCopy.osu");

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
                Logger.getLogger(NoteChart.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        /* Creates an empty list of notes.*/
        notes = new CopyOnWriteArrayList<>();


        /* Tells you what's the map to scan. filePath is a String that's usedfor
         listNotes.
         */
        System.out.println("Absolute path of the file to scan: " + file.getAbsolutePath());
        filePath = file.getAbsolutePath();

        /* Where to extract notes. Useful for deleteNotes(). */
        System.out.println("Enter the beginning of the section to extract (ms)");
        startTime = sc.nextInt();
        System.out.println("Enter the end of the section to extract (ms)");
        endTime = sc.nextInt();

        /* Lists notes in the whole osu! chart, then deletes them to keep only
         the interesting section the user keyed in.
         */
        this.listNotes();
        System.out.println("List created. Deletion of unnecessary notes...");
        this.deleteNotes();

        /* Then, after the deletion is finished, there's almost no chance
         the notes from the original map will end up in the compilation.
         So, the user must key in his desired spot for the first note.
         */
        System.out.println("Deletion complete. Where do you want to put the notes?");
        copyMarker = sc.nextInt();

        /* And then, the file is outputted.*/
        this.createFile();

    }

    /**
     * Method that makes the list of all the notes.
     */
    public void listNotes() {
        try {

            /* These objects are here to read the file from "osu blabla" to the
             last note recoded on the file. Basically, it will read the whole
             file, "ignoring" everything before [HitObjects], which is the
             most important thing.
             */
            InputStream i = new FileInputStream(filePath);
            InputStreamReader r = new InputStreamReader(i);
            BufferedReader br = new BufferedReader(r);
            /* String that will be the line to read */
            String l;

            /* While the line read isn't [HitObjects], do nothing at all.
             However, to make sure the user knows what he's copying, the map
             details is displayed, and gets confirmed or not.
             */
            while (!(l = br.readLine()).equalsIgnoreCase("[HitObjects]")) {
                if (l.startsWith("TitleUnicode:")
                        || l.startsWith("Version:")
                        || l.startsWith("Creator:")) {
                    System.out.println(l);
                }
            }

            /* Then, at that point, we read every line since now every line is
             a note, and create a note off the line. Yeah the new Note(blah) is
             long.
             */
            while ((l = br.readLine()) != null) {
                String[] values = l.split(",");
                String params = "";
                for (int index = 5; index < values.length; index++) {
                    params += values[index];
                }
                notes.add(new Note(
                        Integer.parseInt(values[0]),
                        Integer.parseInt(values[1]),
                        Long.parseLong(values[2]),
                        Integer.parseInt(values[3]),
                        Integer.parseInt(values[4]),
                        params)
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Deletes unnecessary notes from the notechart.
     */
    public void deleteNotes() {
        /* For each note that isn't in the range, delete it. */
        notes.stream().filter((n) -> (n.getMillis() < startTime || n.getMillis() > endTime)).forEach((n) -> {
            notes.remove(n);
        });
    }

    /**
     * Creates a new file.
     */
    public void createFile() {
        /* Difference so the notes are ACTUALLY moved */
        int difference = copyMarker - startTime;

        try {
            /* These objects are here to write the file to "Notes.osu" from
             the first to last note in the ArrayList.            
             */
            FileWriter fw = new FileWriter(newChart, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            /* For each note in the list, append it to the file.
             Output the addition of the note to the console because why not?
             */
            if (this.isNewFile) {
                pw.append("// Copy-paste the section below to your .osu file.");
                bw.newLine();
                pw.append("[HitObjects");
                bw.newLine();
            }

            for (Note n : notes) {
                n.move(difference);
                pw.append(n.outputOsuFile());
                bw.newLine();
                System.out.println("Note (" + n.toString() + ") \t-------- Added to " + newChart.getName());
            }

            /* Close the file (better....) */
            pw.close();

            /* something */
            System.out.println("Notes added to " + newChart.getName() + ".");

        } catch (IOException ex) {
            Logger.getLogger(NoteChart.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

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
}
