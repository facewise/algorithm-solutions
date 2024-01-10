class Solution {
    public String solution(String newId) {
        String answer = "";

        answer = newId.toLowerCase();
        answer = answer.replaceAll("[~!@#$%^&*()=+\\[{\\]}:?,<>/]", "");
        answer = answer.replaceAll("[.]+", "\\.");
        
        if (answer.startsWith("."))
            answer = answer.substring(1);

        if (answer.endsWith("."))
            answer = answer.substring(0, answer.length() - 1);

        if (answer.isEmpty())
            answer = "a";

        if (answer.length() > 15)
            answer = answer.substring(0, 15);

        if (answer.endsWith("."))
            answer = answer.substring(0, answer.length() - 1);

        while (answer.length() < 3)
            answer += answer.substring(answer.length()-1);

        return answer;     
    }
}