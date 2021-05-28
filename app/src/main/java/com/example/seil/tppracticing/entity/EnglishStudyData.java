package com.example.seil.tppracticing.entity;

/**
 * Created by Seil on 2020-11-10.
 */

public class EnglishStudyData {

    private Long id;
    private Long categorycode;
    private String question;
    private String answer;

    public EnglishStudyData(String id, String categorycode, String question, String answer) {
        this.id = Long.parseLong(id);
        this.categorycode = Long.parseLong(categorycode);
        this.question = question;
        this.answer= answer;
    }

    public Long getId() {return this.id;}
    public Long getCategorycode() {return this.categorycode;}
    public String getQuestion() {return this.question;}
    public String getAnswer() {return this.answer;}
}
