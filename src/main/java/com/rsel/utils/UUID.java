package com.rsel.utils;


import java.util.Arrays;
import java.util.Random;

/**
 * Package UUID
 */
public abstract class UUID {

    static Random r = new Random();

        /**
         * Generate a random integer based on a range
         *
         * @param min
         * Minimum value (included)
         * @param max
         * Maximum (included)
         * @return random number
         */
    public static int random(int min, int max) {
        return r.nextInt(max - min + 1) + min;
    }

    private static final char[] _UU64 = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] _UU32 = "0123456789abcdefghijklmnopqrstuv".toCharArray();


    /**
     * @return hexadecimal representation of the UUID in compact format
     */
    public static String UU64() {
        return UU64(java.util.UUID.randomUUID());
    }
    /**
         * Returns a UUID and converts it into a compact form in hexadecimal with the content [\\-0-9a-zA-Z_]
         * <p>
         * For example, a UUID like the following:
         *
         * <pre>
         * a6c5c51c-689c-4525-9bcd-c14c1e107c80
         * A total of 128 bits, divided into L64 and R64, divided into two 64-bit (two long)
         * > L = uu.getLeastSignificantBits();
         * > UUID = uu.getMostSignificantBits();
         * And a hexadecimal number is 6 bits, so the order we take values ​​is
         * 1. Take 10 times from L64 bit, take 6 bits at a time
         * 2. Take the last 4 digits from the L64 bit + the R64 header and the 2 digits
         * 3. Take 10 times from R64, take 6 bits at a time
         * 4. The remaining two are taken last
         * This way, you can use a 22-length string to represent a 32-length UUID, compressing 1/3
         * </pre>
         *
         * @param uu
         * UUID object
         * @return hexadecimal representation of the UUID in compact format
         */
  
    public static String UU64(java.util.UUID uu) {
        int index = 0;
        char[] cs = new char[22];
        long L = uu.getMostSignificantBits();
        long R = uu.getLeastSignificantBits();
        long mask = 63;
     // Take 10 times from L64 bit, take 6 bits at a time
        for (int off = 58; off >= 4; off -= 6) {
            long hex = (L & (mask << off)) >>> off;
            cs[index++] = _UU64[(int) hex];
        }
        // Take the last 4 digits from the L64 bit + the R64 header and the 2 digits
        int l = (int) (((L & 0xF) << 2) | ((R & (3 << 62)) >>> 62));
        cs[index++] = _UU64[l];
     // Take 10 times from R64 bit, take 6 bits at a time
        for (int off = 56; off >= 2; off -= 6) {
            long hex = (R & (mask << off)) >>> off;
            cs[index++] = _UU64[(int) hex];
        }
     // The remaining two are taken last
        cs[index++] = _UU64[(int) (R & 3)];
     // return string
        return new String(cs);
    }

    /**
         * Revert back to a UUID object from a UU64
         *
         * @param uu64
         * UUID in hexadecimal, the content is [\\-0-9a-zA-Z_]
         * @return UUID object
         */
    public static java.util.UUID fromUU64(String uu64) {
        String uu16 = UU16FromUU64(uu64);
        return java.util.UUID.fromString(UU(uu16));
    }

    public static String UU32(java.util.UUID uu) {
        StringBuilder sb = new StringBuilder();
        long m = uu.getMostSignificantBits();
        long l = uu.getLeastSignificantBits();
        for (int i = 0; i < 13; i++) {
            sb.append(_UU32[(int) (m >> ((13 - i - 1) * 5)) & 31]);
        }
        for (int i = 0; i < 13; i++) {
            sb.append(_UU32[(int) (l >> ((13 - i - 1)) * 5) & 31]);
        }
        return sb.toString();
    }

    public static String UU32() {
        return UU32(java.util.UUID.randomUUID());
    }

    public static java.util.UUID fromUU32(String u32) {
        return new java.util.UUID(parseUnsignedLong(u32.substring(0, 13), 32),
                        parseUnsignedLong(u32.substring(13), 32));
    }

    public static long parseUnsignedLong(String s, int radix) {
        int len = s.length();
        long first = Long.parseLong(s.substring(0, len - 1), radix);
        int second = Character.digit(s.charAt(len - 1), radix);
        return first * radix + second;
    }

    /**
         * Convert a compact format UU16 string into a standard UUID format string
         *
         * @param uu16
         * @return standard UUID string
         */
    public static String UU(String uu16) {
        StringBuilder sb = new StringBuilder();
        sb.append(uu16.substring(0, 8));
        sb.append('-');
        sb.append(uu16.substring(8, 12));
        sb.append('-');
        sb.append(uu16.substring(12, 16));
        sb.append('-');
        sb.append(uu16.substring(16, 20));
        sb.append('-');
        sb.append(uu16.substring(20));
        return sb.toString();
    }

    private static final char[] _UU16 = "0123456789abcdef".toCharArray();

    /**
         * Make a compact string represented by UU64 into a string represented by UU16
         *
         * <pre>
         * Take 2 characters each time, restore to 3 bytes, repeat 10 times, the last time, use the last 2 characters, restore back to 2 bytes </prev>
         *
         * @param uu64
         * UuID in uu64 in hexadecimal, the content is [\\-0-9a-zA-Z_]
         * @return hexadecimal representation of the UUID in compact format
         */
    public static String UU16FromUU64(String uu64) {
        byte[] bytes = new byte[32];
        char[] cs = uu64.toCharArray();
        int index = 0;
     // Take 2 characters each time, restore to 3 bytes, repeat 10 times,
        for (int i = 0; i < 10; i++) {
            int off = i * 2;
            char cl = cs[off];
            char cr = cs[off + 1];
            int l = Arrays.binarySearch(_UU64, cl);
            int r = Arrays.binarySearch(_UU64, cr);
            int n = (l << 6) | r;
            bytes[index++] = (byte) ((n & 0xF00) >>> 8);
            bytes[index++] = (byte) ((n & 0xF0) >>> 4);
            bytes[index++] = (byte) (n & 0xF);
        }
     // Last time, use the last 2 characters to restore back to 2 bytes
        char cl = cs[20];
        char cr = cs[21];
        int l = Arrays.binarySearch(_UU64, cl);
        int r = Arrays.binarySearch(_UU64, cr);
        int n = (l << 2) | r;
        bytes[index++] = (byte) ((n & 0xF0) >>> 4);
        bytes[index++] = (byte) (n & 0xF);

     // return a UUID object
        char[] names = new char[32];
        for (int i = 0; i < bytes.length; i++)
            names[i] = _UU16[bytes[i]];
        return new String(names);
    }

    /**
         * Returns a string of the specified length consisting of a random number + a lowercase letter
         *
         * @param length
         * specified length
         * @return random string
         */
    public static String captchaChar(int length) {
        return captchaChar(length, false);
    }

    /**
         * Returns a string of the specified length random number + letter (case sensitive)
         *
         * @param length
         * specified length
         * @param caseSensitivity
         * Is it case sensitive?
         * @return random string
         */
    public static String captchaChar(int length, boolean caseSensitivity) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();// Randomly use the following three random generators
        Random randdata = new Random();
        int data = 0;
        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(caseSensitivity ? 3 : 2);
         // The purpose is to randomly generate generated numbers, uppercase and lowercase letters
            switch (index) {
            case 0:
                data = randdata.nextInt(10);// Only generate 0~9, 0~9 ASCII is 48~57
                sb.append(data);
                break;
            case 1:
                data = randdata.nextInt(26) + 97;// guarantee that only integers between ASCII and 97~122(a-z) will be generated.
                sb.append((char) data);
                break;
            case 2: // When caseSensitivity is true, there will be uppercase letters
                data = randdata.nextInt(26) + 65;// Guaranteed to only produce integers between ASCII and 65~90 (A~Z)
                sb.append((char) data);
                break;
            }
        }
        return sb.toString();
    }

    /**
         * Returns a string of random numbers of the specified length
         *
         * @param length
         * specified length
         * @return random string
         */
    public static String captchaNumber(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }
}