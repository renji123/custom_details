package rmcreation.com.custommerdetails;

import android.app.ProgressDialog;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Custom mycustom;
    List<Custom> customList;
    Myadapter myadapter;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    RequestQueue request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =(RecyclerView)findViewById(R.id.recycler);
        gridLayoutManager=new GridLayoutManager(this,1);

        customList = new ArrayList<>();

        myadapter= new Myadapter(this,customList);
        load_data_from_server(0);



        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(gridLayoutManager);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                    if(gridLayoutManager.findLastCompletelyVisibleItemPosition()==customList.size()-1)
                        load_data_from_server(customList.size());

                }
            });
        }

    }

    private void load_data_from_server(int i) {

        request= Volley.newRequestQueue(this);

        StringRequest str = new StringRequest("https://renjicreation.000webhostapp.com/gravityfetchingdatas.php",

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONArray jar = new JSONArray(response);
                          //  Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                            for(int i = 0;i <= jar.length();i++){
                                JSONObject job = jar.getJSONObject(i);
                                mycustom = new Custom(job.getString("name"),job.getString("place"),job.getString("phone"),job.getString("desc"));
                                customList.add(mycustom);
                                myadapter.notifyDataSetChanged();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        request.add(str);

    }
}
