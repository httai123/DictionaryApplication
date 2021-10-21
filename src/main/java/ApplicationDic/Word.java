package ApplicationDic;


import java.util.Collections;
import java.util.Objects;

public class Word {
    private String word_target;
    private String word_explain;
    private String stress_pattern;
    private String word_type;

    public Word() {
    }

    public Word(String word_target, String word_explain, String stress_pattern, String word_type) {
        this.word_target = word_target;
        this.word_explain = word_explain;
        this.word_type = word_type;
        this.stress_pattern = stress_pattern;
    }

    public String getWord_type() {
        return word_type;
    }

    public void setWord_type(String word_type) {
        this.word_type = word_type;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_target() {
        return word_target;
    }

    public String getStress_pattern() {
        return stress_pattern;
    }

    public void setStress_pattern(String stress_pattern) {
        this.stress_pattern = stress_pattern;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public String toString() {
        return word_target + ";" + word_type + ";" + stress_pattern + ";"
                + word_explain;
    }
}
