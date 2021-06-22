package com.hhstudygroup.npustudy.domain;

import java.io.Serializable;

public class Question_Exam implements Serializable {
    /**
     * question_id: int
     * paper_id: int
     */
    private int question_id;
    private int paper_id;

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(int paper_id) {
        this.paper_id = paper_id;
    }

    @Override
    public String toString() {
        return "Question_Exam{" +
                "question_id=" + question_id +
                ", paper_id=" + paper_id +
                '}';
    }
}
