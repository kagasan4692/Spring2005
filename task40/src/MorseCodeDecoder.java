public class MorseCodeDecoder implements Decoder {
    private static final char[] characters = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0'
    };

    private static final String[] morseCodes = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
            ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-",
            ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----"
    };

    @Override
    public String encode(String source) {
        source = source.toLowerCase();
        StringBuilder encoded = new StringBuilder();
        for (char c : source.toCharArray()) {
            if (c == ' ') {
                encoded.append(" / ");
            } else {
                boolean found = false;
                for (int i = 0; i < characters.length; i++) {
                    if (characters[i] == c) {
                        encoded.append(morseCodes[i]).append(" ");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    encoded.append("? ");
                }
            }
        }
        return encoded.toString().trim();
    }

    @Override
    public String decode(String encoded) {
        StringBuilder decoded = new StringBuilder();
        String[] words = encoded.split(" / ");
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                boolean found = false;
                for (int i = 0; i < morseCodes.length; i++) {
                    if (morseCodes[i].equals(letter)) {
                        decoded.append(characters[i]);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    decoded.append("?");
                }
            }
            decoded.append(" ");
        }
        return decoded.toString().trim();
    }
}
