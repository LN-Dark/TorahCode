package com.lua.torahcode;


public class HebrewAlphabet {

    public char ConvertToLetters(char c)
    {
        switch ( c )
        {
            case 'א': return 'a';
            case 'ב': return 'b';
            case 'ג': return 'g';
            case 'ד': return 'd';
            case 'ה': return 'h';
            case 'ו': return 'v';
            case 'ז': return 'z';
            case 'ח': return 'x';
            case 'ט': return 'u';
            case 'י': return 'y';
            case 'כ': return 'k';
            case 'ך': return '!';
            case 'ל': return 'l';
            case 'מ': return 'm';
            case 'ם': return ',';
            case 'נ': return 'n';
            case 'ן': return ']';
            case 'ס': return 'c';
            case 'ע': return 'i';
            case 'פ': return 'p';
            case 'ף': return '[';
            case 'צ': return 'j';
            case 'ץ': return '/';
            case 'ק': return 'q';
            case 'ר': return 'r';
            case 'ש': return '>';
            case 'ת': return 't';
            case ':': return '.';
            case '-': return ' ';
            default: return c;
        }
    }

    public String ConvertToNumbers(char c)
    {
        switch ( c )
        {
            case 'א': return "1";
            case 'ב': return "2";
            case 'ג': return "3";
            case 'ד': return "4";
            case 'ה': return "5";
            case 'ו': return "6";
            case 'ז': return "7";
            case 'ח': return "8";
            case 'ט': return "9";
            case 'י': return "10";
            case 'כ': return "20";
            case 'ל': return "30";
            case 'מ': return "40";
            case 'נ': return "50";
            case 'ס': return "60";
            case 'ע': return "70";
            case 'פ': return "80";
            case 'צ': return "90";
            case 'ק': return "100";
            case 'ר': return "200";
            case 'ש': return "300";
            case 'ת': return "400";
            default: return String.valueOf(c);
        }
    }

    public char ConvertToHebrew(char c)
    {
        switch ( c )
        {
            case 'a': return 'א';
            case 'b': return 'ב';
            case 'g': return 'ג';
            case 'd': return 'ד';
            case 'h': return 'ה';
            case 'v': return 'ו';
            case 'z': return 'ז';
            case 'x': return 'ח';
            case 'u': return 'ט';
            case 'y': return 'י';
            case 'k': return 'כ';
            case '!': return 'ך';
            case 'l': return 'ל';
            case 'm': return 'מ';
            case ',': return 'ם';
            case 'n': return 'נ';
            case ']': return 'ן';
            case 'c': return 'ס';
            case 'i': return 'ע';
            case 'p': return 'פ';
            case '[': return 'ף';
            case 'j': return 'צ';
            case '/': return 'ץ';
            case 'q': return 'ק';
            case 'r': return 'ר';
            case '>': return 'ש';
            case 't': return 'ת';
            case '.': return ':';
            case ' ': return '-';
            default: return c;
        }
    }
}
