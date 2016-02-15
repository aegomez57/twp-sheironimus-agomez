package agomez.sheironimus.cs222.bsu.edu;

import java.io.*;
import java.io.IOException;

public class BlacklistAnalyzer {

    public String blacklistedWords = "";
    public File blacklistWordsList = new File("C:\\Users\\antho\\Desktop\\TWP\\RSS News Feed Analyzer\\Resources\\BlacklistedWords");

    public void analyzeBlacklist(){
        blacklistedWords = getBlacklist();
    }

    public String getBlacklist(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(blacklistWordsList));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null){
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveBlacklist(String blacklist){
        try{
            FileWriter fileWriter = new FileWriter(blacklistWordsList);
            fileWriter.flush();
            fileWriter.write(blacklist);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Boolean containsBlacklistedWords (String words){
        String[] blWords = blacklistedWords.split("\\s+");
        String[] inputtedWords = words.split("\\s+");
        Boolean flag = false;
        for(String blWord : blWords){
            for(String inputWord : inputtedWords){
                if(inputWord.equals(blWord)){
                    flag = true;
                }
            }
        }
        return flag;
    }

}
