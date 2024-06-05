package com.platform.tutorgo.advisory.domain.exceptions;

public class StudentNotExceptions extends RuntimeException{
     public StudentNotExceptions(){
        super("Students not found");
    }
}
