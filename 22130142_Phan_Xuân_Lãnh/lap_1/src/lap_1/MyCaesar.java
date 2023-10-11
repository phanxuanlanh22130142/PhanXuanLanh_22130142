package lap_1;

public class MyCaesar {
    public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    private int n; // shift steps (right shift)

    public MyCaesar(int shiftSteps) {
        this.n = shiftSteps;
    }

    public char encryptChar(char c) {
        if (Character.isLetter(c)) {
            int index = (Character.toUpperCase(c) - 'A' + n) % 26;
            if (index < 0) {
                index += 26;
            }
            return ALPHABET[index];
        }
        return c;
    }

    public String encrypt(String input) {
        StringBuilder encryptedText = new StringBuilder();
        for (char c : input.toCharArray()) {
            encryptedText.append(encryptChar(c));
        }
        return encryptedText.toString();
    }

    public char decryptChar(char c) {
        if (Character.isLetter(c)) {
            int index = (Character.toUpperCase(c) - 'A' - n) % 26;
            if (index < 0) {
                index += 26;
            }
            return ALPHABET[index];
        }
        return c;
    }

    public String decrypt(String input) {
        StringBuilder decryptedText = new StringBuilder();
        for (char c : input.toCharArray()) {
            decryptedText.append(decryptChar(c));
        }
        return decryptedText.toString();
    }
    public static void main(String[] args) {
        MyCaesar caesar = new MyCaesar(3);

        
        char originalChar = 'A';
        char encryptedChar = caesar.encryptChar(originalChar);
        char decryptedChar = caesar.decryptChar(encryptedChar);
        System.out.println("Original Char: " + originalChar);
        System.out.println("Encrypted Char: " + encryptedChar);
        System.out.println("Decrypted Char: " + decryptedChar);
        System.out.println();

        // Test encrypt() and decrypt()
        String originalText = "HELLO";
        String encryptedText = caesar.encrypt(originalText);
        String decryptedText = caesar.decrypt(encryptedText);
        System.out.println("Original Text: " + originalText);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}

