package net.thebyrdnest.aoc.aoc2019;

import java.util.ArrayList;

public class Day08 {
    ArrayList<String> layers = new ArrayList<>();

    public int numbersInImage(String layer, char number) {
        int iCount = 0;
        for (char cChar : layer.toCharArray()) {
            if (cChar == number)
                iCount++;
        }

        return iCount;
    }

    public int solve1(String input, int width, int height) {
        int i=0;

        System.out.println("Num Layers: " + input.length() / (width*height));
        while (i < input.length()) {
            layers.add(input.substring(i, i + (width * height)));
            i+= (width*height);
        }

        int iLayerIndex = -1;
        int iLayerZeroCount = width*height+1;
        int iLayer = -1;
        for (String layer : layers) {
            iLayer++;
            int zeros = numbersInImage(layer, '0');
            //System.out.println(iLayer + ": " + zeros);

            if (zeros < iLayerZeroCount) {
                iLayerZeroCount = zeros;
                iLayerIndex = iLayer;
            }
        }

        int ones = numbersInImage(layers.get(iLayerIndex), '1');
        int twos = numbersInImage(layers.get(iLayerIndex), '2');

        return ones*twos;
    }

    public String solve2(String input, int width, int height) {
        solve1(input, width, height);

        // process the layers
        String composit = "222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222";
        char[] cComposit = composit.toCharArray();
        for (int i=layers.size()-1; i>=0; i--) {
            char[] cLayer = layers.get(i).toCharArray();
            for (int j=0; j < cLayer.length; j++) {
                if (cLayer[j] != '2') {
                    cComposit[j] = cLayer[j];
                }
            }
        }

        return new String(cComposit);
    }
}