package com.jueggs.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import java.util.List;

public class UIUtils
{
    private static Fade fadeIn;
    private static Fade fadeOut;

    static
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            fadeIn = new Fade(Fade.IN);
            fadeOut = new Fade(Fade.OUT);
        }
    }

    public static void showViewWithFade(ViewGroup root, View view, boolean show)
    {
        if (show && view.getVisibility() == View.VISIBLE || !show && view.getVisibility() == View.GONE)
            return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            TransitionManager.beginDelayedTransition(root, show ? fadeIn : fadeOut);
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public static void showSimpleOneFieldInputDialog(Context context, ViewGroup root, String text, int titleRes, int hintRes, int posCaptionRes,
                                                     int negCaptionRes, final ProcessInput processor)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.input_one_field, root, false);
        final TextInputEditText editText = (TextInputEditText) view.findViewById(R.id.input);
        editText.setHint(hintRes);
        if (!TextUtils.isEmpty(text))
            editText.setText(text);

        builder.setTitle(titleRes);
        builder.setView(view);
        builder.setPositiveButton(posCaptionRes, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int i)
            {
                dialog.dismiss();
                processor.process(editText.getText().toString());
            }
        });
        builder.setNegativeButton(negCaptionRes, null);

        Dialog dialog = builder.create();
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        dialog.show();
    }

    public static void showConfirmationDialog(Context context, int titleRes, int messageRes, int posCaptionRes,
                                              int negCaptionRes, final Action action)
    {
        String message = context.getString(messageRes);
        showConfirmationDialog(context, titleRes, message, posCaptionRes, negCaptionRes, action);
    }

    public static void showConfirmationDialog(Context context, int titleRes, String message, int posCaptionRes,
                                              int negCaptionRes, final Action action)
    {
        new AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(titleRes)
                .setMessage(message)
                .setPositiveButton(posCaptionRes, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int i)
                    {
                        dialog.dismiss();
                        action.execute();
                    }
                })
                .setNegativeButton(negCaptionRes, null)
                .show();
    }

    public interface ProcessInput
    {
        void process(String input);
    }

    public interface Action
    {
        void execute();
    }
}
