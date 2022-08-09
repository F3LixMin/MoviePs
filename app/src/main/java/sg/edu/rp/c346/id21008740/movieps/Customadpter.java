package sg.edu.rp.c346.id21008740.movieps;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Customadapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movies> arrayList;

    public Customadapter(Context context, int resource, ArrayList<Movies> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        arrayList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View rowView = inflater.inflate(layout_id, parent, false);


        TextView tvTitle = rowView.findViewById(R.id.mvTitle);
        TextView tvGenre = rowView.findViewById(R.id.showGenre);
        TextView tvYear = rowView.findViewById(R.id.mvYear);


        Movies currentItem = arrayList.get(position);
        ImageView ivRating = rowView.findViewById(R.id.RatingShow);


        Movies currentVersion = arrayList.get(position);


        tvTitle.setText(currentVersion.getTitle());
        tvGenre.setText(currentVersion.getGenre());
        tvYear.setText(currentVersion.getYear() + "");





        if(currentItem.getRating().equals("G"))
        {
            String imageUrl = "https://www.pngkey.com/png/detail/178-1783399_rated-g-logo-best-google-local-guides-badge.png";
            Picasso.with(parent_context).load(imageUrl).into(ivRating);
        }
        else if (currentItem.getRating().equals("PG"))
        {
            String imageUrl = "https://images.immediate.co.uk/production/volatile/sites/28/2019/02/16278-28797ce.jpg?quality=90&webp=true&fit=584,471";
            Picasso.with(parent_context).load(imageUrl).into(ivRating);
        }
        else if (currentItem.getRating().equals("PG13"))
        {
            String imageUrl ="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c0/RATED_PG-13.svg/2560px-RATED_PG-13.svg.png";
            Picasso.with(parent_context).load(imageUrl).into(ivRating);
        }
        else if (currentItem.getRating().equals("NC16"))
        {
            String imageUrl ="https://upload.wikimedia.org/wikipedia/commons/d/de/MDA_NC16.png";
            Picasso.with(parent_context).load(imageUrl).into(ivRating);
        }
        else if (currentItem.getRating().equals("M18"))
        {
            String imageUrl ="https://www.imda.gov.sg/-/media/Imda/Images/Content/Regulation-Licensing-and-Consultations/Content-Standards-and-classification/M18-rating.png";
            Picasso.with(parent_context).load(imageUrl).into(ivRating);
        }
        else if (currentItem.getRating().equals("R21"))
        {
            String imageUrl ="https://movielabs.com/md/ratings/v2.4.5/html/imageCache/SG_IMDA_R21.png";
            Picasso.with(parent_context).load(imageUrl).into(ivRating);
        }

        return rowView;
    }
}
