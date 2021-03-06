package com.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bean.MaterialOnSchedule;
import com.uhf.uhf.R;

import java.util.List;

/**
 * 临期商品适配器
 */
public class SchduleOnAdapter extends BaseAdapter {

    private Context context;
    private List<MaterialOnSchedule> materialInfoList;
    private LayoutInflater mInflater;//布局装载器对象

    public SchduleOnAdapter(Context context,
                            List<MaterialOnSchedule> materialInfoList) {
        this.context = context;
        this.materialInfoList = materialInfoList;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return materialInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return materialInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.simple_list_item_schedule, null);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tv_schedule_title);
            viewHolder.txCodeTextView = (TextView) convertView.findViewById(R.id.tv_schedule_code);
            viewHolder.seheduleDataTextView=convertView.findViewById(R.id.tv_schedule_date);
            viewHolder.num = (TextView) convertView.findViewById(R.id.tv_schedule_num);
            viewHolder.actualNum = convertView.findViewById(R.id.tv_actual_schedule_num);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_scheduleImage);
            viewHolder.iv_scheduleImage_layout = (LinearLayout) convertView.findViewById(R.id.iv_scheduleImage_layout);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        MaterialOnSchedule waitMaterial = materialInfoList.get(position);
        Integer num = 1;
        Integer actualNum = waitMaterial.getCheckQuantity() == null ? 0 : waitMaterial.getCheckQuantity();

        viewHolder.title.setText(waitMaterial.getMaterialName());
        viewHolder.num.setText("1");
        viewHolder.txCodeTextView.setText(waitMaterial.getMaterialBarcode());
        viewHolder.actualNum.setText(waitMaterial.getProduceDateStr()+" 至 "+waitMaterial.getExpireDateStr());
        viewHolder.actualNum.setText( actualNum.toString());

        //是否盘点标志位
        boolean isInventory = waitMaterial.isInventory();

        if (actualNum == num) {
            viewHolder.actualNum.setText(""+actualNum);
            viewHolder.imageView.setImageResource(R.drawable.right);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewHolder.iv_scheduleImage_layout.getLayoutParams();
            params.setMargins(55, 0, 0, 0);
        } else if (actualNum > num) {
            viewHolder.imageView.setVisibility(View.GONE);
            viewHolder.actualNum.setText("+" + (actualNum - num));
        } else if (actualNum < num && isInventory) {
            viewHolder.actualNum.setText(actualNum - num);
            viewHolder.imageView.setBackgroundResource(R.drawable.wrong1);
        }

        return convertView;

    }

    // ViewHolder用于缓存控件，三个属性分别对应item布局文件的三个控件
    public static class ViewHolder {
        public TextView title;
        public TextView num;
        public TextView actualNum;
        public TextView txCodeTextView;
        public TextView seheduleDataTextView;
        public ImageView imageView;
        public LinearLayout iv_scheduleImage_layout;
    }
}
