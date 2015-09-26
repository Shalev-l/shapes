package com.example.shalev.shapes;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button createRect, createCircle;
    private EditText locX, locY, width, height, radius;
    private Spinner color;
    private RelativeLayout drawBoard;

    private Rectangle rect;
    private Circle circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializationVariables();
    }

    private void initializationVariables() {
        createRect = (Button) findViewById(R.id.rectangleBTM);
        createCircle = (Button) findViewById(R.id.circleBTM);
        locX = (EditText) findViewById(R.id.getXeditTXT);
        locY = (EditText) findViewById(R.id.Ytxt);
        width = (EditText) findViewById(R.id.getWidthTXT);
        height = (EditText) findViewById(R.id.getLengthTXT);
        radius = (EditText) findViewById(R.id.getRadiusTXT);
        color = (Spinner) findViewById(R.id.colorSpinner);
        drawBoard = (RelativeLayout) findViewById(R.id.rlDrawBoard);

        createRect.setOnClickListener(this);
        createCircle.setOnClickListener(this);
        locX.requestFocus();

        circle = new Circle(100, 100, Color.GREEN, 100, this);
        rect= new Rectangle(200,200,Color.MAGENTA,200,100,this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rectangleBTM:
                if (width.getText().toString().equals("") ||
                        height.getText().toString().equals("") ||
                        locX.getText().toString().equals("") ||
                        locY.getText().toString().equals("")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(R.string.errMsg);
                    builder.setTitle("Fields Require!");
                    builder.setIcon(R.drawable.erroricon);
                    builder.setPositiveButton("OK", null);
                    builder.create();
                    builder.show();
                } else
                    createRectangle();
                break;

            case R.id.circleBTM:
                if (radius.getText().toString().equals("") ||
                        locX.getText().toString().equals("") ||
                        locY.getText().toString().equals("")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(R.string.errMsg);
                    builder.setTitle(R.string.errMsgTitle);
                    builder.setIcon(R.drawable.erroricon);
                    builder.setPositiveButton(R.string.OK, null);
                    builder.create();
                    builder.show();
                } else
                    createCircle();
                break;
        }
    }

    //create the rectangle on the screen
    private void createRectangle() {

        rect = new Rectangle(this);
        rect.setX(Integer.parseInt(locX.getText().toString()));
        rect.setY(Integer.parseInt(locY.getText().toString()));
        rect.setWidth(Integer.parseInt(width.getText().toString()));
        rect.setHeight(Integer.parseInt(height.getText().toString()));
        rect.setColor(Color.parseColor(color.getSelectedItem().toString()));
        drawBoard.addView(rect);
    }

    //create the circle on the screen
    private void createCircle() {
        circle = new Circle(this);
        circle.setX(Integer.parseInt(locX.getText().toString()));
        circle.setY(Integer.parseInt(locY.getText().toString()));
        circle.setColor(Color.parseColor(color.getSelectedItem().toString()));
        circle.setRadius(Integer.parseInt(radius.getText().toString()));
        drawBoard.addView(circle);
    }
}