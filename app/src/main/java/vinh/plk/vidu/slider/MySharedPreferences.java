package vinh.plk.vidu.slider;

import android.content.Context;
import android.content.SharedPreferences;

import java.security.Key;

public class MySharedPreferences {
    private static final String Shared_Preferences = "SharedPreferences";
    private Context context ;

    public MySharedPreferences(Context context) {
        this.context = context;
    }
    public void putBooleanValue(String key, boolean value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(Shared_Preferences,Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();

    }
    public boolean getBooleanValue(String Key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(Shared_Preferences,Context.MODE_PRIVATE );
        return sharedPreferences.getBoolean(Key,false);

    }

}
