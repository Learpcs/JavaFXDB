package org.example.homeassoc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ReceiptForService {
    Integer Receipt_ID;
    Integer Invoiced_amount;
    Date date;
    Integer Counter_Readings_ID_readings;
    Integer Account_Account_ID;
    Integer Service_Service_ID;
}
