/**
 * Copyright (C) 2022 the original author or authors.
 * See the notice.md file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ancevt.gifparser;

import java.util.Arrays;

public class GifColorTable {

    private final int size;
    private final int[] colors;

    GifColorTable(byte[] colorBytes, int size, int[] colors) {
        this.size = size;
        this.colors = colors;
    }

    GifColorTable(byte[] colorBytes, int size) {
        this.size = size;
        this.colors = convertBytesToColors(colorBytes);
    }

    public int getSize() {
        return size;
    }

    public int getColorCount() {
        return colors.length;
    }

    public int getColor(int index) {
        return colors[index];
    }

    @Override
    public String toString() {
        return "GifColorTable{" +
                "size=" + size +
                ", colors=" + Arrays.toString(colors) +
                '}';
    }

    private static int[] convertBytesToColors(byte[] colorBytes) {
        int length = colorBytes.length / 3;
        int[] colors = new int[length];
        int index = 0;

        for (int i = 0; i < colorBytes.length; i += 3) {
            final int r = colorBytes[i + 0] & 0xFF;
            final int g = colorBytes[i + 1] & 0xFF;
            final int b = colorBytes[i + 2] & 0xFF;

            int rgb = r;
            rgb = (rgb << 8) + g;
            rgb = (rgb << 8) + b;

            colors[index] = rgb;

            index++;
        }

        return colors;
    }

}
