package org.iilab.pb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.iilab.pb.R;
import org.iilab.pb.model.PageChecklist;

import java.util.List;

/**
 * Created by aoe on 1/16/14.
 */
public class PageCheckListAdapter extends ArrayAdapter<PageChecklist> {

    LayoutInflater mInflater;
    private Context mContext;


    public PageCheckListAdapter(Context context, List<PageChecklist> checklist) {
        super(context, R.layout.row_page_checklist);
        this.mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row_page_checklist, null);

            holder = new ViewHolder();
            holder.tvAction = (TextView) convertView.findViewById(R.id.tv_action);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        PageChecklist item = getItem(position);

        holder.tvAction.setText(item.getTitle());

        return convertView;
    }

    public void setData(List<PageChecklist> itemList) {
        clear();
        if (itemList != null) {
            for (int i = 0; i < itemList.size(); i++) {
                add(itemList.get(i));
            }
        }
    }

    private static class ViewHolder {
        TextView tvAction;
    }
}
