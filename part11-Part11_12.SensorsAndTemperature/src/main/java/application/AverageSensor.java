/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EduardoPC
 */
public class AverageSensor implements Sensor {

    private ArrayList<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : sensors) {
            if (sensor.isOn()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void setOn() {
        for (Sensor sensor : sensors) {
            sensor.setOn();
        }
    }

    @Override
    public void setOff() {
        for (Sensor sensor : sensors) {
            sensor.setOff();
        }
    }

    @Override
    public int read() {
        if (this.isOn() == false) {
            throw new IllegalStateException("Sensor is off.");
        }

        int totalTemperature = 0;
        for (Sensor s : sensors) {
            totalTemperature += s.read();
        }
        totalTemperature /= sensors.size();
        readings.add(totalTemperature);
        return totalTemperature;
    }
    
    public List<Integer> readings(){
        return this.readings;
    }

}
