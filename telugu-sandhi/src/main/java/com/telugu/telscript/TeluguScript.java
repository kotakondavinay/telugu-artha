package com.telugu.telscript;

import com.telugu.sanscript.Sanscript;

import java.util.*;

/**
 * Created by vinaykk on 26/01/17.
 */
public class TeluguScript {
    public TeluguScript() {
        initializeSchemes();
        initializeAlternates();
    }


    // Options interface.
    public static interface Options extends Map<String, Object> {}

    // Options default implementation.
    public static class HashOptions extends HashMap<String, Object> implements TeluguScript.Options {
        public TeluguScript.HashOptions set(String key, Object value) {
            put(key, value);
            return this;
        }
    }

    private TeluguScript.Options defaults = new TeluguScript.HashOptions().set("skip_sgml", false).set("syncope", false);

    // Scheme interface.
    public static interface Scheme extends Map<String, String[]> {
        // Create a deep copy of a scheme.
        public TeluguScript.Scheme cheapCopy();
    }

    // Scheme default implementation.
    public static class HashScheme extends HashMap<String, String[]> implements TeluguScript.Scheme {
        public TeluguScript.Scheme cheapCopy() {
            TeluguScript.Scheme copy = new TeluguScript.HashScheme();
            for (Map.Entry<String, String[]> entry : entrySet()) {
                String[] value = entry.getValue();
                copy.put(entry.getKey(), Arrays.copyOf(value, value.length));
            }
            return copy;
        }
    }

    public class Schemes extends HashMap<String, TeluguScript.Scheme> {}

    private TeluguScript.Schemes schemes = new TeluguScript.Schemes();

    /**
     * Returns the collection of all schemes.
     *
     * @return Schemes
     */
    public TeluguScript.Schemes getSchemes() {
        return schemes;
    }

