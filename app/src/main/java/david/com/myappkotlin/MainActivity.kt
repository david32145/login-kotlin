package david.com.myappkotlin

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)

        var btnLogin = findViewById<Button>(R.id.btnLogin)
        var txtEmail = findViewById<EditText>(R.id.txtEmail)
        var txtPass = findViewById<EditText>(R.id.txtPass)

        val sharedPref = getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        if(!sharedPref.contains("email")){
//           var editor = sharedPref.edit()
//            editor.putString("email", "david32145@gmail.com")
//            editor.putString("pass", "root")
            var intent = Intent(this, StoreUserActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener{
            var email = sharedPref.getString("email", null)
            var pass = sharedPref.getString("pass", null)
            if(txtEmail.text.toString().equals(email) && txtPass.text.toString().equals(pass)){
                Snackbar.make(
                    it,
                    "Você logou com sucesso",
                    Snackbar.LENGTH_SHORT
                ).show()
            }else{
                Snackbar.make(
                    it,
                    "Usuário ou senha incorretos!!!",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }


    }
}
