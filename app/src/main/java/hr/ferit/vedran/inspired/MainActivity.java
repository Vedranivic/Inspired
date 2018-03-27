package hr.ferit.vedran.inspired;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    //TextView-ovi uz pomoć ButterKnifea (za potrebe funkcionalnosti listanja - scroll)
    @BindView(R.id.tvTuring)
    TextView tvTuring;
    @BindView(R.id.tvJobs)
    TextView tvJobs;
    @BindView(R.id.tvGates)
    TextView tvGates;

    //Nizovi stringova u koje se spremaju citati iz string.xml
    String[] quotesTuring;
    String[] quotesJobs;
    String[] quotesGates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //povezivanje preko ButterKnifea
        ButterKnife.bind(this);

        //dodavanje funkcionalnosti skrolanja
        tvTuring.setMovementMethod(new ScrollingMovementMethod());
        tvJobs.setMovementMethod(new ScrollingMovementMethod());
        tvGates.setMovementMethod(new ScrollingMovementMethod());

        //kopiranje sadržaja niza stringova iz string.xml u odgovarajući niz stringova programa
        quotesTuring = getResources().getStringArray(R.array.quotesTuring);
        quotesJobs = getResources().getStringArray(R.array.quotesJobs);
        quotesGates = getResources().getStringArray(R.array.quotesGates);
    }

    /*definiranje metode za klik na sliku i ispis citata - definirana je jedna metoda za sve tri
    slike, te se granjanje switch-case određuje koja će se akcija izvršiti*/
    @OnClick({R.id.ivTuring, R.id.ivJobs, R.id.ivGates})
    public void onClick(ImageView iv){
        //rand i nextInt za pseudoslučajni broj - indeks citata iz niza u granicama vrijednosti
        Random rand = new Random();
        int i;
        switch (iv.getId()){
            case R.id.ivTuring:
                i = rand.nextInt(quotesTuring.length);
                this.displayToastMessage(quotesTuring[i]);
                break;
            case R.id.ivJobs:
                i = rand.nextInt(quotesJobs.length);
                this.displayToastMessage(quotesJobs[i]);
                break;
            case R.id.ivGates:
                i = rand.nextInt(quotesGates.length);
                this.displayToastMessage(quotesGates[i]);
                break;
        }
    }

    //funkcija za prikaz Toast poruke
    private void displayToastMessage(String Text) {
        Toast T = Toast.makeText(MainActivity.this, Text, Toast.LENGTH_LONG);
        T.show();
    }
}
