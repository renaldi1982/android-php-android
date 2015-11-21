package renaldi.benzolgroup.com.enzonemockup;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class IconListAdapter extends ArrayAdapter<String> {
    private static final String TAG = "EnzoneMockup: " + IconListAdapter.class.getSimpleName();
    private Activity context;
    private String[] options;
    private String[] icons;

    public IconListAdapter(Activity context, int resource,  String[] options, String[] icons){
        super(context, resource, options);

        this.context = context;
        this.options = options;
        this.icons = icons;
    }

    // Holder for view
    static class ViewHolder {
        public TextView text;
        public ImageView icon;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View rowView = convertView;

        if(rowView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.list_items,null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.list_item);
            viewHolder.icon = (ImageView) rowView.findViewById(R.id.list_icon);

            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        String s = options[position];
        holder.text.setText(s);
        if (s.startsWith("Windows7") || s.startsWith("iPhone")
                || s.startsWith("Solaris")) {
            holder.icon.setImageResource(R.drawable.list_icon_account_balance_blue_100_18dp);
        } else {
            holder.icon.setImageResource(R.drawable.list_icon_accessibility_blue_100_18dp);
        }

        return rowView;
    }
}
