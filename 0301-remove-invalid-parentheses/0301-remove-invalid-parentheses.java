class Solution {
    private Set<String> resultSet;
    private int longestStringLength;

    public List<String> removeInvalidParentheses(String s) {
        resultSet = new HashSet<>();
        longestStringLength = 0;
        dfs(s, 0, new StringBuilder(), 0, 0);
        return new ArrayList<>(resultSet);
    }

    private void dfs(String s, int currentIndex, StringBuilder currentResult, int openCount, int closeCount) {
        if (currentIndex == s.length()) {
            if (openCount == closeCount) {
                if (currentResult.length() > longestStringLength) {// meaning the new VALID answer is found.
                    //longer the length of valid string== minimum removal.
                    longestStringLength = currentResult.length();
                    resultSet.clear();
                    resultSet.add(currentResult.toString());
                } else if (currentResult.length() == longestStringLength) {
                    resultSet.add(currentResult.toString());
                }
            }
            return;
        }

        char currentChar = s.charAt(currentIndex);

        if (currentChar == '(') {
            // Include the '('
            currentResult.append(currentChar);
            dfs(s, currentIndex + 1, currentResult, openCount + 1, closeCount);
            currentResult.deleteCharAt(currentResult.length() - 1);

            // Exclude the '('
            dfs(s, currentIndex + 1, currentResult, openCount, closeCount);

        } else if (currentChar == ')') {
            // Include the ')' only if it doesn't lead to more close than open
            if (openCount > closeCount) {
                currentResult.append(currentChar);
                dfs(s, currentIndex + 1, currentResult, openCount, closeCount + 1);
                currentResult.deleteCharAt(currentResult.length() - 1);
            }

            // Exclude the ')'
            dfs(s, currentIndex + 1, currentResult, openCount, closeCount);

        } else {
            // Include other characters
            currentResult.append(currentChar);
            dfs(s, currentIndex + 1, currentResult, openCount, closeCount);
            currentResult.deleteCharAt(currentResult.length() - 1);
        }
    }
}