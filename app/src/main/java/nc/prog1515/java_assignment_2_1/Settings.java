package nc.prog1515.java_assignment_2_1;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.fonts.FontFamily;

public class Settings {
    public String text;
    public Typeface typeface;
    public Float fontSize;
    public String fontFamily;
    public int textColor;
    public int backgroundColor;

    Settings(String _text, Typeface _typeface, Float _fontSize, String _fontFamily, int _textColor, int _backgroundColor){
        text = _text;
        typeface = _typeface;
        fontSize = _fontSize;
        fontFamily = _fontFamily;
        textColor = _textColor;
        backgroundColor = _backgroundColor;
    }

    @Override
    public String toString(){
        String output = "Text:\t" + text +
                "\nBold:\t" + typeface.isBold() +
                "\nItalic:\t" + typeface.isItalic() +
                "\nFont Family:\t" + fontFamily +
                "\nFont Size:\t" + fontSize.toString() +
                "\nText Color:\t" + textColor +
                "\nBackground Color:\t" + backgroundColor;
        return output;
    }
}
