package com.example.tastybits.ui.questionview;

import androidx.annotation.NonNull;

/**
 * com.example.tastybits.ui.questionview.QuestionItem class represents the information of a specific question
 */
public class QuestionItem {

    private String id;
    private String questionText;
    private String descriptionText;
    private int upvotes;
    private int views;

    public QuestionItem(String id, String questionText) {
        this.questionText = questionText;
        this.descriptionText = "";
        upvotes = 0;
        views = 0;
    }

    public QuestionItem(String id, String title, String description) {
        this(id, title);
        this.descriptionText = description;
    }

    @NonNull
    @Override
    public String toString() {
        return questionText + ", " + descriptionText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }


}
