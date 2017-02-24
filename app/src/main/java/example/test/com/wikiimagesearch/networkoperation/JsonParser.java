package example.test.com.wikiimagesearch.networkoperation;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import example.test.com.wikiimagesearch.model.wikisearch.ThumbNail;
import example.test.com.wikiimagesearch.model.wikisearch.WikiImageDetail;
import example.test.com.wikiimagesearch.utils.Utils;

/**
 * Created by root on 24/2/17.
 */
public class JsonParser {

    /**
     * Parse the wiki json detail
     * @param jsonResponse
     * @return
     */
    public static ArrayList<WikiImageDetail> parseWikiJsonDetail(String jsonResponse){
        ArrayList<WikiImageDetail> arrayList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONObject jsonQueryObj = jsonObject.getJSONObject("query");
            JSONObject jsonPages = jsonQueryObj.getJSONObject("pages");

            Iterator<?> iterator = jsonPages.keys();
            while(iterator.hasNext()){
                String key = (String) iterator.next();
                JSONObject jsonData = jsonPages.getJSONObject(key);
                WikiImageDetail imageDetail = new WikiImageDetail();
                imageDetail.setPageId(jsonData.getString("pageid"));
                imageDetail.setNs(jsonData.getInt("ns"));
                imageDetail.setTitle(jsonData.getString("title"));
                imageDetail.setIndex(jsonData.getInt("index"));

                if(Utils.isKeyExistInJson(jsonData , "thumbnail")){
                    JSONObject jsonThumNail = jsonData.getJSONObject("thumbnail");
                    ThumbNail thumbNail = new ThumbNail();
                    thumbNail.setSource(jsonThumNail.getString("source"));
                    thumbNail.setHeight(jsonThumNail.getInt("height"));
                    thumbNail.setWidth(jsonThumNail.getInt("width"));
                    imageDetail.setThumbNail(thumbNail);
                }
                arrayList.add(imageDetail);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

 }
