package example.com.crackme;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button button;
    private EditText edit;
    private boolean reset = false;
    private TextView view;

    public void onClick(View view2) {
        if (!this.reset) {
            String obj = this.edit.getText().toString();
            Toast.makeText(getApplicationContext(), obj, 1).show();
            if (Checker.check(obj, this)) {
                this.view.setText(R.string.good);
                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#36967c"));
                this.button.setText(R.string.TryAgain);
            } else {
                this.view.setText(R.string.bad);
                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#AA3939"));
                this.button.setText(R.string.TryAgain);
            }
            this.reset = true;
            return;
        }
        this.view.setText(R.string.hello_world);
        getWindow().getDecorView().setBackgroundColor(-1);
        this.button.setText(R.string.button);
        this.reset = false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.edit = (EditText) findViewById(R.id.input);
        this.view = (TextView) findViewById(R.id.textView1);
        this.button = (Button) findViewById(R.id.button);
        this.button.setOnClickListener(this);
    }
}
