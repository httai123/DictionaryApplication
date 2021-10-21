package ApplicationDic;


import java.io.*;
import java.util.*;

public class DictionaryManagement {
    private static Scanner x;
    List<Word> words = new ArrayList<>();
    List<String> wordTargets = new ArrayList<>();
    List<String> wordExplains = new ArrayList<>();
    List<String> stressPats = new ArrayList<>();
    List<String> wordTypes = new ArrayList<>();

    public int getSize() {
        return words.size();
    }

    public List<String> getWordTypes() {
        return wordTypes;
    }

    public List<Word> getWords() {
        return words;
    }

    public List<String> getStressPats() {
        return stressPats;
    }

    public List<String> getWordExplains() {
        return wordExplains;
    }

    public List<String> getWordTargets() {
        return wordTargets;
    }
    public void removeWord(Word w){
        words.remove(w);
    }
    public void FileAfterDelete(){
        try {
            FileWriter fw = new FileWriter("F:\\\\PROGRAMMING\\\\ATM_PRJ" +
                    "\\\\mavenproject1\\\\src\\\\main\\\\java\\\\image\\\\folder\\\\dictionary.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for(Word i : getWords()){
                bw.write(i.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void readFromFile() {
        try {
            FileReader fr = new FileReader("F:\\\\PROGRAMMING\\\\ATM_PRJ" +
                    "\\\\mavenproject1\\\\src\\\\main\\\\java\\\\image\\\\folder\\\\dictionary.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                String wordTarget = txt[0];
                wordTargets.add(wordTarget);
                String wordType = txt[1];
                wordTypes.add(wordType);
                String stressPat = txt[2];
                stressPats.add(stressPat);
                String wordExplain = txt[3];
                wordExplains.add(wordExplain);
                words.add(new Word(wordTarget, wordExplain, stressPat, wordType));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int search_check(String s) {
        return wordTargets.indexOf(s);
    }

}
