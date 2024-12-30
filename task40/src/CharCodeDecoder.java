public class CharCodeDecoder implements Decoder {
    @Override
    public String encode(String source) {
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            int charCode = (int) c;
            encoded.append(charCode).append(" ");
        }
        return encoded.toString().trim();
    }

    @Override
    public String decode(String encoded) {
        StringBuilder decoded = new StringBuilder();
        String[] codes = encoded.split(" ");
        for (String code : codes) {
            try {
                int charCode = Integer.parseInt(code);
                decoded.append((char) charCode);
            } catch (NumberFormatException e) {
                decoded.append("?");
            }
        }
        return decoded.toString();
    }
}
