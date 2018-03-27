package hr.ferit.vedran.inspired;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvTuring)
    TextView tvTuring;
    @BindView(R.id.tvJobs)
    TextView tvJobs;
    @BindView(R.id.tvGates)
    TextView tvGates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        tvTuring.setMovementMethod(new ScrollingMovementMethod());
        tvJobs.setMovementMethod(new ScrollingMovementMethod());
        tvGates.setMovementMethod(new ScrollingMovementMethod());

    }

    private void displayToastMessage(String Text) {
        Toast T = Toast.makeText(MainActivity.this, Text, Toast.LENGTH_LONG+1);
        T.show();
    }
}
