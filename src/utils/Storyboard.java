/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author Gezochan
 */
public class Storyboard {


    public static void reverseScroll(List<Note> list) {
        int noteCount = list.size();
        String a = "";
        for (int i = 0; i < noteCount; i++) {
            Note n = list.get(i);
            int hs = n.getHitsound();
            a += "Sprite,Foreground,Centre,\"SB/note.png\",320,240\n ";
            a += "M,0," + (n.getMillis() - ((60000 / 191) * 4)) + "," + n.getMillis() + ",-180,370,170,370\n ";
            a += "S,0," + n.getMillis() + ",,0.35\n";
            if (((hs >> 1) & 1) == 1 || ((hs >> 3) & 1) == 1) {
                a += " C,0," + n.getMillis() + ",,100,160,255\n";
            } else {
                a += " C,0," + n.getMillis() + ",,255,80,80\n";
            }
            a += "Sprite,Foreground,Centre,\"SB/note-overlay.png\",320,240\n ";
            a += "M,0," + (n.getMillis() - ((60000 / 191) * 4)) + "," + n.getMillis() + ",-180,370,170,370\n ";
            a += "S,0," + n.getMillis() + ",,0.35\n";
        }
        System.out.println(a);
    }

    public static void gravity(List<Note> list) {
        int noteCount = list.size();
        String a = "";
        for (int i = 0; i < noteCount; i++) {
            Note n = list.get(i);
            int hs = n.getHitsound();
            a += "Sprite,Foreground,Centre,\"SB/note.png\",320,240\n ";
            a += "M,1," + (n.getMillis() - ((60000 / 191) * 4)) + "," + n.getMillis() + ",800,370,170,370\n ";
            a += "S,0," + n.getMillis() + ",,0.35\n";
            if (((hs >> 1) & 1) == 1 || ((hs >> 3) & 1) == 1) {
                a += " C,0," + n.getMillis() + ",,100,160,255\n";
            } else {
                a += " C,0," + n.getMillis() + ",,255,80,80\n";
            }
            a += "Sprite,Foreground,Centre,\"SB/note-overlay.png\",320,240\n ";
            a += "M,1," + (n.getMillis() - ((60000 / 191) * 4)) + "," + n.getMillis() + ",800,370,170,370\n ";
            a += "S,0," + n.getMillis() + ",,0.35\n";
        }
        System.out.println(a);
    }

    public static void mirror(List<Note> list) {
        int noteCount = list.size();
        String a = "";
        for (int i = 0; i < noteCount; i++) {
            Note n = list.get(i);
            int hs = n.getHitsound();
            a += "Sprite,Foreground,Centre,\"SB/note.png\",320,240\n ";
            a += "M,0," + (n.getMillis() - ((60000 / 191) * 4)) + "," + n.getMillis() + ",800,370,170,370\n ";
            a += "S,0," + n.getMillis() + ",,0.35\n";
            if (((hs >> 1) & 1) == 1 || ((hs >> 3) & 1) == 1) {
                a += " C,0," + n.getMillis() + ",,255,80,80\n";
            } else {
                a += " C,0," + n.getMillis() + ",,100,160,255\n";
            }
            a += "Sprite,Foreground,Centre,\"SB/note-overlay.png\",320,240\n ";
            a += "M,0," + (n.getMillis() - ((60000 / 191) * 4)) + "," + n.getMillis() + ",800,370,170,370\n ";
            a += "S,0," + n.getMillis() + ",,0.35\n";
        }
        System.out.println(a);
    }

    public static void mirror2(List<Note> list) {
        int noteCount = list.size();
        String a = "";
        for (int i = 0; i < noteCount; i++) {
            Note n = list.get(i);
            int hs = n.getHitsound();
            a += "Sprite,Foreground,Centre,\"SB/note.png\",320,240\n ";
            a += "M,0," + (n.getMillis() - ((60000 / 191) * 4)) + "," + n.getMillis() + ",-160,370,470,370\n ";
            a += "S,0," + n.getMillis() + ",,0.35\n";
            if (((hs >> 1) & 1) == 1 || ((hs >> 3) & 1) == 1) {
                a += " C,0," + n.getMillis() + ",,255,80,80\n";
            } else {
                a += " C,0," + n.getMillis() + ",,100,160,255\n";
            }
            a += "Sprite,Foreground,Centre,\"SB/note-overlay.png\",320,240\n ";
            a += "M,0," + (n.getMillis() - ((60000 / 191) * 4)) + "," + n.getMillis() + ",-160,370,470,370\n ";
            a += "S,0," + n.getMillis() + ",,0.35\n";
        }
        System.out.println(a);
    }