    private void initializeSchemes() {
        TeluguScript.Scheme scheme;

        /* Telugu
         * ------
         * Sanskrit-complete.
         */
        scheme = new TeluguScript.HashScheme();
        scheme.put("vowels", new String[] {"అ", "ఆ", "ఇ", "ఈ", "ఉ", "ఊ", "ఋ", "ౠ", "ఌ", "ౡ", "ఎ", "ఏ", "ఐ", "ఒ", "ఓ", "ఔ"});
        scheme.put("vowel_marks", new String[] {"ా", "ి", "ీ", "ు", "ూ", "ృ", "ౄ", "ౢ", "ౣ", "ె", "ే", "ై", "ొ", "ో", "ౌ"});
        scheme.put("other_marks", new String[] {"ం", "ః", "ఁ"});
        scheme.put("virama", new String[] {"్"});
        scheme.put("consonants", new String[] {"క", "ఖ", "గ", "ఘ", "ఙ", "చ", "ఛ", "జ", "ఝ", "ఞ", "ట", "ఠ", "డ", "ఢ", "ణ", "త", "థ", "ద", "ధ", "న", "ప", "ఫ", "బ", "భ", "మ", "య", "ర", "ల", "వ", "శ", "ష", "స", "హ", "ళ", "క్ష", "జ్ఞ"});
        scheme.put("symbols", new String[] {"౦", "౧", "౨", "౩", "౪", "౫", "౬", "౭", "౮", "౯", "ఓం", "ఽ", "।", "॥"});
        scheme.put("other", new String[] {"", "", "", "", "", "", "", "", "ఱ"});
        schemes.put("telugu", scheme);

                /* Harvard-Kyoto
         * -------------
         * A simple 1:1 mapping.
         */
        scheme = new HashScheme();
        scheme.put("vowels", new String[] {"a", "A", "i", "I", "u", "U", "R", "RR", "lR", "lRR", "", "e", "ai", "", "o", "au"});
        scheme.put("other_marks", new String[] {"M", "H", "~",});
        scheme.put("virama", new String[] {""});
        scheme.put("consonants", new String[] {"k", "kh", "g", "gh", "G", "c", "ch", "j", "jh", "J", "T", "Th", "D", "Dh", "N", "t", "th", "d", "dh", "n", "p", "ph", "b", "bh", "m", "y", "r", "l", "v", "z", "S", "s", "h", "L", "kS", "jJ"});
        scheme.put("symbols", new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "OM", "'", "|", "||"});
        schemes.put("hk", scheme);

    }

    // Set of names of Roman schemes.
    private Map<String, Boolean> romanSchemes = new HashMap<String, Boolean>();

    // Map of alternate encodings.
    private class AlternateMap extends HashMap<String, String[]> {}
    private class Alternates extends HashMap<String, AlternateMap> {}

    private Alternates allAlternates = new Alternates();
    private void initializeAlternates() {
        AlternateMap map = new AlternateMap();
        map.put("A", new String[] {"aa"});
        map.put("I", new String[] {"ii", "ee"});
        map.put("U", new String[] {"uu", "oo"});
        map.put("RRi", new String[] {"R^i"});
        map.put("RRI", new String[] {"R^I"});
        map.put("LLi", new String[] {"L^i"});
        map.put("LLI", new String[] {"L^I"});
        map.put("M", new String[] {".m", ".n"});
        map.put("~N", new String[] {"N^"});
        map.put("ch", new String[] {"c"});
        map.put("Ch", new String[] {"C", "chh"});
        map.put("~n", new String[] {"JN"});
        map.put("v", new String[] {"w"});
        map.put("Sh", new String[] {"S", "shh"});
        map.put("kSh", new String[] {"kS", "x"});
        map.put("j~n", new String[] {"GY", "dny"});
        map.put("OM", new String[] {"AUM"});
        map.put("\\_", new String[] {"\\`"});
        map.put("\\_H", new String[] {"\\`H"});
        map.put("\\'M", new String[] {"\\'.m", "\\'.n"});
        map.put("\\_M", new String[] {"\\_.m", "\\_.n", "\\`M", "\\`.m", "\\`.n"});
        map.put(".a", new String[] {"~"});
        map.put("|", new String[] {"."});
        map.put("||", new String[] {".."});
        map.put("z", new String[] {"J"});
        allAlternates.put("itrans", map);
    }

    // object cache
    private class Cache {
        public String from = null;
        public String to = null;
        public TMap map = null;
        public Options options = null;
    }

    private Cache cache = new Cache();

    /**
     * Check whether the given scheme encodes romanized Sanskrit.
     *
     * @param name  the scheme name
     * @return      boolean
     */
    public boolean isRomanScheme(String name) {
        Boolean value = romanSchemes.get(name);
        return value != null && value;
    }


    private class SMap extends HashMap<String, String> {}

    private class TMap {
        public boolean fromRoman;
        public boolean toRoman;
        public SMap consonants;
        public SMap letters;
        public SMap marks;
        public String[] virama;
        public int maxTokenLength;
    }

    /**
     * Create a map from every character in `from` to its partner in `to`.
     * Also, store any "marks" that `from` might have.
     *
     * @param from     input scheme
     * @param to       output scheme
     * @param options  scheme options
     */
    private TMap makeMap(String from, String to, Options options) {
        AlternateMap alternates = allAlternates.get(from) != null ? allAlternates.get(from) : new AlternateMap();
        SMap consonants = new SMap();
        Scheme fromScheme = schemes.get(from);
        SMap letters = new SMap();
        List<Integer> tokenLengths = new ArrayList<Integer>();
        SMap marks = new SMap();
        Scheme toScheme = schemes.get(to);

        for (Map.Entry<String, String[]> entry : fromScheme.entrySet()) {
            String group = entry.getKey();
            String[] fromGroup = entry.getValue();
            String[] toGroup = toScheme.get(group);
            if (toGroup == null) {
                continue;
            }
            for (int i = 0; i < fromGroup.length; i++) {
                String F = fromGroup[i];
                String T = toGroup[i];
                String[] alts = alternates.get(F) != null ? alternates.get(F) : new String[] {};

                tokenLengths.add(F.length());
                for (String value : alts) {
                    tokenLengths.add(value.length());
                }

                if (group.equals("vowel_marks") || group.equals("virama")) {
                    marks.put(F,  T);
                    for (String alt : alts) {
                        marks.put(alt, T);
                    }
                } else {
                    letters.put(F, T);
                    for (String alt : alts) {
                        letters.put(alt, T);
                    }
                    if (group.equals("consonants") || group.equals("other")) {
                        consonants.put(F, T);
                        for (String alt : alts) {
                            consonants.put(alt, T);
                        }
                    }
                }
            }
        }

        TMap map = new TMap();
        map.consonants = consonants;
        map.fromRoman = isRomanScheme(from);
        map.letters = letters;
        map.marks = marks;
        map.maxTokenLength = Collections.max(tokenLengths);
        map.toRoman = isRomanScheme(to);
        map.virama = toScheme.get("virama");

        return map;
    }

    /**
     * Transliterate from one script to another.
     *
     * @param data     the string to transliterate
     * @param from     the source script
     * @param to       the destination script
     * @param options  transliteration options
     * @return         the finished string
     */
    public String t(String data, String from, String to, Options options) {
        if (options == null) {
            options = new HashOptions();
        }
        Options cachedOptions = cache.options != null ? cache.options : new HashOptions();
        boolean hasPriorState = (cache.from != null && cache.from.equals(from) && cache.to != null && cache.to.equals(to));
        TMap map;

        // Here we simultaneously build up an `options` object and compare
        // these options to the options from the last run.
        for (Map.Entry<String, Object> entry : defaults.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (options.get(key) != null) {
                value = options.get(key);
            }
            options.put(key, value);

            // This comparison method is not generalizable, but since these
            // objects are associative arrays with identical keys and with
            // values of known type, it works fine here.
            if (!value.equals(cachedOptions.get(key))) {
                hasPriorState = false;
            }
        }

        if (hasPriorState) {
            map = cache.map;
        } else {
            map = makeMap(from, to, options);
            cache.from = from;
            cache.map = map;
            cache.options = options;
            cache.to = to;
        }

        if (map.fromRoman) {
            return transliterateRoman(data, map, options);
        } else {
            return transliterateBrahmic(data, map, options);
        }
    }

    // Version of t() that supplies null options.
    public String t(String data, String from, String to) {
        return t(data, from, to, null);
    }

    /**
     * Transliterate from a romanized script.
     *
     * @param data     the string to transliterate
     * @param map      map data generated from makeMap()
     * @param options  transliteration options
     * @return         the finished string
     */
    private String transliterateRoman(String data, TMap map, Options options) {
        StringBuilder buf = new StringBuilder();
        SMap consonants = map.consonants;
        int dataLength = data.length();
        boolean hadConsonant = false;
        SMap letters = map.letters;
        SMap marks = map.marks;
        int maxTokenLength = map.maxTokenLength;
        Boolean optSkipSGML = (Boolean) options.get("skip_sgml");
        Boolean optSyncope = (Boolean) options.get("syncope");
        String tempLetter;
        String tempMark;
        StringBuilder tokenBuffer = new StringBuilder();
        boolean toRoman = map.toRoman;
        String[] virama = map.virama;

        // Transliteration state. It's controlled by these values:
        // - `skippingSGML`: are we in SGML?
        // - `toggledTrans`: are we in a toggled region?
        //
        // We combine these values into a single variable `skippingTrans`:
        //
        //     `skippingTrans` = skippingSGML || toggledTrans;
        //
        // If (and only if) this value is true, don't transliterate.
        boolean skippingSGML = false;
        boolean skippingTrans = false;
        boolean toggledTrans = false;

        for (int i = 0; (i < dataLength) || (tokenBuffer.length() > 0); i++) {
            // Fill the token buffer, if possible.
            int difference = maxTokenLength - tokenBuffer.length();
            if (difference > 0 && i < dataLength) {
                tokenBuffer.append(data.charAt(i));
                if (difference > 1) {
                    continue;
                }
            }

            // Match all token substrings to our map.
            for (int j = 0; j < maxTokenLength; j++) {
                String token = tokenBuffer.substring(0, Math.min(maxTokenLength - j, tokenBuffer.length()));

                if (skippingSGML) {
                    skippingSGML = !token.equals(">");
                } else if (token.equals("<")) {
                    skippingSGML = optSkipSGML;
                } else if (token.equals("##")) {
                    toggledTrans = !toggledTrans;
                    tokenBuffer = tokenBuffer.delete(0, 2);
                    break;
                }
                skippingTrans = skippingSGML || toggledTrans;
                if (((tempLetter = letters.get(token)) != null) && !skippingTrans) {
                    if (toRoman) {
                        buf.append(tempLetter);
                    } else {
                        // Handle the implicit vowel. Ignore 'a' and force
                        // vowels to appear as marks if we've just seen a
                        // consonant.
                        if (hadConsonant) {
                            if ((tempMark = marks.get(token)) != null) {
                                buf.append(tempMark);
                            } else if (!token.equals("a")) {
                                buf.append(virama[0]);
                                buf.append(tempLetter);
                            }
                        } else {
                            buf.append(tempLetter);
                        }
                        hadConsonant = consonants.get(token) != null;
                    }
                    tokenBuffer = tokenBuffer.delete(0, maxTokenLength - j);
                    break;
                } else if (j == maxTokenLength - 1) {
                    if (hadConsonant) {
                        hadConsonant = false;
                        if (!optSyncope) {
                            buf.append(virama[0]);
                        }
                    }
                    buf.append(token);
                    tokenBuffer = tokenBuffer.delete(0, 1);
                    // 'break' is redundant here, "j == ..." is true only on
                    // the last iteration.
                }
            }
        }
        if (hadConsonant && !optSyncope) {
            buf.append(virama[0]);
        }
        return buf.toString();
    }

    /**
     * Transliterate from a Brahmic script.
     *
     * @param data     the string to transliterate
     * @param map      map data generated from makeMap()
     * @param options  transliteration options
     * @return         the finished string
     */
    private String transliterateBrahmic(String data, TMap map, Options options) {
        StringBuilder buf = new StringBuilder();
        SMap consonants = map.consonants;
        boolean danglingHash = false;
        boolean hadRomanConsonant = false;
        SMap letters = map.letters;
        SMap marks = map.marks;
        String temp;
        boolean toRoman = map.toRoman;
        boolean skippingTrans = false;

        for (int i = 0; i < data.length(); i++) {
            String L = Character.toString(data.charAt(i));
            // Toggle transliteration state
            if (L.equals("#")) {
                if (danglingHash) {
                    skippingTrans = !skippingTrans;
                    danglingHash = false;
                } else {
                    danglingHash = true;
                }
                if (hadRomanConsonant) {
                    buf.append('a');
                    hadRomanConsonant = false;
                }
                continue;
            } else if (skippingTrans) {
                buf.append(L);
                continue;
            }

            if ((temp = marks.get(L)) != null) {
                buf.append(temp);
                hadRomanConsonant = false;
            } else {
                if (danglingHash) {
                    buf.append('#');
                    danglingHash = false;
                }
                if (hadRomanConsonant) {
                    buf.append('a');
                    hadRomanConsonant = false;
                }

                // Push transliterated letter if possible. Otherwise, push
                // the letter itself.
                if ((temp = letters.get(L)) != null && !temp.equals("")) {
                    buf.append(temp);
                    hadRomanConsonant = toRoman && (consonants.get(L) != null);
                } else {
                    buf.append(L);
                }
            }
        }
        if (hadRomanConsonant) {
            buf.append('a');
        }
        return buf.toString();
    }

}
