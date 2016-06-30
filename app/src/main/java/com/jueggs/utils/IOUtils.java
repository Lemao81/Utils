package com.jueggs.utils;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOUtils
{
    public static final String TAG = IOUtils.class.getSimpleName();

    public static String readStream(InputStream is)
    {
        StringBuilder buffer = new StringBuilder();

        if (is != null)
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            try
            {
                String line;
                while ((line = br.readLine()) != null)
                    buffer.append(line);
            }
            catch (IOException e)
            {
                Log.e(TAG, e.getMessage());
            }
            finally
            {
                try
                {
                    is.close();
                    br.close();
                }
                catch (IOException e)
                {
                    Log.e(TAG, e.getMessage());
                }
            }
        }
        return buffer.toString();
    }
}
