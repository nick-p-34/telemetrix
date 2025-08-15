package com.example.telemetrix.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class TelemetryEvent {
    private String carId;
    private String driver;
    private String team;
    @JsonProperty("vehicle_class")
    private String vehicleClass;
    private int lap;
    private double speed;
    private int rpm;
    private int gate;
    @JsonProperty("split_time")
    private double splitTime;
    private int gear;
    private double throttle;
    private double brake;
    @JsonProperty("steering_deg")
    private double steeringDeg;
    @JsonProperty("fuel_l")
    private double fuelL;
    @JsonProperty("tyre_wear")
    private double tyreWear;
    @JsonProperty("stint_time")
    private double stintTime;
    @JsonProperty("position_m")
    private double positionM;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getVehicleClass() {
        return team;
    }

    public void setVehicleClass(String team) {
        this.team = team;
    }

    public int getLap() {
        return lap;
    }

    public void setLap(int lap) {
        this.lap = lap;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public int getGate() {
        return gate;
    }

    public void setGate(int gate) {
        this.gate = gate;
    }

    public double getSplitTime() {
        return splitTime;
    }

    public void setSplitTime(double splitTime) {
        this.splitTime = splitTime;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public double getThrottle() {
        return throttle;
    }

    public void setThrottle(double throttle) {
        this.throttle = throttle;
    }

    public double getBrake() {
        return brake;
    }

    public void setBrake(double brake) {
        this.brake = brake;
    }

    public double getSteeringDeg() {
        return steeringDeg;
    }

    public void setSteeringDeg(double steeringDeg) {
        this.steeringDeg = steeringDeg;
    }

    public double getFuelL() {
        return fuelL;
    }

    public void setFuelL(double fuelL) {
        this.fuelL = fuelL;
    }

    public double getTyreWear() {
        return tyreWear;
    }

    public void setTyreWear(double tyreWear) {
        this.tyreWear = tyreWear;
    }

    public double getStintTime() {
        return stintTime;
    }

    public void setStintTime(double stintTime) {
        this.stintTime = stintTime;
    }

    public double getPositionM() {
        return positionM;
    }

    public void setPositionM(double positionM) {
        this.positionM = positionM;
    }
}