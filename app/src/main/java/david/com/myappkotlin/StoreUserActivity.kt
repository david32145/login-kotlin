package david.com.myappkotlin

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.widget.Button
import android.widget.EditText

class StoreUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_user)

        var btnLogin = findViewById<Button>(R.id.btnStore)
        var txtEmail = findViewById<EditText>(R.id.txtEmailStore)
        var txtPass = findViewById<EditText>(R.id.txtPassStore)

        var sharedWriter = getSharedPreferences("login", Context.MODE_PRIVATE).edit()
        btnLogin.setOnClickListener{
            sharedWriter.putString("email", txtEmail.text.toString())
            sharedWriter.putString("pass", txtPass.text.toString())
            sharedWriter.commit()
            finish()
        }
    }

}
