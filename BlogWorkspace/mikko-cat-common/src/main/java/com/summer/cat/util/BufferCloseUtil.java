package com.summer.cat.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class BufferCloseUtil {
    public static void closeBufferInput(BufferedInputStream bis) throws IOException {
        if (null != bis) {
            bis.close();
        }
    }

    public static void closeBufferOutput(BufferedOutputStream bos) throws IOException {
        if (null != bos) {
            bos.close();
        }
    }
}
