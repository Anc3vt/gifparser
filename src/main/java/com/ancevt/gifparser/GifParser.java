/**
 * Copyright (C) 2022 the original author or authors.
 * See the notice.md file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ancevt.gifparser;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class GifParser {

    public static void main(String[] args) throws IOException, GifException {
        final GifParser parser = new GifParser();
        final GifData result = parser.parse(
                GifParser.class.getClassLoader().getResourceAsStream("giphy1.gif")
        );

        System.out.println("Result: " + result);
    }

    private File file;
    private DataInputStream stream;

    public GifParser() {

    }

    public GifData parse(File file) throws FileNotFoundException, IOException, GifException {
        return parse(new FileInputStream(file));
    }

    public GifData parse(InputStream inputStream) throws IOException, GifException {
        stream = new DataInputStream(inputStream);

        final byte[] bSign = new byte[3];
        stream.read(bSign);
        final String sign = new String(bSign);

        if (!sign.equals(GifControlByte.SIGNATURE)) {
            throw new GifException("GIF signature not found in input stream (not a gif?)");
        }

        final byte[] bVersion = new byte[3];
        stream.read(bVersion);
        final String version = new String(bVersion);

        final int logicalScreenWidth = stream.readUnsignedShort();
        final int logicalScreenHeight = stream.readUnsignedShort();

        final int multiValue = stream.readUnsignedByte();

        final boolean globalColorTableFlag = (multiValue & 0x80) != 0;
        final int colorResolution = (multiValue & 0x70) >> 4;
        final boolean globalColorTableSortFlag = (multiValue & 0x08) != 0;
        final int globalColorTableSize = (multiValue & 0x07);

        final int backgroundColorIndex = stream.readUnsignedByte();
        final int pixelAspectRatio = stream.readUnsignedByte();

        final GifColorTable globalColorTable
                = globalColorTableFlag ? parseColorTable(
                globalColorTableSize
        ) : null;

        final GifHeader header = new GifHeader(
                version,
                logicalScreenWidth,
                logicalScreenHeight,
                globalColorTableFlag,
                colorResolution,
                globalColorTableSortFlag,
                globalColorTableSize,
                backgroundColorIndex,
                pixelAspectRatio,
                globalColorTable
        );

        // TODO: implement here

        System.out.println(header);

        return null;
    }

    private GifColorTable parseColorTable(int size) throws IOException {
        final int colorCount = (int) Math.pow(2, size + 1);
        final int length = 3 * colorCount;

        byte[] bytes = new byte[length];

        for (int i = 0; i < length; i += 3) {
            bytes[i] = stream.readByte(); // R
            bytes[i + 1] = stream.readByte(); // G
            bytes[i + 2] = stream.readByte(); // B
        }

        return new GifColorTable(bytes, size);
    }
}
