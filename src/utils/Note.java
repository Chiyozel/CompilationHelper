/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import exception.InvalidHitsoundException;
import exception.InvalidTypeException;

/**
 *
 * @author Gezochan
 */
public class Note {

    private int x;
    private int y;
    private long ms;
    private int nt;
    private int hs;
    private String params;

    public Note(int x, int y, long ms, int nt, int hs, String params) {
        this.x = x;
        this.y = y;
        this.ms = ms;
        this.nt = nt;
        this.hs = hs;
        this.params = params;
    }
    
    @Override
    public String toString(){
        return "Position: ("+x+","+y+")\tTime: "+ms+"\tType: "+nt+"\tHitsounds: "+hs+"\tSpecial Parameter: "+params;
    }
    
    public String outputOsuFile(){
        return x+","+y+","+ms+","+nt+","+hs+","+params;
    }
    
    public void center(){
        x=256;
        y=192;
    }
    
    public void move(int offset){
        ms+=offset;
    }
    
    public long getMillis(){
        return ms;
    }

    public int getHitsound() {
        return hs;
    }

    public void setHitsound(int i) {
        hs = i;
    }
}
