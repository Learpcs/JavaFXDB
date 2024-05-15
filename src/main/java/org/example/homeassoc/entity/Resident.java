package org.example.homeassoc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Resident {
    Integer id;
    String name;
    Integer apparts;
}
