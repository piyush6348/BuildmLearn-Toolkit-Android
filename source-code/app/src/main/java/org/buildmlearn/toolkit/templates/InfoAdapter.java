package org.buildmlearn.toolkit.templates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.buildmlearn.toolkit.R;
import org.buildmlearn.toolkit.views.TextViewPlus;

import java.util.ArrayList;

/**
 * Created by abhishek on 17/06/15 at 9:48 PM.
 */
public class InfoAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<InfoModel> data;

    public InfoAdapter(Context mContext, ArrayList<InfoModel> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public InfoModel getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        InfoTemplateHolder holder;

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.info_template_item, parent, false);
            holder = new InfoTemplateHolder();
        } else {
            holder = (InfoTemplateHolder) convertView.getTag();
        }

        holder.word = (TextViewPlus ) convertView.findViewById(R.id.word);
        holder.meaning = (TextViewPlus) convertView.findViewById(R.id.meaning);

        InfoModel info = getItem(position);

        holder.meaning.setText(info.getMeaning());
        holder.word.setText(info.getWord());
        convertView.setTag(holder);
        return convertView;
    }

    public class InfoTemplateHolder{
        public TextViewPlus word;
        public TextViewPlus meaning;
    }
}
