package com.morse.testMorse.Entities;

import lombok.Data;
import java.util.regex.Pattern;
@Data
public class Morse {
    public static final String[] english = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            ",", ".", "?" };

    public static final String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "--..--", ".-.-.-", "..--.." };

    private String ascii="";
    private String morses="";
    public Morse(String morse){
        this.morses=morse;
        convertirAMorse();
    }
    private void convertirAMorse(){
        int index=-1;
        String separador = Pattern.quote(" ");
        String[] parts = morses.split(separador);
        for(int i=0; i<parts.length;i++){
            index=buscarCodigo(parts[i]);
            if(index!=-1)
                ascii+=english[index];
        }
    }
    private int buscarCodigo(String c){
        int index=-1;
        for(int i=0; i<morse.length;i++){
            if(morse[i].equals(c))
                index=i;
        }
        return index;
    }
}
