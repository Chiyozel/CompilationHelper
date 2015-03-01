/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.List;
import utils.Note;

/**
 *
 * @author Gezochan
 */
public class TaikoUtils {

    public static void invertAllHitsounds(List<Note> list) {
        list.stream().forEach((Note n) -> {
            int hs = n.getHitsound();
            if (((hs >> 1) & 1) == 1 || ((hs >> 3) & 1) == 1) {
                if (((hs >> 2) & 1) == 1) {
                    n.setHitsound(4);
                } else {
                    n.setHitsound(0);
                }
            } else {
                if (((hs >> 2) & 1) == 1) {
                    n.setHitsound(12);
                } else {
                    n.setHitsound(8);
                }
            }
        });
    }

    public static void capsNotes(List<Note> list) {
        list.stream().forEach((n) -> {
            int hs = n.getHitsound();
            if (((hs >> 1) & 1) == 1 || ((hs >> 3) & 1) == 1) {
                n.setHitsound(12);
            } else {
                n.setHitsound(4);
            }
        });
    }

    public static void randomize(List<Note> list) {
        list.stream().forEach((n) -> {
            int hs = (int) (2 * Math.random());
            hs *= 8;
            n.setHitsound(hs);
        });
    }

    public static void center(Note n) {
        n.moveTo(256, 192);
    }

    public static void centerAllNotes(List<Note> list) {
        list.stream().forEach((n) -> {
            center(n);
        });
    }

    public static void sortNote(Note n) {
        int hs = n.getHitsound();
        if (((hs >> 1) & 1) == 1 || ((hs >> 3) & 1) == 1) {
            if (((hs >> 2) & 1) == 1) {
                n.moveTo(64,64);
            } else {
                n.moveTo(64,320);
            }
        } else {
            if (((hs >> 2) & 1) == 1) {
                n.moveTo(448,64);
            } else {
                n.moveTo(448,320);
            }
        }
    }
    
    public static void sortAllNotes(List<Note> list){
        list.stream().forEach((n) -> {
            sortNote(n);
        });
    }
}
