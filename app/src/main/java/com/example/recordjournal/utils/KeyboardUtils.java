package com.example.recordjournal.utils;

import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import com.example.recordjournal.R;

/**
 * @author hello word
 * @desc 作用描述
 * @date 2021/9/8
 */
public class KeyboardUtils {
    private final Keyboard k1;
    private KeyboardView mKeyboardView;
    private EditText mEditText;

    public interface OnEnsureListener{
        public void onEnsure();
    }

    OnEnsureListener onEnsureListener;

    public void setOnEnsureListener(OnEnsureListener onEnsureListener) {
        this.onEnsureListener = onEnsureListener;
    }

    KeyboardView.OnKeyboardActionListener listener = new KeyboardView.OnKeyboardActionListener() {
        @Override
        public void onPress(int primaryCode) {

        }

        @Override
        public void onRelease(int primaryCode) {

        }

        @Override
        public void onKey(int primaryCode, int[] keyCodes) {
            //~~~
            Editable editable = mEditText.getText();
            int start = mEditText.getSelectionStart();
            switch (primaryCode){
                case Keyboard.KEYCODE_DELETE://点击了删除键
                    if (editable!=null&&editable.length()>0){
                        if (start>0){
                            editable.delete(start-1,start);
                        }
                    }
                    break;
                case Keyboard.KEYCODE_CANCEL://清零
                    editable.clear();
                    break;
                case Keyboard.KEYCODE_DONE://运算
                    onEnsureListener.onEnsure();
                    break;
                default://其他数字直接插入
                    editable.insert(start,Character.toString((char) primaryCode));
                    break;
            }
        }

        @Override
        public void onText(CharSequence text) {

        }

        @Override
        public void swipeLeft() {

        }

        @Override
        public void swipeRight() {

        }

        @Override
        public void swipeDown() {

        }

        @Override
        public void swipeUp() {

        }
    };

    public KeyboardUtils(KeyboardView keyboardView, EditText editText) {
        mKeyboardView = keyboardView;
        mEditText = editText;
        mEditText.setInputType(InputType.TYPE_NULL);  //取消弹出系统键盘
        k1 = new Keyboard(mEditText.getContext(), R.xml.keyboard);
        mKeyboardView.setKeyboard(k1);
        mKeyboardView.setEnabled(true);
        mKeyboardView.setPreviewEnabled(true);
        mKeyboardView.setOnKeyboardActionListener(listener);
    }

    /*显示出键盘*/
    public void showKeyboard() {
        int visibility = mKeyboardView.getVisibility();
        if (visibility == View.INVISIBLE || visibility == View.GONE) {
            mKeyboardView.setVisibility(View.VISIBLE);
        }
    }
}
