package edreamz.mandoob.network;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreferenceManager {

    public static final String PREF_NAME = "Durocrete";


    // Login
    public static final String Username = "username";
    public static final String Password = "password";
    public static final String language = "language";
    public static final String show_message_flag="show_message_flag";



    // Shared Preferences
    SharedPreferences pref;
    // Editor for Shared preferences
    SharedPreferences.Editor editor;
    // Context
    Context _context;
    // Shared pref mode
    int PRIVATE_MODE = 0;
    private String TAG = MyPreferenceManager.class.getSimpleName();


    // Constructor
    public MyPreferenceManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void clearSharedPreference() {
        editor.clear();
        editor.commit();
    }

    public void clearSelectedSharedPreference(String key) {
        editor.remove(key);
        editor.commit();
    }

    //boolean
    public void setBooleanPreferences(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean getBooleanPreferences(String value) {
        return pref.getBoolean(value, false);
    }

    //String
    public String getStringPreferences(String value) {
        return pref.getString(value, null);
    }


    public void setStringPreferences(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }


    public void setIntPreferences(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public int getIntPreferences(String value) {
        return pref.getInt(value, 0);
    }

//    public void storeUser(User user) {
//        editor.putString(KEY_USER_ID, user.getId());
//        editor.putString(KEY_USER_NAME, user.getName());
//        editor.putString(KEY_USER_EMAIL, user.getEmail());
//        editor.commit();
//
//        Log.e(TAG, "User is stored in shared preferences. " + user.getName() + ", " + user.getEmail());
//    }
//
//    public User getUser() {
//        if (pref.getString(KEY_USER_ID, null) != null) {
//            String id, name, email;
//            id = pref.getString(KEY_USER_ID, null);
//            name = pref.getString(KEY_USER_NAME, null);
//            email = pref.getString(KEY_USER_EMAIL, null);
//
//            User user = new User(id, name, email);
//            return user;
//        }
//        return null;
//    }

//    public void addNotification(String notification) {
//
//        // get old notifications
//        String oldNotifications = getNotifications();
//
//        if (oldNotifications != null) {
//            oldNotifications += "|" + notification;
//        } else {
//            oldNotifications = notification;
//        }
//
//        editor.putString(KEY_NOTIFICATIONS, oldNotifications);
//        editor.commit();
//    }
//
//    public String getNotifications() {
//        return pref.getString(KEY_NOTIFICATIONS, null);
//    }

//    public void clear() {
//        editor.clear();
//        editor.commit();
//    }
}
