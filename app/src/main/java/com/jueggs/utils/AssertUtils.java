package com.jueggs.utils;

public class AssertUtils
{
    public static void assertNotNull(Object object, String msg)
    {
        if (object == null)
            throw new NullPointerException(msg);
    }
}
