package ApplicationDic;


public class Word_explain {
    private StringBuilder word_explain;

    public Word_explain() {
        this.word_explain = new StringBuilder("");
    }

    public Word_explain(StringBuilder word_explain) {
        this.word_explain = word_explain;
    }

    @Override
    public String toString() {
        return word_explain + "";
    }

    public void addWord(String word) {
        word_explain.append(word + "\n");
    }

}
