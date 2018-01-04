package rmcreation.com.custommerdetails;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by robin1 on 28/12/2017.
 */

class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {

    Context context;
    List<Custom> mlist;

    public Myadapter(Context context, List<Custom> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @Override
    public Myadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.listing,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Myadapter.ViewHolder holder, int position) {
        holder.oriname.setText(mlist.get(position).getName());
        holder.oriplace.setText(mlist.get(position).getPlace());
        holder.oriphone.setText(mlist.get(position).getPhone());
        holder.oridesc.setText(mlist.get(position).getDesc());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

      TextView oriname,oriplace,oriphone,oridesc;

        public ViewHolder(View itemView) {
            super(itemView);
            oriname = (TextView) itemView.findViewById(R.id.custname);
            oriplace =(TextView)itemView.findViewById(R.id.custplace);
            oriphone =(TextView)itemView.findViewById(R.id.custphone);
            oridesc =(TextView)itemView.findViewById(R.id.custdesc);
        }
    }
}
