package com.jueggs.utils;

import java.util.List;

public class Utils
{
    public static <T> boolean isEmpty(List<T> list)
    {
        return list == null || list.size() == 0;
    }

    public static <T> boolean hasElements(List<T> list)
    {
        return !isEmpty(list);
    }

    public static boolean isEmpty(byte[] array)
    {
        return array == null || array.length == 0;
    }

    public static boolean hasElements(byte[] array)
    {
        return !isEmpty(array);
    }
}
