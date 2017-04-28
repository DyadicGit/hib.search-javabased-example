package org.hanbo.mvc.entities;

import org.hibernate.search.annotations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Indexed
@Table(name = "sys_meta_question")
public class Sys_meta_question {
    @Id
    @Column(name = "QUESTION_ID")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO,name = "ID")
    private Integer QUESTION_ID;

    @Column(name = "QUESTION_STRUCTURES_ID", nullable = false)
    private String QUESTION_STRUCTURES_ID;

    @Column(name = "QUESTION_CODE", nullable = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String QUESTION_CODE;

    @Column(name = "QUESTION_TEXT", nullable = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String QUESTION_TEXT;

    @Column(name = "QUESTION_ID_ID", nullable = false)
    private String QUESTION_ID_ID;

    @Column(name = "QUESTION_SORTING", nullable = false)
    private String QUESTION_SORTING;

    public Integer getQUESTION_ID() {
        return QUESTION_ID;
    }

    public void setQUESTION_ID(Integer QUESTION_ID) {
        this.QUESTION_ID = QUESTION_ID;
    }

    public String  getQUESTION_STRUCTURES_ID() {
        return QUESTION_STRUCTURES_ID;
    }

    public void setQUESTION_STRUCTURES_ID(String  QUESTION_STRUCTURES_ID) {
        this.QUESTION_STRUCTURES_ID = QUESTION_STRUCTURES_ID;
    }

    public String getQUESTION_CODE() {
        return QUESTION_CODE;
    }

    public void setQUESTION_CODE(String QUESTION_CODE) {
        this.QUESTION_CODE = QUESTION_CODE;
    }

    public String getQUESTION_TEXT() {
        return QUESTION_TEXT;
    }

    public void setQUESTION_TEXT(String QUESTION_TEXT) {
        this.QUESTION_TEXT = QUESTION_TEXT;
    }

    public String getQUESTION_ID_ID() {
        return QUESTION_ID_ID;
    }

    public void setQUESTION_ID_ID(String QUESTION_ID_ID) {
        this.QUESTION_ID_ID = QUESTION_ID_ID;
    }

    public String getQUESTION_SORTING() {
        return QUESTION_SORTING;
    }

    public void setQUESTION_SORTING(String QUESTION_SORTING) {
        this.QUESTION_SORTING = QUESTION_SORTING;
    }

}
