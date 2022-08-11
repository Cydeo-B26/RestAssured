package com.cydeo.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//@Getter
//@Setter
@Data
public class SpartanSearch {
    private List<Spartan> content;
    private int totalElement;
}
