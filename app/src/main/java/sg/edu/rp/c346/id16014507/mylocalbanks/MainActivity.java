package sg.edu.rp.c346.id16014507.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS, tvOCBC, tvUOB;
    String wordClick = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        registerForContextMenu(tvDBS);

        tvOCBC = findViewById(R.id.textViewOCBC);
        registerForContextMenu(tvOCBC);

        tvUOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(tvUOB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText(R.string.DBS);
            tvOCBC.setText(R.string.OCBC);
            tvUOB.setText(R.string.UOB);
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText(R.string.DBSCHINESE);
            tvOCBC.setText(R.string.OCBCCHINESE);
            tvUOB.setText(R.string.UOBCHINESE);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0, R.string.website);
        menu.add(0,1,1, R.string.contactBank);
        menu.add(0,2,2, R.string.togglefavourite);

        if(v == tvDBS) {
            wordClick = getString(R.string.DBS);
        }
        else if(v == tvOCBC) {
            wordClick = getString(R.string.OCBC);
        }
        else if (v == tvUOB) {
            wordClick = getString(R.string.UOB);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (wordClick.equalsIgnoreCase(getString(R.string.DBS))) {
            if(item.getItemId() == 0) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.dbsWebsite)));
                startActivity(intent);
            }
            else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.dbsPhone)));
                startActivity(intentCall);
            }
            else if (item.getItemId() == 2) {
                if(tvDBS.getCurrentTextColor() == (Color.BLACK)) {
                    tvDBS.setTextColor(Color.RED);
                }
                else if(tvDBS.getCurrentTextColor() == (Color.RED)) {
                    tvDBS.setTextColor(Color.BLACK);
                }
            }
        }
        else if(wordClick.equalsIgnoreCase(getString(R.string.OCBC))) {
            if(item.getItemId() == 0) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.ocbcWebsite)));
                startActivity(intent);
            }
            else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.ocbcPhone)));
                startActivity(intentCall);
            }
            if(tvOCBC.getCurrentTextColor() == (Color.BLACK)) {
                tvOCBC.setTextColor(Color.RED);
            }
            else if(tvOCBC.getCurrentTextColor() == (Color.RED)) {
                tvOCBC.setTextColor(Color.BLACK);
            }
        }
        else if(wordClick.equalsIgnoreCase(getString(R.string.UOB))) {
            if(item.getItemId() == 0) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.uobWebsite)));
                startActivity(intent);
            }
            else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.uobPhone)));
                startActivity(intentCall);
            }
            if(tvUOB.getCurrentTextColor() == (Color.BLACK)) {
                tvUOB.setTextColor(Color.RED);
            }
            else if(tvUOB.getCurrentTextColor() == (Color.RED)) {
                tvUOB.setTextColor(Color.BLACK);
            }
        }
        return super.onContextItemSelected(item);
    }
}