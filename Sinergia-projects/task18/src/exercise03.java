public class exercise03 {
    public static void main(String[] args) {
        ProgrammingLanguage languageJava = new ProgrammingLanguage();

        languageJava.name = "Java";

        String[] versionsJava = {"Java 1.0", "Java 1.1", "Java 1.2", "Java 1.3", "Java 1.4", "Java 5", "Java 6", "Java 7",
                "Java 8", "Java 9", "Java 10", "Java 11", "Java 12", "Java 13", "Java 14", "Java 15", "Java 16", "Java 17",
                "Java 18", "Java 19", "Java 20"};
        languageJava.version = versionsJava;

        String[] typingJava = {"STRONG Typing"};
        languageJava.typing = typingJava;

        String[] keywordsJava = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
                "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
                "new", "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp",
                "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"};
        languageJava.keywords = keywordsJava;


        ProgrammingLanguage languageCPlusPlus = new ProgrammingLanguage();

        languageCPlusPlus.name = "CPlusPlus";

        String[] versionsCPlusPlus = {"C++98", "C++03", "C++11", "C++14", "C++17", "C++20", "C++23"};
        languageCPlusPlus.version = versionsCPlusPlus;

        String[] typingCPlusPlus = {"STRONG Typing", "STATIC Typing"};
        languageCPlusPlus.typing = typingCPlusPlus;

        String[] keywordsCPlusPlus = {"alignas", "alignof", "and", "and_eq", "asm", "atomic_cancel", "atomic_commit", "atomic_noexcept",
                "auto", "bitand", "bitor", "bool", "break", "case", "catch", "char", "char8_t", "char16_t", "char32_t", "class", "co_await",
                "co_return", "co_yield", "compl", "concept", "const", "consteval", "constexpr", "const_cast", "continue", "decltype", "default",
                "delete", "do", "double", "dynamic_cast", "else", "enum", "explicit", "export", "extern", "false", "float", "for", "friend",
                "goto", "if", "inline", "int", "long", "mutable", "namespace", "new", "noexcept", "not", "not_eq", "nullptr", "operator", "or",
                "or_eq", "private", "protected", "public", "register", "reinterpret_cast", "requires", "return", "short", "signed", "sizeof",
                "static", "static_assert", "static_cast", "struct", "switch", "synchronized", "template", "this", "thread_local", "throw", "true",
                "try", "typedef", "typeid", "typename", "union", "unsigned", "using", "virtual", "void", "volatile", "wchar_t", "while", "xor",
                "xor_eq"};
        languageCPlusPlus.keywords = keywordsCPlusPlus;


        ProgrammingLanguage languageJavascript = new ProgrammingLanguage();

        languageJavascript.name = "Javascript";

        String[] versionsJavascript = {"ES1", "ES2", "ES3", "ES5", "ES6 (ES2015)", "ES2016", "ES2017", "ES2018", "ES2019", "ES2020",
                "ES2021", "ES2022", "ES2023"};
        languageJavascript.version = versionsJavascript;

        String[] typingJavascript = {"DYNAMIC Typing", "WEAK Typing"};
        languageJavascript.typing = typingJavascript;

        String[] keywordsJavascript = {"break", "case", "catch", "class", "const", "continue", "debugger", "default", "delete", "do", "else",
                "enum", "export", "extends", "false", "finally", "for", "function", "if", "import", "in", "instanceof", "let", "new", "null",
                "return", "super", "switch", "this", "throw", "true", "try", "typeof", "var", "void", "while", "with", "yield"};
        languageJavascript.keywords = keywordsJavascript;
    }

}
