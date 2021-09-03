package com.example.demo.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MusicDto implements Validator {
    private int id;
    private String nameSong;
    private String nameWriteSong;
    private String typeSong;

    public MusicDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameWriteSong() {
        return nameWriteSong;
    }

    public void setNameWriteSong(String nameWriteSong) {
        this.nameWriteSong = nameWriteSong;
    }

    public String getTypeSong() {
        return typeSong;
    }

    public void setTypeSong(String typeSong) {
        this.typeSong = typeSong;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto) target;
        if (musicDto.getNameSong().equals("") || musicDto.getNameSong().length()>800 ){
            errors.rejectValue("nameSong", "song.validate.nameSong","Không được để trống, dưới 800 ký tự, ko chwuas ký tự đặc biệt");
        }
        if (musicDto.getNameWriteSong().equals("") || musicDto.getNameSong().length()>300){
            errors.rejectValue("nameWriteSong", "song.validate.nameWriteSong","Không được để trống, dưới 800 ký tự, ko chwuas ký tự đặc biệt");
        }
        if (musicDto.getTypeSong().equals("") || musicDto.getTypeSong().length()>300){
            errors.rejectValue("typeSong", "song.validate.typeSong","Không được để trống, dưới 800 ký tự, ko chwuas ký tự đặc biệt");
        }


    }
}
