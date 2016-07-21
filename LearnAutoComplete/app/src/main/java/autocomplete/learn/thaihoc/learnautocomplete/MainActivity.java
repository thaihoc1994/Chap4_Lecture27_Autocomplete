package autocomplete.learn.thaihoc.learnautocomplete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtTen;

    AutoCompleteTextView autotxtTinhThanh;//tuong duong list view
    //nguon du lieu co dinh
    String []arrTinhThanh;
    ArrayAdapter<String>adapterTinhThanh;


    Button btnOK;
    TextView txtChiTiet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        addEvent();
    }

    private void addEvent() {
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyXacNhanThongTin();
            }
        });
    }

    private void xuLyXacNhanThongTin() {
        String s = txtTen.getText().toString() + "\n" + autotxtTinhThanh.getText().toString();
        txtChiTiet.setText(s);
    }

    private void addControl() {
        txtTen = (EditText) findViewById(R.id.txtTen);
        btnOK = (Button) findViewById(R.id.btnOK);
        txtChiTiet = (TextView) findViewById(R.id.txtChiTiet);

        autotxtTinhThanh = (AutoCompleteTextView) findViewById(R.id.autotxtTinhThanh);

        arrTinhThanh = getResources().getStringArray(R.array.arrTinhThanh);
        adapterTinhThanh = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrTinhThanh
        );

        autotxtTinhThanh.setAdapter(adapterTinhThanh);
    }
}
