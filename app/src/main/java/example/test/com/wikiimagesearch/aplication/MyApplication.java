package example.test.com.wikiimagesearch.aplication;

import android.app.Application;

import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by root on 24/2/17.
 */
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        this.initImageLoader();
    }

    /**
     * Init the image loaded
     */
    private void initImageLoader(){
        // Create global configuration and initialize ImageLoader with this configuration
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this.getApplicationContext())
                .memoryCache(new UsingFreqLimitedMemoryCache(5 * 1024 * 1024)) // 5 Mb (delete most not used image)
                .build();
        ImageLoader.getInstance().init(config);
    }
}
