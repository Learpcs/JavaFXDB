package org.example.homeassoc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AccountOutstanding {
    Integer Record_ID;
    Integer Account_Account_ID;
    Date Maturity_date;
    Integer Sum;
}
