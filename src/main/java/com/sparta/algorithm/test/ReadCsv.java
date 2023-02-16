package com.sparta.algorithm.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadCsv {
    public static void main(String[] args) {
        //반환용 리스트
        List<List<String>> ret = new ArrayList<List<String>>();
        BufferedReader br = null;
        HashMap<String, Integer> school = new HashMap<>();

        try {
            br = Files.newBufferedReader(Paths.get("C:\\Users\\HoRang\\comments.csv"));
            //Charset.forName("UTF-8");
            String line = "";

            while ((line = br.readLine()) != null) {
                //CSV 1행을 저장하는 리스트
                List<String> tmpList;
                String array[] = line.split(",");
                //배열에서 리스트 반환
                tmpList = Arrays.asList(array);

                System.out.println(tmpList);
                ret.add(tmpList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
