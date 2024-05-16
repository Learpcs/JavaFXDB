package org.example.homeassoc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class JournalApartmentResident {
    Integer Record_ID;
    Integer Apartment_Apartment_ID;
    Integer Resident_Resident_ID;
    String Ownership_date;
}