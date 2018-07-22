/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.callcentercommondtos;

/**
 *
 * @author mostafa.kashif
 */
public class ServiceDto {

    private int id;
    private double cost;
    private int usage;
    private String name;

    public ServiceDto(int id, double cost, int usage, String name) {
        this.id = id;
        this.cost = cost;
        this.usage = usage;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ServiceDto{" + "id=" + id + ", cost=" + cost + ", usage=" + usage + ", name=" + name + '}';
    }
    
    
}
