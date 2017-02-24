package example.test.com.wikiimagesearch.ui.wikisearch;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import example.test.com.wikiimagesearch.R;
import example.test.com.wikiimagesearch.model.wikisearch.ThumbNail;
import example.test.com.wikiimagesearch.model.wikisearch.WikiImageDetail;
import example.test.com.wikiimagesearch.utils.Utils;

/**
 * Created by root on 23/2/17.
 */
public class WikiImageDetailAdapter extends RecyclerView.Adapter<WikiImageDetailAdapter.MyViewHolder> {

    private ArrayList<WikiImageDetail> imageDetails = null;
    private ImageLoader imageLoader = null;
    private DisplayImageOptions displayImageOptions = null;

    WikiImageDetailAdapter(ArrayList<WikiImageDetail> imageDetails){
        this.imageDetails = imageDetails;
        this.imageLoader = Utils.getImageLoaderInstance();
        this.displayImageOptions = Utils.getDisplayOption();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wiki_image_detail_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return imageDetails.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTitle;
        public ImageView imgWikiImage;

        public MyViewHolder(View view) {
            super(view);
            txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            imgWikiImage = (ImageView) view.findViewById(R.id.imgWikiImage);
        }
    }

    public void updateAndRefreshList(ArrayList<WikiImageDetail> imageDetails){
        this.imageDetails = imageDetails;
        this.notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        WikiImageDetail imageDetail = imageDetails.get(position);
        holder.txtTitle.setText(imageDetail.getTitle());
        this.setImage(imageDetail.getThumbNail() , holder.imgWikiImage);
    }

    private void setImage(ThumbNail thumbNail , ImageView imageView){
        if(thumbNail == null){
            this.imageLoader.displayImage("", imageView , displayImageOptions);
        }else{
            this.imageLoader.displayImage(thumbNail.getSource() , imageView , displayImageOptions);
        }
    }
}
