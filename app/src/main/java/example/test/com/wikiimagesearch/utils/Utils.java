package example.test.com.wikiimagesearch.utils;

import android.graphics.Bitmap;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONObject;

import example.test.com.wikiimagesearch.R;

/**
 * Created by root on 23/2/17.
 */
public class Utils {

    /**
     * Set the text change listener
     * @param editText
     * @param onTextChange
     */
    public static void setTextWatcher(EditText editText , final OnTextChange onTextChange){
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                onTextChange.onTextChange(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    /**
     * Check for key exist in json or not
     * @param jsonObject
     * @param key
     * @return
     */
    public static boolean isKeyExistInJson(JSONObject jsonObject , String key){
        try{
            return jsonObject.has(key);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }


    public static ImageLoader getImageLoaderInstance(){
        return ImageLoader.getInstance();
    }

    /**
     * Get display option
     * @return
     */
    public static DisplayImageOptions getDisplayOption(){
        return new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.default_image)
                .showImageForEmptyUri(R.drawable.default_image)
                .showImageOnFail(R.drawable.default_image)
                .cacheInMemory(true)
                .cacheOnDisc(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
    }
}
