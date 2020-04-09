package ro.pub.cs.systems.eim.Colocviu1_245;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // Implement code here to be performed when
        // broadcast is detected

        String data = intent.getStringExtra("MyData");
        Toast.makeText(context.getApplicationContext(), data, Toast.LENGTH_LONG).show();
    }
}
