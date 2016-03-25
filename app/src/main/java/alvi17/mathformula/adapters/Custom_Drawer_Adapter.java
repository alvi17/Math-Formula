package alvi17.mathformula.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import alvi17.mathformula.model.DrawerItem;
import alvi17.mathformula.R;

public class Custom_Drawer_Adapter extends ArrayAdapter<DrawerItem>{
    Context context;
    List<DrawerItem> drawerItemList;
    int layoutResID;

    public Custom_Drawer_Adapter(Context context, int layoutResourceID,List<DrawerItem> listItems) {
          super(context,layoutResourceID,listItems);
          this.context = context;
          this.drawerItemList = listItems;
          this.layoutResID = layoutResourceID;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
          // TODO Auto-generated method stub
        DrawerItemHolder drawerHolder;
        View view = convertView;

        if (view == null) {
              LayoutInflater inflater = ((Activity) context).getLayoutInflater();
              drawerHolder = new DrawerItemHolder();

              view = inflater.inflate(layoutResID, parent, false);
              drawerHolder.ItemName = (TextView) view
                          .findViewById(R.id.drawer_itemName);
              drawerHolder.icon = (ImageView) view.findViewById(R.id.drawer_icon);

              drawerHolder.title = (TextView) view.findViewById(R.id.drawerTitle);

              drawerHolder.headerLayout = (LinearLayout) view
                          .findViewById(R.id.headerLayout);
              drawerHolder.itemLayout = (LinearLayout) view
                          .findViewById(R.id.itemLayout);


              view.setTag(drawerHolder);

        } else {
              drawerHolder = (DrawerItemHolder) view.getTag();

        }

        DrawerItem dItem = (DrawerItem) this.drawerItemList.get(position);

        
         if (dItem.getTitle() != null) {
              drawerHolder.headerLayout.setVisibility(LinearLayout.VISIBLE);
              drawerHolder.itemLayout.setVisibility(LinearLayout.INVISIBLE);
             
              drawerHolder.title.setText(dItem.getTitle());

        } else {

              drawerHolder.headerLayout.setVisibility(LinearLayout.INVISIBLE);
            
              drawerHolder.itemLayout.setVisibility(LinearLayout.VISIBLE);

              drawerHolder.icon.setImageDrawable(view.getResources().getDrawable(
                          dItem.getImgResID()));
              drawerHolder.ItemName.setText(dItem.getItemName());

        }
        return view;
    }
    private static class DrawerItemHolder {
        TextView ItemName, title;
        ImageView icon;
        LinearLayout headerLayout, itemLayout;
       
  }
}


