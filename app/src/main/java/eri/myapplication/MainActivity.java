package eri.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void calculatePercent(View view) {
        EditText myPercent = (EditText) findViewById(R.id.percent);
        String percentStr = myPercent.getText().toString();
        EditText myBill = (EditText) findViewById(R.id.bill);
        String billStr = myBill.getText().toString();

        if (percentStr != "" && billStr != "") {

            double percent;
            try {
                percent = Double.parseDouble(percentStr);
            } catch (NumberFormatException e) {
                return;
            }

            double bill;
            try {
                bill = Double.parseDouble(billStr);
            } catch (NumberFormatException e) {
                return;
            }

            double calculatedTip = (percent / 100) * bill;
            Log.d("percent ", percentStr);
            Log.d("bill ", billStr);
            Log.d("tip ", Double.toString(calculatedTip));

            TextView tipBox = (TextView) findViewById(R.id.tipText);
            tipBox.setText("$" + String.format("%.2g%n", calculatedTip));

            tipBox.setTextColor(Color.RED);
        }
    }

    public void clearTextFields(View view) {
        EditText myPercent = (EditText) findViewById(R.id.percent);
        myPercent.setText("");

        EditText myBill = (EditText) findViewById(R.id.bill);
        myBill.setText("");

        TextView tipBox = (TextView) findViewById(R.id.tipText);
        tipBox.setText("$0.00");

        tipBox.setTextColor(Color.BLACK);
    }
}
