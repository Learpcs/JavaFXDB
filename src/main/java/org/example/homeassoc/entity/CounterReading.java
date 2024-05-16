package org.example.homeassoc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CounterReading {
    Integer Indication_ID;
    Integer Reading;
    Date Received_date;
    Integer Counter_Counter_ID;
}
