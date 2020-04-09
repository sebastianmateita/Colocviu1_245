package ro.pub.cs.systems.eim.Colocviu1_245;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Colocviu1_245SecondaryActivity extends Activity {
    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);

        // intent from parent
        Intent intentFromParent = getIntent();
        Bundle data = intentFromParent.getExtras();
        // process information from data ...

        String sum = intentFromParent.getStringExtra("CurrentSum");
        String[] numbers = sum.replaceAll("\\s","").split("\\+", 10);

        int finalSum = 0;
        for (String num : numbers) {
            finalSum += Integer.parseInt(num);
        }

        // intent to parent
        Intent intentToParent = new Intent();
        intentToParent.putExtra("Sum", finalSum);
        setResult(RESULT_OK, intentToParent);
        finish();
    }
}
