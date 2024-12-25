package org.codingchallenges.wc.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class CommonUtils {

    public static BufferedReader readFile(String path) throws Exception {
        return (Objects.nonNull(path) && !path.isEmpty() && !"test.txt".equals(path)) ? new BufferedReader(new FileReader(path)) :
                new BufferedReader(new InputStreamReader(Objects.requireNonNull(CommonUtils.class.getClassLoader().getResourceAsStream("test.txt")), StandardCharsets.UTF_8));
    }

    public static String convertFileInputToString(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = CommonUtils.readFile(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append('\r').append('\n');
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            System.err.println("There is some issue with the file. Please check : " + e.getMessage());
            return "";
        }
    }

    public static void main(String[] args) {
        String s = convertFileInputToString("test.txt");
        System.out.println(s.getBytes(StandardCharsets.UTF_8).length);
        int line = 0;
        for (char c : s.toCharArray()) {
            if (c == '\n') {
                line++;
            }
        }
        int word = 0;
        int n = s.length(), start = 0;
        while (start < n) {
            while (start < n && (s.charAt(start) == ' ' || s.charAt(start) == '\r' || s.charAt(start) == '\n')) {
                start++;
            }
            if (start < n) {
                word++;
            }
            while (start < n && (s.charAt(start) != ' ' && s.charAt(start) != '\r' && s.charAt(start) != '\n')) {
                start++;
            }
        }
        System.out.println(line + " " + word + " " + s.split("\\s+").length);
    }
}
