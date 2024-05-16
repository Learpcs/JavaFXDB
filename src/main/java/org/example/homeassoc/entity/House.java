package org.example.homeassoc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class House {
    Integer House_ID;
    String Address;
    Integer Number_of_apartments;
}
