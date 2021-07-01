package com.company.mentalfitness.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.company.mentalfitness.View.ListViewItem;
import com.company.mentalfitness.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListViewAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    // ListViewAdapter의 생성자
    public ListViewAdapter() {

    }
    public void clear(){
        listViewItemList.clear();
    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listViewItemList.size();
    }
    // 오름차순 정렬을 위한 Overide
    Comparator<ListViewItem> Ascend = new Comparator<ListViewItem>() {

        @Override
        public int compare(ListViewItem o1, ListViewItem o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    } ;
    // 내림차순 정렬을 위한 OverRide
    Comparator<ListViewItem> Descend = new Comparator<ListViewItem>() {

        @Override
        public int compare(ListViewItem o1, ListViewItem o2) {
            return -(o1.getTitle().compareTo(o2.getTitle()));
        }
    } ;
    Comparator<ListViewItem> Date = new Comparator<ListViewItem>() {

        @Override
        public int compare(ListViewItem o1, ListViewItem o2) {
            return (o1.getDate().compareTo(o2.getDate()));
        }
    } ;

    //오름차순 정렬 메소드
    public void AscendingSort(){
        Collections.sort(listViewItemList,Ascend);
    }
    //내림차순 메소드
    public void DescendingSort(){
        Collections.sort(listViewItemList,Descend);
    }
    public void DateSort(){
        Collections.sort(listViewItemList,Date);
    }
    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.feed_list_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView iconImageBar = (ImageView) convertView.findViewById(R.id.imageView1);
        ImageView iconImageFolder = (ImageView) convertView.findViewById(R.id.imageView2);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1);
        TextView date = (TextView) convertView.findViewById(R.id.textView2);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ListViewItem listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        iconImageBar.setImageDrawable(listViewItem.getIconB());
        iconImageFolder.setImageDrawable(listViewItem.getIconF());
        titleTextView.setText(listViewItem.getTitle());
        date.setText(listViewItem.getDate());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.

    public void addItem(Drawable iconB, Drawable iconF, String title, String date) {
        ListViewItem item = new ListViewItem();
        item.setIconB(iconB);
        item.setIconF(iconF);
        item.setTitle(title);
        item.setDate(date);

        listViewItemList.add(item);
    }

    public ArrayList<ListViewItem> getList(){return listViewItemList;}

//    public void addItem(Drawable drawable, Drawable drawable1, String title) {
//    }
}
