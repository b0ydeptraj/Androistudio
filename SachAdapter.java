package com.example.ngoduchiep2_cntt02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SachAdapter extends ArrayAdapter<Sach> {
    Context context;
    int resource;
    List<Sach> listSach;

    public SachAdapter(Context context, int resource, List<Sach> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listSach = objects;


    }

    //tạo class viewHolder
    class ViewHolder {
        TextView tvmasach1, tvtensach1, tvtheloaisach1, tvtacgia1, tvdongia1, tvnhaxuatban1;

    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_sach, parent, false);
            //khởi tạo viewholder

            //ánh xạ
            viewHolder.tvmasach1 = (TextView) convertView.findViewById(R.id.tv_masach1);
            viewHolder.tvtensach1 = (TextView) convertView.findViewById(R.id.tv_tensach1);
            viewHolder.tvtheloaisach1 = (TextView) convertView.findViewById(R.id.tv_theloaisach1);
            viewHolder.tvtacgia1 = (TextView) convertView.findViewById(R.id.tv_tacgia1);
            viewHolder.tvdongia1 = (TextView) convertView.findViewById(R.id.tv_dongia1);
            viewHolder.tvnhaxuatban1 = (TextView) convertView.findViewById(R.id.tv_nhaxuatban1);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //thiết lập giá trị
        Sach sp = listSach.get(position);
        viewHolder.tvmasach1.setText(sp.getMasach());
        viewHolder.tvtensach1.setText(sp.getTensach());
        viewHolder.tvtheloaisach1.setText(sp.getTheloaisach());
        viewHolder.tvtacgia1.setText(sp.getTacgia());
        viewHolder.tvnhaxuatban1.setText(sp.getNhaxuatban());
        viewHolder.tvdongia1.setText(String.valueOf(sp.getDongia()));

        return convertView;

    }
}
