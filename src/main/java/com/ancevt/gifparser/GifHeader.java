/**
 * Copyright (C) 2022 the original author or authors.
 * See the notice.md file distributed with this work for additional
 * information regarding copyright ownership.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ancevt.gifparser;

public class GifHeader {

    private final String version;
    private final int logicalScreenWidth;
    private final int logicalScreenHeight;
    private final boolean globalColorTableFlag;
    private final int colorResolution;
    private final boolean globalColorTableSortFlag;
    private final int globalColorTableSize;

    private final int backgroundColorIndex;
    private final int pixelAspectRatio;

    private final GifColorTable globalColorTable;

    private final float computedAspectRatio;

    public GifHeader(
            String version,
            int logicalScreenWidth,
            int logicalScreenHeight,
            boolean globalColorTableFlag,
            int colorResolution,
            boolean globalColorTableSortFlag,
            int globalColorTableSize,
            int backgroundColorIndex,
            int pixelAspectRatio,
            GifColorTable globalColorTable
    ) {
        this.version = version;
        this.logicalScreenWidth = logicalScreenWidth;
        this.logicalScreenHeight = logicalScreenHeight;
        this.globalColorTableFlag = globalColorTableFlag;
        this.colorResolution = colorResolution;
        this.globalColorTableSortFlag = globalColorTableSortFlag;
        this.globalColorTableSize = globalColorTableSize;
        this.backgroundColorIndex = backgroundColorIndex;
        this.pixelAspectRatio = pixelAspectRatio;
        this.globalColorTable = globalColorTable;
        this.computedAspectRatio = (pixelAspectRatio + 15f) / 16;
    }

    public String getVersion() {
        return version;
    }

    public int getLogicalScreenWidth() {
        return logicalScreenWidth;
    }

    public int getLogicalScreenHeight() {
        return logicalScreenHeight;
    }

    public boolean isGlobalColorTableFlag() {
        return globalColorTableFlag;
    }

    public int getColorResolution() {
        return colorResolution;
    }

    public boolean isGlobalColorTableSortFlag() {
        return globalColorTableSortFlag;
    }

    public int getGlobalColorTableSize() {
        return globalColorTableSize;
    }

    public int getBackgroundColorIndex() {
        return backgroundColorIndex;
    }

    public int getPixelAspectRatio() {
        return pixelAspectRatio;
    }

    public GifColorTable getGlobalColorTable() {
        return globalColorTable;
    }

    public float getComputedAspectRatio() {
        return computedAspectRatio;
    }

    @Override
    public String toString() {
        return "GifHeader{" +
                "version='" + version + '\'' +
                ", logicalScreenWidth=" + logicalScreenWidth +
                ", logicalScreenHeight=" + logicalScreenHeight +
                ", globalColorTableFlag=" + globalColorTableFlag +
                ", colorResolution=" + colorResolution +
                ", globalColorTableSortFlag=" + globalColorTableSortFlag +
                ", globalColorTableSize=" + globalColorTableSize +
                ", backgroundColorIndex=" + backgroundColorIndex +
                ", pixelAspectRatio=" + pixelAspectRatio +
                ", globalColorTable=" + globalColorTable +
                ", computedAspectRatio=" + computedAspectRatio +
                '}';
    }
}
