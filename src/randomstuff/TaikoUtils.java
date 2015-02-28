/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomstuff;

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

}
