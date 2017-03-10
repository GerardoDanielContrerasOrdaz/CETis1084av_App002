package mx.edu.cetis108.cetis1084av_app002;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.security.PublicKey;

import static mx.edu.cetis108.cetis1084av_app002.R.string.btnSuma;
import static mx.edu.cetis108.cetis1084av_app002.R.string.editText1;

//Se impletementa el evento (implements View.OnClickListener)
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Se crean variables de cada uno de los objetos que vamos a utilizar
    EditText editText1, editText2;
    TextView txtView;
    Button btn1, btn2, btn3, btn4;
    //Se crean 3 variavles tipo flotante para las operaciones
    float num1,num2,operacion;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        //Llama a cada uno de los objetos utilizados por el Id
        btn1=(Button) findViewById(R.id.btnSuma);
        btn2=(Button) findViewById(R.id.btnResta);
        btn3=(Button) findViewById(R.id.btnMult);
        btn4=(Button) findViewById(R.id.btnDiv);
        editText1=(EditText) findViewById(R.id.editText1);
        editText2=(EditText) findViewById(R.id.editText2);
        txtView=(TextView) findViewById(R.id.txtView);

        //Indica que estos Botones van a tener el evento OnClickListener
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

    }

    //Se ingresa el codigo de la App dentro del evento OnClickListener
    @Override
    public void onClick(View v) {

        //Tomamos los valores que ingresamos en el EditText (getText())y los convertimos a String(toString())
        num1=Float.valueOf((editText1).getText().toString());
        num2=Float.valueOf((editText2).getText().toString());
        //Con la Sentencia Switch validamos en que Botón se ha hecho un Click
       switch (v.getId()) {
           //R(Resources).id(El id que tiene nuestro boton).btnSuma(es el id que tiene nuestro Bóton en la App)
           case R.id.btnSuma:
               operacion = num1 + num2;
               //El TextView toma el dato(setText) y se pone el parámetro (operacion)
               txtView.setText(""+operacion);
               break;
           case R.id.btnResta:
               operacion = num1 - num2;
               txtView.setText(""+operacion);
               break;
           case R.id.btnMult:
               operacion = num1 * num2;
               txtView.setText(""+operacion);
               break;
           case R.id.btnDiv:
               operacion = num1 / num2;
               txtView.setText(""+operacion );
               break;

       }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
