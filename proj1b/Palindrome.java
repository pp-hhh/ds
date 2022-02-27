import java.util.Deque;
import java.util.LinkedList;

public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> wordDeque = new LinkedList<>();
        for(int i = 0; i < word.length(); ++i) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    private boolean isPalindromeHelper(Deque<Character> d) {
        if (d.size() == 1 || d.size() == 0){
            return true;
        }
        if (d.removeFirst() != d.removeLast()){
            return false;
        }
        return isPalindromeHelper(d);
    }

    public boolean isPalindrome(String word){
        Deque<Character> d = this.wordToDeque(word);
        return isPalindromeHelper(d);
    }

    private boolean isPalindromeHelper(Deque<Character> d, CharacterComparator cc){
        if (d.size() == 0 || d.size() == 1) {
            return true;
        }
        if (!cc.equalChars(d.removeFirst(), d.removeLast())){
            return false;
        }
        return isPalindromeHelper(d, cc);
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> d = this.wordToDeque(word);
        return isPalindromeHelper(d, cc);
    }
}
