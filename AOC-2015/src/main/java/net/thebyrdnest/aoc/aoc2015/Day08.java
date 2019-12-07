package net.thebyrdnest.aoc.aoc2015;

public class Day08 {
    int memCount = 0;
    int codeCount = 0;
    int encodingCount = 0;

    public void countCharacters(String input) {
        memCount = 0;
        codeCount = 0;
        encodingCount = 0;

        char[] cInput = input.toCharArray();

        int i=0;
        while(i < cInput.length) {
            if (cInput[i] == '\\') {
                if (i < cInput.length - 1 && cInput[i + 1] == '\\') {
                    codeCount+=2;
                    memCount+=1;
                    encodingCount+=4;
                    i += 2;
                } else if (i < cInput.length - 1 && cInput[i + 1] == '\"') {
                    codeCount+=2;
                    memCount+=1;
                    encodingCount+=4;
                    i += 2;
                } else if (i < cInput.length - 1 && cInput[i + 1] == 'x') {
                    codeCount+=4;
                    memCount+=1;
                    encodingCount+=5;
                    i += 4;
                }
            } else if (cInput[i] == '\"') {
                codeCount+=1;
                memCount+=0;
                encodingCount+=2;
                i += 1;
            }else {
                codeCount+=1;
                memCount+=1;
                encodingCount+=1;
                i += 1;
            }
        }
        encodingCount+=2;
    }

    public int getMemCount() {
        return memCount;
    }

    public int getCodeCount() {
        return codeCount;
    }

    public int getEncodingCount() {
        return encodingCount;
    }
}
