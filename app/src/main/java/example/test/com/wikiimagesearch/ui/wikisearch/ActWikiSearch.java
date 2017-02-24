package example.test.com.wikiimagesearch.ui.wikisearch;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.test.com.wikiimagesearch.R;
import example.test.com.wikiimagesearch.model.wikisearch.WikiImageDetail;
import example.test.com.wikiimagesearch.networkoperation.JsonParser;
import example.test.com.wikiimagesearch.networkoperation.NetworkOperation;
import example.test.com.wikiimagesearch.networkoperation.OnOperationComplete;
import example.test.com.wikiimagesearch.ui.base.ActBase;
import example.test.com.wikiimagesearch.utils.OnTextChange;
import example.test.com.wikiimagesearch.utils.Urls;
import example.test.com.wikiimagesearch.utils.Utils;

public class ActWikiSearch extends ActBase {

    @BindView(R.id.edtEnterSearchTerm)
    EditText edtEnterSearchTerm;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_wiki_search);

        this.init();
        this.setTextWatcher();
    }

    /**
     * Initialization
     */
    private void init(){
        this.setUpToolbar();
        ButterKnife.bind(this);
    }

    /** 
     * Set the text watcher
     */
    private void setTextWatcher(){
        Utils.setTextWatcher(edtEnterSearchTerm, new OnTextChange() {
            @Override
            public void onTextChange(String text) {
                getWikiImageDetail(text);
            }
        });
    }

    /**
     * Get the image detail from server
     * @param text
     */
    private void getWikiImageDetail(String text){
        NetworkOperation.doGetRequest(Urls.WIKI_BASE_URL + text , new OnOperationComplete() {
            @Override
            public void onOperationComplete(String response) {
                setAndRefreshRecycleView(JsonParser.parseWikiJsonDetail(response));
            }
        });
    }

    /**
     * Set and refresh the recycle view
     * @param imageDetails
     */
    private void setAndRefreshRecycleView(ArrayList<WikiImageDetail> imageDetails){
        if(recyclerView.getAdapter() != null){
            ((WikiImageDetailAdapter)recyclerView.getAdapter()).updateAndRefreshList(imageDetails);
        }else{
            WikiImageDetailAdapter mAdapter = new WikiImageDetailAdapter(imageDetails);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
        }
    }
}
