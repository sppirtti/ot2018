/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import wt.domain.Time;

/**
 *
 * @author Samuli
 */
public class TimeFileDao implements TimeDao {

    public List<Time> times;
    private String filename;

    public TimeFileDao(String filename) {

        this.filename = filename;
        times = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNext()) {
                String[] split = scanner.nextLine().split(";");
                Time newTime = new Time(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]),Integer.parseInt(split[3]),
                        Integer.parseInt(split[4]),Integer.parseInt(split[5]), Integer.parseInt(split[6]));
                
                times.add(newTime);
                
            }

        } catch (Exception e) {
            

        }
    }

    public void save() throws Exception {
        try (FileWriter fw = new FileWriter(new File(filename))) {
            for (Time t : times) {
                fw.write(
                        t.getUsername() + ";" + t.getMonth() + ";"
                        + t.getDay() + ";" + t.getStartHour() + ";"
                        + t.getStartMinute() + ";" + t.getEndHour() + ";"
                        + t.getEndMinute());

            }

        }
    }

    @Override
    public Time add(Time time) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public List<Time> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}