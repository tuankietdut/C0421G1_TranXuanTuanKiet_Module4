package cg.wbd.grandemonstration.controller;

public class DuplicateEmailException  extends Exception{
    public DuplicateEmailException(String message) {
        super(message);
    }
}
