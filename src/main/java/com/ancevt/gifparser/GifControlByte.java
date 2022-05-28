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

public class GifControlByte {

    /**
     * GIF file signature
     */
    public static final String SIGNATURE = "GIF";

    /**
     * Image separator byte code
     */
    public static final int IMAGE_SEPARATOR = 0x2C;

    /**
     * Extension introducer byte code
     */
    public static final int EXTENSION_INTRODUCER = 0x21;

    /**
     * Graphic control extension block byte code
     */
    public static final int EXT_GRAPHIC_CONTROL = 0xF9;

    /**
     * Comment extension block byte code
     */
    public static final int EXT_COMMENT = 0xFE;

    /**
     * Plain text extension block byte code (not used in real cases)
     */
    public static final int EXT_PLAIN_TEXT = 0x01;

    /**
     * Application extension block byte code
     */
    public static final int EXT_APPLICATION = 0xFF;

    /**
     * GIF block terminator byte code
     */
    public static final int BLOCK_TERMINATOR = 0x00;

    /**
     * GIF end of file trailer byte code
     */
    public static final int TRAILER = 0x3B;
}
