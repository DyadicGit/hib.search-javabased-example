package org.hanbo.mvc.helpers;

/**
 * Created by OlgerdSe on 2017-03-08.
 */
import java.util.List;

public class Pasirinkimai {
    private List<String> pasirinkimas;
    private List<String> QUESTION_TEXT;

    public List<String> getPasirinkimas() {
        return pasirinkimas;
    }

    public void setPasirinkimas(List<String> pasirinkimas) {
        this.pasirinkimas = pasirinkimas;
    }

    public List<String> getQUESTION_TEXT() {
        return QUESTION_TEXT;
    }

    public void setQUESTION_TEXT(List<String> QUESTION_TEXT) {
        this.QUESTION_TEXT = QUESTION_TEXT;
    }
}