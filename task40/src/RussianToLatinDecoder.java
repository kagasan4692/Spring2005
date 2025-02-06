public class RussianToLatinDecoder implements Decoder {
    private static final char[] chars = {
            'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'
    };

    private static final String[] codes = {
            "a", "b", "v", "g", "d", "e", ">|<", "z", "i", "y", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "h", "ts", "ch", "w", "3", "9", "-", "'", "]", "8", "0"
    };

    @Override
    public String encode(String source) {
        source = source.toLowerCase();
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            boolean found = false;
            for (int j = 0; j < chars.length; j++) {
                if (c == chars[j]) {
                    encoded.append(codes[j]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                encoded.append(c);
            }
        }
        return encoded.toString();
    }

    @Override
    public String decode(String encoded) {
        encoded = encoded.toLowerCase();
        StringBuilder decoded = new StringBuilder();
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < encoded.length(); i++) {
            buffer.append(encoded.charAt(i));
            boolean found = false;
            for (int j = 0; j < codes.length; j++) {
                if (buffer.toString().equals(codes[j])) {
                    decoded.append(chars[j]);
                    buffer.setLength(0);
                    found = true;
                    break;
                }
            }

            if (!found && buffer.length() == 1 && !Character.isLetter(buffer.charAt(0))) {
                decoded.append(buffer.charAt(0));
                buffer.setLength(0);
            }
        }

        if (buffer.length() > 0) {
            decoded.append(buffer);
        }

        return decoded.toString();
    }
}