    public static void dScroll(List<Note> list) {
        int noteCount = list.size();
        String a = "";
        for (int i = 0; i < noteCount; i++) {
            Note n = list.get(i);
            int hs = n.getHitsound();
            if (((hs >> 1) & 1) == 1 || ((hs >> 3) & 1) == 1) {
                a += "Sprite,Foreground,Centre,\"SB/note.png\",320,240\n ";
                a += "M,0," + (n.getMillis() - ((60000 / 191) * 4)) + "," + n.getMillis() + ",170,-260,170,370\n ";
                a += "S,0," + n.getMillis() + ",,0.35\n";
                a += " C,0," + n.getMillis() + ",,100,160,255\n";
                a += "Sprite,Foreground,Centre,\"SB/note-overlay.png\",320,240\n ";
                a += "M,0," + (n.getMillis() - ((60000 / 191) * 4)) + "," + n.getMillis() + ",170,-260,170,370\n ";
                a += "S,0," + n.getMillis() + ",,0.35\n";
            } else {
                a += "Sprite,Foreground,Centre,\"SB/note.png\",320,240\n ";
                a += "M,0," + (n.getMillis() - ((60000 / 191) * 4)) + "," + n.getMillis() + ",800,370,170,370\n ";
                a += "S,0," + n.getMillis() + ",,0.35\n";
                a += " C,0," + n.getMillis() + ",,255,80,80\n";
                a += "Sprite,Foreground,Centre,\"SB/note-overlay.png\",320,240\n ";
                a += "M,0," + (n.getMillis() - ((60000 / 191) * 4)) + "," + n.getMillis() + ",800,370,170,370\n ";
                a += "S,0," + n.getMillis() + ",,0.35\n";
            }
        }
        System.out.println(a);
    }

    public static void scroll(List<Note> list, double speed) {
        final double TRUC = speed;
        int noteCount = list.size();
        String a = "";
        for (int i = 0; i < noteCount; i++) {
            Note n = list.get(i);
            int hs = n.getHitsound();
            a += "Sprite,Foreground,Centre,\"SB/note.png\",320,240\n ";
            a += "M,0," + (n.getMillis() - ((60000 / 191) * (4 / TRUC))) + "," + n.getMillis() + ",800,370,170,370\n ";
            a += "S,0," + n.getMillis() + ",,0.35\n";
            if (((hs >> 1) & 1) == 1 || ((hs >> 3) & 1) == 1) {
                a += " C,0," + n.getMillis() + ",,100,160,255\n";
            } else {
                a += " C,0," + n.getMillis() + ",,255,80,80\n";
            }
            a += "Sprite,Foreground,Centre,\"SB/note-overlay.png\",320,240\n ";
            a += "M,0," + (n.getMillis() - ((60000 / 191) * (4 / TRUC))) + "," + n.getMillis() + ",800,370,170,370\n ";
            a += "S,0," + n.getMillis() + ",,0.35\n";
        }
        System.out.println(a);
    }

    public static void piMoScroll(List<Note> list) {
        int noteCount = list.size();
        String a = "";
        for (int i = 0; i < noteCount; i++) {
            Note n = list.get(i);
            int hs = n.getHitsound();
            if (((hs >> 1) & 1) == 1 || ((hs >> 3) & 1) == 1) {
                a += "Sprite,Foreground,Centre,\"SB/note.png\",320,240\n ";
                a += "M,0," + (n.getMillis() - ((60000 / 191) * 4)) + "," + n.getMillis() + ",720,370,320,370\n ";
                a += "S,0," + n.getMillis() + ",,0.35\n";
                a += " C,0," + n.getMillis() + ",,100,160,255\n";
                a += "Sprite,Foreground,Centre,\"SB/note-overlay.png\",320,240\n ";
                a += "M,0," + (n.getMillis() - ((60000 / 191) * 4)) + "," + n.getMillis() + ",720,370,320,370\n ";
                a += "S,0," + n.getMillis() + ",,0.35\n";
            } else {
                a += "Sprite,Foreground,Centre,\"SB/note.png\",320,240\n ";
                a += "M,0," + (n.getMillis() - ((60000 / 191) * 4)) + "," + n.getMillis() + ",-80,370,320,370\n ";
                a += "S,0," + n.getMillis() + ",,0.35\n";
                a += " C,0," + n.getMillis() + ",,255,80,80\n";
                a += "Sprite,Foreground,Centre,\"SB/note-overlay.png\",320,240\n ";
                a += "M,0," + (n.getMillis() - ((60000 / 191) * 4)) + "," + n.getMillis() + ",-80,370,320,370\n ";
                a += "S,0," + n.getMillis() + ",,0.35\n";
            }
        }
        System.out.println(a);
    }


