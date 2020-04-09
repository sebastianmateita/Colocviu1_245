package ro.pub.cs.systems.eim.Colocviu1_245;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Colocviu1_245MainActivity extends AppCompatActivity {

    private Button addButton, computeButton;
    private TextView allTerms;
    private EditText nextTerm;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String currentSum = allTerms.getText().toString();
            String enteredNumber = nextTerm.getText().toString();

            switch(view.getId()) {
                case R.id.add_button:
                    if (enteredNumber.equals(""))
                        return;

                    if (currentSum.equals("")) {
                        currentSum = enteredNumber;
                    }
                    else {
                        currentSum = currentSum.concat(" + " + enteredNumber);
                    }
                    allTerms.setText(currentSum);
                    nextTerm.setText("");
                    break;
                case R.id.compute_button:
                    Intent intent = new Intent(getApplicationContext(), Colocviu1_245SecondaryActivity.class);
                    intent.putExtra("CurrentSum", currentSum);
                    startActivityForResult(intent, 1);

                    break;
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        int result = intent.getIntExtra("Sum", 0);
        Toast.makeText(this, "The activity returned with result " + result, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_245_main);

        allTerms = (TextView)findViewById(R.id.all_terms);
        nextTerm = (EditText)findViewById(R.id.next_term);

        addButton = (Button)findViewById(R.id.add_button);
        addButton.setOnClickListener(buttonClickListener);

        computeButton = (Button)findViewById(R.id.compute_button);
        computeButton.setOnClickListener(buttonClickListener);
    }
}
