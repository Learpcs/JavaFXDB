package org.example.homeassoc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Service {
    Integer Service_ID;
    String Name;
    Integer Tariff;
    Date Date_of_appearance;
    Date Termination_date;
}