    public static void counter(List<Note> list) {
        Collections.reverse(list);
        int noteCount = list.size();
        String a = "";
        a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + ((noteCount % 100) / 10) + ".png\",320,240\n ";
        a += "M,0," + list.get(list.size() - 1).getMillis() + "," + list.get(list.size() - 2).getMillis() + ",80,370\n ";
        a += "S,0," + list.get(list.size() - 1).getMillis() + "," + list.get(list.size() - 2).getMillis() + ",0.5\n";
        a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + ((noteCount % 1000) / 100) + ".png\",320,240\n ";
        a += "M,0," + list.get(list.size() - 1).getMillis() + "," + list.get(list.size() - 32).getMillis() + ",60,370\n ";
        a += "S,0," + list.get(list.size() - 1).getMillis() + "," + list.get(list.size() - 32).getMillis() + ",0.5\n";
        for (int i = noteCount - 1; i > 0; i--) {
            Note nCurrent = list.get(i - 1);
            Note nNext = list.get(i);
            if (i >= 100) {
                a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + (i % 10) + ".png\",320,240\n ";
                a += "M,0," + nNext.getMillis() + "," + nCurrent.getMillis() + ",100,370\n ";
                a += "S,0," + nNext.getMillis() + "," + nCurrent.getMillis() + ",0.5\n";
                if ((i + 1) % 10 == 0 && i >= 10) {
                    a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + (((i % 100) / 10)) + ".png\",320,240\n ";
                    a += "M,0," + nCurrent.getMillis() + "," + list.get(i - 10).getMillis() + ",80,370\n ";
                    a += "S,0," + nCurrent.getMillis() + "," + list.get(i - 10).getMillis() + ",0.5\n";
                }
                if ((i + 1) % 100 == 0 && i >= 100) {
                    a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + (((i % 1000) / 100)) + ".png\",320,240\n ";
                    a += "M,0," + nCurrent.getMillis() + "," + list.get(i - 100).getMillis() + ",60,370\n ";
                    a += "S,0," + nCurrent.getMillis() + "," + list.get(i - 100).getMillis() + ",0.5\n";
                }
            }
            if (i >= 10 && i < 100) {
                a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + (i % 10) + ".png\",320,240\n ";
                a += "M,0," + nNext.getMillis() + "," + nCurrent.getMillis() + ",90,370\n ";
                a += "S,0," + nNext.getMillis() + "," + nCurrent.getMillis() + ",0.5\n";
                if ((i + 1) % 10 == 0 && i >= 10) {
                    a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + (((i % 100) / 10)) + ".png\",320,240\n ";
                    a += "M,0," + nCurrent.getMillis() + "," + list.get(i - 10).getMillis() + ",70,370\n ";
                    a += "S,0," + nCurrent.getMillis() + "," + list.get(i - 10).getMillis() + ",0.5\n";
                }
            }
            if (i >= 1 && i < 10) {
                a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + (((i % 100) / 10)) + ".png\",320,240\n ";
                a += "M,0," + nCurrent.getMillis() + "," + list.get(i - 1).getMillis() + ",80,370\n ";
                a += "S,0," + nCurrent.getMillis() + "," + list.get(i - 1).getMillis() + ",0.5\n";
            }
        }
        System.out.println(a);
    }

    public static void counter3(List<Note> list) {
        Collections.reverse(list);
        int noteCount = list.size();
        String a = "";
        a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + ((noteCount % 100) / 10) + ".png\",320,240\n ";
        a += "M,0," + list.get(list.size() - 1).getMillis() + "," + list.get(list.size() - 2).getMillis() + ",80,370\n ";
        a += "V,0," + list.get(list.size() - 1).getMillis() + ",,-1,1\n";
        a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + ((noteCount % 1000) / 100) + ".png\",320,240\n ";
        a += "M,0," + list.get(list.size() - 1).getMillis() + "," + list.get(list.size() - 32).getMillis() + ",60,370\n ";
        for (int i = noteCount - 1; i > 0; i--) {
            Note nCurrent = list.get(i - 1);
            Note nNext = list.get(i);
            if (i >= 100) {
                a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + (i % 10) + ".png\",320,240\n ";
                a += "M,0," + nNext.getMillis() + "," + nCurrent.getMillis() + ",532,370\n ";
                a += "V,0," + nNext.getMillis() + ",,-0.5,0.5\n";
                if ((i + 1) % 10 == 0 && i >= 10) {
                    a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + (((i % 100) / 10)) + ".png\",320,240\n ";
                    a += "M,0," + nCurrent.getMillis() + "," + list.get(i - 10).getMillis() + ",552,370\n ";
                    a += "V,0," + nCurrent.getMillis() + ",,-0.5,0.5\n";
                }
                if ((i + 1) % 100 == 0 && i >= 100) {
                    a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + (((i % 1000) / 100)) + ".png\",320,240\n ";
                    a += "M,0," + nCurrent.getMillis() + "," + list.get(i - 100).getMillis() + ",572,370\n ";
                    a += "V,0," + nCurrent.getMillis() + ",,-0.5,0.5\n";
                }
            }
            if (i >= 10 && i < 100) {
                a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + (i % 10) + ".png\",320,240\n ";
                a += "M,0," + nNext.getMillis() + "," + nCurrent.getMillis() + ",542,370\n ";
                a += "V,0," + nNext.getMillis() + ",,-0.5,0.5\n";
                if ((i + 1) % 10 == 0 && i >= 10) {
                    a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + (((i % 100) / 10)) + ".png\",320,240\n ";
                    a += "M,0," + nCurrent.getMillis() + "," + list.get(i - 10).getMillis() + ",562,370\n ";
                    a += "V,0," + nCurrent.getMillis() + ",,-0.5,0.5\n";
                }
            }
            if (i >= 1 && i < 10) {
                a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + (((i % 100) / 10)) + ".png\",320,240\n ";
                a += "M,0," + nCurrent.getMillis() + "," + list.get(i - 1).getMillis() + ",552,370\n ";
                a += "V,0," + nCurrent.getMillis() + ",,-0.5,0.5\n";
            }
        }
        System.out.println(a);
    }

