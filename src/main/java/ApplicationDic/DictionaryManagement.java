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
                    "\\\\mavenproject1\\\\src\\\\main\\\\java\\\\image\\\\folder\\\\dictionaries.txt");
            for(Word i : getWords()){
                fw.write(i.toString()+"\n");
            }
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void readFromFile() {
        try {
            FileReader fr = new FileReader("F:\\\\PROGRAMMING\\\\ATM_PRJ" +
                    "\\\\mavenproject1\\\\src\\\\main\\\\java\\\\image\\\\folder\\\\dictionaries.txt");
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

//    public void insertFromFile() {
//        try {
//            words = new ArrayList<>();
//            Path path = Paths.get("F:\\PROGRAMMING\\ATM_PRJ\\mavenproject1\\src\\main\\java\\image\\folder\\dictionaries.txt");
//            List<String> data = Files.readAllLines(path);
//            ListIterator<String> it = data.listIterator();
//            Word word = new Word();
//            while (it.hasNext()) {
//                String f = it.next();
//                if (f.startsWith("*")) {
//                    word = new Word();
//                    String[] part = f.split("/", 2);
//                    String s = part[0].substring(1).trim();
//                    if (s.startsWith("'") || s.startsWith(">") ) {
//                        s = s.substring(1, s.length());
//                    }
//                    word.setWord_target(s);
//                    if (part.length < 2) {
//                        word.setStress_pattern("");
//                    } else {
//                        word.setStress_pattern("/" + part[1]);
//                    }
//                    while (it.hasNext()) {
//                        String res = it.next();
//                        if (!res.startsWith("*")) {
//                            word.addToResult(res);
//                        } else {
//                            words.add(word);
//                            it.previous();
//                            break;
//                        }
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    public int search_check(String s) {
//        Word search = new Word(s.trim());
//        int find = Collections.binarySearch(words, search);
//        return find;
//    }

    //public void addWordToMyDic() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a word you want to add: ");
//        String add_word = sc.nextLine();
//        int find = Collections.binarySearch(getWords(), new Word(add_word));
//        if (find < 0) {
//            System.out.println("Enter word phonetic: ");
//            String phonetic = sc.nextLine();
//            System.out.println("Enter word type: ");
//            String type = sc.nextLine();
//            System.out.println("Enter word explain: ");
//            String explain = sc.nextLine();
//            StringBuilder detail = new StringBuilder("> " + type + "\n" + "= " + explain);
//            try {
//                FileWriter output = new FileWriter("F:\\PROGRAMMING\\ATM_PRJ\\mavenproject1\\src\\main\\java\\image\\folder\\dictionaries.txt", true);
//                output.write("\n" + "\n");
//                output.write("*" + add_word + "\n" + phonetic);
//                output.write("\n");
//                output.write(String.valueOf(detail));
//                output.close();
//            } catch (IOException e) {
//                System.out.println("File append error.");
//            }
//            System.out.println("You had added success");
//        } else {
//            System.out.println("MainSource.Word already exist.");
//        }
    //}

    public void removeChosenLine(String file, String lineToRemove) {

        try {

            File inFile = new File(file);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {

                if (!line.trim().equals(lineToRemove)) {

                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