    public static void counter2(List<Note> list) {
        Collections.reverse(list);
        int noteCount = list.size();
        String a = "";
        a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + ((noteCount % 100) / 10) + ".png\",320,240\n ";
        a += "M,0," + list.get(list.size() - 1).getMillis() + "," + list.get(list.size() - 2).getMillis() + ",80,370\n ";
        a += "S,0," + list.get(list.size() - 1).getMillis() + "," + list.get(list.size() - 2).getMillis() + ",0.5\n";
        a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + ((noteCount % 1000) / 100) + ".png\",320,240\n ";
        a += "M,0," + list.get(list.size() - 1).getMillis() + "," + list.get(list.size() - 32).getMillis() + ",60,370\n ";
        a += "S,0," + list.get(list.size() - 1).getMillis() + "," + list.get(list.size() - 32).getMillis() + ",0.5\n";
        for (int i = noteCount - 1; i > 0; i--) {
            Note nCurrent = list.get(i - 1);
            Note nNext = list.get(i);
            if (i >= 100) {
                a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + (i % 10) + ".png\",320,240\n ";
                a += "M,0," + nNext.getMillis() + "," + nCurrent.getMillis() + ",570,370\n ";
                a += "S,0," + nNext.getMillis() + "," + nCurrent.getMillis() + ",0.5\n";
                if ((i + 1) % 10 == 0 && i >= 10) {
                    a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + (((i % 100) / 10)) + ".png\",320,240\n ";
                    a += "M,0," + nCurrent.getMillis() + "," + list.get(i - 10).getMillis() + ",550,370\n ";
                    a += "S,0," + nCurrent.getMillis() + "," + list.get(i - 10).getMillis() + ",0.5\n";
                }
                if ((i + 1) % 100 == 0 && i >= 100) {
                    a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + (((i % 1000) / 100)) + ".png\",320,240\n ";
                    a += "M,0," + nCurrent.getMillis() + "," + list.get(i - 100).getMillis() + ",530,370\n ";
                    a += "S,0," + nCurrent.getMillis() + "," + list.get(i - 100).getMillis() + ",0.5\n";
                }
            }
            if (i >= 10 && i < 100) {
                a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + (i % 10) + ".png\",320,240\n ";
                a += "M,0," + nNext.getMillis() + "," + nCurrent.getMillis() + ",560,370\n ";
                a += "S,0," + nNext.getMillis() + "," + nCurrent.getMillis() + ",0.5\n";
                if ((i + 1) % 10 == 0 && i >= 10) {
                    a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + (((i % 100) / 10)) + ".png\",320,240\n ";
                    a += "M,0," + nCurrent.getMillis() + "," + list.get(i - 10).getMillis() + ",540,370\n ";
                    a += "S,0," + nCurrent.getMillis() + "," + list.get(i - 10).getMillis() + ",0.5\n";
                }
            }
            if (i >= 1 && i < 10) {
                a += "Sprite,Foreground,Centre,\"SB/numbers/val_" + (((i % 100) / 10)) + ".png\",320,240\n ";
                a += "M,0," + nCurrent.getMillis() + "," + list.get(i - 1).getMillis() + ",550,370\n ";
                a += "S,0," + nCurrent.getMillis() + "," + list.get(i - 1).getMillis() + ",0.5\n";
            }
        }
        System.out.println(a);
    }
    
}
